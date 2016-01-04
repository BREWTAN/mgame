package onight.mgame.front.action;

import onight.osgi.annotation.iPojoBean;
import onight.tfw.ntrans.api.PBActor;

import com.google.protobuf.Message;

@iPojoBean
public abstract class ModuleStarter<T extends Message> extends PBActor<T> {

	@Override
	public String getModule() {
		return "FNT";
	}

}
