package onight.tfw.cass.mapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Transient;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Select.Selection;

import onight.tfw.cass.enums.Table;
import onight.tfw.cass.exception.CQLGenException;
import onight.tfw.cass.util.AnnotationUtils;

public class SelectStatement extends CQLStatement {
	protected static Map<Class<?>, Method> classDataTypeMap = new HashMap<>();
	
	public CQLStatement findOne(Class<?> clazz) throws CQLGenException {
		cachedCQL=generateSelect(clazz, true).getQueryString();
		return this;
	}

	public CQLStatement findAll(Class<?> clazz) throws CQLGenException {
		cachedCQL=generateSelect(clazz, false).getQueryString();
		return this;
	}
	
	
	public CQLStatement countAll(Class<?> clazz) throws CQLGenException {
		cachedCQL = generateCount(clazz, false).getQueryString();
		return this;
	}
	
	public CQLStatement count(Class<?> clazz) throws CQLGenException {
		cachedCQL = generateCount(clazz, true).getQueryString();
		return this;
	}
	
	public CQLStatement findByExample(Class<?> clazz,HashMap<String,Object> mb,int limit){
		cachedCQL = generateSelectByExample(clazz,mb,limit).getQueryString();
		return this;
	}
	
	
	public Select generateSelectByExample(Class<?> clazz,HashMap<String,Object> mb,int limit) {
		Table tb = (Table) clazz.getAnnotation(Table.class);
		Selection selection = QueryBuilder.select();
		Select select = selection.from(tb.name());
		for (Field field : clazz.getDeclaredFields()) {
			Transient trans = (Transient) field.getAnnotation(Transient.class);
			if (trans != null) {
				continue;
			}
			selection.column(field.getName());
			Annotation[] annotations = field.getAnnotations();
			if(AnnotationUtils.hasKeyAndIndex(annotations)&&mb.get(field.getName())!=null) {
				select.where().and(QueryBuilder.eq(field.getName(), "?"));
				postFieldnames.add(field.getName());
			}
		}
		if(limit>0)
		{
			select.limit(limit);
		}
		return select;
	}
	
	private Select generateCount(Class<?> clazz, boolean byCondi)
			throws CQLGenException {
		Table tb = (Table) clazz.getAnnotation(Table.class);
		if (tb == null) {
			throw new CQLGenException("TableName not found");
		}
		Selection selection = QueryBuilder.select();
		Select select = selection.countAll().from(tb.name());
		if (!byCondi) {
			return select;
		}
		for (Field field : clazz.getDeclaredFields()) {
			Annotation[] annotations = field.getAnnotations();
			if(AnnotationUtils.hasPartitionKey(annotations)) {
				select.where().and(QueryBuilder.eq(field.getName(), "?"));
				postFieldnames.add(field.getName());
			}
		}
		return select;
	}
	
	private Select generateSelect(Class<?> clazz, boolean withCondi) throws CQLGenException {
		Table tb = (Table) clazz.getAnnotation(Table.class);
		if (tb == null) {
			throw new CQLGenException("TableName not found");
		}
		Selection selection = QueryBuilder.select();
		Select select = selection.from(tb.name());
		for (Field field : clazz.getDeclaredFields()) {
			Transient trans = (Transient) field.getAnnotation(Transient.class);
			if (trans != null) {
				continue;
			}
			selection.column(field.getName());
			if (withCondi) {
				Annotation[] annotations = field.getAnnotations();
				if(AnnotationUtils.hasKey(annotations)) {
					select.where().and(QueryBuilder.eq(field.getName(), "?"));
					postFieldnames.add(field.getName());
				}
			}
		}
		return select;
	}
	
}
