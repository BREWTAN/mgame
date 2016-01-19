package onight.act.scala.persist

import java.util.concurrent.ConcurrentLinkedQueue
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import onight.oapi.scala.traits.OLog
import onight.tfw.mservice.NodeHelper
import onight.tfw.async.CompleteHandler
import onight.tfw.otransio.api.beans.FramePacket
import onight.act.ordbgens.act.so.ACTDAOs._
import scala.concurrent.Future
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.ExceptionBody

class BatchRunner[E](val runner: BatcherCallback[E],
  val buckets: ConcurrentLinkedQueue[E]) extends Runnable with OLog {

  val BATCH_SIZE = NodeHelper.getPropInstance.get("insert.batchsize", 10);

  def offer(e: (E)) = {
    buckets.add(e);
  }

  def syncList(list: List[E]) {
    val blist = list.toList;
    val ff = runner.onBatch(blist);
    ff onSuccess {
      case result @ _ => {
        list.map(runner.onSuccess(_))
      }
    }
    ff onFailure ({
      case t @ _ => {
        log.error("insert failed:!", t)
        if (list.size > 1) {
          list.map({ x =>
            val oneresult = runner.onOne(x)
            oneresult onSuccess { case _ => runner.onSuccess(x) }
            oneresult onFailure { case t @ _ => runner.onFailed(x, t) }
          })
        } else {
          runner.onFailed(list(0), t)
        }
      }
    })

  }
  override def run() = {
    val list = ListBuffer[E]();
    for (i <- 1 to BATCH_SIZE) {
      val e = buckets.poll()
      if (e != null) {
        list += e
        if (list.size >= BATCH_SIZE) {
          syncList(list.toList);
          list.clear();
        }
      }else{
        Thread.sleep(10)
      }
    }
    if (list.size > 0) {
      syncList(list.toList);
      list.clear();
    }
  }
}
