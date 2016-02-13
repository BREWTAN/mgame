package onight.chats.scala.action.chat

import java.util.Date
import org.apache.commons.lang3.StringUtils
import onight.chats.scala.commons.RoomModules
import onight.chats.scala.daos.CassDAOs
import onight.oapi.scala.commons.LService
import onight.oapi.scala.commons.PBUtils
import onight.oapi.scala.traits.OLog
import onight.tfw.async.CompleteHandler
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.FramePacket
import onight.tfw.outils.serialize.SessionIDGenerator
import onight.tfw.outils.serialize.TransBeanSerializer.BeanMap
import onight.osgi.annotation.NActorProvider
import onight.chats.scala.commons.ChatP2PModules
import onight.chats.msg.pbo.P2P.PBIChatMessage
import onight.chats.msg.pbo.P2P.PBIP2PRet
import onight.chats.msg.pbo.P2P.PBIP2PRet.RetCode
import onight.chats.msg.pbo.P2P.PBP2PCommand
import scala.collection.JavaConversions.mapAsScalaMap

@NActorProvider
object SendChatMessage extends ChatP2PModules[PBIChatMessage] {
  override def service = SendChatMessageService
}

object SendChatMessageService extends OLog with PBUtils with LService[PBIChatMessage] {

  override def cmd: String = PBP2PCommand.SND.name();

  val idGenerator = new SessionIDGenerator(null);
  //  http://localhost:18080/p2p/pbsnd.do?fh=VSNDROM000000J00&bd={%22to_u%22:%22r001%22,%22from_u%22:%22u001%22,%22msg%22:%22hello%22}&gcmd=SNDP2P
  def onPBPacket(pack: FramePacket, pbo: PBIChatMessage, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBIP2PRet.newBuilder();

    if (pbo == null) {
      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getToU)) {
      ret.setDesc("接收者不能为空").setStatus("0002") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else if (StringUtils.isBlank(pbo.getFromU)) {
      ret.setDesc("发送者不能为空").setStatus("0003") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    } else {
      val bmap = new BeanMap[String, Object]()
      pbo.getAllFields.map({ kv =>
        bmap.put(kv._1.getName, kv._2)
      })
      bmap.put("insert_time", new Date(System.currentTimeMillis()));
      bmap.put("readed", java.lang.Boolean.valueOf(false))
      bmap.put("msg_id", pbo.getFromU + "_" + System.currentTimeMillis() + "_" + idGenerator.generate(pbo.getFromU))

      val v = CassDAOs.userMsgdao.insert(bmap)
      log.debug("send message:insert back={}", v);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    }

  }
}