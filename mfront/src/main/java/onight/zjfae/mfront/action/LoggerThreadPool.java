package onight.zjfae.mfront.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.NActorProvider;
import onight.tfw.async.CompleteHandler;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.annotations.StoreDAO;
import onight.tfw.otransio.api.PackHeader;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.zjfae.afront.Amobilezj.PEAConfigReload;
import onight.zjfae.afront.Amobilezj.PEARetConfigReload;
import onight.zjfae.ordbgens.app.entity.APPIfeLog;
import onight.zjfae.ordbgens.app.entity.APPIfeMatch;
import onight.zjfae.ordbgens.app.entity.APPIfeMatchExample;
import onight.zjfae.ordbgens.app.entity.APPIfeMatchExample.Criteria;

/**
 * 异步线程日志输出
 *
 */
@NActorProvider
@Slf4j
public class LoggerThreadPool extends MobileModuleStarter<PEAConfigReload> {

	private final Object monitor = new Object();

	private  Boolean load = false;

	private ThreadPoolExecutor threadPoolExecutor = null;

	@StoreDAO(domain = APPIfeLog.class, target = "appmysql")
	@Getter
	@Setter
	OJpaDAO<APPIfeLog> appIfeLogDao;

	@StoreDAO(domain = APPIfeMatch.class, target = "appmysql")
	@Getter
	@Setter
	OJpaDAO<APPIfeMatch> appIfeMatchDao;

	Map<String, String> matcheMap = new ConcurrentHashMap<String, String>();

	LoggerThreadPool() {
		synchronized (monitor) {
			BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(1000);
			threadPoolExecutor = new ThreadPoolExecutor(10, 50, 300, TimeUnit.SECONDS, queue);
		}
	}
	@Override
	public String[] getCmds() {
		return new String[] { "ltp" };
	}

	@Override
	public void onPBPacket(FramePacket pack, PEAConfigReload arg1, CompleteHandler handler) {
		PEARetConfigReload.Builder ret = PEARetConfigReload.newBuilder();
		reloadMatchMap();
		ret.setReturnCode("0000");
		ret.setReturnMsg("success");
		handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
	}

	private void logFuture(final APPIfeLog appIfeLog) {
		Callable<Object> c = new Callable<Object>() {
			public Object call() {
				try {
					appIfeLogDao.insert(appIfeLog);
				} catch (Exception ex) {
					log.info("insert error", ex);
				}
				return null;
			}
		};
		FutureTask<Object> ft = new FutureTask<Object>(c);
		threadPoolExecutor.execute(ft);
	}

	public Map<String, String> reloadMatchMap() {
		Criteria criteria = new Criteria().andStatusEqualTo("1");
		List<Criteria> criteriaS = new ArrayList<Criteria>();
		criteriaS.add(criteria);
		APPIfeMatchExample appIfeMatchExample = new APPIfeMatchExample();
		appIfeMatchExample.setOredCriteria(criteriaS);
		List<Object> appIfeMatchS = appIfeMatchDao.selectByExample(appIfeMatchExample);
		synchronized (monitor) {
			Map<String, String> map = new ConcurrentHashMap<String, String>();
			for (Object appIfeMatch : appIfeMatchS) {
				map.put(((APPIfeMatch) appIfeMatch).getPbAction(), "1");
			}
			matcheMap = map;
		}
		return matcheMap;
	}

	public void log(FramePacket pack, String requestBody, String pbname, String resStr, Long cost) {
		
		if (!load) {
			synchronized (monitor) {
				reloadMatchMap();
			    load = true;
			}
		}
		try {
			if (matcheMap.get(pbname) != null) {
				APPIfeLog appIfeLog = new APPIfeLog();
				appIfeLog.setAppVersion(pack.getExtStrProp("appVersion"));
				appIfeLog.setClientOsver(pack.getExtStrProp("clientOsver"));
				appIfeLog.setUserCookies(pack.getExtStrProp("SMID") + "," + pack.getExtStrProp("userid"));
				appIfeLog.setRetMsg(pack.getExtStrProp("userid"));
				appIfeLog.setPbAction(pbname);
				appIfeLog.setPlatform(pack.getExtStrProp("p"));
				appIfeLog.setReqStr(StringUtils.substring(requestBody, 0, 4096));
				try {
					if (StringUtils.isNumeric(pack.getExtStrProp("ReqTime"))) {
						appIfeLog.setReqTime(new Date(Long.parseLong(pack.getExtStrProp("ReqTime"))));
					}
				} catch (Exception e) {
					log.debug("reqLogTime Error:" + pack.getExtStrProp("ReqTime"), e);
					// e.printStackTrace();
				}
				appIfeLog.setProxyTime(new Date());
				appIfeLog.setResTime(new Date());
				appIfeLog.setResStr(StringUtils.substring(resStr, 0, 4096));
				appIfeLog.setUserIp(pack.getExtStrProp(PackHeader.PEER_IP));
				appIfeLog.setCostMs(cost.intValue());
				appIfeLog.setUuid(UUID.randomUUID().toString().replace("-", ""));
				logFuture(appIfeLog);
			}
		} catch (Exception ex) {
			log.info("insert log error", ex);
		}
	}
}