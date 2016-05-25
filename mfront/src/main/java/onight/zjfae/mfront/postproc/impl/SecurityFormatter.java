package onight.zjfae.mfront.postproc.impl;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;
import onight.zjfae.mfront.postproc.AbstractPostFieldTracker;
import onight.zjfae.mfront.postproc.annotation.Formatter;
import onight.zjfae.mfront.utils.PBMessageFlatten.ModifyValue;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;

@Slf4j
@Formatter("securityformat")
public class SecurityFormatter extends AbstractPostFieldTracker {

	public SecurityFormatter(APPIfacePostproc procs) {
		super(procs);
	}

	@Override
	public ModifyValue modTraceValue(Object v) {
		String patterns[] = StringUtils.stripAll(procs.getProcParams().trim().split(","));
		if (patterns.length < 2) {
			log.debug("格式化参数错误：" + v + ",formatter=" + procs.getProcParams()+",proc.uuid="+procs.getUuid());
			return null;
		}

		try {
			if (v == null) {
				return new ModifyValue(patterns[1].trim());
			} else {
				return new ModifyValue(formatSecurity(patterns[0].trim(), String.valueOf(v)));
			}
		} catch (Throwable e) {
			log.debug("格式化错误：" + v + ",formatter=" + procs.getProcParams(), e);
			if ("{}".equals(patterns[1].trim())) {
				return new ModifyValue(patterns[1].trim());
			}
			return null;
		}
	}

	public static String formatSecurity(String pattern,String value){
		StringBuffer sb =new StringBuffer();
		int offseti = 0;
		for(char ch:pattern.toCharArray()){
			if(ch=='*'){
				sb.append(ch);
			}else{
				if(offseti<value.length())
				{
					sb.append(value.charAt(offseti));
				}else
				{
					sb.append(ch);
				}
			}
			offseti++;
		}
		for(int i = offseti ;i<value.length();i++){
			sb.append(value.charAt(i));
		}
	
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(formatSecurity("000***000", "1234567890"));
	}
}
