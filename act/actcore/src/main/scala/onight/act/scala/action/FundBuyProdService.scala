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
import onight.act.scala.persist.FundBuyXRunner
import io.netty.util.concurrent.FailedFuture
import io.netty.util.concurrent.GlobalEventExecutor
import scala.util.Failure
import scala.concurrent.impl.Future
import scala.util.Try
import scala.util.Failure
import scala.concurrent.impl.Future
import scala.concurrent.Future
import com.github.mauricio.async.db.QueryResult
import onight.act.ordbgens.act.pbo.Act.PBIFundBuy

@NActorProvider
object FundBuyCreateActor extends SessionModules[PBIFundBuy] {
  override def service = FundBuyService
}

object FundBuyService extends OLog with PBUtils with LService[PBIFundBuy] {

  override def cmd: String = PBCommand.BUY.name();

  val buckets = new ConcurrentLinkedQueue[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket, PBIFundBuy)]();
  {
    for (i <- 1 to NodeHelper.getPropInstance.get("insert.run.checkcount", 5)) {
      BatchCheckExc.exec.scheduleAtFixedRate(new BatchRunner[(KOTActTransLogs, CompleteHandler, PBIActRet.Builder, FramePacket, PBIFundBuy)](FundBuyXRunner, buckets), 10, NodeHelper.getPropInstance.get("insert.run.periodms", 100), TimeUnit.MICROSECONDS);
    }
  }

  //http://localhost:18080/act/pbbuy.do?fh=VBUYACT000000J00&bd={%22from_fund_no%22:{"a001","a002"},%22to_fund_no%22:%22a004%22,%22amt%22:100.0,%22sett_date%22:%2220160118%22,%22cons_date%22:%2220160118%22,%22tx_sno%22:%221%22,%22dc_type%22:%22001%22,%22cnt%22:1}&gcmd=BUYACT

  def onPBPacket(pack: FramePacket, pbo: PBIFundBuy, handler: CompleteHandler) = {
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
      vmap.put("FROM_FUND_NO",pbo.getFromFundNo(0) )
      val v = TActTransLogsDAO.instanceFromMap(vmap.asInstanceOf[HashMap[String, Object]])

      ret.setFundNo(v.TO_FUND_NO)
      
      buckets.offer((v, handler, ret, pack,pbo));
      
//
//      import scala.concurrent.ExecutionContext.Implicits.global
//
//      implicit def qresult(result: QueryResult, index: Int) = {
//        println("getresult:" + "@@" + index + ",R=" + result)
//      }
//      val ff = TActTransLogsDAO.pool.use { x =>
//        x.inTransaction { c =>
//          val c0 = c.sendPreparedStatement("UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL-(?) WHERE FUND_NO = (?) AND CUR_BAL>(?);", Seq(200, "a001", 200))
//            .flatMap { qr =>
//              println("qr1 ==>" + qr)
//              if (qr.rowsAffected > 0) {
//                val c1 = c.sendPreparedStatement("UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL-(?) WHERE FUND_NO = (?) AND CUR_BAL>(?);", Seq(200, "a002", 200));
//                //                c1.onComplete { c1x =>
//                //                  println("c1x ==>" + c1x)
//                //                }
//                c1
//              } else {
//                ret.setRetcode(RetCode.FAILED).setDesc("First Sub Error")
//                handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
//                Future.successful(new RuntimeException("First sub error"))
//              }
//            }.flatMap {
//              case qr: QueryResult =>
//                println("qr2 ==>" + qr)
//                if (qr.rowsAffected > 0) {
//                  ret.setRetcode(RetCode.SUCCESS).setDesc("Success")
//                  handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
//                  Future.successful(qr)
//                } else {
//                  ret.setRetcode(RetCode.FAILED).setDesc("２nd Sub Error")
//                  handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
//                  c.sendPreparedStatement("UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL+(?) WHERE FUND_NO = (?)", Seq(200, "a001"));//加回去
////                  Future.failed(new RuntimeException("Second sub error"))
//                }
//            }
//          //          c0.onComplete { c0x =>
//          //            println("c0x ==>" + c0x)
//          //          }
//
//          c0
//        }
//      }
      //      val ff = TActTransLogsDAO.execBatch("UPDATE T_ACT_FUND SET CUR_BAL = CUR_BAL-(?) WHERE FUND_NO = (?) AND CUR_BAL>(?);",
      //        List(Seq(200, "a001", 200), Seq(-200, "a001", -200), Seq(200, "a001", 200), Seq(200, "a001", 200)))
      //      
    }

  }
}