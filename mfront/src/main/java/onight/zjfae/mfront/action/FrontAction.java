package onight.zjfae.mfront.action;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.NActorProvider;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.CompleteHandler;
import onight.tfw.otransio.api.IPacketSender;
import onight.tfw.otransio.api.PSender;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.tfw.otransio.api.beans.SendFailedBody;
import onight.zjfae.mfront.filter.SSOPacketHelper;

import org.apache.commons.lang3.StringUtils;

import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.Message;

@iPojoBean
@NActorProvider
// @Provides(specifications = { IActor.class, PSenderService.class })
@Slf4j
@Data
public class FrontAction extends MobileModuleStarter<Message> {

	@Getter
	@PSender
	protected IPacketSender sender;

	SSOPacketHelper filter = new SSOPacketHelper();

	@Override
	public String[] getCmds() {
		return new String[] { "FNT" };
	}

	// http://localhost:8081/fnt/pbfnt.do?fh=VSINSSM000000J00&bd={%22login_id%22:%22abc%22,%22password%22:%22000000%22,%22op%22:0,%22res_id%22:%22android%22}&gcmd=SINSSM

	@Override
	public void onPBPacket(final FramePacket pack, Message nubo, final CompleteHandler handler) {
		// log.debug("pack:" + pack);
		String gcmd = pack.getExtStrProp("gcmd");
		if (StringUtils.isBlank(gcmd) || gcmd.length() != 6) {
			handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("gcmd 不能为空", pack)));
		} else {
			pack.getFixHead().setCmd(gcmd.substring(0, 3));
			pack.getFixHead().setModule(gcmd.substring(3, 6));
			pack.getFixHead().reset();
			pack.getFixHead().setSync(true);// 没有scala很麻烦
			sender.asyncSend(pack).withComplete(handler);
		}
	}

	@Override
	public Builder getPBBuilder() {
		return null;
	}

}
