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
import onight.act.scala.persist.FundTransXRunner
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
      import scala.concurrent.ExecutionContext.Implicits.global

@NActorProvider
object FundTransCreateActor extends SessionModules[PBIFundTrans] {
  override def service = FundTransService
}

object FundTransService extends OLog with PBUtils with LService[PBIFundTrans] {

  
  override def cmd: String = PBCommand.TRN.name();

  val buckets_insertAndSub = new ConcurrentLinkedQueue[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)]();
  {
    for (i <- 1 to NodeHelper.getPropInstance.get("insert.run.checkcount", 5)) {
      BatchCheckExc.exec.scheduleAtFixedRate(new BatchRunner[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket)](FundTransXRunner, buckets_insertAndSub), 10, NodeHelper.getPropInstance.get("insert.run.periodms", 100), TimeUnit.MICROSECONDS);
    }
  }

  //http://localhost:8081/act/pbtrn.do?fh=VTRNACT000000J00&bd={%22from_fund_no%22:%22S0001%22,%22to_fund_no%22:%22a001%22,%22amt%22:100.0,%22sett_date%22:%2220160118%22,%22cons_date%22:%2220160118%22,%22tx_sno%22:%221%22,%22dc_type%22:%22001%22,%22cnt%22:1}&gcmd=CRTTRN
  
  //ab -n 1000000 -k -r -c 1000 "http://localhost:18080/act/pbtrn.do?fh=VTRNACT000000J00&bd={%22from_fund_no%22:%22S0001%22,%22to_fund_no%22:%22a001%22,%22amt%22:100.0,%22sett_date%22:%2220160118%22,%22cons_date%22:%2220160118%22,%22tx_sno%22:%221%22,%22dc_type%22:%22001%22,%22cnt%22:1}&gcmd=CRTTRN"

  
  def onPBPacket(pack: FramePacket, pbo: PBIFundTrans, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBIActRet.newBuilder();

    if (pbo == null) {
      //      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getFromFundNo)) {
      ret.setDesc("来帐账户号不能为空").setStatus("0002") setRetcode (RetCode.FAILED);
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
      vmap.put("LOG_UUID", UUIDGenerator.generate())
      vmap.put("DC_TYPE", cmd)
      val v = TActTransLogsDAO.instanceFromMap(vmap.asInstanceOf[HashMap[String, Object]])
      ret.setFundNo(v.TO_FUND_NO)
      
      buckets_insertAndSub.offer((v, handler, ret, pack));
      
//      import scala.concurrent.ExecutionContext.Implicits.global

//      implicit def qresult(result: QueryResult, index: Int) = {
////        println("getresult:" + "@@" + index +",R="+ result)
//      }
//      val ff = TActTransLogsDAO.execBatch("UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL-(?) WHERE FUND_NO = (?) AND CUR_BAL>(?);",
//        List(Seq(200, "a001", 200)))
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