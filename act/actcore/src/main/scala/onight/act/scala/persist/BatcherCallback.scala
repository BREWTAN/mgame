package onight.act.scala.persist

import scala.concurrent.Future

trait BatcherCallback[E] {

  def onBatch(vs: List[E]): Future[Any]

  def onOne(v: E): Future[Any]
  
  def onSuccess(v:E)
  
  def onFailed(v:E,error:Throwable)
}


