package cn.msec.bval.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Email extends RegexFM {

	@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface EmailA {
		Class valClass() default Email.class;
	}
	
	@RegexFMA(pattern = "^[\\w-]+(\\.[\\w-]+)*@([a-z0-9-]+(\\.[a-z0-9-]+)*?\\.[a-z]{2,6}|(\\d{1,3}\\.){3}\\d{1,3})(:\\d{4})?$")
	public class EmailBean {
	}

	@Override
	public boolean init(Annotation a) {
		return super.init(EmailBean.class.getAnnotation(RegexFMA.class));
	}
}
