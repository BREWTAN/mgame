package onight.zjfae.mfront.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import onight.mgame.utils.PBInfo;
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
import onight.zjfae.mfront.preproc.AbstractPreProc;
import onight.zjfae.mfront.preproc.PreProcResult;
import onight.zjfae.mfront.preproc.PreProccesorLoader;
import onight.zjfae.mfront.service.IFEBeanMapping.PostProc;
import onight.zjfae.mfront.service.IFEBeanMapping.PreProc;
import onight.zjfae.mfront.utils.PBMessageFlatten;
import onight.zjfae.mfront.utils.WrapClassLoader;
import onight.zjfae.ordbgens.app.entity.APPDictionary;
import onight.zjfae.ordbgens.app.entity.APPDictionaryExample;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;
import onight.zjfae.ordbgens.app.entity.APPIfacePostprocExample;
import onight.zjfae.ordbgens.app.entity.APPIfacePreproc;
import onight.zjfae.ordbgens.app.entity.APPIfacePreprocExample;
import onight.zjfae.ordbgens.app.entity.APPSysParam;
import onight.zjfae.ordbgens.app.entity.APPSysParamKey;

import org.apache.commons.lang3.StringUtils;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Message;

@NActorProvider
@Slf4j
@iPojoBean
public class ConfigProcessor extends MobileModuleStarter<PEAConfigReload> implements PostProc, PreProc {

	@AllArgsConstructor
	public class PostProcessor {
		List<FieldDescriptor> pathfd;
		AbstractPostFieldTracker tracker;
	}

	@AllArgsConstructor
	public class PreProcessor {
		AbstractPreProc proc;
		APPIfacePreproc appProc;
	}

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
	public PreProcResult preDO(FramePacket fp, String pbname) {
		List<PreProcessor> fds = pbPreProcs.get(pbname);
		if (fds != null) {
			for (PreProcessor proc : fds) {
				if (proc.proc.doPreProc(fp)) {
					return new PreProcResult(true, proc.appProc);
				}
			}
		}
		return null;
	}

	@Override
	public void onPBPacket(FramePacket pack, PEAConfigReload pbo, CompleteHandler handler) {

		if (pbo != null) {
			APPSysParam sysparam = appSysParamDao.selectByPrimaryKey(new APPSysParamKey("__admin_reload"));
			String exloader = pack.getExtStrProp("opid");
			PEARetConfigReload.Builder ret = PEARetConfigReload.newBuilder();
			ret.setReturnCode("0001");
			if (sysparam != null && StringUtils.isBlank(exloader)) {
				ret.setReturnMsg("权限不对，无法更新:exloader为空");
			} else if (sysparam != null && !StringUtils.equalsIgnoreCase(exloader,sysparam.getParamValue())) {
				ret.setReturnMsg("权限不对，无法更新:exloader和db不等：exloader="+exloader);
			} else {
				init();
				ret.setReturnCode("0000");
				ret.setReturnMsg("共加载前处理策略个数：" + pbPreProcs.size() + "，后处理策略个数：" + pbPostProcs.size() + ":prekeys=" + pbPreProcs.keySet() + ",postkeys="
						+ pbPostProcs.keySet());
			}
			handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
		} else {
			PEARetConfigReload.Builder ret = PEARetConfigReload.newBuilder();
			ret.setReturnCode("0001");
			ret.setReturnMsg("请求内容不能为空");
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
	OJpaDAO<APPIfacePostproc> appFacePostDao;

	@StoreDAO(domain = APPIfacePreproc.class, target = "appmysql")
	@Getter
	@Setter
	OJpaDAO<APPIfacePreproc> appFacePreDao;

	@StoreDAO(domain = APPSysParam.class, target = "appmysql")
	@Getter
	@Setter
	OJpaDAO<APPSysParam> appSysParamDao;

	@StoreDAO(domain = APPDictionary.class, target = "appmysql")
	@Getter
	@Setter
	OJpaDAO<APPDictionary> appDictionaryDao;

	public void init() {
		if (appFacePostDao != null && appFacePostDao.getDaosupport() != null) {
			synchronized (appFacePostDao) {
				loadDictionary();
				List<APPIfacePostproc> tmpprocs = new ArrayList<APPIfacePostproc>();
				loadProcFromDB(tmpprocs);
				HashMap<String, List<PostProcessor>> mapper = loadClassInfo(tmpprocs);
				log.debug("load PostProcs.size=" + mapper.size());
				pbPostProcs = mapper;

			}
		}
		if (appFacePreDao != null && appFacePreDao.getDaosupport() != null) {
			synchronized (appFacePreDao) {
				List<APPIfacePreproc> tmpprocs = new ArrayList<APPIfacePreproc>();
				loadPreProcFromDB(tmpprocs);
				HashMap<String, List<PreProcessor>> tmppbPreProcs = new HashMap<String, List<PreProcessor>>();

				try {
					for (Class clazz : WrapClassLoader.getClasses("onight.mgame.autogens")) {
						try {
							PBInfo ano = (PBInfo) clazz.getAnnotation(PBInfo.class);
							if (ano == null)
								continue;
							for (APPIfacePreproc proc : tmpprocs) {
								if (ano.name().matches(proc.getPbAction())) {
									List<PreProcessor> preprocs = tmppbPreProcs.get(ano.name());
									if (preprocs == null) {
										preprocs = new ArrayList<>();
										tmppbPreProcs.put(ano.name(), preprocs);
									}
									AbstractPreProc preproc = preLoader.getPreProcess(proc);
									if (preproc != null) {
										preprocs.add(new PreProcessor(preproc, proc));
									}
								}
							}

						} catch (Exception e) {
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				log.debug("load PreProcs.size=" + tmppbPreProcs.size());
				pbPreProcs = tmppbPreProcs;

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
			example.setOrderByClause("PIO DESC");
			List<Object> lst = appFacePostDao.selectByExample(example);
			if (lst != null) {
				for (Object obj : lst) {
					APPIfacePostproc proc = (APPIfacePostproc) obj;
					tmpprocs.add(proc);
				}
			}
			log.debug("从数据库共加载后处理策略个数：" + tmpprocs.size());
		} catch (Exception e) {
			log.debug("从数据库加载后处理策略失败:" + e.getMessage(), e);
			// e.printStackTrace();
		}
	}

	public void loadPreProcFromDB(List<APPIfacePreproc> tmpprocs) {
		APPIfacePreprocExample example = new APPIfacePreprocExample();

		try {
			example.createCriteria().andStatusEqualTo(1);
			example.setOrderByClause("PIO DESC");
			List<Object> lst = appFacePreDao.selectByExample(example);
			if (lst != null) {
				for (Object obj : lst) {
					APPIfacePreproc proc = (APPIfacePreproc) obj;
					tmpprocs.add(proc);
				}
			}
			log.debug("从数据库共加载预处理策略个数：" + tmpprocs.size());
		} catch (Exception e) {
			log.debug("从数据库加载预处理策略失败:" + e.getMessage(), e);
			// e.printStackTrace();
		}
	}

	HashMap<String, List<PostProcessor>> pbPostProcs = new HashMap<String, List<PostProcessor>>();

	HashMap<String, List<PreProcessor>> pbPreProcs = new HashMap<String, List<PreProcessor>>();

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
	 * '格式化函数(DateFormat:时间格式化,FloatFormat:浮点格式化,StringFormat:字符串格式化,TrimSize:大小格式,JavaScript:通过js脚本自己控制/暂时不支持,ScriptFile:脚本文件/
	 * 不 推 荐 / 暂 时 不 支 持 ) ' ,
	 * 
	 * @param proc
	 * @return
	 */

	FormatterLoader formLoader = new FormatterLoader();
	PreProccesorLoader preLoader = new PreProccesorLoader();
}
