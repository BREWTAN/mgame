package onight.zjfae.mfront.action;

import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.AsyncPBActor;
import onight.tfw.ntrans.api.PBActor;

import com.google.protobuf.Message;

@iPojoBean
public abstract class AuthorizedModuleStarter<T extends Message> extends AsyncPBActor<T> {

	public static final String MODULE_NAME = "AZJ";

	@Override
	public String getModule() {
		return MODULE_NAME;
	}

}
