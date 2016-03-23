package onight.chats.scala.action.room

import scala.collection.JavaConversions.mapAsScalaMap

import org.apache.commons.lang3.StringUtils

import onight.chats.rooms.pbo.Rooms.PBIRoomOp
import onight.chats.rooms.pbo.Rooms.PBIRoomRet
import onight.chats.rooms.pbo.Rooms.PBIRoomRet.RetCode
import onight.chats.rooms.pbo.Rooms.PBRoomCommand
import onight.chats.scala.commons.RoomModules
import onight.chats.scala.daos.CassDAOs
import onight.oapi.scala.commons.LService
import onight.oapi.scala.commons.PBUtils
import onight.oapi.scala.traits.OLog
import onight.osgi.annotation.NActorProvider
import onight.tfw.async.CompleteHandler
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.FramePacket
import onight.tfw.outils.serialize.TransBeanSerializer.BeanMap

@NActorProvider
object MuteUserChatRoom extends RoomModules[PBIRoomOp] {
  override def service = MuteUserChatRoomService
}

object MuteUserChatRoomService extends OLog with PBUtils with LService[PBIRoomOp] {

  override def cmd: String = PBRoomCommand.MUT.name();

  //  http://localhost:18080/rom/pbblk.do?fh=VMUTROM000000J00&bd={"room_id":"rm001","user_role":"A","user_id":"u001","op_user":"admin"}
  def onPBPacket(pack: FramePacket, pbo: PBIRoomOp, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBIRoomRet.newBuilder();

    if (pbo == null) {
      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getRoomId)) {
      ret.setDesc("房间ID不能为空").setStatus("0002") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else {
      val bmap = new BeanMap[String, Object]()
      pbo.getAllFields.map({ kv =>
        bmap.put(kv._1.getName, kv._2)
      })
      bmap.put("is_muted",java.lang.Boolean.valueOf(true))
      
      val v = CassDAOs.roomUserdao.insert(bmap)

      log.debug("Block Room:ret={}", v)
      if (v == 1) {
        ret.setDesc("SUCCESS").setRetcode(RetCode.SUCCESS).setStatus("0000");
      } else {
        ret.setDesc("UserNotInRoom").setRetcode(RetCode.FAILED).setStatus("0009")
      }
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    }

  }
}