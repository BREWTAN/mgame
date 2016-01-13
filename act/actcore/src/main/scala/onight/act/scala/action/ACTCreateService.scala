package onight.act.scala.action

import scala.concurrent.ExecutionContext.Implicits.global
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
import onight.act.ordbgens.act.pbo.Act.PBIActCreate
import onight.act.ordbgens.act.pbo.Act.PBCommand
import onight.act.ordbgens.act.pbo.Act.PBIActRet
import onight.act.ordbgens.act.pbo.Act.PBIActRet.RetCode
import scala.collection.mutable.MutableList
import scala.collection.mutable.ListBuffer
import java.util.concurrent.ScheduledThreadPoolExecutor
import onight.tfw.mservice.NodeHelper
import java.util.concurrent.ConcurrentLinkedQueue
import onight.act.ordbgens.act.so.ACTDAOs._
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.mutable.HashMap
import java.sql.Timestamp
import onight.tfw.async.CallBack
import onight.act.scala.persist.BatchRunner
import onight.act.scala.persist.ActCreateRunner
import org.apache.commons.lang3.StringUtils
import onight.act.scala.persist.BatchCheckExc
import java.util.concurrent.TimeUnit
import onight.act.ordbgens.act.pbo.Act.PBIActCreate

@NActorProvider
object ACTCreateActor extends SessionModules[PBIActCreate] {
  override def service = ACTCreateService
}

object ACTCreateService extends OLog with PBUtils with LService[PBIActCreate] {

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
  val buckets = new ConcurrentLinkedQueue[(KOTActInfo, CompleteHandler, PBIActRet.Builder, FramePacket)]();
  {
    for (i <- 1 to NodeHelper.getPropInstance.get("insert.run.checkcount", 5)) {
      BatchCheckExc.exec.scheduleAtFixedRate(new BatchRunner[(KOTActInfo, CompleteHandler, PBIActRet.Builder, FramePacket)](ActCreateRunner, buckets), //
          10, NodeHelper.getPropInstance.get("insert.run.periodms", 100), TimeUnit.MICROSECONDS);
    }
  }

  def onPBPacket(pack: FramePacket, pbo: PBIActCreate, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBIActRet.newBuilder();

    if (pbo == null) {
      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getActNo)) {
      ret.setDesc("账户号不能为空").setStatus("0002") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else {
      val vmap = pbo.getAllFields.map({ kv =>
        (kv._1.getName.toUpperCase(), kv._2)
      })
      vmap.put("CREATE_TIME",  java.lang.Long.valueOf(System.currentTimeMillis()))
      vmap.put("ACT_STAT", "0")
      val v = TActInfoDAO.instanceFromMap(vmap.asInstanceOf[HashMap[String, Object]])

      ret.setActNo(v.ACT_NO)
      buckets.offer((v, handler, ret, pack));

    }

  }
}