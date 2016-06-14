package onight.zjfae.mfront.action;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.NActorProvider;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.CompleteHandler;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.annotations.StoreDAO;
import onight.tfw.otransio.api.PackHeader;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.tfw.otransio.api.beans.SendFailedBody;
import onight.tfw.outils.bean.BeanPBUtil;
import onight.tfw.outils.serialize.UUIDGenerator;
import onight.zjfae.afront.Amobilezj.PEACommand;
import onight.zjfae.afront.Amobilezj.PEALogs;
import onight.zjfae.afront.Amobilezj.PEAModule;
import onight.zjfae.afront.Amobilezj.PEARetAppLogs;
import onight.zjfae.ordbgens.app.entity.APPSysFaceLogs;

@iPojoBean
@NActorProvider
// @Provides(specifications = { IActor.class, PSenderService.class })
@Slf4j
public class AppLogAction extends MobileModuleStarter<PEALogs> {

	@Override
	public String getModule() {
		return PEAModule.AZJ.name();
	}

	@Override
	public String[] getCmds() {
		return new String[] { PEACommand.LOG.name() };
	}

	@StoreDAO(domain = APPSysFaceLogs.class, target = "appmysql")
	@Setter @Getter
	OJpaDAO<APPSysFaceLogs> appLogsDao;

	BeanPBUtil pbutils = new BeanPBUtil();

	@Override
	public void onPBPacket(final FramePacket pack, PEALogs pbo, final CompleteHandler handler) {
		// log.debug("pack:" + pack);
		if (pbo == null ) {
			handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("showtype 不能为空", pack)));
		} else {
			PEARetAppLogs.Builder ret = PEARetAppLogs.newBuilder();

			try {
				APPSysFaceLogs logs = pbutils.copyFromPB(pbo, new APPSysFaceLogs());
				logs.setUuid(UUIDGenerator.generate());
				logs.setClientIp(pack.getExtStrProp(PackHeader.PEER_IP));
				appLogsDao.insertSelective(logs);
				ret.setReturnCode("000000").setReturnMsg("成功");
				handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
			} catch (Exception e) {
				log.debug("插入日志失败:",e);
				handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("插入日志失败:"+e.getMessage(), pack)));
			}
			
		}

	}

}