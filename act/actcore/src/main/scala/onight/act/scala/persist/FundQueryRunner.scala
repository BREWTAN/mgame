package onight.act.scala.persist

import onight.tfw.async.CompleteHandler
import onight.act.ordbgens.act.pbo.Act.PBIActRet
import onight.tfw.otransio.api.beans.FramePacket
import scala.concurrent.Future
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.ExceptionBody
import onight.act.ordbgens.act.so.ACTDAOs.KOTActFund
import onight.act.ordbgens.act.so.ACTDAOs.TActFundDAO
import onight.act.ordbgens.act.pbo.Act.PBIActQuery
import java.util.concurrent.ConcurrentHashMap
import scala.concurrent.ExecutionContext
import onight.act.ordbgens.act.pbo.Act.PBIActRet.RetCode
import scala.concurrent.ExecutionContextExecutor
import onight.tfw.mservice.NodeHelper
import onight.oapi.scala.traits.OLog
import onight.act.ordbgens.act.pbo.Actgens.PBTActFund
import scala.collection.JavaConversions.mapAsScalaMap
import com.google.protobuf.Message
import scala.collection.mutable.MutableList
import java.util.HashMap
import scala.collection.JavaConversions._
import java.util.ArrayList
import com.google.protobuf.Descriptors.FieldDescriptor
import onight.async.mysql.commons.SimpleDAO
import com.github.mauricio.async.db.RowData
import onight.act.ordbgens.act.so.ACTDAOs.TActInfoDAO
import onight.act.ordbgens.act.pbo.Actgens.PBTActInfo

abstract class FundQueryRunner extends BatcherCallback[(String, CompleteHandler, PBIActRet.Builder, FramePacket, FieldDescriptor)] with OLog {
  implicit lazy val global: ExecutionContextExecutor = ExecutionContext.fromExecutor(BatchCheckExc.daoexec)

  val selectSQLMap = new ConcurrentHashMap[Int, String]();

  val BATCH_SIZE = NodeHelper.getPropInstance.get("insert.batchsize", 10);

  val preSQL: String; // = TActFundDAO.SelectString + " WHERE  " + TActFundDAO.keyname;
  val msgDefaultInstance: Message; // = PBTActFund.getDefaultInstance
  def fieldValue(row: RowData, name: String): Any;
  val getRowID: String;

  def initSQL() = {
    for (size <- 1 to BATCH_SIZE) {
      val ret = preSQL + " IN (?" + (",?" * (size - 1)) + ")";
      selectSQLMap.put(size, ret)
    }
    log.error("初始化 batch sql OK:size = " + selectSQLMap.size())
  }

  def onBatch(vs: List[(String, CompleteHandler, PBIActRet.Builder, FramePacket, FieldDescriptor)]): Future[Any] = {

    val selectsql = {
      if (selectSQLMap.containsKey(vs.size)) {
        selectSQLMap.get(vs.size)
      } else {
        val ret = preSQL + " IN (?" + (",?" * (vs.size - 1)) + ")";
        selectSQLMap.put(vs.size, ret)
        ret
      }
    };

    val batchv = vs.map(_._1);
    
    if(batchv.size!=vs.size){
      log.error("not same size::"+batchv.size+",size="+vs.size);
    }

    TActFundDAO.exec(selectsql, batchv.toSeq).onSuccess {
      case qr @ _ => {
        log.debug("result={}", qr);
        val rowmapByID = new HashMap[String, MutableList[Message]]();
        if (qr.rowsAffected > 0) {
          for (row <- qr.rows.head) {
            val rowbuilder = msgDefaultInstance.newBuilderForType()
            for (fd <- rowbuilder.getDescriptorForType.getFields) {
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
            var existlist = rowmapByID.get(row(getRowID).asInstanceOf[String])
            if (existlist == null) {
              existlist = new MutableList[Message]();
              rowmapByID.put(row(getRowID).asInstanceOf[String], existlist);
            }
            existlist += (rowbuilder.build());
          }
        }
        vs.map { v =>
          val rowlist = rowmapByID.get(v._1);
          if (rowlist != null) {
            val fd = v._5; //.getDescriptorForType().findFieldByName("pbfund");
            rowlist.map { msg =>
              v._3.addRepeatedField(fd, msg)
            }
          } else {
            v._3.setRetcode(RetCode.FAILED).setDesc("未找到相关记录");
          }
          v._2.onFinished(PacketHelper.toPBReturn(v._4, v._3.build()));
        }
      }
    }

    Future.successful("NOOP")

  }
  def onOne(v: (String, CompleteHandler, PBIActRet.Builder, FramePacket, FieldDescriptor)): Future[Any] = {

    onBatch(List(v));
    Future.successful("NOOP")
  }

  def onSuccess(x: (String, CompleteHandler, PBIActRet.Builder, FramePacket, FieldDescriptor)) = {
    //    x._2.onFinished(PacketHelper.toPBReturn(x._4, x._3.build()));
  }

  def onFailed(x: (String, CompleteHandler, PBIActRet.Builder, FramePacket, FieldDescriptor), t: Throwable) = {
    //    x._2.onFinished(PacketHelper.toPBReturn(x._4, new ExceptionBody(t.getMessage, null)));
  }

}

object FundQueryFundByActNORunner extends FundQueryRunner {
  val preSQL: String = TActFundDAO.SelectString + " WHERE  ACT_NO ";
  val msgDefaultInstance: Message = PBTActFund.getDefaultInstance
  def fieldValue(row: RowData, name: String): Any = { TActFundDAO.fieldValue(row, name) };
  val getRowID: String = "ACT_NO"
  initSQL();
}

object FundQueryFundByFundNORunner extends FundQueryRunner {
  val preSQL: String = TActFundDAO.SelectString + " WHERE  " + TActFundDAO.keyname;
  val msgDefaultInstance: Message = PBTActFund.getDefaultInstance
  def fieldValue(row: RowData, name: String): Any = { TActFundDAO.fieldValue(row, name) };
  val getRowID: String = TActFundDAO.keyname
  initSQL();
}

object FundQueryActInfoByActNORunner extends FundQueryRunner {
  val preSQL: String = TActInfoDAO.SelectString + " WHERE  " + TActInfoDAO.keyname;
  val msgDefaultInstance: Message = PBTActInfo.getDefaultInstance
  def fieldValue(row: RowData, name: String): Any = { TActInfoDAO.fieldValue(row, name) };
  val getRowID: String = TActInfoDAO.keyname
  
  initSQL();
}



