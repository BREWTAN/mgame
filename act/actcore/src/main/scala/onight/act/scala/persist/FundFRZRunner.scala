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

object FundFRZRunner extends BatcherCallback[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket, Option[Double])] with OLog {
  implicit lazy val global: ExecutionContextExecutor = ExecutionContext.fromExecutor(BatchCheckExc.daoexec)
 
  val insertSQLMap = new ConcurrentHashMap[Int, String]();

  def onBatch(vs: List[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket, Option[Double])]): Future[Any] = {
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
    val updateSQL = "UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL-(?),FREEZE_TOTAL = FREEZE_TOTAL+(?),UPDATE_ACT_LOG_ID = (?) WHERE FUND_NO = (?) AND CUR_BAL>=(?);"
    //3.update状态
    val updateVals = vs.map(x => {
      Seq(x._1.AMT, x._1.LOG_UUID, x._1.TO_FUND_NO, x._5)
    })

    implicit def qresult(result: QueryResult, index: Int) = {
      //      log.debug("getresult:" + "@@" + index + ",R=" + result) //处理成功就返回了，然后往下一步发
      //      log.error("getresult:" + "@@" + index + ",R=" + result+",size="+vs.size)
      //if (index < vs.size) {
      val x = vs(index)
      if (result.rowsAffected > 0) {
        x._3.setRetcode(RetCode.SUCCESS)
      } else {
        log.error("update Failed:" + result + ",index=" + index)
        x._3.setRetcode(RetCode.FAILED)
      }
      x._2.onFinished(PacketHelper.toPBReturn(x._4, x._3.build()));
    }
    //     implicit lazy val global: ExecutionContextExecutor = ExecutionContext.fromExecutor(BatchCheckExc.exec)
    val ret = TActTransLogsDAO.execInsertUpdateBatch(insertSQL, insertVals, updateSQL, updateVals)
    ret
  }

  def onOne(v: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket, Option[Double])): Future[Any] = {
    //    TActTransLogsDAO.insert(v._1)
    log.error("onOne in Step.1:")
    onBatch(List(v))
  }

  def onSuccess(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket, Option[Double])) = {
    //第一步插入都成功了
    //第二步是update金额
    //    x._2.onFinished(PacketHelper.toPBReturn(x._4, x._3.build()));
  }

  def onFailed(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket, Option[Double]), t: Throwable) = {
    x._2.onFinished(PacketHelper.toPBReturn(x._4, new ExceptionBody(t.getMessage, null)));
  }

}

