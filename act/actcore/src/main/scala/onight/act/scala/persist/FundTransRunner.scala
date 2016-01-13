package onight.act.scala.persist

import onight.tfw.async.CompleteHandler
import onight.act.ordbgens.act.pbo.Act.PBIActRet
import onight.tfw.otransio.api.beans.FramePacket
import scala.concurrent.Future
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.ExceptionBody
import onight.act.ordbgens.act.so.ACTDAOs.KOTActTransLogs
import onight.act.ordbgens.act.so.ACTDAOs.TActTransLogsDAO

object FundTransRunner extends BatcherCallback[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)] {
  def onBatch(vs: List[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)]): Future[Any] = {
    TActTransLogsDAO.insertBatch(vs.map(_._1))
  }

  def onOne(v: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)): Future[Any] = {
    TActTransLogsDAO.insert(v._1)
  }

  def onSuccess(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)) = {
    //从一个账户到另外一个账户
    x._2.onFinished(PacketHelper.toPBReturn(x._4, x._3.build()));
  }

  def onFailed(x: (KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket),t:Throwable) = {
    x._2.onFinished(PacketHelper.toPBReturn(x._4, new ExceptionBody(t.getMessage, null)));
  }
  
}