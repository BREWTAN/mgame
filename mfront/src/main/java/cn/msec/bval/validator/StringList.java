package cn.msec.bval.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

public class StringList implements IVal {

	@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface StringListA {
		String[] value() default {};

		boolean notnull() default false;

		Class<? extends IVal> valClass() default StringList.class;
	}

	StringListA strlist;

	@Override
	public boolean init(Annotation a) {
		strlist = (StringListA) a;
		return true;
	}

	@Override
	public boolean isValid(String v) {
		if (v == null || StringUtils.isBlank(v))
			return !strlist.notnull();
		for (String str : strlist.value()) {
			if (StringUtils.equals(v, str))
				return true;
		}
		return false;
	}
}
