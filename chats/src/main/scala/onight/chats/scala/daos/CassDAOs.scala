package onight.chats.scala.daos

import scala.beans.BeanProperty
import onight.mgame.chats.cass.entity.RoomInfo
import onight.tfw.ojpa.api.OJpaDAO
import onight.tfw.ojpa.api.annotations.StoreDAO
import onight.mgame.chats.cass.entity.RoomMessage
import onight.osgi.annotation.NActorProvider
import onight.oapi.scala.commons.SessionModules
import com.google.protobuf.Message

@NActorProvider
object CassDAOs extends SessionModules[Message] {
  
  
  @BeanProperty
  @StoreDAO(domain = classOf[RoomInfo], target = "cass")
  var roomInfodao: OJpaDAO[RoomInfo] = null
  
  
    @BeanProperty
  @StoreDAO(domain = classOf[RoomMessage], target = "cass")
  var roomMsgdao: OJpaDAO[RoomMessage] = null
}


