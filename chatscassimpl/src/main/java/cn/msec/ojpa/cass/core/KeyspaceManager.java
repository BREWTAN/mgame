package cn.msec.ojpa.cass.core;

import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;

import cn.msec.ojpa.cass.dao.SimpleCassandraDAO;
import cn.msec.ojpa.cass.enums.Table;
import cn.msec.ojpa.cass.enums.TableType;
import cn.msec.ojpa.msc.cass.entity.TransBufferMsg;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Session;

public class KeyspaceManager {

	private @Setter HashMap<String, SimpleCassandraDAO> tableJPADao = new HashMap<>();
	private @Getter @Setter Session session;
	private @Getter @Setter String keyspace;
	private @Setter ConsistencyLevel consistency = ConsistencyLevel.QUORUM;// default QUORUM
	private @Setter String strategy = "SimpleStrategy";//NetworkTopologyStrategy
	private @Setter String replica = "1";//default
	private @Setter String basePackage = null;
	
	public KeyspaceManager(CassandraClusterFactory factory, String keyspace,
			String strategy,String replica,ConsistencyLevel consistency) {
		this.session = factory.openKeyspace(keyspace,strategy, replica);
		this.keyspace = keyspace;
		this.consistency = consistency;
	}

	public void warmup(Class<?> clazz) {
		try {
//			if(clazz.getSuperclass().equals(SimpleCassandraDAO.class)){
//				SimpleCassandraDAO dao = (SimpleCassandraDAO) clazz.getDeclaredConstructor().newInstance();
				SimpleCassandraDAO dao=new SimpleCassandraDAO(clazz,TableType.NORMAL);
				dao.initWithSession(session,consistency);
				tableJPADao.put(dao.getTablename(), dao);
//			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error in warming up table for clazz:"+ clazz);
		}
	}

	public void initTables() {
		if(StringUtils.isBlank(basePackage)){
			return ;
		}
		try {
			List<String> daoNames = ScanResolver.scanBasePackage(basePackage);
			for(String className : daoNames){
				Class<?> clazz = Class.forName(className, true, this.getClass().getClassLoader());
				warmup(clazz);
			}
			
			warmup(TransBufferMsg.class);
		} catch (Exception e) {
			throw new RuntimeException("init dao error..",e);
		}
	}
	public SimpleCassandraDAO getDaoByTableName(String table){
		return tableJPADao.get(table); 
	}

}
