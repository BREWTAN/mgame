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

@NActorProvider
object ACTCreateActor extends SessionModules[PBActCreate] {
  override def service = ACTCreateService
}

object ACTCreateService extends OLog with PBUtils with LService[PBActCreate] {

  override def cmd: String = PBCommand.CRT.name();

  //ab -n 1000000 -k -r -c 500 "http://localhost:8081/act/pbcrt.do?fh=VCRTACT000000J00&bd={%22op%22:0}&gcmd=CRTACT"
  //Total transferred:      221000000 bytes
  //HTML transferred:       120000000 bytes
  //  Time taken for tests:   250.370 seconds
  //Requests per second:    3994.08 [#/sec] (mean)
  //Time per request:       125.185 [ms] (mean)
  //Time per request:       0.250 [ms] (mean, across all concurrent requests)
  //Transfer rate:          862.00 [Kbytes/sec] received

  // 如果每次插入10条,性能相当于原来的3.5倍，cpu占满
  //Time taken for tests:   67.985 seconds
  //Requests per second:    1470.90 [#/sec] (mean)
  //  ab -n 1000000 -k -r -c 1000 "http://localhost:8081/act/pbcrt.do?fh=VCRTACT000000J00&bd={%22op%22:0}&gcmd=CRTACT"
  
// 每次50笔，100万笔，
//  Concurrency Level:      1000
//Time taken for tests:   76.068 seconds
//Complete requests:      1000000
//Failed requests:        0
//Keep-Alive requests:    1000000
//Total transferred:      203000000 bytes
//HTML transferred:       102000000 bytes
//Requests per second:    13146.19 [#/sec] (mean)
//Time per request:       76.068 [ms] (mean)
//Time per request:       0.076 [ms] (mean, across all concurrent requests)
//Transfer rate:          2606.13 [Kbytes/sec] received
  val buckets = new ConcurrentLinkedQueue[(KOActInfo, CompleteHandler, PBActRet.Builder, FramePacket)]();
  val exec = new ScheduledThreadPoolExecutor(NodeHelper.getPropInstance.get("insert.run.thread", 10));

  {
    for (i <- 1 to NodeHelper.getPropInstance.get("insert.run.thread",10)) {
      exec.execute(new BatchInsertRunner[KOActInfo](ACTDAOs.actInfoDAO, buckets));
    }
  }

  def onPBPacket(pack: FramePacket, pbo: PBActCreate, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBActRet.newBuilder();

    if (pbo == null) {
      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else {
      val v = KOActInfo(UUIDGenerator.generate(), "test123", UUIDGenerator.generate(), "123", "aff", "aabb");
      ret.setActNo(v.ACT_NO)
      buckets.offer((v, handler, ret, pack));
      //      val actid = UUIDGenerator.generate();
      //      val arrays = ListBuffer[KOActInfo]();
      //      for (i <- 1 to 10) {
      //        arrays.+=(KOActInfo(UUIDGenerator.generate(), "test123", UUIDGenerator.generate(), "123", "aff", "aabb"))
      //      }
      //      val ff = ACTDAOs.actInfoDAO.insertBatch(arrays.toList);
      //      //        val ff = ACTDAOs
      //      ff onSuccess {
      //        case result @ _ => {
      //          if (result.rowsAffected > 0) {
      //            ret.setActNo(actid).setDesc("SUCCESS");
      //          } else {
      //            ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      //          }
      //          handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
      //
      //        }
      //      }
      //      ff onFailure ({
      //        case t @ _ => {
      //          log.error("error in run LoginService：", t);
      //          ret.setDesc("Packet_Error").setStatus("0003") setRetcode (RetCode.FAILED);
      //          handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
      //        }
      //      })
    }

  }
}