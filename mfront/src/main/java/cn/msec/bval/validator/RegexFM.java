package cn.msec.bval.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFM implements IVal {
	@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface RegexFMA {
		String pattern();

		Class<? extends IVal> valClass() default RegexFM.class;
	}

	Pattern regex;

	public RegexFM() {

	}

	@Override
	public boolean init(Annotation a) {
		try {
			regex = Pattern.compile(((RegexFMA) a).pattern());
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean isValid(String v) {
		if (v != null) {
			Matcher matcher = regex.matcher(v);
			return matcher.matches();
		}
		return true;
	}

}