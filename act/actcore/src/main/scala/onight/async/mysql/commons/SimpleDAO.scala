package onight.async.mysql.commons

import java.lang.reflect.Field
import java.sql.Timestamp
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.reflect.ClassTag
import scala.util.Failure
import scala.util.Success
import org.slf4j.LoggerFactory
import com.github.mauricio.async.db.Connection
import com.github.mauricio.async.db.QueryResult
import com.github.mauricio.async.db.QueryResult
import com.github.mauricio.async.db.ResultSet
import scala.concurrent.ExecutionContextExecutor
import onight.act.scala.persist.BatchCheckExc
import com.google.protobuf.Message
import com.google.protobuf.Descriptors.FieldDescriptor
import scala.collection.JavaConversions._
import com.github.mauricio.async.db.RowData
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat
import scala.util.Try
import scala.math.BigDecimal

//import akka.util.Timeout

case class DBResult(t: Any)
case class Range(offset: Int, limit: Int)

class QueryResultWithArray(
  val seqs: Seq[Any],
  override val rowsAffected: Long, override val statusMessage: String, override val rows: Option[ResultSet] = None)
    extends QueryResult(rowsAffected, statusMessage, rows) {

}

class NoneQueryResult()
    extends QueryResult(0, null) {

}
trait SimpleDAO[T] extends AsyncDB {

  implicit lazy val global: ExecutionContextExecutor = ExecutionContext.fromExecutor(BatchCheckExc.daoexec)

  val log = LoggerFactory.getLogger("SimpleDAO")
  //  implicit val timeout = Timeout(60000)
  //  def mapToBean(row: RowData): T;
  val ttag: ClassTag[T];
  val tablename: String;

  val keyname: String;

  lazy val fields = ttag.runtimeClass.getDeclaredFields().filter({ field =>
    field.setAccessible(true); true
  });
  lazy val constructor = ttag.runtimeClass.getConstructors()(0);

  def instanceFromMap(row: HashMap[String, Object]) = {
    val map = fields.map({ field =>
      val v = row.get(field.getName())
      //      println("FF:" + field.getName() + "(" + field.getType() + ")" +  "(" + field.getGenericType() + ")" +",=>" + v + ",type=" + v.getClass + ",v=" + v)
      if (v == null) {
        null
      } else {
        val cv = v match {
          case s: Some[_] =>
            val clazz = s.get.getClass()
            val sv = {
              if (field.getGenericType().eq(classOf[java.lang.String])) {
                s.get.asInstanceOf[String]
              } else if (field.getGenericType().eq(classOf[java.sql.Timestamp])) {
                new Timestamp(s.get.asInstanceOf[Long])
              } else if (field.getType == classOf[Option[_]]) {
                Option(s.get)
              } else {
                s.get.asInstanceOf[String]
              }
            }
            //            s.get.asInstanceOf[String]
            sv
          case None => null
        }
        cv
      }
    })
    constructor.newInstance(map.toArray[AnyRef]: _*).asInstanceOf[T]
  }

  def resultRowTOPB(rootbuilder: Message.Builder, rowfd:FieldDescriptor, qr: Try[QueryResult]): Boolean = {
    val ret = qr.map {
      case qr: QueryResult => {
        if (qr.rowsAffected > 0) {
          for (row <- qr.rows.head) {
            val rowbuilder = rootbuilder.newBuilderForField(rowfd)
            for (fd <- rowbuilder.getDescriptorForType().getFields()) {
              val v = fieldValue(row, fd.getName.toUpperCase())
              if (v != null) {
                try {
                  rowbuilder.setField(fd, v)
                } catch {
                  case a: Throwable => {
                    log.error("cannot set v:" + fd.getName + ",v=" + v)
                  }
                }
              }
            }
//            log.debug("get row:"+rowbuilder.build())
            rootbuilder.addRepeatedField(rowfd,rowbuilder.build());
          }
          true
        } else {
          false
        }
      }
      case u @ _ => false
    }
    ret.get
  }
  def fieldValue(row: RowData, name: String): Any = {
   return  row(name) match {
      case v: String => v
      case n @ null => {
        return null;
      }
      case v: org.joda.time.LocalDateTime => {
        v.toDateTime().getMillis
      }
      case Some(v) => return v
      case v: scala.math.BigDecimal => {
//        log.debug("change bigDe{}",v.doubleValue());
         return Double.box(v.doubleValue()); 
      }
      case v @ _ => {
        log.warn("unknow type:" + v.getClass() + ":" + row(name))
        return v
      }
    }
  }
  def resultRow(queryResult: QueryResult): Any = {
    //    println(UpdateString)
    //    val fields = ttag.runtimeClass.getDeclaredFields();
    val ret: ListBuffer[T] = ListBuffer.empty;
    queryResult.rows match {
      case Some(rs) =>
        for (row <- queryResult.rows.head) ret.append({
          val map = fields.map({ field =>
            //            println("FF:" + field.getName() + ",=>" + row(field.getName()))
            fieldValue(row, field.getName)
          })
          val instance = constructor.newInstance(map)
          instance.asInstanceOf[T]
        })
      case _ => return queryResult
    }
    //    println(queryResult.rows)

    return ret.toList;
  }

  def beanValue(bean: T, filter: Field => Boolean): Seq[Any] = {
    fields.filter(filter).map(_.get(bean)).map { v =>
      v match {
        case opt: Option[Any] => opt.getOrElse(null)
        case list: List[Any] => {
          list.mkString(",")
        }
        case _ => v
      }
    }
  }

  def bean2Array(bean: T): Seq[Any] = {
    fields.map(_.get(bean)).map { v =>
      v match {
        case opt: Option[Any] => opt.getOrElse(null)
        case list: List[Any] => {
          list.mkString(",")
        }
        case _ => v
      }
    }
  }
  def folder(v: Any): String = {
    v match {
      case opt: Option[Any] => '"' + opt.getOrElse("null").toString + '"'
      case list: List[Any] => {
        (list.mkString(","))
      }
      case v if v != null => '"' + v.toString + '"'
      case _ => "null"
    }
  }
  def beans2Values(beans: List[T]): String = {
    val list = (for (bean <- beans) yield fields.map(_.get(bean)).map(folder(_)).mkString("(", ",", ")"))
    list.mkString("values", ",", "")
  }
  def beans2Prepare(beans: List[T]): String = {
    val list = (for (bean <- beans) yield fields.map(f => "?").mkString("(", ",", ")"))
    list.mkString("values", ",", "")
  }

  def beans2Array(beans: List[T]): Seq[Any] = {
    val seqs: ArrayBuffer[Any] = ArrayBuffer.empty;
    for (bean <- beans) yield fields.map(_.get(bean)).map { v =>
      v match {
        case opt: Option[Any] => seqs.+=(opt.getOrElse(null))
        case list: List[Any] => {
          seqs.+=(list.mkString(","))
        }
        case _ => seqs.+=(v)
      }
    }
    seqs
  }
  def bean2KeyLastArray(bean: T): Seq[Any] = beanValue(bean, _.getName() != keyname) ++ beanValue(bean, _.getName() == keyname)

  def beans2KeyLastArray(beans: List[T]): Seq[Any] =
    {
      //     for (bean <- beans) yield beanValue(bean, _.getName() != keyname) ++ beanValue(bean, _.getName() == keyname)
      val seqs: ArrayBuffer[Any] = ArrayBuffer.empty;

      beans.map { bean =>
        seqs ++= bean2KeyLastArray(bean)
      }
      seqs
    }

  def bean2NoKeyArray(bean: T): Seq[Any] = beanValue(bean, _.getName() != keyname)

  def bean2KeyArray(bean: T): Seq[Any] = beanValue(bean, _.getName() == keyname)

  def fieldValueIsNotNull(fv: Any) = fv != null && fv != None

  def bean2SelectiveArray(bean: T): Seq[Any] = beanValue(bean, { v =>
    val vv = v.get(bean);
    vv != null && vv != None
  })

  def bean2NoKeySelectiveArray(bean: T): Seq[Any] = beanValue(bean, { field =>
    field.get(bean) != null && field.getName() != keyname
  })

  def getInt(queryResultO: Option[QueryResult]): Int = {
    queryResultO match {
      case Some(queryResult) =>
        queryResult.rows match {
          case Some(rs) =>
            queryResult.rows.head(0).asInstanceOf[Int]
          case _ =>
            -1
        }
      case _ => -1
    }

  }
  def exec(query: String, values: Seq[Any] = List())(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = {
    log.debug("exec:" + query + ",obj=" + values)

    if (noexec) return Future { new QueryResultWithArray(values, 0L, query) }

    val result = pool.sendPreparedStatement(query, values)
    if (f != null) {
      result.onComplete {
        case Success(result) => {
          val dbresults = DBResult(resultRow(result.asInstanceOf[QueryResult]))
          f(dbresults)
        }
        case Failure(failure) => f(DBResult(failure))
      }
    } else {
      //      val ff = Await.result(result, timeout.duration);

    }
    return result
  }

  def flatExec(r: Future[QueryResult], c: Connection, query: String, vals: List[Seq[Any]], index: Int)(implicit f: (QueryResult, Int) => Unit = null, noexec: Boolean = false): Future[QueryResult] = {

    if (f != null) {
      r.onComplete { x => f(x.get, index) }
    }
    if (index < vals.size) {
      val v = r.flatMap { x => c.sendPreparedStatement(query, vals(index)) }
      flatExec(v, c, query, vals, index + 1)
    } else {
      r
    }
  }

  def flatExecBatch(r: Future[QueryResult], c: Connection, query: List[String], vals: List[Seq[Any]], index: Int)(implicit f: (QueryResult, Int) => Unit = null, noexec: Boolean = false): Future[QueryResult] = {

    if (f != null) {
      r.onComplete { x => f(x.get, index) }
    }
    if (index < vals.size) {
      val v = r.flatMap { x => c.sendPreparedStatement(query(index), vals(index)) }
      flatExecBatch(v, c, query, vals, index + 1)
    } else {
      r
    }
  }

  def execBatch(query: String, vals: List[Seq[Any]])(implicit f: (QueryResult, Int) => Unit = null, noexec: Boolean = false): Future[QueryResult] = {
    log.debug("execBatch:" + query + ",vals=" + vals)
    //    pool.sendPreparedStatement(query, values)
    val result = pool.use { x =>
      x.inTransaction { c =>
        flatExec(c.sendPreparedStatement(query, vals(0)), c, query, vals, 1)(f)
      }
    }
    result
  }
  
  def execBatchUpdates(query: List[String], vals: List[Seq[Any]])(implicit f: (QueryResult, Int) => Unit = null, noexec: Boolean = false): Future[QueryResult] = {
    log.debug("execBatch:" + query + ",vals=" + vals)
    //    pool.sendPreparedStatement(query, values)
    val result = pool.use { x =>
      x.inTransaction { c =>
        flatExecBatch(c.sendPreparedStatement(query(0), vals(0)), c, query, vals, 1)(f)
      }
    }
    result
  }

  def flatExecInsertAndUpdate(r: Future[QueryResult], c: Connection, query: String, vals: List[Seq[Any]], index: Int)(implicit f: (QueryResult, Int) => Unit = null, noexec: Boolean = false): Future[QueryResult] = {
    if (index < vals.size) {
      val v = r.flatMap { x =>
        val xf = c.sendPreparedStatement(query, vals(index))
        xf
      }
      //      futures.+=:(v)
      if (f != null) {
        v.onComplete { xv => f(xv.get, index) }
      }
      //      log.error("ff,2.size="+futures.size)

      flatExecInsertAndUpdate(v, c, query, vals, index + 1)
    } else {
      r
    }
  }

  def execInsertUpdateBatch(insertQuery: String, insertArray: Seq[Any], update: String, vals: List[Seq[Any]])(implicit f: (QueryResult, Int) => Unit = null, noexec: Boolean = false): Future[QueryResult] = {
    //    log.debug("execBatch:" + insertQuery + ",vals=" + vals)
    //    pool.sendPreparedStatement(query, values)
    val result = pool.use { x =>
      x.inTransaction { c =>
        val exec1 = c.sendPreparedStatement(insertQuery, insertArray)
        flatExecInsertAndUpdate(exec1, c, update, vals, 0)(f)
      }
    }
    result
  }

  def execQuery(query: String)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = {
    log.info("exec:" + query)
    if (noexec) return Future { new QueryResult(0L, query) }
    val result = pool.sendQuery(query)
    if (f != null) {
      result.onComplete {
        case Success(result) => {
          val dbresults = DBResult(resultRow(result.asInstanceOf[QueryResult]))
          f(dbresults)
        }
        case Failure(failure) => f(DBResult(failure))
      }
    } else {
      //      val ff = Await.result(result, timeout.duration);

    }
    return result
  }
  lazy val InsertString: String = {
    ("INSERT INTO " + tablename + " (") + fields.map({ _.getName() }).mkString(",") + ") values(" + "?," * (fields.size - 1) + "?)"
  }

  private lazy val UpdateString: String = {
    ("UPDATE " + tablename + " SET ") + fields.filter(_.getName() != keyname).map({ _.getName() }).mkString("=(?) , ") + " =(?) WHERE " + keyname + " = (?)"
  }

  private lazy val SubtractString: String = {
    ("UPDATE " + tablename + " SET ") + fields.filter(_.getName() != keyname).map({ _.getName() }).mkString("=(?) , ") + " =(?) WHERE " + keyname + " = (?)"
  }
  def SelectString: String = {
    ("SELECT ") + fields.map({ _.getName() }).mkString(",") + " from " + tablename;
  }
  private def CountString: String = {
    "SELECT COUNT(1)  as __count FROM " + tablename;
  }

  private def rangeStr(range: Range): String = {
    if (range == null) ""
    else
      " LIMIT " + range.offset + "," + range.limit + " "
  }

  private def SelectOneString: String = {
    ("SELECT ") + fields.map({ _.getName() }).mkString(",") + " from " + tablename + " WHERE " + keyname + " = (?)";
  }

  private def SelectByCond(bean: T)(implicit condition: String = "AND"): String = {
    ("SELECT ") + fields.map({ _.getName() }).mkString(",") + " from " + tablename + " WHERE " +
      fields.filter({ v =>
        val vv = v.get(bean);
        vv != null && vv != None
      }).map({ _.getName() }).mkString("", "=(?) " + condition + " ", "=(?) ")
  }
  private def CountByCond(cond: String): String = {
    "SELECT COUNT(1) as __count from " + tablename + " WHERE " + cond
  }

  private lazy val InsertOrUpdate: String = {
    InsertString + " ON DUPLICATE KEY UPDATE " + fields.filter(_.getName() != keyname).map(_.getName()).mkString("", "=(?) , ", "=(?)")
  }

  //  private def InsertBatchString(beans: List[T]): String = {
  //    ("INSERT INTO " + tablename + " (") + fields.map({ _.getName() }).mkString(",") + ") " +  beans2Values(beans)
  //  }

  def InsertBatchString(beans: List[T]): String = {
    ("INSERT INTO " + tablename + " (") + fields.map({ _.getName() }).mkString(",") + ") " + beans2Prepare(beans)
  }

  private def UpdateBatchString(beans: List[T]): String = {

    (("UPDATE " + tablename + " SET ") + fields.filter({ field =>
      field.getName() != keyname
    }).map({ _.getName() }).mkString("=(?) , ") + " =(?) WHERE " + keyname + " = (?);") * beans.size
  }

  private def UpdateSelectiveString(bean: T): String = {
    ("UPDATE " + tablename + " SET ") + fields.filter({ field =>
      field.get(bean) != null && field.getName() != keyname
    }).map({ _.getName() }).mkString("=(?) , ") + " =(?) WHERE " + keyname + " = (?)"
  }

  private def UpdateCondString(beanset: T, beanfilter: T): String = {
    ("UPDATE " + tablename + " SET ") + fields.filter(_.get(beanset) != null).map({ _.getName() }).mkString("=(?) , ") + " =(?) WHERE " +
      fields.filter(_.get(beanfilter) != null).map { _.getName() }.mkString(" ", "=(?) AND ", "=(?) ")
  }

  private lazy val DeleteOneString: String = {
    "DELETE FROM " + tablename + " WHERE " + keyname + " = (?)";
  }

  private def DeleteCondString(bean: T): String = {
    val selectFields = fields.filter(_.get(bean) != null)
    "DELETE FROM " + tablename + " WHERE " + selectFields.map({ _.getName() }).mkString("=(?) AND ") + " = (?)"
  }

  private def InsertSelectiveString(bean: T): String = {
    val selectFields = fields.filter(_.get(bean) != null)
    ("INSERT INTO " + tablename + " (") + selectFields.map({ _.getName() }).mkString(",") + ") values(" + "?," * (selectFields.size - 1) + "?)"
  }

  def insertSelective(bean: T)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(InsertSelectiveString(bean), bean2SelectiveArray(bean))(f, noexec)

  def insert(bean: T)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(InsertString, bean2Array(bean))(f, noexec)

  def insertBatch(beans: List[T])(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(InsertBatchString(beans), beans2Array(beans))(f, noexec)

  def insertOrUpdate(bean: T)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(InsertOrUpdate, bean2Array(bean) ++ bean2NoKeyArray(bean))(f, noexec)

  def update(bean: T)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(UpdateString, bean2KeyLastArray(bean))(f, noexec)

  //  def updateBatch(beans: List[T])(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(UpdateBatchString(beans), beans2KeyLastArray(beans))(f,noexec)

  def updateSelective(bean: T)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(UpdateSelectiveString(bean), bean2NoKeySelectiveArray(bean) ++ bean2KeyArray(bean))(f, noexec)

  def updateByCond(beanset: T, beanfilter: T)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(UpdateCondString(beanset, beanfilter),
    bean2SelectiveArray(beanset) ++ bean2SelectiveArray(beanfilter))(f, noexec)

  def delete(keyy: String)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(DeleteOneString, Array(keyy))(f, noexec)

  def deleteByCond(bean: T)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(DeleteCondString(bean), bean2SelectiveArray(bean))(f, noexec)

  def findByKey(keyy: String)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = if (keyy != null && keyy.length() > 0) exec(SelectOneString, Array(keyy))(f, noexec) else exec(SelectString)(f, noexec)

  def findByCondPrepare(bean: T, range: Range = null)(implicit condition: String = "AND", f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(SelectByCond(bean)(condition) + rangeStr(range), bean2SelectiveArray(bean))(f, noexec)

  def findByCond(cond: String, range: Range = null)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = execQuery(SelectString + " WHERE " + cond + rangeStr(range))(f, noexec)

  //  def findByCondPrepare(cond: String, range: Range = null)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(SelectString + " WHERE " + cond, )(f, noexec)

  def findAll(range: Range = null)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[QueryResult] = exec(SelectString + rangeStr(range))(f, noexec)

  def countAll(): Future[Option[Long]] = exec(CountString).map({ result =>
    result.rows.map({ row =>
      row.head(0).asInstanceOf[Long]
    })
  })

  def countByCond(cond: String)(implicit f: DBResult => Unit = null, noexec: Boolean = false): Future[Option[Long]] = exec(CountByCond(cond))(f, noexec).map({ result =>
    result.rows.map({ row =>
      println("count==" + row.head(0).asInstanceOf[Long])
      row.head(0).asInstanceOf[Long]
    })
  })

  def hb() = exec("SELECT " + keyname + " FROM " + tablename + " LIMIT 1")

  //  import reflect.runtime.universe._

  // then only keep the ones with a MyProperty annotation
  //  fields.flatMap(f => f.annotations.find(_.tpe =:= typeOf[MyProperty]).
  //    map((f, _))).toList

  def execListSub(qr: QueryResult, c: Connection): Future[QueryResult] = {
    qr match {
      case qrw: QueryResultWithArray => c.sendPreparedStatement(qrw.statusMessage, qrw.seqs)
      case _ => c.sendPreparedStatement(qr.statusMessage)
    }
  }
  def execList(fs: List[QueryResult], i: Int, c: Connection): Future[QueryResult] = {
    if (i < fs.size - 1)
      execListSub(fs(i), c).flatMap(r => execList(fs, i + 1, c))
    else
      execListSub(fs(i), c)
  }

  def execInBatch(fs: List[QueryResult])(implicit executionContext: ExecutionContext): Future[QueryResult] = {

    pool.use({
      _.inTransaction({ c =>
        execList(fs, 0, c)
      })
    })(executionContext)
  }
}

