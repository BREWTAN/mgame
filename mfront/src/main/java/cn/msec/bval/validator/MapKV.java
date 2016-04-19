package cn.msec.bval.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import cn.msec.bval.validator.NotBlank.NotBlankA;

public class MapKV{

	@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	@NotBlankA
	public @interface MapKVA {
		String key() default "";

		String value() default "";

		boolean notblank() default false;
	}
	
	MapKVA kva;
	public boolean init(Annotation a) {
		kva = (MapKVA) a;
		return true;
	}
	
	public String getProp(Map<String,String>map){
		if(map.containsKey(kva.key())){
			return map.get(kva.key());
		}
		return kva.value();
	}
}
