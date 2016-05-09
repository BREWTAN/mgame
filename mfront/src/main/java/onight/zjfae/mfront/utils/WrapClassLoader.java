package onight.zjfae.mfront.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import onight.zjfae.mfront.service.IFEBeanMapping;

import org.apache.commons.lang3.StringUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleReference;

@Slf4j
public class WrapClassLoader extends ClassLoader {
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

	private static List<Class> findClasses(String packageName) throws ClassNotFoundException {
		// Enumeration<URL> en =
		// BundleReference.class.cast(IFEBeanMapping.class.getClassLoader()).getBundle().findEntries(packageName.replaceAll("\\.",
		// "/"), "*.class", true);
		WrapClassLoader loader = new WrapClassLoader(IFEBeanMapping.class.getClassLoader());
		Enumeration<URL> en;
		List<Class> classes = new ArrayList<Class>();
		if (IFEBeanMapping.class.getClassLoader() instanceof org.osgi.framework.BundleReference) {
			Bundle bundle = BundleReference.class.cast(IFEBeanMapping.class.getClassLoader()).getBundle();
			en = bundle.findEntries(packageName.replaceAll("\\.", "/"), "*.class", true);
			// System.out.println("en==" + en);
			while (en.hasMoreElements()) {
				URL url = en.nextElement();
				try {
					Class clazz = bundle.loadClass(url.getFile().substring(1, url.getFile().lastIndexOf(".")).replaceAll("/", "."));
					// Class clazz = loader.loadClass(url.toString());
					classes.add(clazz);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} else {
			try {
				en = loader.getResources(packageName.replaceAll("\\.", "/"));
				File files[] = new File(en.nextElement().getFile()).listFiles(new FileFilter() {

					@Override
					public boolean accept(File pathname) {
						return pathname.getName().endsWith(".class");
					}
				});
				for (File file : files) {
					try {
						String clazzpath = file.getAbsolutePath().substring(1, file.getAbsolutePath().lastIndexOf(".")).replaceAll("/", ".");
						int start = clazzpath.indexOf(packageName);
						Class clazz = IFEBeanMapping.class.getClassLoader().loadClass(clazzpath.substring(start));
						classes.add(clazz);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		log.info("found Classes in " + packageName + ", count :" + classes.size());

		return classes;

	}

	public static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.addAll(findClasses(packageName));
		return classes.toArray(new Class[classes.size()]);
	}

	public static String getCamelStr(String str) {
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

}