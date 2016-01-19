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
import onight.act.ordbgens.act.so.ACTDAOs.KOTActTransLogs
import onight.act.ordbgens.act.so.ACTDAOs.TActTransLogsDAO
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
import onight.act.scala.persist.FundTransRunner
import org.apache.commons.lang3.StringUtils
import onight.act.scala.persist.BatchCheckExc
import java.util.concurrent.TimeUnit
import onight.act.ordbgens.act.pbo.Act.PBIFundTrans
import onight.tfw.otransio.api.beans.ExceptionBody
import onight.act.ordbgens.act.so.ACTDAOs.KOTActTransLogs
import onight.act.ordbgens.act.so.ACTDAOs.TActFundDAO
import onight.act.ordbgens.act.so.ACTDAOs.KOTActFund
import com.github.mauricio.async.db.QueryResult
import onight.tfw.outils.serialize.UUIDGenerator
import onight.act.scala.persist.FundAddRunner

@NActorProvider
object FundADDCreateActor extends SessionModules[PBIFundTrans] {
  override def service = FundADDService
}

object FundADDService extends OLog with PBUtils with LService[PBIFundTrans] {

  override def cmd: String = PBCommand.ADD.name();

  val buckets = new ConcurrentLinkedQueue[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket,Option[Double])]();
  {
    for (i <- 1 to NodeHelper.getPropInstance.get("insert.run.checkcount", 5)) {
      BatchCheckExc.exec.scheduleAtFixedRate(new BatchRunner[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket,Option[Double])](FundAddRunner, buckets), 10, NodeHelper.getPropInstance.get("insert.run.periodms", 100), TimeUnit.MICROSECONDS);
    }
  }

  //http://localhost:8081/act/pbcrf.do?fh=VCRFACT000000J00&bd={"fund_no":"a001","act_no":"1235","cust_id":"abcdefg","act_name":"你好","mchnt_id":"abc","channel_id":"abc"}&gcmd=CRTACF

  def onPBPacket(pack: FramePacket, pbo: PBIFundTrans, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBIActRet.newBuilder();

    if (pbo == null) {
      //      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getToFundNo)) {
      ret.setDesc("到帐账户号不能为空").setStatus("0002") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else {
      //      val v = KOTActFund(UUIDGenerator.generate(), pbo.getActNo, UUIDGenerator.generate(), "123", "aff", "aabb");
      val vmap = pbo.getAllFields.map({ kv =>
        (kv._1.getName.toUpperCase(), kv._2)
      })
      vmap.put("CREATE_TIME", java.lang.Long.valueOf(System.currentTimeMillis()))
      vmap.put("STATUS", "0000")
      vmap.put("DC_TYPE", cmd)
      vmap.put("LOG_UUID", UUIDGenerator.generate())
      val v = TActTransLogsDAO.instanceFromMap(vmap.asInstanceOf[HashMap[String, Object]])
      ret.setFundNo(v.TO_FUND_NO)
      if(v.AMT.get>=0)
      {
         buckets.offer((v, handler, ret, pack,Some(Double.MinValue))); 
      }else{
        buckets.offer((v, handler, ret, pack,Some(-v.AMT.get)));
      }
      
//      val v = TActTransLogsDAO.instanceFromMap(vmap.asInstanceOf[HashMap[String, Object]])
//
//      ret.setFundNo(v.TO_FUND_NO)
//
//      import scala.concurrent.ExecutionContext.Implicits.global
//
//      implicit def qresult(result: QueryResult, index: Int) = {
//        println("getresult:" + "@@" + index +",R="+ result)
//      }
//      val ff = TActTransLogsDAO.execBatch("UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL-(?) WHERE FUND_NO = (?) AND CUR_BAL>(?);",
//        List(Seq(200, "a001", 200),Seq(-200, "a001", -200),Seq(200, "a001", 200),Seq(200, "a001", 200)))
//      //      val ff = TActFundDAO.updateSelective(new KOTActFund("a0001",CUR_BAL = Some(1000.0)))
//      ff onSuccess {
//        case result @ _ => {
////          println("result::" + result)
//          handler.onFinished(PacketHelper.toPBReturn(pack, ret));
//        }
//      }
//      ff onFailure ({
//        case t @ _ => {
//          handler.onFinished(PacketHelper.toPBReturn(pack, new ExceptionBody(t.getMessage, null)));
//        }
//      })
      //      buckets.offer((v, handler, ret, pack));
    }

  }
}