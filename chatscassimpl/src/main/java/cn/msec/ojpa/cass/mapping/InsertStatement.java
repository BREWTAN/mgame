package cn.msec.ojpa.cass.mapping;

import java.lang.reflect.Field;

import org.springframework.data.annotation.Transient;

import cn.msec.ojpa.cass.enums.Table;
import cn.msec.ojpa.cass.exception.CQLGenException;

import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class InsertStatement extends CQLStatement {

	public CQLStatement insert(Class<?> clazz) throws CQLGenException {
		return insertIfNotExist(clazz, false);
	}

	public CQLStatement insertIfNotExist(Class<?> clazz, boolean ifNotExist) throws CQLGenException {
		Table tb = (Table) clazz.getAnnotation(Table.class);
		if (tb == null) {
			throw new CQLGenException("TableName not found");
		}
		Insert insert = QueryBuilder.insertInto(tb.name());
		for (Field field : clazz.getDeclaredFields()) {
			Transient trans = (Transient) field.getAnnotation(Transient.class);
			if (trans != null) {
				continue;
			}
			fieldnames.add(field.getName());
			insert.value(field.getName(), "?");
		}
		if (ifNotExist) {
			insert.ifNotExists();
		}
		cachedCQL=insert.getQueryString();
		return this;
	}

}
