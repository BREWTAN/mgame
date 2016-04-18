package onight.mgame.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

public class CSVGenerator {

	static HashMap<String, String> faceMap = new HashMap<String, String>();

	public static void parseFile(File file, String content) {
		String lines[] = content.split("\n");
		// System.out.println("file=="+file.getAbsolutePath());
		// System.out.println("lines.1=:"+lines[1]);
		if (!lines[1].trim().endsWith("html")) {//
			System.out.println("Not Corrent File:" + file.getName() + ".line1=" + lines[1]);
			return;
		}
		String facenames[] = lines[1].trim().split(",");

		if (facenames.length < 6) {
			System.out.println("Not Corrent File:" + file.getName() + ".line1=" + lines[1] + "::facelength=" + facenames.length);
			return;
		}
		
		String pbname = facenames[5].replaceAll("/", "_").replaceAll("_ife", "PBIFE").replaceAll("\\.html", "");
		String pbpath = facenames[5];

		String chname = file.getName().split("-Table 1")[0];// facenames[0].trim()
															// + "_" +
															// facenames[1].trim();
		chname = chname.replaceAll("\\(|\\)|-|（|）", "_").replaceAll(" ", "_");
		if (faceMap.containsKey(chname)) {
			System.out.println("Duplicate FaceFile:" + chname + "::" + file.getName() + "<==>" + faceMap.get(chname));
			return;
		}
		faceMap.put(chname, file.getName());

		// 检查请求参数,,,,,

		if (!lines[2].trim().startsWith("请求参数,,,,,")) {
			System.out.println("Not Corrent FzileLine2ERROR:" + file.getName() + ".line2=" + lines[2]);
			return;
		}
		// 字段英文名,字段中文名,数据类型,数据长度,是否为空,备注
		if (!lines[3].trim().startsWith("字段英文名,字段中文名,数据类型,数据长度,是否为空")) {
			System.out.println("Not Corrent FileLine2ERROR:" + file.getName() + ".line3=" + lines[3]);
			return;
		}
		// 请求参数或者返回参数
		int l = 4;
		StringBuffer reqLines = new StringBuffer();
		while (l < lines.length && !lines[l].trim().startsWith("返回参数,,,,")) {
			int idx = lines[l].indexOf(",");
			if (idx == 0) {
				l++;
				continue;
			}
			reqLines.append("\t\tString ").append(lines[l].substring(0, idx)).append(";//  ").append(lines[l].substring(idx)).append("\n");
			l++;
		}
		reqLines.append("\t\t String tfw__reserved;//保留字段\n\n");

		if (l >= lines.length - 1 && !lines[l].trim().startsWith("返回参数,,,,")) {
			System.out.println("Not Correct 2ERROR:" + file.getName() + ".linel=" + l + ".lines.length=" + lines.length);
		}
		l++;
		if (!lines[l].trim().startsWith("字段英文名,字段中文名,数据类型,数据长度,是否为空")) {
			System.out.println("Not Corrent FileLine2ERROR:" + file.getName() + ".linel=" + lines[l]);
			return;
		}
		l++;
		StringBuffer reslines = new StringBuffer();
		String className = null;
		int startresline = l;
		String classType = null;
		while (l < lines.length && !lines[l].trim().startsWith("返回参数,,,,")) {
			String pars[] = lines[l].split(",");
			int idx = lines[l].indexOf(",");
			if (idx == 0 || pars[0].trim().length() == 0) {
				l++;
				continue;
			}
			if ((pars[0].trim().compareToIgnoreCase("zjsWebResponse") == 0 || pars[0].trim().compareToIgnoreCase("returnCode") == 0
					|| pars[0].trim().compareToIgnoreCase("returnMsg") == 0 || pars[0].trim().compareToIgnoreCase("data") == 0)
					&& l - startresline < 5) {
				l++;
				continue;
			}
			if (className == null && (pars[2].trim().compareToIgnoreCase("String") != 0) && pars[2].trim().compareToIgnoreCase("Boolean") != 0
					&& pars[2].trim().compareToIgnoreCase("BigDecimal") != 0) {
				className = pars[0];
				if (pars[2].trim().compareToIgnoreCase("Object") == 0) {
					classType = pars[0];
				} else if (pars[2].trim().compareToIgnoreCase("map") == 0) {
					classType = pars[0];
				} else {
					classType = pars[2].trim();
				}
				reslines.append("\t@Data\n");
				reslines.append("\t@AllArgsConstructor\n");
				reslines.append("\t@NoArgsConstructor\n");
				if (classType.compareToIgnoreCase("List") == 0) {
					reslines.append("\tpublic static class " + StringUtils.capitalize(className) + " {\n\n");
				} else {
					reslines.append("\tpublic static class " + StringUtils.capitalize(classType) + " {\n\n");
				}
				l++;
				continue;
			}
			if (className != null) {
				if (pars[0].startsWith(className)) {
					reslines.append("\t\t\t\tString ").append(pars[0].replaceAll(className + "\\.", "")).append(";//  ").append(lines[l].substring(idx))
							.append("\n");
				} else if ( pars[0].startsWith(StringUtils.capitalize(className))) {
					reslines.append("\t\t\t\tString ").append(pars[0].replaceAll(StringUtils.capitalize(className) + "\\.", "")).append(";//  ").append(lines[l].substring(idx))
							.append("\n");
				} else {// 重来
					if (classType.compareToIgnoreCase("List") == 0) {
						reslines.append("}\n\n\t\t List<" + StringUtils.capitalize(className) + ">" + className + ";// \n \n");
					} else {
						reslines.append("}\n\n\t\t " + StringUtils.capitalize(classType) + " " + className + ";// \n \n");
					}
					className = null;
					continue;
				}
			} else {
				reslines.append("\t\t" + pars[2].trim() + " ").append(pars[0]).append(";//  ").append(lines[l].substring(idx)).append("\n");
			}
			l++;
		}
		if (className != null) {
			if (classType.compareToIgnoreCase("List") == 0) {
				reslines.append("}\n\n\t\t List<" + StringUtils.capitalize(className) + ">" + className + ";// \n \n");
			} else {
				reslines.append("}\n\n\t\t " + StringUtils.capitalize(classType) + " " + className + ";// \n \n");
			}
			className = null;
		}
		reslines.append("\t\t String tfw__reserved;//保留字段 \n\n");

		String dstPath = "/Users/brew/Documents/KJ/MING/git/mgame/mfront/src/main/java/onight/mgame/autogens";
		try {
			FileOutputStream fout = new FileOutputStream(dstPath + File.separator + "IF_" + chname + ".java");

			fout.write("package onight.mgame.autogens;\n\n".getBytes());

			fout.write("import lombok.AllArgsConstructor;\n".getBytes());
			fout.write("import lombok.Data;\n".getBytes());
			fout.write("import java.util.List;\n".getBytes());
			fout.write("import java.math.BigDecimal;\n".getBytes());

			fout.write("import lombok.NoArgsConstructor;\n\n".getBytes());
			fout.write(("// " + lines[1] + "").getBytes());

			fout.write(("@onight.mgame.utils.PBInfo(name = \""+pbname+"\", path = \""+pbpath+"\") \n").getBytes());

			fout.write(("public class IF_" + chname + " {\n").getBytes("UTF-8"));

			fout.write("\t// =======REQuest==============\n\n".getBytes());
			fout.write("\t@Data\n".getBytes());
			fout.write("\t@AllArgsConstructor\n".getBytes());
			fout.write("\t@NoArgsConstructor\n".getBytes());
			fout.write("\tpublic static class Request {\n\n".getBytes());
			fout.write(reqLines.toString().getBytes("UTF-8"));
			// String imageFile;// 文件名,MultipartFile,,否,
			fout.write("\t}\n\n".getBytes());

			// =======REQuest==============
			fout.write("\t// ======RESponse==========\n\n".getBytes());

			// ======RESponse==========
			fout.write("\t@Data\n".getBytes());
			fout.write("\t@AllArgsConstructor\n".getBytes());
			fout.write("\t@NoArgsConstructor\n".getBytes());
			fout.write("\tpublic static class Response {\n".getBytes());
			fout.write(reslines.toString().getBytes("UTF-8"));
			// String imageFile;// 文件名,MultipartFile,,否,
			fout.write("\t}\n\n}\n".getBytes());

			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// System.out.println("chname == " + chname);

	}

	public static void main(String[] args) {
		File outDir = new File("/Users/brew/Downloads/test/2");
		outDir.mkdirs();
		int i = 0;
		for (File file : new File("/Users/brew/Downloads/test/1").listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".csv");
			}
		})) {
			// if (i < 3)
			try {
				FileInputStream fin = new FileInputStream(file);
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				byte bb[] = new byte[2048];
				int size = 0;
				while ((size = fin.read(bb)) > 0) {
					bout.write(bb, 0, size);
				}

				bout.close();
				fin.close();
				String content = new String(bout.toByteArray(), "UTF-8");
				// System.out.println("file::" + file.getName() + "\n" +
				// content);
				parseFile(file, content);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
