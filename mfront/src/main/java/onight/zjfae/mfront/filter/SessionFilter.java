package onight.zjfae.mfront.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.iPojoBean;
import onight.sm.Ssm.PBModule;
import onight.sm.Ssm.PBSSORet;
import onight.sm.Ssm.RetCode;
import onight.tfw.async.CompleteHandler;
import onight.tfw.async.OFuture;
import onight.tfw.ntrans.api.ActWrapper;
import onight.tfw.otransio.api.IPacketSender;
import onight.tfw.otransio.api.PSender;
import onight.tfw.otransio.api.PSenderService;
import onight.tfw.otransio.api.PacketFilter;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.ExceptionBody;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.zjfae.afront.Amobilezj.PEAModule;
import onight.zjfae.mfront.action.MobileModuleStarter;

import org.apache.felix.ipojo.annotations.Provides;

@iPojoBean
@Provides(specifications = { PacketFilter.class, PSenderService.class })
@Slf4j
@Data
public class SessionFilter implements PacketFilter,PSenderService {

	@Override
	public boolean postRoute(ActWrapper actor, FramePacket pack, CompleteHandler handler) {
		// log.debug("postRoute:"+module+":" + pack);
//		if ("SINSSM".equals(pack.getGlobalCMD())) {
//			// pack.getBody()
//		}
		return false;
	}

	@PSender
	protected IPacketSender sender;

	public void performSession(final FramePacket pack, IPacketSender sender, final CompleteHandler handler) {
	}

	@Override
	public boolean preRoute(final ActWrapper actor, final FramePacket pack, final CompleteHandler handler) {
		// log.debug("preRoute:"+module+":" + pack);
		if (PEAModule.AZJ.name().equals(pack.getModule())) {//
			log.debug("I Should Check this:cmd=" + pack.getGlobalCMD());
			if (SSOPacketHelper.getSSOGetPacket(pack) == null) {
				handler.onFinished(PacketHelper.toPBReturn(pack, new ExceptionBody("NOT_AUTHORIED", null)));
				return true;
			}
			final OFuture<FramePacket> sessop = sender.asyncSend(SSOPacketHelper.getSSOGetPacket(pack));
			pack.putSession(sessop);
			sessop.withComplete(new CompleteHandler() {
				@Override
				public void onFinished(FramePacket vldpack) {
					// op.result(vldpack);
					try {
						PBSSORet ssoret = SSOPacketHelper.parseRet(vldpack.getBody());
						log.debug("ssoret==" + ssoret);
						if (ssoret.getStatus() == RetCode.SUCCESS) {
							log.debug("get session success:session==" + ssoret.getSession());
							actor.onPacket(pack, handler);
						} else {
							handler.onFinished(PacketHelper.toPBReturn(pack, new ExceptionBody("NOT_AUTHORIED", null)));
						}
					} catch (Exception e) {
						log.warn("error In Process SSORET:" + vldpack, e);
						handler.onFinished(PacketHelper.toPBReturn(pack, new ExceptionBody("Session_Not_Found:" + e.getMessage(), null)));
					}
				}
			});

			return true;
		}
		return false;
	}

	@Override
	public String[] modules() {
		return new String[] { MobileModuleStarter.MODULE_NAME };
	}

	@Override
	public String getModule() {
		return MobileModuleStarter.MODULE_NAME;
	}

}
