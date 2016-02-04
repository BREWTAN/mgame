package onight.tfw.cass.enums;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Identifies a secondary index in the table. Usually it is a field with common dublicate values for the hole table.
 * such as city, place, educationType, state flags ant etc.
 * 
 * Using unique fields is not common and has overhead, such as email, username and etc.
 * 
 * @author Alex Shvid
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
public @interface Counter {

	/**
	 * The name of the index in the keyspace.
	 * 
	 * @return
	 */

	String name() default "";

}
