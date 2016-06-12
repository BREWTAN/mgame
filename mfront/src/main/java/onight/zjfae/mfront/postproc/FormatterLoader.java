package onight.zjfae.mfront.postproc;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;
import onight.zjfae.mfront.postproc.annotation.Formatter;
import onight.zjfae.mfront.utils.WrapClassLoader;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;
/**
 * @author tfw
 * @date   2016年6月12日
 * @desc   加载需要格式化处理类信息
 */
@Slf4j
public class FormatterLoader {

	public HashMap<String, Class> formattersByProcName = new HashMap<String, Class>();

	public FormatterLoader() {

		try {
			for (Class clazz : WrapClassLoader.getClasses("onight.zjfae.mfront.postproc.impl")) {
				Formatter fm = (Formatter) clazz.getAnnotation(Formatter.class);
				if (fm != null) {
					formattersByProcName.put(fm.value().toLowerCase(), clazz);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AbstractPostFieldTracker getTracker(APPIfacePostproc proc) {
		Class clazz = formattersByProcName.get(proc.getFormatProc().toLowerCase());
		if (clazz != null) {
			try {
				Constructor<AbstractPostFieldTracker> con = clazz.getConstructor(APPIfacePostproc.class);
				return con.newInstance(proc);
			} catch (Exception e) {
				log.warn("New_TrackerClass_Error::" + proc.getFormatProc() + ",class=" + clazz, e);
			}

		}
		return null;

	}
}
