package onight.mgame.acctcore.startup;

import onight.osgi.annotation.iPojoBean;
import onight.tfw.ntrans.api.PBActor;
import onight.tfw.outils.bean.BeanPBUtil;

import com.google.protobuf.Message;

@iPojoBean
public abstract class ModuleStarter<T extends Message> extends PBActor<T> {

	@Override
	public String getModule() {
		return "ACT";
	}

	protected static BeanPBUtil pbBeanUtil = new BeanPBUtil();

}
