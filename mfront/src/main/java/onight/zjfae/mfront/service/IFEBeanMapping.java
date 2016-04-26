package onight.zjfae.mfront.service;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import onight.mgame.utils.PBInfo;
import onight.tfw.outils.bean.JsonPBUtil;

import org.apache.commons.lang3.StringUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleReference;

import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.Message;

public class IFEBeanMapping {

	public static class WrapClassLoader extends ClassLoader {

		public WrapClassLoader(ClassLoader parent) {
			super(parent);
		}

		@Override
		public Class<?> loadClass(String name) throws ClassNotFoundException {
			// log.info("LOadClass::" + name);
			Class<?> clazz = null;
			try {
				clazz = super.loadClass(name);
			} catch (Exception e) {
			}
			if (clazz == null) {
				try {
					clazz = BundleReference.class.cast(IFEBeanMapping.class.getClassLoader()).getBundle().loadClass(name);
				} catch (Exception e) {
				}
			}
			if (clazz == null) {
				clazz = BundleReference.class.cast(IFEBeanMapping.class.getClassLoader()).getBundle().loadClass(name);

			}
			return clazz;
		}

	}

	private static List<Class> findClasses(String packageName) throws ClassNotFoundException {
		// Enumeration<URL> en =
		// BundleReference.class.cast(IFEBeanMapping.class.getClassLoader()).getBundle().findEntries(packageName.replaceAll("\\.",
		// "/"), "*.class", true);
		Bundle bundle = BundleReference.class.cast(IFEBeanMapping.class.getClassLoader()).getBundle();
		Enumeration<URL> en = bundle.findEntries(packageName.replaceAll("\\.", "/"), "*.class", true);
		WrapClassLoader loader = new WrapClassLoader(IFEBeanMapping.class.getClassLoader());
		System.out.println("en==" + en);
		List<Class> classes = new ArrayList<Class>();
		while (en.hasMoreElements()) {
			URL url = en.nextElement();
			try {
				Class clazz =  bundle.loadClass(url.getFile().substring(1,url.getFile().lastIndexOf(".")).replaceAll("/", "."));
//				Class clazz = loader.loadClass(url.toString());
				classes.add(clazz);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return classes;

		// // List<Class> classes = new ArrayList<Class>();
		// if (!directory.exists()) {
		// return classes;
		// }
		// File[] files = directory.listFiles();
		//
		// for (File file : files) {
		// if (file.isDirectory()) {
		// assert !file.getName().contains(".");
		// classes.addAll(findClasses(file, packageName + "." +
		// file.getName()));
		// } else if (file.getName().endsWith(".class")) {
		// classes.add(Class.forName(packageName + '.' +
		// file.getName().substring(0, file.getName().length() - 6)));
		// }
		// }
		// return classes;
	}

	private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.addAll(findClasses(packageName));
		return classes.toArray(new Class[classes.size()]);
	}

	public HashMap<String, Class> name2JsonClass = new HashMap<>();
	public HashMap<String, Class> name2ReqPBClass = new HashMap<>();
	public HashMap<String, Class> name2ResPBClass = new HashMap<>();
	public HashMap<String, String> name2EURL = new HashMap<>();

	public interface PostProc {
		public void postDO(Message message, String pbname);
	}

	public interface PreProc{
		public void prepDO(Message message,String pbname);
	}
	public HashMap<String, PostProc> name2PostProcess = new HashMap<>();
	public HashMap<String, PreProc> name2PrepProcess = new HashMap<>();



	public String getCamelStr(String str) {
		StringBuffer sb = new StringBuffer();
		for (String substr : str.split("_")) {
			sb.append(StringUtils.capitalize(substr));
		}
		str = sb.toString();
		sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (StringUtils.isNumeric("" + str.charAt(i))) {
				sb.append(str.charAt(i));
				if (i < str.length() - 1) {
					i++;
					sb.append(StringUtils.upperCase("" + str.charAt(i)));
				}
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	public void init() {
		try {
			for (Class clazz : getClasses("onight.mgame.autogens")) {
				// Class clazz = IF_不良资产产品查询_项目揭示_.class;
				PBInfo ano = (PBInfo) clazz.getAnnotation(PBInfo.class);
				if (ano == null)
					continue;

				name2EURL.put(ano.name(), ano.path());

				name2JsonClass.put(ano.name(), clazz);
				Class pbclazz = Class.forName("onight.zjfae.afront.gens." + getCamelStr(ano.name()) + "$Ret_" + ano.name());
				name2ResPBClass.put(ano.name(), pbclazz);

				Class pbreqclazz = Class.forName("onight.zjfae.afront.gens." + getCamelStr(ano.name()) + "$REQ_" + ano.name());
				name2ReqPBClass.put(ano.name(), pbreqclazz);
			}

			initPostProc();
			initPrepProc();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initPostProc() {
		//
		name2PostProcess.put("PBIFE_passwordmanage_resetTradePassword", new RegPostProc());
	}
	public void initPrepProc(){
		//
		name2PrepProcess.put("PBIFE_passwordmanage_resetTradePassword", new RegPrepProc());
		name2PrepProcess.put("PBIFE_trade_queryTransferSellProfits", new BuyOrTradeFee());
		
		

	}

	public <T> T parseREQ(HttpServletRequest req) {
		String pbcmd = req.getParameter("pbcmd");

		return null;
	}

	public Message json2ResPB(String key, String json) {
		Class pbclazz = name2ResPBClass.get(key);
		if (pbclazz == null) {
			return null;
		}
		try {
			Method method = pbclazz.getDeclaredMethod("newBuilder");
			// Builder builder = getPBBuilder();
			if (method != null) {
				Builder builder = (Builder) method.invoke(null);
				JsonPBUtil.json2PB(json, (Builder) builder);
				return builder.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getEURL(String pbname) {
		return name2EURL.get(pbname);
	}

	public Builder getReqBuilder(String pbname) {
		Class pbclazz = name2ReqPBClass.get(pbname);
		if (pbclazz == null) {
			return null;
		}
		try {
			Method builder = pbclazz.getDeclaredMethod("newBuilder");
			return (Builder) builder.invoke(pbclazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Builder getResBuilder(String pbname) {
		Class pbclazz = name2ResPBClass.get(pbname);
		if (pbclazz == null) {
			return null;
		}
		try {
			Method builder = pbclazz.getDeclaredMethod("newBuilder");
			return (Builder) builder.invoke(pbclazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void postProcess(Message message,String pbname) {
		PostProc pbclazz = name2PostProcess.get(pbname);
		if (pbclazz == null) {
			return ;
		}
		try {
		 pbclazz.postDO(message, pbname);;	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void preProcess(Message message,String pbname) {
		PreProc pbclazz = name2PrepProcess.get(pbname);
		if (pbclazz == null) {
			return ;
		}
		try {
		 pbclazz.prepDO(message, pbname);;	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		IFEBeanMapping beanmap = new IFEBeanMapping();
		beanmap.init();
		String test = "PBIFE_securityquestionmanage_setSecurityQuestionPre";
		Class pbclazz = beanmap.name2ResPBClass.get(test);
		try {
			Method builder = pbclazz.getDeclaredMethod("newBuilder");
			System.out.println("bb==" + builder.invoke(pbclazz).hashCode());
			Message msg = beanmap.json2ResPB("PBIFE_bankcardmanage_acquireBankSmsCheckCode4changeBind", "{\"serialNo\":\"aabb\"}");
			System.out.println("msg==" + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
