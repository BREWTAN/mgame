package cn.msec.bval.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

public class Number implements IVal{

	@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface NumberA {
		double min() default Integer.MIN_VALUE;

		double max() default Integer.MAX_VALUE;
		
		Class<? extends IVal> valClass() default Number.class;
	}

	NumberA number;

	@Override
	public boolean init(Annotation a) {
		try {
			number = (NumberA) a;
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean isValid(String v) {
		if (StringUtils.isNumeric(v)) {
			Double d = Double.parseDouble(v);
			return d >= number.min() && d <= number.max();
		}
		return false;
	}

}
