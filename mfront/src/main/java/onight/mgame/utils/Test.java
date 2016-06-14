package onight.mgame.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		File dstDir = new File("/Users/wangdongguang/Rmitec/project/zjfae/app/mgame/mfront/src/main/proto/gens");
		dstDir.mkdirs();
		for (Class clazz : getClasses("onight.mgame.autogens")) {
			// Class clazz = IF_不良资产产品查询_项目揭示_.class;
			PBInfo ano = (PBInfo) clazz.getAnnotation(PBInfo.class);
			if (ano == null)
				continue;
		     System.out.println( StringUtils.rightPad(clazz.getSimpleName().substring(3, clazz.getSimpleName().length()),48," ")  +"/ife/mzj/pbife.do?fh=VIFEMZJ000000P00&p=ios&pbname="+ano.name().trim());
		     
		}

	}

	private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes.toArray(new Class[classes.size()]);
	}
	
	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
	}
}
