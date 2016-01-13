package onight.act.scala.persist

import java.util.concurrent.ScheduledThreadPoolExecutor
import onight.tfw.mservice.NodeHelper

object BatchCheckExc {
  val exec = new ScheduledThreadPoolExecutor(NodeHelper.getPropInstance.get("insert.run.thread", 10));
}