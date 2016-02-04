package cn.msec.ojpa.cass.enums;

/**
 * Tany
 * id列表
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
public @interface Id {
}
