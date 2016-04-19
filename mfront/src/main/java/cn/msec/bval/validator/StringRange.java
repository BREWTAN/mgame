package cn.msec.bval.validator;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import cn.msec.bval.validator.NotBlank.NotBlankA;

public class StringRange implements IVal {

	@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	@NotBlankA
	public @interface StringRangeA {
		int min() default 0;

		int value() default 0;

		boolean notblank() default false;
		
		boolean isbyte() default false;

		int max() default Integer.MAX_VALUE;
		
		boolean isSpecial() default false;

		Class<? extends IVal> valClass() default StringRange.class;
		
	}

	StringRangeA range;
	
	char specialChars[] = "[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~\"".toCharArray();//！@#￥%&*（）——+|{}]【】‘；：”“’。，、？
//	Pattern pattern = Pattern.compile(regex);


	@Override
	public boolean init(Annotation a) {
		range = (StringRangeA) a;
		return true;
	}

	@Override
	public boolean isValid(String v) {
		if (v == null||v.equals("")) {
			if (range.notblank()||range.value()>0||(range.min()>0&&!range.notblank())) {
				return false;
			} else {
				return true;
			}
		}
		if(!range.isSpecial()&&specialCharValid(v)){
			return false;
		}
		int l = v.length();
		if(range.isbyte()){
			try {
				l = v.getBytes("UTF-8").length;
			} catch (UnsupportedEncodingException e) {
			}
		}
		if (range.value() > 0)
			return range.value() == l;
		return l >= range.min() && l <= range.max();
	}
	public boolean specialCharValid(String v){
		return StringUtils.containsAny(v, specialChars);
//		return v.contains(regex);
//		boolean result = false;
//		String[] strArr = {};
//		if(v.length()>0){
//			strArr = v.split("");
//		}
//		for(String str : strArr){
//			Matcher mather = pattern.matcher(str);
//			if(mather.matches()){
//				result = true;
//				break;
//			}
//		}
//		return result;
	}
}
