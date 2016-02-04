package cn.msec.ojpa.cass.mapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.springframework.data.annotation.Transient;

import cn.msec.ojpa.cass.enums.Table;
import cn.msec.ojpa.cass.exception.CQLGenException;
import cn.msec.ojpa.cass.util.AnnotationUtils;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Update;

public class CounterStatement extends CQLStatement {

	public enum CounterAction {
		INCREMENT,
		DECREMENT,
		PREPEND,
		DISCARD;
	}
	
	public CQLStatement increment(Class<?> clazz) throws CQLGenException {
		cachedCQL = generateUpdate(clazz,CounterAction.INCREMENT).getQueryString();
		return this;
	}
	
	public CQLStatement decrement(Class<?> clazz) throws CQLGenException {
		cachedCQL = generateUpdate(clazz,CounterAction.DECREMENT).getQueryString();
		return this;
	}
	
	private Update generateUpdate(Class<?> clazz,CounterAction action) throws CQLGenException {
		Table tb = (Table) clazz.getAnnotation(Table.class);
		if (tb == null) {
			throw new CQLGenException("TableName not found");
		}
		Update update = QueryBuilder.update(tb.name());
		for (Field field : clazz.getDeclaredFields()) {
			Transient trans = (Transient) field.getAnnotation(Transient.class);
			if (trans != null) {
				continue;
			}
			Annotation[] annotations = field.getAnnotations();
			if(!AnnotationUtils.hasKey(annotations)&&!AnnotationUtils.hasCounter(annotations)){
				throw new CQLGenException("counter does not allow other properties:"+field.getName());
			}
			if(AnnotationUtils.hasKey(annotations)) {
				update.where().and(QueryBuilder.eq(field.getName(), "?"));
				postFieldnames.add(field.getName());
			} else if(CounterAction.INCREMENT.equals(action)) {
				update.with(QueryBuilder.incr(field.getName(), QueryBuilder.bindMarker(field.getName())));
				fieldnames.add(field.getName());
			}else if(CounterAction.DECREMENT.equals(action)){
				update.with(QueryBuilder.decr(field.getName(), QueryBuilder.bindMarker(field.getName())));
				fieldnames.add(field.getName());
			}
		}
		return update;
	}
	
//	public static void main(String[] args) {
//		CounterStatement cs = new CounterStatement();
//		try {
//			CQLStatement cql = cs.increment(ExpendBulk.class);
//			System.out.println(cql);
//		} catch (CQLGenException e) {
//			e.printStackTrace();
//		}
//	}
}
