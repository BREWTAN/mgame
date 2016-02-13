package onight.tfw.cass.util;

import java.lang.annotation.Annotation;

import onight.tfw.cass.enums.Counter;
import onight.tfw.cass.enums.Id;
import onight.tfw.cass.enums.Indexed;
import onight.tfw.cass.enums.KeyColumn;
import onight.tfw.cass.enums.KeyPart;

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
	
	
	public static  boolean hasPartitionKey(Annotation[] annotations){
		if(annotations==null||annotations.length<=0){
			return false;
		}
		for(Annotation at: annotations){
			if (at.annotationType() == KeyColumn.class) {
				KeyColumn kc=(KeyColumn)at;
				return kc.keyPart()==KeyPart.PARTITION;
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
