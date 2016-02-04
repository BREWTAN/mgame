package cn.msec.ojpa.cass.util;

import java.lang.annotation.Annotation;

import cn.msec.ojpa.cass.enums.Counter;
import cn.msec.ojpa.cass.enums.Id;
import cn.msec.ojpa.cass.enums.Indexed;
import cn.msec.ojpa.cass.enums.KeyColumn;

public class AnnotationUtils {
	
	public static  boolean hasKey(Annotation[] annotations){
		if(annotations==null||annotations.length<=0){
			return false;
		}
		for(Annotation at: annotations){
			if (at.annotationType() == KeyColumn.class||
				at.annotationType() == Id.class) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasKeyAndIndex(Annotation[] annotations){
		if(annotations==null||annotations.length<=0){
			return false;
		}
		for(Annotation at: annotations){
			if (at.annotationType() == KeyColumn.class||
				at.annotationType() == Indexed.class||
				at.annotationType() == Id.class) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasCounter(Annotation[] annotations){
		if(annotations==null||annotations.length<=0){
			return false;
		}
		for(Annotation at: annotations){
			if (at.annotationType() == Counter.class) {
				return true;
			}
		}
		return false;
	}
	
}
