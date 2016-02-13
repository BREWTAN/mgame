package onight.chats.scala.commons

import java.util.concurrent.atomic.AtomicInteger

object MessageIDGenerator {

  val counter = new AtomicInteger(0);
}