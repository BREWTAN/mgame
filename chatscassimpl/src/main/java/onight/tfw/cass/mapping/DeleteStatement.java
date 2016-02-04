package onight.tfw.cass.mapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.springframework.data.annotation.Transient;

import com.datastax.driver.core.querybuilder.Delete;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import onight.tfw.cass.enums.Table;
import onight.tfw.cass.exception.CQLGenException;
import onight.tfw.cass.util.AnnotationUtils;

public class DeleteStatement extends CQLStatement {

	public CQLStatement deleteByKey(Class<?> clazz) throws CQLGenException {
		Table tb = (Table) clazz.getAnnotation(Table.class);
		if (tb == null) {
			throw new CQLGenException("TableName not found");
		}
		Delete delete = QueryBuilder.delete().from(tb.name());
		for (Field field : clazz.getDeclaredFields()) {
			Transient trans = (Transient) field.getAnnotation(Transient.class);
			if (trans != null) {
				continue;
			}
			Annotation[] annotations = field.getAnnotations();
			if(AnnotationUtils.hasKey(annotations)) {
				delete.where().and(QueryBuilder.eq(field.getName(), "?"));
				postFieldnames.add(field.getName());
			}
		}
		cachedCQL = delete.getQueryString();
		return this;
	}
	
	public CQLStatement deleteIfExist(Class<?> clazz) throws CQLGenException {
		deleteByKey(clazz);
		cachedCQL = cachedCQL.substring(0, cachedCQL.lastIndexOf(";")) + " IF EXISTS;";
		return this;
	}

}
