package cn.msec.bval.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

public class NotBlank implements IVal {
	@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface NotBlankA {
		Class<? extends IVal> valClass() default NotBlank.class;

	}

	@Override
	public boolean init(Annotation a) {
		return true;
	}

	@Override
	public boolean isValid(String v) {
		return StringUtils.isNotBlank(v);
	}

}