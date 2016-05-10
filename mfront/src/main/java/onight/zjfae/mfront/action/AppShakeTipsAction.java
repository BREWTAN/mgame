package onight.zjfae.mfront.action;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.NActorProvider;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.CompleteHandler;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.annotations.StoreDAO;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.tfw.otransio.api.beans.SendFailedBody;
import onight.tfw.outils.bean.BeanPBUtil;
import onight.zjfae.afront.Amobilezj.PBAPPAds;
import onight.zjfae.afront.Amobilezj.PBAPPShakeTips;
import onight.zjfae.afront.Amobilezj.PEACommand;
import onight.zjfae.afront.Amobilezj.PEAGetAds;
import onight.zjfae.afront.Amobilezj.PEAGetTips;
import onight.zjfae.afront.Amobilezj.PEAModule;
import onight.zjfae.afront.Amobilezj.PEARetTips;
import onight.zjfae.ordbgens.app.entity.APPAds;
import onight.zjfae.ordbgens.app.entity.APPShakeTips;
import onight.zjfae.ordbgens.app.entity.APPShakeTipsExample;

import com.google.protobuf.AbstractMessage.Builder;

@iPojoBean
@NActorProvider
// @Provides(specifications = { IActor.class, PSenderService.class })
@Slf4j
public class AppShakeTipsAction extends MobileModuleStarter<PEAGetTips> {

	@Override
	public String getModule() {
		return PEAModule.AZJ.name();
	}

	@Override
	public String[] getCmds() {
		return new String[] { PEACommand.TIP.name() };
	}

	@StoreDAO(domain = APPShakeTips.class, target = "appmysql")
	@Setter @Getter
	OJpaDAO<APPShakeTips> appShakeTipsDao;

	BeanPBUtil pbutils = new BeanPBUtil();

	@Override
	public void onPBPacket(final FramePacket pack, PEAGetTips pbo, final CompleteHandler handler) {
		// log.debug("pack:" + pack);
		if (pbo == null) {
			handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("body 不能为空", pack)));
		} else {
			PEARetTips.Builder ret = PEARetTips.newBuilder();

			try {
				APPShakeTipsExample example = new APPShakeTipsExample();
				example.createCriteria().andStatusEqualTo(1);
				int count = appShakeTipsDao.countByExample(example);
				example.setOffset(Math.abs((int)(Math.random()*100000)%count));
				example.setLimit(1);

				List<Object> lst = appShakeTipsDao.selectByExample(example);
				for (Object ob : lst) {
					APPShakeTips ads = (APPShakeTips) ob;
					PBAPPShakeTips pba = pbutils.toPB(PBAPPShakeTips.newBuilder(), ads);
					ret.addTips(pba);
				}
				handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
			} catch (Exception e) {
				log.debug("查询心理鸡汤失败:",e);
				handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("UNknowException:"+e.getMessage(), pack)));
			}
			
		}

	}

	@Override
	public Builder<?> getPBBuilder() {
		return PEAGetTips.newBuilder(); 
	}
}