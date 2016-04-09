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
import onight.act.ordbgens.act.pbo.Act._
import onight.act.ordbgens.act.so.ACTDAOs.TActInfoDAO
import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.ExecutionContext
import onight.act.ordbgens.act.pbo.Actgens.PBTActInfo
import com.github.mauricio.async.db.QueryResult
import onight.act.ordbgens.act.pbo.Actgens.PBTActFund
import onight.async.mysql.commons.Range
import com.google.protobuf.Descriptors.FieldDescriptor
import onight.act.scala.persist.FundQueryRunner
import onight.act.scala.persist.FundQueryFundByFundNORunner
import onight.act.scala.persist.FundQueryActInfoByActNORunner
import onight.act.scala.persist.FundQueryFundByActNORunner

@NActorProvider
object FundQueryCreateActor extends SessionModules[PBIActQuery] {
  override def service = FundQueryService
}

object FundQueryService extends OLog with PBUtils with LService[PBIActQuery] {

  implicit lazy val global: ExecutionContextExecutor = ExecutionContext.fromExecutor(BatchCheckExc.daoexec)

  override def cmd: String = PBCommand.QUE.name();

  val bucketsFundByFundNO = new ConcurrentLinkedQueue[(String, CompleteHandler, PBIActRet.Builder, FramePacket, FieldDescriptor)]();
  val bucketsFundByActNO = new ConcurrentLinkedQueue[(String, CompleteHandler, PBIActRet.Builder, FramePacket, FieldDescriptor)]();
  val bucketsActInfoByActNO = new ConcurrentLinkedQueue[(String, CompleteHandler, PBIActRet.Builder, FramePacket, FieldDescriptor)]();
  {
    for (i <- 1 to NodeHelper.getPropInstance.get("insert.run.checkcount", 5)) {
      BatchCheckExc.exec.scheduleAtFixedRate(new BatchRunner[(String, CompleteHandler, PBIActRet.Builder, FramePacket, FieldDescriptor)](FundQueryFundByFundNORunner, bucketsFundByFundNO), 10, NodeHelper.getPropInstance.get("insert.run.periodms", 100), TimeUnit.MICROSECONDS);
      BatchCheckExc.exec.scheduleAtFixedRate(new BatchRunner[(String, CompleteHandler, PBIActRet.Builder, FramePacket, FieldDescriptor)](FundQueryFundByActNORunner, bucketsFundByActNO), 10, NodeHelper.getPropInstance.get("insert.run.periodms", 100), TimeUnit.MICROSECONDS);
      BatchCheckExc.exec.scheduleAtFixedRate(new BatchRunner[(String, CompleteHandler, PBIActRet.Builder, FramePacket, FieldDescriptor)](FundQueryActInfoByActNORunner, bucketsActInfoByActNO), 10, NodeHelper.getPropInstance.get("insert.run.periodms", 100), TimeUnit.MICROSECONDS);
    }
  }

  //
  //  http://localhost:18080/act/pbque.do?fh=VQUEACT000000J00&bd={%22act_no%22:%22abc%22}&gcmd=QUEACT

  def onPBPacket(pack: FramePacket, pbo: PBIActQuery, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBIActRet.newBuilder();

    if (pbo == null) {
      //      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getActNo) && StringUtils.isBlank(pbo.getFundNo)) {
      ret.setDesc("账户号和资金子账户不能同时为空").setStatus("0002") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));

    } else {

      val buckets = {
        val fdact = ret.getDescriptorForType().findFieldByName("pbact");
        val fdfund = ret.getDescriptorForType().findFieldByName("pbfund");
        if (StringUtils.isNoneBlank(pbo.getActNo)) {
          if (StringUtils.equals("*", pbo.getFundNo)) {
            (bucketsFundByActNO, fdfund, pbo.getActNo);
          } else {
            (bucketsActInfoByActNO, fdact, pbo.getActNo);
          }
        } else {
          (bucketsFundByFundNO, fdfund, pbo.getFundNo);
        }
      }
      buckets._1.offer((buckets._3, handler, ret, pack, buckets._2));
      //     
      //
      //      val fdact = ret.getDescriptorForType().findFieldByName("pbact");
      //      val fdfund = ret.getDescriptorForType().findFieldByName("pbfund");
      //      if (StringUtils.isNoneBlank(pbo.getActNo)) {
      //        if (StringUtils.equals("*", pbo.getFundNo)) {
      //          TActFundDAO.findByCond("ACT_NO = '" + pbo.getActNo + "'", new Range(0, 100)) onComplete { x =>
      //            try {
      //              if (TActFundDAO.resultRowTOPB(ret, fdfund, x)) {
      //              } else {
      //                ret.setDesc("未找到:").setRetcode(RetCode.FAILED)
      //              }
      //              handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
      //            } catch {
      //              case e: Throwable => {
      //                log.error("unkonw error:2:", e)
      //                ret.setDesc("出错了:" + e.getMessage).setRetcode(RetCode.FAILED)
      //                handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
      //              }
      //            }
      //          }
      //        } else {
      //          //先查主账户，如果不为空则肯定需要查出这个用户的信息的；
      //          //如果为空则不管
      //          TActInfoDAO.findByKey(pbo.getActNo) onComplete { x =>
      //            try {
      //              if (TActInfoDAO.resultRowTOPB(ret, fdact, x)) {
      //              } else {
      //                ret.setDesc("未找到:").setRetcode(RetCode.FAILED)
      //              }
      //              handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
      //            } catch {
      //              case e: Throwable => {
      //                log.error("unkonw error:2:", e)
      //                ret.setDesc("出错了:" + e.getMessage).setRetcode(RetCode.FAILED)
      //                handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
      //              }
      //            }
      //          }
      //          //          ret.setPbact(pbBeanUtil.toPB(PBTActInfo.newBuilder(), x))            
      //        }
      //      } else if (StringUtils.isNoneBlank(pbo.getFundNo)) {
      //        //先查主账户，如果不为空则肯定需要查出这个用户的信息的；
      //        //如果为空则不管
      //        TActFundDAO.findByKey(pbo.getFundNo) onComplete { x =>
      //          try {
      //            if (TActFundDAO.resultRowTOPB(ret, fdfund, x)) {
      //            } else {
      //              ret.setDesc("未找到:").setRetcode(RetCode.FAILED)
      //            }
      //            handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
      //          } catch {
      //            case e: Throwable => {
      //              log.error("unkonw error:2:", e)
      //              ret.setDesc("出错了:" + e.getMessage).setRetcode(RetCode.FAILED)
      //              handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
      //            }
      //          }
      //          //          ret.setPbact(pbBeanUtil.toPB(PBTActInfo.newBuilder(), x))            
      //        }
      //      } else {
      //        ret.setDesc("账户号和资金子账户不能同时为空").setStatus("0002") setRetcode (RetCode.FAILED);
      //        handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
      //
      //      }

      //      val v = KOTActFund(UUIDGenerator.generate(), pbo.getActNo, UUIDGenerator.generate(), "123", "aff", "aabb");
    }

  }
}