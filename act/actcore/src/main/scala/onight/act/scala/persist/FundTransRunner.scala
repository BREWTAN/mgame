package onight.act.scala.persist

import onight.tfw.async.CompleteHandler
import onight.act.ordbgens.act.pbo.Act.PBIActRet
import onight.tfw.otransio.api.beans.FramePacket
import scala.concurrent.Future
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.ExceptionBody
import onight.act.ordbgens.act.so.ACTDAOs.KOTActTransLogs
import onight.act.ordbgens.act.so.ACTDAOs.TActTransLogsDAO
import com.github.mauricio.async.db.QueryResult
import onight.tfw.outils.serialize.UUIDGenerator
import java.util.concurrent.ConcurrentLinkedQueue
import onight.tfw.mservice.NodeHelper
import java.util.concurrent.TimeUnit
import onight.oapi.scala.traits.OLog
import onight.act.ordbgens.act.pbo.Act.PBIActRet.RetCode
import java.sql.Timestamp
import scala.collection.mutable.ListBuffer
import java.util.concurrent.ConcurrentHashMap
import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.ExecutionContext
import onight.act.ordbgens.act.so.ACTDAOs.TActTransLogsHisDAO

object FundTransRunner extends BatcherCallback[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)] with OLog {
  implicit lazy val global: ExecutionContextExecutor = ExecutionContext.fromExecutor(BatchCheckExc.daoexec)

  val insertSQLMap = new ConcurrentHashMap[Int, String]();

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
    val updateSQL = "UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL-(?) ,UPDATE_ACT_LOG_ID = (?) WHERE FUND_NO = (?) AND CUR_BAL>(?);"
    //3.update状态
    val updateVals = vs.map(x => {
      if (x._1.FROM_FUND_NO.startsWith("S000")) {
        Seq(x._1.AMT,x._1.LOG_UUID, x._1.FROM_FUND_NO, Some(Double.MinValue))
      } else {
        Seq(x._1.AMT,x._1.LOG_UUID, x._1.FROM_FUND_NO, x._1.AMT)
      }
    })

    implicit def qresult(result: QueryResult, index: Int) = {
      //      log.debug("getresult:" + "@@" + index + ",R=" + result) //处理成功就返回了，然后往下一步发
      //      log.error("getresult:" + "@@" + index + ",R=" + result+",size="+vs.size)
      //if (index < vs.size) {
      val x = vs(index)
      if (result.rowsAffected > 0) {
        x._3.setRetcode(RetCode.SUCCESS)
        FundTransStep2_AddRunner.bucketsStep2_update.add(x)
      } else {
        log.error("update Failed:" + result + ",index=" + index)
        x._3.setRetcode(RetCode.FAILED)
        FundTransStep3FinalUpdateLogRunner.buckets_Final_update.add(x)
      }
      x._2.onFinished(PacketHelper.toPBReturn(x._4, x._3.build()));
      //}
    }
    //     implicit lazy val global: ExecutionContextExecutor = ExecutionContext.fromExecutor(BatchCheckExc.exec)

    val ret = TActTransLogsDAO.execInsertUpdateBatch(insertSQL, insertVals, updateSQL, updateVals)

    //    log.error("onBatch:" + "@@,size=" + vs.size + ".end:" + (System.currentTimeMillis() - start) + ",ret=" + ret)

    ret
  }

  def onOne(v: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)): Future[Any] = {
    //    TActTransLogsDAO.insert(v._1)
    log.error("onOne in Step.1:")
    onBatch(List(v))

  }

  def onSuccess(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)) = {
    //第一步插入都成功了
    //第二步是update金额
    //    x._2.onFinished(PacketHelper.toPBReturn(x._4, x._3.build()));
  }

  def onFailed(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket), t: Throwable) = {
    x._2.onFinished(PacketHelper.toPBReturn(x._4, new ExceptionBody(t.getMessage, null)));
  }

}
//2.update金额
object FundTransStep2_AddRunner extends BatcherCallback[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)] with OLog {

  val bucketsStep2_update = new ConcurrentLinkedQueue[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)]();
//  {
//    for (i <- 1 to NodeHelper.getPropInstance.get("insert.run.checkcount", 5)) {
//      BatchCheckExc.exec.scheduleAtFixedRate(new BatchRunner[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)](FundTransStep2_AddRunner, bucketsStep2_update), 10, NodeHelper.getPropInstance.get("insert.run.periodms", 100), TimeUnit.MICROSECONDS);
//    }
//  }

//  val updateSQLMap = new ConcurrentHashMap[Int, List[String]]();
  val insertSQLMap = new ConcurrentHashMap[Int, String]();

  def onBatch(vs: List[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)]): Future[Any] = {
    val start = System.currentTimeMillis()

    val batchv = vs.map(_._1);
    val insertSQL = {
      if (insertSQLMap.containsKey(batchv.size)) {
        insertSQLMap.get(batchv.size)
      } else {
//        val ret = TActTransLogsDAO.InsertBatchString(batchv).replace("T_ACT_TRANS_LOGS", "T_ACT_TRANS_LOGS_HIS");
        val varray=(",(?,?,?)"*batchv.size);
        val ret =  "INSERT INTO T_ACT_TRANS_LOGS_DEBT(LOG_UUID,FROM_FUND_NO,TO_FUND_NO) values "+varray.replaceFirst(",", "");
        insertSQLMap.put(batchv.size, ret)
        ret
      }
    };
//    log.error("insertv = "+insertSQL)
//    val insertVals = TActTransLogsDAO.beans2Array(batchv)
    val insertVals = vs.flatMap(x=> List(x._1.LOG_UUID,x._1.FROM_FUND_NO,x._1.TO_FUND_NO))
    val updateSQL = "UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL+(?),UPDATE_ACT_LOG_ID = (?) WHERE FUND_NO = (?)"
    
    //3.update状态
    val updateVals = vs.map(x => {
      Seq(x._1.AMT,x._1.LOG_UUID, x._1.TO_FUND_NO)
    })

    val ret = TActTransLogsHisDAO.execInsertUpdateBatch(insertSQL, insertVals.toSeq, updateSQL, updateVals)

    //    log.error("onBatch:" + "@@,size=" + vs.size + ".end:" + (System.currentTimeMillis() - start) + ",ret=" + ret)

    ret

    //
    ////    val updateVals_Fund = vs.map(x => {
    ////      Seq(x._1.AMT, x._1.TO_FUND_NO)
    ////    })
    //
    ////    val updateVals_Logs = vs.map(x => {
    ////      Seq(x._1.AMT, x._1.TO_FUND_NO)
    ////    })
    //
    //    val updateSQL = {
    //      if (updateSQLMap.containsKey(vs.size)) {
    //        updateSQLMap.get(vs.size)
    //      } else {
    //        val updateSql = ListBuffer[String]();
    //        for (i <- 1 to vs.size) {
    //          updateSql.append("UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL + (?) WHERE FUND_NO = (?);")
    //        }
    ////        for (i <- 1 to vs.size) {
    ////          updateSql.append("UPDATE T_ACT_TRANS_LOGS SET `STATUS` = '0001' , UPDATE_TIME = (?) WHERE LOG_UUID = (?);")
    ////        }
    //        val ret = updateSql.toList
    //        updateSQLMap.put(vs.size, ret)
    //        ret
    //      }
    //    }
    //
    //    val curtime = new Timestamp(System.currentTimeMillis()).toString();
    //    val updateVals = vs.map(x => {
    //      Seq(x._1.AMT, x._1.TO_FUND_NO)
    ////    })  ::: vs.map(x => {
    ////      Seq(curtime, x._1.LOG_UUID)
    //    })
    //    //    log.debug("FundTransStep2_AddRunner.onBatch.size=" + vs.size+",sql="+updateSql+",vals="+updateVals)
    //    //    implicit def qresult(result: QueryResult, index: Int) = {
    //    //      if (result.rowsAffected <= 0) {
    //    //        log.error("exec error in batch 2:" + index)
    //    //      }
    //    //    }
    //    //     implicit lazy val global: ExecutionContextExecutor = ExecutionContext.fromExecutor(BatchCheckExc.exec)
    //
    //    TActTransLogsDAO.execBatchUpdates(updateSQL, updateVals)

  }

  def onOne(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)): Future[Any] = {
    log.error("onOne in Step.2:")
    onBatch(List(x))
  }

  def onSuccess(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)) = {
    log.debug("update OKOK in Step2:")
  }

  def onFailed(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket), t: Throwable) = {
    log.error("error in Step2:", t)
  }

}

//3.最后更新交易日志
object FundTransStep3FinalUpdateLogRunner extends BatcherCallback[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)] with OLog {

  val buckets_Final_update = new ConcurrentLinkedQueue[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)]();
  {
    for (i <- 1 to NodeHelper.getPropInstance.get("insert.run.checkcount", 5)) {
      BatchCheckExc.exec.scheduleAtFixedRate(new BatchRunner[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)](FundTransStep3FinalUpdateLogRunner, buckets_Final_update), 10, NodeHelper.getPropInstance.get("insert.run.periodms", 100), TimeUnit.MICROSECONDS);
    }
  }

  def onBatch(vs: List[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)]): Future[Any] = {
    val updateSQL = "UPDATE T_ACT_TRANS_LOGS SET STATUS = (?) , UPDATE_TIME = (?) WHERE LOG_UUID = (?);"
    val updateVals = vs.map(x => {
      Seq(
        if (x._3.getRetcode == RetCode.SUCCESS) {
          "0003"
        } else {
          "0009"
        }, new Timestamp(System.currentTimeMillis()).toString(), x._1.LOG_UUID)
    })
    implicit def qresult(result: QueryResult, index: Int) = {
      //      log.debug("getresult.step.final:" + "@@" + index + ",R=" + result) //处理成功就返回了，然后往下一步发
    }
    TActTransLogsDAO.execBatch(updateSQL, updateVals)

  }

  def onOne(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)): Future[Any] = {

    log.error("onOne in Step.Final:")

    onBatch(List(x))
  }

  def onSuccess(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)) = {
    log.debug("update OKOK in Step2:")
  }

  def onFailed(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket), t: Throwable) = {
    log.error("error in Step2:", t)
  }

}
