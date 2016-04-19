package cn.msec.bval.exception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ErrorMessage {
	ITRD_Message value() default ITRD_Message.ITM_UNKNOW;
}