package onight.zjfae.mfront.preproc;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;
import onight.zjfae.mfront.postproc.annotation.Formatter;
import onight.zjfae.mfront.preproc.annotation.APreProcessor;
import onight.zjfae.mfront.utils.WrapClassLoader;
import onight.zjfae.ordbgens.app.entity.APPIfacePreproc;

@Slf4j
public class PreProccesorLoader {

	public HashMap<String, Class> ppByProcName = new HashMap<String, Class>();

	public PreProccesorLoader() {

		try {
			for (Class clazz : WrapClassLoader.getClasses("onight.zjfae.mfront.preproc.impl")) {
				APreProcessor app = (APreProcessor) clazz.getAnnotation(APreProcessor.class);
				if (app != null) {
					ppByProcName.put(app.value().toLowerCase(), clazz);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AbstractPreProc getPreProcess(APPIfacePreproc proc) {
		Class clazz = ppByProcName.get(proc.getPreProc().toLowerCase());
		if (clazz != null) {
			try {
				Constructor<AbstractPreProc> con = clazz.getConstructor(APPIfacePreproc.class);
				return con.newInstance(proc);
			} catch (Exception e) {
				log.warn("New_TrackerClass_Error::" + proc.getPreProc() + ",class=" + clazz, e);
			}

		}
		return null;

	}
}
