package onight.chats.scala.action.room

import onight.osgi.annotation.NActorProvider
import onight.tfw.async.CompleteHandler
import onight.oapi.scala.traits.OLog
import onight.tfw.otransio.api.beans.FramePacket
import onight.tfw.otransio.api.PacketHelper
import org.apache.commons.lang3.StringUtils
import onight.oapi.scala.commons.PBUtils
import onight.oapi.scala.commons.LService
import onight.chats.scala.commons.RoomModules
import onight.chats.rooms.pbo.Rooms.PBIRoomCreate
import onight.chats.rooms.pbo.Rooms.PBIRoomRet.RetCode
import onight.chats.rooms.pbo.Rooms.PBRoomCommand
import onight.chats.rooms.pbo.Rooms.PBIRoomRet
import scala.collection.JavaConversions.mapAsScalaMap
import onight.chats.scala.daos.CassDAOs
import onight.tfw.outils.serialize.TransBeanSerializer.BeanMap
import onight.chats.rooms.pbo.Rooms.PBIRoomMessage
import onight.tfw.outils.serialize.SessionIDGenerator

@NActorProvider
object SendRoomMessage extends RoomModules[PBIRoomMessage] {
  override def service = SendRoomMessageService
}

object SendRoomMessageService extends OLog with PBUtils with LService[PBIRoomMessage] {

  override def cmd: String = PBRoomCommand.SND.name();

  val idGenerator = new SessionIDGenerator(null);
  
  def onPBPacket(pack: FramePacket, pbo: PBIRoomMessage, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBIRoomRet.newBuilder();

    if (pbo == null) {
      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getRoomId)) {
      ret.setDesc("房间名称不能为空").setStatus("0002") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else {
      val bmap = new BeanMap[String, Object]()
      pbo.getAllFields.map({ kv =>
        bmap.put(kv._1.getName, kv._2)
      })
      bmap.put("msg_id", idGenerator.generate(pbo.getRoomId))
      
      bmap.put("create_timems", java.lang.Long.valueOf(System.currentTimeMillis()))
      val v = CassDAOs.roomMsgdao.insert(bmap)
      log.debug("send message:insert back={}", v);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    }

  }
}