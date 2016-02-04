package cn.msec.ojpa.cass.mapping;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.springframework.cassandra.core.cql.generator.CreateTableCqlGenerator;
import org.springframework.cassandra.core.keyspace.CreateTableSpecification;
import org.springframework.cassandra.core.keyspace.Option;
import org.springframework.cassandra.core.keyspace.TableOption;
import org.springframework.cassandra.core.keyspace.TableOption.CachingOption;
import org.springframework.cassandra.core.keyspace.TableOption.CompressionOption;
import org.springframework.data.cassandra.mapping.CassandraSimpleTypeHolder;

import cn.msec.ojpa.cass.enums.Counter;
import cn.msec.ojpa.cass.enums.Id;
import cn.msec.ojpa.cass.enums.KeyColumn;
import cn.msec.ojpa.cass.enums.KeyPart;
import cn.msec.ojpa.cass.enums.Qualify;
import cn.msec.ojpa.cass.enums.Table;
import cn.msec.ojpa.cass.exception.CQLGenException;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.DataType;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Truncate;

public class TableStatement {

	public static Statement create(Class<?> clazz) throws CQLGenException {
		Table tb = (Table) clazz.getAnnotation(Table.class);
		if (tb == null) {
			throw new CQLGenException("TableName not found");
		}

		CreateTableSpecification tableSpec = CreateTableSpecification.createTable(tb.name()).ifNotExists(tb.ifNotExists());
		genColumns(clazz, tableSpec);
		if (tb.compression() != null) {
			HashMap<Option, String> compress = new HashMap<>();
			compress.put(CompressionOption.SSTABLE_COMPRESSION, "");
			tableSpec.with(TableOption.COMPRESSION, compress);
//			.with("compaction","{}",false,false);
		}
		tableSpec.ifNotExists();
		if (tb.cacheAll()) {
			tableSpec.with(TableOption.CACHING, CachingOption.KEYS);
		}
		return new SimpleStatement(CreateTableCqlGenerator.toCql(tableSpec));
	}
	
	public static Statement truncate(Class<?> clazz) throws CQLGenException {
		Table tb = (Table) clazz.getAnnotation(Table.class);
		if (tb == null) {
			throw new CQLGenException("TableName not found");
		}

		Truncate tableSpec = QueryBuilder.truncate(tb.name());
		return new SimpleStatement(tableSpec.getQueryString());
	}

	private static void genColumns(Class<?> clazz, CreateTableSpecification tableSpec) throws CQLGenException {
		// list fields.
		for (Field field : clazz.getDeclaredFields()) {
			KeyColumn kc = (KeyColumn) field.getAnnotation(KeyColumn.class);
			if (kc != null) {
				if (kc.keyPart() == KeyPart.PARTITION) {
					tableSpec.partitionKeyColumn(field.getName(), dateTypeFor(field));
					//
				} else {
					tableSpec.clusteredKeyColumn(field.getName(), dateTypeFor(field), kc.ordering());
				}
			} else if (field.getAnnotation(Id.class) != null) {
				tableSpec.partitionKeyColumn(field.getName(), dateTypeFor(field));
			} else 
			{
				tableSpec.column(field.getName(),dateTypeFor(field));
			}
		}

	}

	public static DataType dateTypeFor(Field field){
		Counter cc= field.getAnnotation(Counter.class);
		if(cc!=null){
			return DataType.counter();
		}
		Qualify qualify = field.getAnnotation(Qualify.class);
		if(qualify!=null){
			return getDataTypeFor(qualify);
		}
		return CassandraSimpleTypeHolder.getDataTypeFor(field.getType());
	}
	
	private static DataType getDataTypeFor(Qualify annotation) {
		DataType.Name type = annotation.type();
		if (type.isCollection()) {
			switch (type) {
			case MAP:
				return DataType.map(CassandraSimpleTypeHolder.getDataTypeFor(annotation.typeArguments()[0]),
						CassandraSimpleTypeHolder.getDataTypeFor(annotation.typeArguments()[1]));
			case LIST:
				return DataType.list(CassandraSimpleTypeHolder.getDataTypeFor(annotation.typeArguments()[0]));
			case SET:
				return DataType.set(CassandraSimpleTypeHolder.getDataTypeFor(annotation.typeArguments()[0]));
			default:
				throw new RuntimeException(
						String.format("unknown multivalued DataType [%s] for property [%s] ", type, annotation.typeArguments() ));
			}
		} else {
			return CassandraSimpleTypeHolder.getDataTypeFor(type);
		}
	}
	
//	public static void main(String[] args) {
//		try {
//			Statement cql = TableStatement.create(MessageIDCounter.class);
//			System.out.println("CQLs=" + cql);
//
//			Cluster cluster = Cluster.builder().addContactPoint("192.168.24.31").build();
//			Session session = cluster.connect("lottery");
//			session.execute(cql);
//
//			session.close();
//			cluster.close();
//
//		} catch (CQLGenException e) {
//			e.printStackTrace();
//		}
//
//	}

}
