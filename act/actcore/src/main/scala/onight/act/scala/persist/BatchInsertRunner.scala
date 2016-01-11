package onight.act.scala.persist

import java.util.concurrent.ConcurrentLinkedQueue
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import onight.act.ordbgens.act.pbo.Act.PBActRet
import onight.async.mysql.commons.SimpleDAO
import onight.oapi.scala.traits.OLog
import onight.tfw.async.CompleteHandler
import onight.tfw.mservice.NodeHelper
import onight.tfw.otransio.api.beans.FramePacket
import onight.tfw.otransio.api.PacketHelper

class BatchInsertRunner[E](val dao: SimpleDAO[E],
  val buckets: ConcurrentLinkedQueue[(E, CompleteHandler, PBActRet.Builder, FramePacket)]) extends Runnable with OLog {

  //  val buckets = new ConcurrentLinkedQueue[(E, CompleteHandler, PBActRet.Builder, FramePacket)]();

  val BATCH_SIZE = NodeHelper.getPropInstance.get("insert.batchsize", 10);
  //  var dao: SimpleDAO[E];

  def offer(e: (E, CompleteHandler, PBActRet.Builder, FramePacket)) = {
    buckets.add(e);
  }
  def syncList(list: List[(E, CompleteHandler, PBActRet.Builder, FramePacket)]) {
    val blist = list.map(_._1);
    if (blist.size != list.size) {
      log.error("lost!")
    }
    val ff = dao.insertBatch(blist);
    ff onSuccess {
      case result @ _ => {
        list.map { x =>
          {
            x._2.onFinished(PacketHelper.toPBReturn(x._4, x._3.build()));
          }
        }

      }
    }
    ff onFailure ({
      case t @ _ => {
         log.error("insert failed:!",t)
        list.map { x =>
          {
            x._2.onFinished(PacketHelper.toPBReturn(x._4, x._3.build()));
          }
        }
      }
    })

  }
  override def run() = {
    val list = ListBuffer[(E, CompleteHandler, PBActRet.Builder, FramePacket)]();
    while (true) {
      val e = buckets.poll()
      if (e != null) {
        list += e
        if (list.size >= BATCH_SIZE) {
          syncList(list.toList);
          list.clear();
        }
      } else {
        if (list.size > 0) {
          syncList(list.toList);
          list.clear();
        }
        Thread.sleep(10)
      }
    }
  }
}