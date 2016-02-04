package onight.chats.scala.commons

import com.google.protobuf.Message
import onight.oapi.scala.traits.OLog
import onight.oapi.scala.commons.SessionModules
import onight.chats.msg.pbo.P2P.PBModule
//import onight.tfw.outils.serialize.SessionIDGenerator
//import onight.tfw.mservice.NodeHelper
//import org.apache.commons.lang3.StringUtils
//import onight.act.ordbgens.act.pbo.PBModule

abstract class ChatP2PModules[T <: Message] extends SessionModules[T] with OLog{

  override def getModule: String = PBModule.P2P.name()

}

