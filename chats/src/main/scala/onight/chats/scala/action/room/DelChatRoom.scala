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
object DeleteChatRoom extends RoomModules[PBIRoomOp] {
  override def service = DeleteChatRoomService
}

object DeleteChatRoomService extends OLog with PBUtils with LService[PBIRoomOp] {

  override def cmd: String = PBRoomCommand.DEL.name();

  //  http://localhost:18080/rom/pbdel.do?fh=VDELROM000000J00&bd={"room_id":"rm001"}
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
      val v = CassDAOs.roomInfodao.deleteByPrimaryKey(bmap)

      log.debug("Delete RoomInfo:ret={}", v)
      
      val userbmap = new BeanMap[String, Object]()
      userbmap.put("room_id", pbo.getRoomId)
      val dv=CassDAOs.roomUserdao.deleteByPrimaryKey(userbmap);
      log.debug("delete roomusers return:{}",dv);
      if (v == 1) {
        ret.setDesc("SUCCESS").setRetcode(RetCode.SUCCESS).setStatus("0000");
      } else {
        ret.setDesc("RoomIDNotExisted").setRetcode(RetCode.FAILED).setStatus("0009")
      }
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    }

  }
}