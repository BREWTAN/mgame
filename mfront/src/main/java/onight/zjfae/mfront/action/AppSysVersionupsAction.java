package onight.zjfae.mfront.action;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.NActorProvider;
import onight.tfw.async.CompleteHandler;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.annotations.StoreDAO;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.tfw.otransio.api.beans.SendFailedBody;
import onight.tfw.outils.bean.BeanPBUtil;
import onight.zjfae.afront.Amobilezj.PEACommand;
import onight.zjfae.afront.Amobilezj.PEAGetUpg;
import onight.zjfae.afront.Amobilezj.PEAModule;
import onight.zjfae.afront.Amobilezj.PEARetUpg;
import onight.zjfae.ordbgens.app.entity.APPSysVersionups;
import onight.zjfae.ordbgens.app.entity.APPSysVersionupsExample;
import onight.zjfae.ordbgens.app.entity.APPSysVersionupsExample.Criteria;

@NActorProvider
@Slf4j
public class AppSysVersionupsAction extends MobileModuleStarter<PEAGetUpg> {

	@Override
	public String getModule() {
		return PEAModule.AZJ.name();
	}

	@Override
	public String[] getCmds() {
		return new String[] { PEACommand.UPG.name() };
	}

	@StoreDAO(domain = APPSysVersionups.class, target = "appmysql")
	@Setter @Getter
	OJpaDAO<APPSysVersionups> appSysVersionupsDao;

	BeanPBUtil pbutils = new BeanPBUtil();

	@Override
	public void onPBPacket(final FramePacket pack, PEAGetUpg pbo, final CompleteHandler handler) {
		// log.debug("pack:" + pack);
		if (pbo == null) {
			handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("请求内容不能为空", pack)));
		} else {
			PEARetUpg.Builder ret = PEARetUpg.newBuilder();
			try {
				APPSysVersionupsExample example = new APPSysVersionupsExample();
				if(pbo.getPlatform() ==1 || pbo.getPlatform()==2){
					Criteria  criteria = example.createCriteria();
					criteria.andTargetplatformEqualTo(pbo.getPlatform()).andStatusEqualTo(1);
					if(StringUtils.isNoneBlank(pbo.getVersionid())){
						criteria.andVersionidGreaterThan(pbo.getVersionid());
					}
					example.setOrderByClause("inserttime desc ");
					example.setLimit(1);
					List<Object> lst = appSysVersionupsDao.selectByExample(example);
					APPSysVersionups appSysVersionups = null;
				    for(Iterator<Object> it = lst.iterator();it.hasNext();){
				    	appSysVersionups = (APPSysVersionups) it.next();
				    	ret.setContents(appSysVersionups.getContents());
				    	ret.setUpurl(appSysVersionups.getUpurl());
				    	ret.setUpType(appSysVersionups.getUpType());
				    	ret.setVersionid(appSysVersionups.getVersionid());
				    	ret.setReturnCode("9999");
				    	ret.setReturnMsg("succ");
				    }
				    if( appSysVersionups == null){
				    	ret.setReturnCode("0000");
				    	ret.setReturnMsg("不需要升级");
				    }
					handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
				}else{
				   	ret.setReturnCode("0001");
			    	ret.setReturnMsg("平台类型未找到");
					handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
				}
			} catch (Exception e) {
				log.debug("查询升级信息失败",e);
				handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("查询升级信息失败", pack)));
			}
		}
	}
}