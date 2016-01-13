package onight.act.scala.persist

import onight.tfw.async.CompleteHandler
import onight.act.ordbgens.act.pbo.Act.PBIActRet
import onight.tfw.otransio.api.beans.FramePacket
import scala.concurrent.Future
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.ExceptionBody
import onight.act.ordbgens.act.so.ACTDAOs.KOTActInfo
import onight.act.ordbgens.act.so.ACTDAOs.TActInfoDAO

object ActCreateRunner extends BatcherCallback[(KOTActInfo, CompleteHandler, PBIActRet.Builder, FramePacket)] {
  def onBatch(vs: List[(KOTActInfo, CompleteHandler, PBIActRet.Builder, FramePacket)]): Future[Any] = {
    TActInfoDAO.insertBatch(vs.map(_._1))
  }

  def onOne(v: (KOTActInfo, CompleteHandler, PBIActRet.Builder, FramePacket)): Future[Any] = {
    TActInfoDAO.insert(v._1)
  }

  def onSuccess(x: (KOTActInfo, CompleteHandler, PBIActRet.Builder, FramePacket)) = {
    x._2.onFinished(PacketHelper.toPBReturn(x._4, x._3.build()));
  }

  def onFailed(x: (KOTActInfo, CompleteHandler, PBIActRet.Builder, FramePacket), t: Throwable) = {
    x._2.onFinished(PacketHelper.toPBReturn(x._4, new ExceptionBody(t.getMessage, null)));
  }
}