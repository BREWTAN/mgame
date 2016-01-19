package onight.act.scala.action

import java.sql.Timestamp
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.ScheduledThreadPoolExecutor
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.mutable.HashMap
import onight.act.ordbgens.act.pbo.Act.PBIActRet
import onight.act.ordbgens.act.pbo.Act.PBIActRet.RetCode
import onight.act.ordbgens.act.pbo.Act.PBCommand
import onight.act.ordbgens.act.pbo.Act.PBIFundCreate
import onight.act.ordbgens.act.so.ACTDAOs.KOTActFund
import onight.act.ordbgens.act.so.ACTDAOs.TActFundDAO
import onight.oapi.scala.traits.OLog
import onight.osgi.annotation.NActorProvider
import onight.scala.commons.LService
import onight.scala.commons.PBUtils
import onight.scala.commons.SessionModules
import onight.tfw.async.CompleteHandler
import onight.tfw.mservice.NodeHelper
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.FramePacket
import onight.act.scala.persist.BatchRunner
import onight.act.scala.persist.FundCreateRunner
import org.apache.commons.lang3.StringUtils
import onight.act.scala.persist.BatchCheckExc
import java.util.concurrent.TimeUnit

@NActorProvider
object FundACTCreateActor extends SessionModules[PBIFundCreate] {
  override def service = FundACTCreateService
}

object FundACTCreateService extends OLog with PBUtils with LService[PBIFundCreate] {

  override def cmd: String = PBCommand.CRF.name();

  val buckets = new ConcurrentLinkedQueue[(KOTActFund, CompleteHandler, PBIActRet.Builder, FramePacket)]();
  {
    for (i <- 1 to NodeHelper.getPropInstance.get("insert.run.checkcount", 5)) {
      BatchCheckExc.exec.scheduleAtFixedRate(new BatchRunner[(KOTActFund, CompleteHandler, PBIActRet.Builder, FramePacket)](FundCreateRunner, buckets), 10, NodeHelper.getPropInstance.get("insert.run.periodms", 100), TimeUnit.MICROSECONDS);
    }
  }
  
  //http://localhost:8081/act/pbcrf.do?fh=VCRFACT000000J00&bd={"fund_no":"a001","act_no":"1235","cust_id":"abcdefg","act_name":"你好","mchnt_id":"abc","channel_id":"abc"}&gcmd=CRTACF
  

  def onPBPacket(pack: FramePacket, pbo: PBIFundCreate, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBIActRet.newBuilder();

    if (pbo == null) {
      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getActNo)) {
      ret.setDesc("账户号不能为空").setStatus("0002") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getFundNo)) {
      ret.setDesc("资金子账户号不能为空").setStatus("0002") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else {
      //      val v = KOTActFund(UUIDGenerator.generate(), pbo.getActNo, UUIDGenerator.generate(), "123", "aff", "aabb");
      val vmap = pbo.getAllFields.map({ kv =>
        (kv._1.getName.toUpperCase(), kv._2)
      })
      vmap.put("CREATE_TIME",  java.lang.Long.valueOf(System.currentTimeMillis()))
      vmap.put("ACT_STAT", "0")
      vmap.put("CUR_BAL",java.lang.Double.valueOf(0.0))
      val v = TActFundDAO.instanceFromMap(vmap.asInstanceOf[HashMap[String, Object]])

      ret.setActNo(v.ACT_NO)
      ret.setFundNo(v.FUND_NO)

      if (v.ACT_NO == null) { //如果主账户不存在，则自动创建一个主账户，id=custid
        //        ACTCreateService.buckets.offer(e)  
      }

      buckets.offer((v, handler, ret, pack));
    }

  }
}