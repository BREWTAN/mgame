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
import onight.chats.rooms.pbo.Rooms.PBIRoomRet.RetCode
import onight.chats.rooms.pbo.Rooms.PBRoomCommand
import onight.chats.rooms.pbo.Rooms.PBIRoomRet
import scala.collection.JavaConversions.mapAsScalaMap
import onight.chats.scala.daos.CassDAOs
import onight.tfw.outils.serialize.TransBeanSerializer.BeanMap
import onight.chats.rooms.pbo.Rooms.PBIRoomOp

@NActorProvider
object CreateChatRoom extends RoomModules[PBIRoomOp] {
  override def service = CreateChatRoomService
}

object CreateChatRoomService extends OLog with PBUtils with LService[PBIRoomOp] {

  override def cmd: String = PBRoomCommand.NEW.name();

  //  http://localhost:18080/rom/pbnew.do?fh=VNEWROM000000J00&bd={"room_id":"rm001","room_name":"rm001","create_user":"abc","max_user":10}&gcmd=NEWROM
  def onPBPacket(pack: FramePacket, pbo: PBIRoomOp, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBIRoomRet.newBuilder();

    if (pbo == null) {
      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getRoomId)) {
      ret.setDesc("房间ID不能为空").setStatus("0002") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getRoomName)) {
      ret.setDesc("房间名称不能为空").setStatus("0003") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else {
      val bmap = new BeanMap[String, Object]()
      pbo.getAllFields.map({ kv =>
        bmap.put(kv._1.getName, kv._2)
      })
      bmap.put("create_timems", java.lang.String.valueOf(System.currentTimeMillis()))
      if(StringUtils.isNoneBlank(pbo.getOpUser))
      {
        bmap.put("create_user",pbo.getOpUser);
      }
      val v = CassDAOs.roomInfodao.insertIfNoExist(bmap)

      log.debug("new Room:ret={}", v)
      if(v==1){
        ret.setDesc("SUCCESS").setRetcode(RetCode.SUCCESS).setStatus("0000");
      }else{
        ret.setDesc("RoomIDAlreadyExisted").setRetcode(RetCode.FAILED).setStatus("0009")
      }
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    }

  }
}