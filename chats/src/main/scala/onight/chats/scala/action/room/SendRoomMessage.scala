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
import onight.chats.rooms.pbo.Rooms.PBIRoomMessage
import onight.tfw.outils.serialize.SessionIDGenerator
import java.util.Date
import java.lang.Long

@NActorProvider
object SendRoomMessage extends RoomModules[PBIRoomMessage] {
  override def service = SendRoomMessageService
}

object SendRoomMessageService extends OLog with PBUtils with LService[PBIRoomMessage] {

  override def cmd: String = PBRoomCommand.SND.name();

  val idGenerator = new SessionIDGenerator(null);
//  http://localhost:18080/rom/pbsnd.do?fh=VSNDROM000000J00&bd={%22room_id%22:%22r001%22,%22from_u%22:%22u001%22,%22msg%22:%22hello%22}&gcmd=SNDROM
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
      bmap.put("insert_time",new Date(System.currentTimeMillis()));
      bmap.put("msg_id",pbo.getRoomId+"_"+System.currentTimeMillis()+"_"+idGenerator.generate(pbo.getFromU))
      
      val v = CassDAOs.roomMsgdao.insert(bmap)
      log.debug("send message:insert back={}", v);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    }

  }
}