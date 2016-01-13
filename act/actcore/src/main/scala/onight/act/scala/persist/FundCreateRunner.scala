package onight.act.scala.persist

import onight.tfw.async.CompleteHandler
import onight.act.ordbgens.act.pbo.Act.PBIActRet
import onight.tfw.otransio.api.beans.FramePacket
import scala.concurrent.Future
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.ExceptionBody
import onight.act.ordbgens.act.so.ACTDAOs.KOTActFund
import onight.act.ordbgens.act.so.ACTDAOs.TActFundDAO

object FundCreateRunner extends BatcherCallback[(KOTActFund, CompleteHandler, PBIActRet.Builder, FramePacket)] {
  def onBatch(vs: List[(KOTActFund, CompleteHandler, PBIActRet.Builder, FramePacket)]): Future[Any] = {
    TActFundDAO.insertBatch(vs.map(_._1))
  }

  def onOne(v: (KOTActFund, CompleteHandler, PBIActRet.Builder, FramePacket)): Future[Any] = {
    TActFundDAO.insert(v._1)
  }

  def onSuccess(x: (KOTActFund, CompleteHandler, PBIActRet.Builder, FramePacket)) = {
    x._2.onFinished(PacketHelper.toPBReturn(x._4, x._3.build()));
  }

  def onFailed(x: (KOTActFund, CompleteHandler, PBIActRet.Builder, FramePacket),t:Throwable) = {
    x._2.onFinished(PacketHelper.toPBReturn(x._4, new ExceptionBody(t.getMessage, null)));
  }
  
}