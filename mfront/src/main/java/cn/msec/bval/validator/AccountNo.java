package cn.msec.bval.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

import cn.msec.bval.validator.NotBlank.NotBlankA;

public class AccountNo implements IVal {

	@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	@NotBlankA
	public @interface AccountNoM {
		boolean notblank() default true;
		Class<? extends IVal> valClass() default AccountNo.class;
		
	}


	@Override
	public boolean init(Annotation a) {
		return true;
	}

	@Override
	public boolean isValid(String v) {
		if (StringUtils.isBlank(v)) {
			return false;
		}
		return v.split("-").length==2;
	}
}
