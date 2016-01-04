package onight.mgame.front.action;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.NActorProvider;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.CompleteHandler;
import onight.tfw.otransio.api.IPacketSender;
import onight.tfw.otransio.api.PSender;
import onight.tfw.otransio.api.PSenderService;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.tfw.otransio.api.beans.SendFailedBody;
import onight.tfw.outils.serialize.SerializerFactory;
import onight.tfw.proxy.IActor;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.ipojo.annotations.Provides;

import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.Message;

@iPojoBean
@NActorProvider
//@Provides(specifications = { IActor.class, PSenderService.class })
@Slf4j
@Data
public class FrontAction extends ModuleStarter<Message> {

	@Getter
	@Setter
	@PSender
	protected IPacketSender sender;

	@Override
	public String[] getCmds() {
		return new String[] { "PXY" };
	}

	@Override
	public void onPBPacket(FramePacket pack, Message nubo, CompleteHandler handler) {
		log.debug("pack:" + pack);
		String gcmd = pack.getExtStrProp("gcmd");
		if (StringUtils.isBlank(gcmd) || gcmd.length() != 6) {
			handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("gcmd 不能为空", pack)));
		} else {
			pack.getFixHead().setCmd(gcmd.substring(0, 3));
			pack.getFixHead().setModule(gcmd.substring(3, 6));
			pack.getFixHead().reset();
			pack.getFixHead().setSync(true);
			FramePacket ret = sender.send(pack, 60 * 1000);
			log.debug("ret.Head==:" + ret.getFixHead().toStrHead());
			log.debug("ret.exthead==:" + ret.getExtHead().getVkvs());
			// log.debug("ret==:"+new String(ret.getBody())+"");

			handler.onFinished(ret);
		}
	}

	@Override
	public Builder getPBBuilder() {
		return null;
	}

}
