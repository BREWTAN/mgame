package onight.tfw.cass.core;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Session;

import lombok.Getter;
import lombok.Setter;
import onight.mgame.chats.cass.counter.RoomCounters;
import onight.mgame.chats.cass.entity.RoomBlocks;
import onight.mgame.chats.cass.entity.RoomInfo;
import onight.mgame.chats.cass.entity.RoomMessage;
import onight.mgame.chats.cass.entity.RoomUsers;
import onight.tfw.cass.dao.SimpleCassandraDAO;
import onight.tfw.cass.enums.TableType;

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

	public void warmup(Class<?> clazz,TableType type) {
		try {
//			if(clazz.getSuperclass().equals(SimpleCassandraDAO.class)){
//				SimpleCassandraDAO dao = (SimpleCassandraDAO) clazz.getDeclaredConstructor().newInstance();
				SimpleCassandraDAO dao=new SimpleCassandraDAO(clazz,type);
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
//			List<String> daoNames = ScanResolver.scanBasePackage(basePackage);
//			for(String className : daoNames){
//				Class<?> clazz = Class.forName(className, true, this.getClass().getClassLoader());
//				warmup(clazz);
//			}
			warmup(RoomInfo.class,TableType.UNIQUE);
			warmup(RoomUsers.class,TableType.UNIQUE);
			warmup(RoomBlocks.class,TableType.UNIQUE);
			warmup(RoomMessage.class,TableType.UNIQUE);
			warmup(RoomCounters.class,TableType.COUNTER);
		} catch (Exception e) {
			throw new RuntimeException("init dao error..",e);
		}
	}
	public SimpleCassandraDAO getDaoByTableName(String table){
		return tableJPADao.get(table); 
	}

}
