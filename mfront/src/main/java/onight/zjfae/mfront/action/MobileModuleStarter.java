package onight.zjfae.mfront.action;

import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.AsyncPBActor;
import onight.tfw.outils.conf.PropHelper;

import com.google.protobuf.Message;

@iPojoBean
public abstract class MobileModuleStarter<T extends Message> extends AsyncPBActor<T> {

	public static final String MODULE_NAME = "MZJ";

	@Override
	public String getModule() {
		return MODULE_NAME;
	}
	
	static PropHelper props = new PropHelper(null);

}
