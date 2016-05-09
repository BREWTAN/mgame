package onight.zjfae.mfront.service;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import onight.mgame.utils.PBInfo;
import onight.tfw.outils.bean.JsonPBUtil;
import onight.zjfae.mfront.utils.WrapClassLoader;

import org.apache.commons.lang3.StringUtils;

import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.Message;

public class IFEBeanMapping {

	public HashMap<String, Class> name2JsonClass = new HashMap<>();
	public HashMap<String, Class> name2ReqPBClass = new HashMap<>();
	public HashMap<String, Class> name2ResPBClass = new HashMap<>();
	public HashMap<String, String> name2EURL = new HashMap<>();

	public interface PostProc {
		public void postDO(Message.Builder builder, String pbname);
	}

	public interface PreProc {
		public boolean prepDO(Message message, String pbname);
	}

	public HashMap<String, PostProc> name2PostProcess = new HashMap<>();
	public HashMap<String, PreProc> name2PrepProcess = new HashMap<>();

	
	public void init() {
		try {
			for (Class clazz : WrapClassLoader.getClasses("onight.mgame.autogens")) {
				// Class clazz = IF_不良资产产品查询_项目揭示_.class;
				PBInfo ano = (PBInfo) clazz.getAnnotation(PBInfo.class);
				if (ano == null)
					continue;
				name2EURL.put(ano.name(), ano.path());

				name2JsonClass.put(ano.name(), clazz);
				Class pbclazz = Class.forName("onight.zjfae.afront.gens." + WrapClassLoader.getCamelStr(ano.name()) + "$Ret_" + ano.name());
				name2ResPBClass.put(ano.name(), pbclazz);

				Class pbreqclazz = Class.forName("onight.zjfae.afront.gens." + WrapClassLoader.getCamelStr(ano.name()) + "$REQ_" + ano.name());
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

	public void initPrepProc() {
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

	public void postProcess(Message.Builder builder, String pbname) {
		PostProc pbclazz = name2PostProcess.get(pbname);
		if (pbclazz == null) {
			return;
		}
		try {
			pbclazz.postDO(builder, pbname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean preProcess(Message message, String pbname) {
		PreProc pbclazz = name2PrepProcess.get(pbname);
		if (pbclazz == null) {
			return true;
		}
		try {
			return pbclazz.prepDO(message, pbname);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
