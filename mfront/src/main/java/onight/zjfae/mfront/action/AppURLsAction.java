package onight.zjfae.mfront.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
import onight.zjfae.afront.Amobilezj.PBAPPUrlParams;
import onight.zjfae.afront.Amobilezj.PEACommand;
import onight.zjfae.afront.Amobilezj.PEAGetUrl;
import onight.zjfae.afront.Amobilezj.PEAModule;
import onight.zjfae.afront.Amobilezj.PEARetUrl;
import onight.zjfae.ordbgens.app.entity.APPUrlParams;
import onight.zjfae.ordbgens.app.entity.APPUrlParamsExample;

@iPojoBean
@NActorProvider
// @Provides(specifications = { IActor.class, PSenderService.class })
@Slf4j
public class AppURLsAction extends MobileModuleStarter<PEAGetUrl> {

	@Override
	public String getModule() {
		return PEAModule.AZJ.name();
	}

	@Override
	public String[] getCmds() {
		return new String[] { PEACommand.URL.name() };
	}

	@StoreDAO(domain = APPUrlParams.class, target = "appmysql")
	@Setter @Getter
	OJpaDAO<APPUrlParams> appUrlsDao;

	BeanPBUtil pbutils = new BeanPBUtil();

	@Override
	public void onPBPacket(final FramePacket pack, PEAGetUrl pbo, final CompleteHandler handler) {
		// log.debug("pack:" + pack);
		if (pbo == null) {
			handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("请求内容不能为空", pack)));
		} else {
			PEARetUrl.Builder ret = PEARetUrl.newBuilder();
			ret.setKeyNo(pbo.getKeyNo());
			

			try {
				APPUrlParamsExample example = new APPUrlParamsExample();
				if(StringUtils.isNotBlank(pbo.getKeyNo()))
				{
					example.createCriteria().andKeyNoEqualTo(pbo.getKeyNo()).andStatusEqualTo(1);
				}else{
					example.createCriteria().andStatusEqualTo(1);
				}
				example.setLimit(100);

				List<Object> lst = appUrlsDao.selectByExample(example);
				for (Object ob : lst) {
					APPUrlParams ads = (APPUrlParams) ob;
					PBAPPUrlParams pba = pbutils.toPB(PBAPPUrlParams.newBuilder(), ads);
					ret.addUrls(pba);
				}
				handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
			} catch (Exception e) {
				log.debug("查询URL地址失败:",e);
				handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("查询URL失败:"+e.getMessage(), pack)));
			}
		}
	}
}