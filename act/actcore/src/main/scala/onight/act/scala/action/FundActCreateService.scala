package onight.act.scala.action

import scala.concurrent.ExecutionContext.Implicits.global
import onight.act.scala.persist.ACTDAOs
import onight.osgi.annotation.NActorProvider
import onight.scala.commons.PBUtils
import onight.tfw.outils.serialize.UUIDGenerator
import onight.tfw.async.CompleteHandler
import onight.scala.commons.LService
import onight.oapi.scala.traits.OLog
import onight.scala.commons.SessionModules
import com.github.mauricio.async.db.RowData
import onight.tfw.otransio.api.beans.FramePacket
import onight.tfw.otransio.api.PacketHelper
import onight.act.scala.persist.ACTDAOs.KOActInfo
import onight.act.ordbgens.act.pbo.Act.PBActCreate
import onight.act.ordbgens.act.pbo.Act.PBCommand
import onight.act.ordbgens.act.pbo.Act.PBActRet
import onight.act.ordbgens.act.pbo.Act.PBActRet.RetCode
import scala.collection.mutable.MutableList
import scala.collection.mutable.ListBuffer
import onight.act.scala.persist.BatchInsertRunner
import java.util.concurrent.ScheduledThreadPoolExecutor
import onight.tfw.mservice.NodeHelper
import java.util.concurrent.ConcurrentLinkedQueue
import onight.act.ordbgens.act.pbo.Act.PBFundCreate

@NActorProvider
object FundACTCreateActor extends SessionModules[PBFundCreate] {
  override def service = FundACTCreateService
}

object FundACTCreateService extends OLog with PBUtils with LService[PBFundCreate] {

  override def cmd: String = PBCommand.CRT.name();

  val buckets = new ConcurrentLinkedQueue[(KOActInfo, CompleteHandler, PBActRet.Builder, FramePacket)]();
  val exec = new ScheduledThreadPoolExecutor(NodeHelper.getPropInstance.get("insert.run.thread", 10));

  {
    for (i <- 1 to NodeHelper.getPropInstance.get("insert.run.thread",10)) {
      exec.execute(new BatchInsertRunner[KOActInfo](ACTDAOs.actInfoDAO, buckets));
    }
  }

  def onPBPacket(pack: FramePacket, pbo: PBFundCreate, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBActRet.newBuilder();

    if (pbo == null) {
      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else {
      val v = KOActInfo(UUIDGenerator.generate(), "test123", UUIDGenerator.generate(), "123", "aff", "aabb");
      ret.setActNo(v.ACT_NO)
      buckets.offer((v, handler, ret, pack));
    }

  }
}