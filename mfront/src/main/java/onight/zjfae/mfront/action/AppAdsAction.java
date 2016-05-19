package onight.zjfae.mfront.action;

import java.util.List;

import lombok.Data;
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
import onight.zjfae.afront.Amobilezj.PEACommand;
import onight.zjfae.afront.Amobilezj.PEAGetAds;
import onight.zjfae.afront.Amobilezj.PEAModule;
import onight.zjfae.afront.Amobilezj.PEARetAds;
import onight.zjfae.ordbgens.app.entity.APPAds;
import onight.zjfae.ordbgens.app.entity.APPAdsExample;

import org.apache.commons.lang3.StringUtils;

import com.google.protobuf.AbstractMessage.Builder;

@iPojoBean
@NActorProvider
// @Provides(specifications = { IActor.class, PSenderService.class })
@Slf4j
public class AppAdsAction extends MobileModuleStarter<PEAGetAds> {

	@Override
	public String getModule() {
		return PEAModule.AZJ.name();
	}

	@Override
	public String[] getCmds() {
		return new String[] { PEACommand.ADS.name() };
	}

	@StoreDAO(domain = APPAds.class, target = "appmysql")
	@Setter @Getter
	OJpaDAO<APPAds> appAdsDao;

	BeanPBUtil pbutils = new BeanPBUtil();

	@Override
	public void onPBPacket(final FramePacket pack, PEAGetAds pbo, final CompleteHandler handler) {
		// log.debug("pack:" + pack);
		if (pbo == null || StringUtils.isBlank(pbo.getShowType())) {
			handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("showtype 不能为空", pack)));
		} else {
			PEARetAds.Builder ret = PEARetAds.newBuilder();
			ret.setShowType(pbo.getShowType());

			try {
				APPAdsExample example = new APPAdsExample();
				example.createCriteria().andShowTypeEqualTo(pbo.getShowType()).andStatusEqualTo(1);
				example.setLimit(100);

				List<Object> lst = appAdsDao.selectByExample(example);
				for (Object ob : lst) {
					APPAds ads = (APPAds) ob;
					PBAPPAds pba = pbutils.toPB(PBAPPAds.newBuilder(), ads);
					ret.addAds(pba);
				}
				handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
			} catch (Exception e) {
				log.debug("查询广告失败:",e);
				handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("UNknowException:"+e.getMessage(), pack)));
			}
			
		}

	}

	@Override
	public Builder<?> getPBBuilder() {
		return PEAGetAds.newBuilder();
	}
}