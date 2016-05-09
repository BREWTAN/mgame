package onight.zjfae.mfront.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
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
import onight.zjfae.afront.Amobilezj.PEACommand;
import onight.zjfae.afront.Amobilezj.PEAConfigReload;
import onight.zjfae.afront.Amobilezj.PEAModule;
import onight.zjfae.afront.Amobilezj.PEARetConfigReload;
import onight.zjfae.mfront.cache.KDictionary;
import onight.zjfae.mfront.postproc.AbstractPostFieldTracker;
import onight.zjfae.mfront.postproc.FormatterLoader;
import onight.zjfae.mfront.postproc.impl.DateTimeFormatter;
import onight.zjfae.mfront.postproc.impl.FloatFormatter;
import onight.zjfae.mfront.service.IFEBeanMapping.PostProc;
import onight.zjfae.mfront.utils.PBMessageFlatten;
import onight.zjfae.mfront.utils.PBMessageFlatten.FieldTracker;
import onight.zjfae.ordbgens.app.entity.APPDictionary;
import onight.zjfae.ordbgens.app.entity.APPDictionaryExample;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;
import onight.zjfae.ordbgens.app.entity.APPIfacePostprocExample;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Message;

@NActorProvider
@Slf4j
@iPojoBean
public class ConfigPostProc extends MobileModuleStarter<PEAConfigReload> implements PostProc {

	// List<APPIfacePostproc> procs = new ArrayList<APPIfacePostproc>();

	@AllArgsConstructor
	public class PostProcessor {
		List<FieldDescriptor> pathfd;
		AbstractPostFieldTracker tracker;
	}

	// HashMap<String, List<APPIfacePostproc>> procsBypbName = new
	// HashMap<String, List<APPIfacePostproc>>();

	@Override
	public void postDO(Message.Builder builder, String pbname) {
		List<PostProcessor> fds = pbPostProcs.get(pbname);
		if (fds != null) {
			for (PostProcessor proc : fds) {
				PBMessageFlatten.traceFields(builder, proc.pathfd, 0, proc.tracker);
			}
		}
	}

	@Override
	public void onPBPacket(FramePacket pack, PEAConfigReload pbo, CompleteHandler handler) {

		if (pbo != null) {
			init();
			PEARetConfigReload.Builder ret = PEARetConfigReload.newBuilder();
			ret.setRetCode("0000");
			ret.setRetMessage("共加载策略个数：" + pbPostProcs.size() + ":" + pbPostProcs);
			handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
		} else {
			PEARetConfigReload.Builder ret = PEARetConfigReload.newBuilder();
			ret.setRetCode("0001");
			ret.setRetMessage("请求内容不能为空");
			handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
		}
	}

	@Override
	public String getModule() {
		return PEAModule.AZJ.name();
	}

	@Override
	public String[] getCmds() {
		return new String[] { PEACommand.C01.name() };
	}

	@Override
	public void onDaoServiceAllReady() {
		super.onDaoServiceAllReady();
		init();
	}

	@StoreDAO(domain = APPIfacePostproc.class, target = "appmysql")
	@Getter
	@Setter
	OJpaDAO<APPIfacePostproc> appFaceDao;

	@StoreDAO(domain = APPDictionary.class, target = "appmysql")
	@Getter
	@Setter
	OJpaDAO<APPDictionary> appDictionaryDao;

	public void init() {
		if (appFaceDao != null && appFaceDao.getDaosupport() != null) {
			synchronized (appFaceDao) {
				loadDictionary();
				List<APPIfacePostproc> tmpprocs = new ArrayList<APPIfacePostproc>();
				loadProcFromDB(tmpprocs);
				HashMap<String, List<PostProcessor>> mapper = loadClassInfo(tmpprocs);
				log.debug("load Procs.size=" + mapper.size());

				pbPostProcs = mapper;

			}
		}
	}

	public void loadDictionary() {
		if (appDictionaryDao != null && appDictionaryDao.getDaosupport() != null) {
			APPDictionaryExample example = new APPDictionaryExample();
			example.createCriteria().andStatusEqualTo(1);

			List<Object> lst = appDictionaryDao.selectByExample(example);
			HashMap<String, HashMap<String, APPDictionary>> ldictsByKeyNO = new HashMap<>();
			HashMap<String, HashMap<String, APPDictionary>> lcaseIgnoreDictsByKeyNO = new HashMap<>();
			if (lst != null) {
				for (Object obj : lst) {
					APPDictionary dict = (APPDictionary) obj;
					HashMap<String, APPDictionary> keypairs = ldictsByKeyNO.get(dict.getKeyNo());
					if (keypairs == null) {
						keypairs = new HashMap<String, APPDictionary>();
						ldictsByKeyNO.put(dict.getKeyNo(), keypairs);
						lcaseIgnoreDictsByKeyNO.put(dict.getKeyNo().toLowerCase(), keypairs);
					}
					keypairs.put(dict.getKeyCode(), dict);
				}
			}
			KDictionary.dictsByKeyNO = ldictsByKeyNO;
			KDictionary.caseIgnoreDictsByKeyNO = lcaseIgnoreDictsByKeyNO;
		}
	}

	public void loadProcFromDB(List<APPIfacePostproc> tmpprocs) {
		APPIfacePostprocExample example = new APPIfacePostprocExample();

		try {
			example.createCriteria().andStatusEqualTo(1);
			List<Object> lst = appFaceDao.selectByExample(example);
			if (lst != null) {
				for (Object obj : lst) {
					APPIfacePostproc proc = (APPIfacePostproc) obj;
					tmpprocs.add(proc);
				}
			}
			log.debug("从数据库共加载策略个数：" + tmpprocs.size());
		} catch (Exception e) {
			log.debug("从数据库加载后处理策略失败:" + e.getMessage(), e);
			// e.printStackTrace();
		}
	}

	HashMap<String, List<PostProcessor>> pbPostProcs = new HashMap<String, List<PostProcessor>>();

	public HashMap<String, List<PostProcessor>> loadClassInfo(List<APPIfacePostproc> tmpprocs) {
		HashMap<String, HashMap<String, List<FieldDescriptor>>> packMapper = new HashMap<String, HashMap<String, List<FieldDescriptor>>>();
		PBMessageFlatten.flattenPackage("onight.mgame.autogens", packMapper);
		HashMap<String, List<PostProcessor>> tmppbPostProcs = new HashMap<String, List<PostProcessor>>();
		for (APPIfacePostproc proc : tmpprocs) {
			AbstractPostFieldTracker tracker = formLoader.getTracker(proc);
			if (tracker == null) {
				log.warn("未找到处理器类型:" + proc.getFormatProc() + "." + proc);
				continue;
			}
			for (Map.Entry<String, HashMap<String, List<FieldDescriptor>>> pbnameentry : packMapper.entrySet()) {
				String pb_name = pbnameentry.getKey();
				if (pb_name.matches(proc.getPbAction())) {
					List<PostProcessor> fds = tmppbPostProcs.get(pb_name);
					if (fds == null) {
						fds = new ArrayList<PostProcessor>();
						tmppbPostProcs.put(pb_name, fds);
					}
					for (Map.Entry<String, List<FieldDescriptor>> fieldEntry : pbnameentry.getValue().entrySet()) {
						String fieldpath = fieldEntry.getKey();
						if (fieldpath.matches(proc.getKeyRex())) {
							fds.add(new PostProcessor(fieldEntry.getValue(), tracker));
							log.debug("MathField:" + fieldpath + ".math" + proc.getKeyRex());
						}
					}
				}
			}
		}
		return tmppbPostProcs;
	}

	/**
	 * 获取格式化的函数
	 * '格式化函数(DateFormat:时间格式化,FloatFormat:浮点格式化,StringFormat:字符串格式化,TrimSize:大小格式,JavaScript:通过js脚本自己控制/暂时不支持,ScriptFile:脚本文件/不推荐/
	 * 暂 时 不 支 持 ) ' ,
	 * 
	 * @param proc
	 * @return
	 */

	FormatterLoader formLoader = new FormatterLoader();
}
