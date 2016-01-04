package cn.msec.ojpa.msc.cache;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Data;
import lombok.val;
import lombok.extern.slf4j.Slf4j;
import onight.tfg.ordbgens.sys.entity.TSysParam;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.IJPAClient;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.ServiceSpec;
import onight.tfw.ojpa.api.StoreServiceProvider;
import onight.tfw.ojpa.api.annotations.StoreDAO;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.proxy.IActor;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;

@Component(name = "CacheLoader")
@Instantiate
@Provides(specifications = { IJPAClient.class, StoreServiceProvider.class, IActor.class })
@Slf4j
@Data
public class CacheLoader extends StoreServiceProvider implements IJPAClient, IActor {
	@Override
	public String getProviderid() {
		return ServiceSpec.CACHE_STORE.getTarget();
	}

	@Override
	public DomainDaoSupport getDaoByBeanName(OJpaDAO dao) {
		return new CacheDao(this);
	}

	// table-->rowkey-->colname-->colv
	private HashMap<String, HashMap<String, HashMap<String, Object>>> storebyTableColumn = new HashMap<String, HashMap<String, HashMap<String, Object>>>();

	@StoreDAO(domain = Element.class, key = "k", target = "redis")
	protected OJpaDAO<Element> redisDao;

	@StoreDAO(domain = TSysParam.class, target = "mysql")
	protected OJpaDAO<Element> mysqlDao;

	public <T> T getV(String tab, String key, String col, T defv) {
		val tabm = storebyTableColumn.get(tab);
		if (tabm != null) {
			val row = tabm.get(key);
			if (row != null) {
				if (row.containsKey(col)) {
					val v = row.get(col);
					if (v != null)
						return (T) v;
					else
						return defv;
				}
			}
		}
		return defv;
	}

	public List<Object> searchByCol(String tab, String[] cols, String[] colsv) {
		val tabm = storebyTableColumn.get(tab);
		ArrayList<Object> ret = new ArrayList<Object>();
		if (tabm != null && cols != null && cols.length == colsv.length) {
			for (HashMap<String, Object> row : tabm.values()) {
				if (row != null) {
					boolean match = true;
					for (int i = 0; i < cols.length; i++) {
						String col = cols[i];
						val v = row.get(col);
						if (!v.equals(colsv[i])) {
							match = false;
							break;
						}
					}
					if (match) {
						ret.add(row);
					}
				}
			}
		}
		return ret;
	}

	public <T> T getV(String tab, String key, String col) {
		return getV(tab, key, col, null);
	}

	public <T> T getO(String tab, String key) {
		return getO(tab, key, null);
	}

	public <T> T getO(String tab, String key, T defaulto) {
		val tabm = storebyTableColumn.get(tab);
		if (tabm != null && tabm.containsKey(key)) {
			return (T) tabm.get(key);
		}
		return defaulto;
	}
	
	public static String toCamelKey(String key){
		StringBuffer sb=new StringBuffer();
		for(String str:key.split("_")){
			if(sb.length()>0)
			{
				sb.append(StringUtils.capitalize(StringUtils.lowerCase(str)));
			}else{
				sb.append(StringUtils.lowerCase(str));
			}
		}
		return sb.toString();
	}
	private HashMap<String, Object> toCaseIgnore(Map<String, Object> omap) {
		val ret = new HashMap<String, Object>();
		for (val entry : omap.entrySet()) {
			ret.put(toCamelKey(entry.getKey()), entry.getValue());
		}
		return ret;
	}

	protected String localKey(Object row, List<String> keyfields) {
		if (row instanceof Map) {
			StringBuffer sb = new StringBuffer();

			for (String skey : keyfields) {
				if (sb.length() > 0)
					sb.append("-");
				sb.append(((Map) row).get(skey));
			}
			return sb.toString();
		}
		return String.valueOf(row);
	}

	static List<String> getKeyField(Class beanclazz) throws ClassNotFoundException {
		Class keyclazz = Class.forName(beanclazz.getName() + "Key");
		List<String> ret = new ArrayList<String>();
		for (Field ff : keyclazz.getDeclaredFields()) {
			ret.add(ff.getName());
		}
		return ret;

	}

	public void reloadToCache(Class beanclazz, HashMap<String, HashMap<String, HashMap<String, Object>>> tmpmap) {

		Tab tab = (Tab) beanclazz.getAnnotation(Tab.class);
		if (tab != null && !StringUtils.isBlank(tab.name())) {

			// find keys:
			List<String> keyfields;
			try {
				keyfields = getKeyField(beanclazz);
			} catch (ClassNotFoundException e) {
				log.warn("cannot Found key for keyfields, drop mapping to cache:" + beanclazz);
				return;
			}
			Object obj = mysqlDao.doBySQL("SELECT * FROM " + tab.name());
			val tablename = tab.name().replaceAll("_", "").toLowerCase();
			// List arr = SerializerUtil.deserializeArray(obj, beanclazz);
			val tablecolmap = new HashMap<String, HashMap<String, Object>>();
			tmpmap.put(tablename, tablecolmap);
			for (Object row : (List) obj) {
				HashMap<String, Object> mb = toCaseIgnore((HashMap<String, Object>) row);
				String key = localKey(mb, keyfields);
				tablecolmap.put(key, mb);
				log.debug("store:" + tablename + ",(" + keyfields + "):" + key + ":" + mb);
			}
		} else {
			log.warn("cannot Found tab def for keyfields, drop mapping to cache:" + beanclazz);
		}
	}

	public static void main(String[] args) {
		Class beanclazz = TSysParam.class;
		try {
			System.out.println(getKeyField(beanclazz));
			System.out.println(String.valueOf(null));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onDaoServiceReady(OJpaDAO<?> dao) {
		if (mysqlDao == dao) {
			val tmpmap = new HashMap<String, HashMap<String, HashMap<String, Object>>>();
			for (Class clazz : PreLoadClass.getPreLoad()) {
				reloadToCache(clazz, tmpmap);
			}
			storebyTableColumn = tmpmap;
		}
	}

	@Override
	public void doDelete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		String mac = req.getParameter("mac");
		if (!"123456".equals(mac)) {
			res.getWriter().write("{\"status\":-2,\"msg\":\"UnAuthorized!\"}");
			return;
		}
		if ("reload".equals(cmd)) {
			onDaoServiceReady(mysqlDao);
			res.getWriter().write("{\"status\":1,\"cmd\":\"" + cmd + "\"}");
		} else {
			res.getWriter().write("{\"status\":-1,\"msg\":\"unknow command!\"}");
		}
	}

	@Override
	public void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

	}

	@Override
	public void doPut(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

	}

	@Override
	public String getWebPath() {
		return "/cache/man.do";
	}

}
