package onight.act.scala.persist

import java.util.concurrent.ConcurrentHashMap
import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.Future
import com.github.mauricio.async.db.Connection
import com.github.mauricio.async.db.QueryResult
import onight.act.ordbgens.act.pbo.Act.PBIActRet
import onight.act.ordbgens.act.pbo.Act.PBIActRet.RetCode
import onight.act.ordbgens.act.so.ACTDAOs.KOTActTransLogs
import onight.act.ordbgens.act.so.ACTDAOs.TActTransLogsDAO
import onight.oapi.scala.traits.OLog
import onight.tfw.async.CompleteHandler
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.ExceptionBody
import onight.tfw.otransio.api.beans.FramePacket
import scala.collection.mutable.Map
import scala.concurrent.Await
import scala.concurrent.duration._
import com.github.mauricio.async.db.QueryResult

object FundTransXRunner extends BatcherCallback[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)] with OLog {
  val insertSQLMap = new ConcurrentHashMap[Int, String]();
  implicit lazy val global: ExecutionContextExecutor = ExecutionContext.fromExecutor(BatchCheckExc.daoexec)

  def updateSeq(p: Future[QueryResult], c: Connection, v: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)): Future[QueryResult] = {
    p.flatMap { pr =>
      c.sendPreparedStatement("UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL-(?),UPDATE_ACT_LOG_ID = (?) WHERE FUND_NO = (?) AND CUR_BAL>=(?);", Seq(v._1.AMT, v._1.LOG_UUID, v._1.FROM_FUND_NO,
        if (v._1.FROM_FUND_NO.startsWith("S000")) {
          Some(Double.MinValue)
        } else {
          v._1.AMT
        }))
        .flatMap { qr =>
          if (qr.rowsAffected > 0) {
            v._3.setRetcode(RetCode.SUCCESS).setDesc("Success").setStatus("0000")
            //            v._2.onFinished(PacketHelper.toPBReturn(v._4, v._3.build()));
            c.sendPreparedStatement("UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL+(?),UPDATE_ACT_LOG_ID = (?) WHERE FUND_NO = (?)", Seq(v._1.AMT, v._1.LOG_UUID, v._1.TO_FUND_NO))
            //            c.sendPreparedStatement("INSERT INTO T_ACT_TRANS_LOGS_DEBT(LOG_UUID,FROM_FUND_NO,TO_FUND_NO) values(?,?,?) ", Seq(v._1.LOG_UUID, v._1.FROM_FUND_NO, v._1.TO_FUND_NO))

          } else {
            v._3.setRetcode(RetCode.FAILED).setDesc("First_BAL_NOT_ENOUGH").setStatus("0010")
            //            v._2.onFinished(PacketHelper.toPBReturn(v._4, v._3.build()));
            Future.successful(qr)
          }
        }
    }
  }

  def subs(p: Future[QueryResult], c: Connection, v: (Double, String, String)): Future[QueryResult] = {
    p.flatMap { pr =>
      c.sendPreparedStatement("UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL-(?),UPDATE_ACT_LOG_ID = (?) WHERE FUND_NO = (?) AND CUR_BAL>=(?);", Seq(v._1, v._2, v._3,
        if (v._3.startsWith("S000")) {
          Some(Double.MinValue)
        } else {
          v._1
        }))
        .flatMap { qr =>
          if (qr.rowsAffected > 0) {
            Future.successful(qr)
          } else {
            Future.failed(new RuntimeException("cannot_sub_all"));
          }
        }
    }
  }
  def adds(p: Future[QueryResult], c: Connection, v: (Double, String, String)): Future[QueryResult] = {
    p.flatMap { pr =>
      c.sendPreparedStatement("UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL+(?),UPDATE_ACT_LOG_ID = (?) WHERE FUND_NO = (?);", Seq(v._1, v._2, v._3))
        .flatMap { qr =>
          if (qr.rowsAffected > 0) {
            Future.successful(qr)
          } else {
            Future.failed(new RuntimeException("cannot_add_all"));
          }
        }
    }
  }
  def onBatch(vs: List[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)]): Future[Any] = {
    //2.update金额
    //    log.error("onBatch:" + "@@,size=" + vs.size)
    val start = System.currentTimeMillis()

    val batchv = vs.map(_._1);
    val insertSQL = {
      if (insertSQLMap.containsKey(batchv.size)) {
        insertSQLMap.get(batchv.size)
      } else {
        val ret = TActTransLogsDAO.InsertBatchString(batchv);
        insertSQLMap.put(batchv.size, ret)
        ret
      }
    };

    val insertVals = TActTransLogsDAO.beans2Array(batchv)
    val mapsub = Map[String, (Double, String, String)]();
    val mapadd = Map[String, (Double, String, String)]();

    vs.map({ v =>
      val vdsub = mapsub.get(v._1.FROM_FUND_NO)
      if (vdsub == None) {
        mapsub.put(v._1.FROM_FUND_NO, (v._1.AMT.get, v._1.LOG_UUID, v._1.FROM_FUND_NO))
      } else {
        mapsub.put(v._1.FROM_FUND_NO, (v._1.AMT.get + vdsub.get._1, v._1.LOG_UUID, v._1.FROM_FUND_NO))
      }
      val vdadd = mapadd.get(v._1.TO_FUND_NO)
      if (vdadd == None) {
        mapadd.put(v._1.TO_FUND_NO, (v._1.AMT.get, v._1.LOG_UUID, v._1.TO_FUND_NO))
      } else {
        mapadd.put(v._1.TO_FUND_NO, (v._1.AMT.get + vdadd.get._1, v._1.LOG_UUID, v._1.TO_FUND_NO))
      }
    })

    val ret = TActTransLogsDAO.pool.use { x =>
      x.inTransaction { c =>
        val s = c.sendPreparedStatement(insertSQL, insertVals);
        val sub = mapsub.foldLeft(s)((p, v) => subs(p, c, v._2))
        mapadd.foldLeft(sub)((p, v) => adds(p, c, v._2))
      }
    }
    //    Await.ready(ret, 60 seconds)

    ret onSuccess {
      case result @ _ => {
        vs.map({ v =>
          v._3.setRetcode(RetCode.SUCCESS).setDesc("Success").setStatus("0000")
          v._2.onFinished(PacketHelper.toPBReturn(v._4, v._3.build()));
        })
        Future.successful(result)
      }
    }
    ret onFailure ({
      case t @ _ => {
        log.warn("mapreduce failed:　Trying Batch", t)
        val ret2 = TActTransLogsDAO.pool.use { x =>
          x.inTransaction { c =>
            val s = c.sendPreparedStatement(insertSQL, insertVals);
            vs.foldLeft(s)((p, v) =>
              updateSeq(p, c, v))
          }
        }
        ret2 onSuccess {
          case result @ _ => {
            vs.map({ v =>
              v._2.onFinished(PacketHelper.toPBReturn(v._4, v._3.build()));
            })
          }
        }
        ret2 onFailure ({ //批量还是失败了。
          case t @ _ => {
            log.warn("mapreduce failed:　Trying ONE", t)
            if (vs.size > 0) {
              vs.map({ v =>
                val oneresult = onOne(v)
                oneresult onSuccess {
                  case _ =>
                    v._3.setRetcode(RetCode.SUCCESS).setDesc("Success").setStatus("0000")
                    v._2.onFinished(PacketHelper.toPBReturn(v._4, v._3.build()));
                }
                oneresult onFailure { case t @ _ => onFailed(v, t) }
              })
            } else {
              onFailed(vs(0), t)
            }
          }
        })
      }
    })
    Future.successful("NOOP")

    //    val ret = TActTransLogsDAO.pool.use { x =>
    //      x.inTransaction { c =>
    //        val s = c.sendPreparedStatement(insertSQL, insertVals);
    //        vs.foldLeft(s)((p, v) =>
    //          updateSeq(p, c, v))
    //      }
    //    }
    //    log.error("onBatch:" + "@@,size=" + vs.size + ".end:" + (System.currentTimeMillis() - start) + ",ret=" + ret)

    //    ret
  }

  def onOne(v: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)): Future[Any] = {
    //    TActTransLogsDAO.insert(v._1)
    log.error("onOne in Step.1:")
    onBatch(List(v))
  }

  def onSuccess(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)) = {
    //第一步插入都成功了
    //第二步是update金额
    //        x._2.onFinished(PacketHelper.toPBReturn(x._4, x._3.build()));
  }

  def onFailed(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket), t: Throwable) = {
    x._2.onFinished(PacketHelper.toPBReturn(x._4, new ExceptionBody(t.getMessage, null)));
  }

}
