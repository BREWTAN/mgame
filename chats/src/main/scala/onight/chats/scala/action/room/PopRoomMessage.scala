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
import onight.mgame.chats.cass.entity.RoomUsers
import onight.tfw.ojpa.api.KVExample
import onight.chats.rooms.pbo.Rooms.PBIRoomInfo
import onight.mgame.chats.cass.entity.RoomInfo
import onight.mgame.chats.cass.entity.RoomMessage
import onight.chats.rooms.pbo.Rooms.PBIRoomMessage

@NActorProvider
object PopRoomMessage extends RoomModules[PBIRoomOp] {
  override def service = PopRoomMessageService
}

object PopRoomMessageService extends OLog with PBUtils with LService[PBIRoomOp] {

  override def cmd: String = PBRoomCommand.MSG.name();

  //  http://localhost:18080/rom/pbmsg.do?fh=VMSGROM000000J00&bd={}
  def onPBPacket(pack: FramePacket, pbo: PBIRoomOp, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBIRoomRet.newBuilder();

    if (pbo == null) {
      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else {
      val bmap = new BeanMap[String, Object]()
      pbo.getAllFields.map({ kv =>
        bmap.put(kv._1.getName, kv._2)
      })
      //      bmap.put("op_timems", java.lang.String.valueOf(System.currentTimeMillis()))

      val example = new KVExample();

      example.setLimit(1000)
      example.getCriterias.add(bmap);

      val objs = CassDAOs.roomMsgdao.selectByExample(example);

      log.debug("Enter Room:ret={}", objs)
      val it=objs.iterator()
      while(it.hasNext()){
        val itbean=it.next().asInstanceOf[RoomMessage];
        val bean=pbBeanUtil.toPB[PBIRoomMessage](PBIRoomMessage.newBuilder(),itbean)
        ret.addMsgs(bean);
      }
      if (objs.size() > 0) {
        ret.setDesc("SUCCESS").setRetcode(RetCode.SUCCESS).setStatus("0000");
      } else {
        ret.setDesc("No_Message").setRetcode(RetCode.FAILED).setStatus("0009")
      }
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    }

  }
}