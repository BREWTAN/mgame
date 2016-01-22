package onight.act.scala.persist

import java.util.concurrent.ScheduledThreadPoolExecutor
import onight.tfw.mservice.NodeHelper
import java.util.concurrent.ForkJoinPool

object BatchCheckExc {
  val exec = new ScheduledThreadPoolExecutor(NodeHelper.getPropInstance.get("insert.run.thread", 50));
  
  
  val daoexec = new ScheduledThreadPoolExecutor(NodeHelper.getPropInstance.get("dao.future.thread", 500));
}