package starstart.cgw.scala.service

import com.google.protobuf.Message

import onight.osgi.annotation.NActorProvider
import onight.scala.commons.SessionModules
import onight.tfw.async.CallBack
import onight.tfw.otransio.api.beans.FramePacket

@NActorProvider
object Sender extends SessionModules[Message] {

  override def getCmds(): Array[String] = Array("SEN")

  def asyncSend(jsonString: String, cb: CallBack[FramePacket]) {
//    Sender.asyncSend(jsonStr, cb);
  }
}