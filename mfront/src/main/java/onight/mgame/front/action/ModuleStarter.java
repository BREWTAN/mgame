package onight.mgame.front.action;

import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.AsyncPBActor;
import onight.tfw.ntrans.api.PBActor;

import com.google.protobuf.Message;

@iPojoBean
public abstract class ModuleStarter<T extends Message> extends AsyncPBActor<T> {

	public static final String MODULE_NAME = "FNT";

	@Override
	public String getModule() {
		return MODULE_NAME;
	}

}
