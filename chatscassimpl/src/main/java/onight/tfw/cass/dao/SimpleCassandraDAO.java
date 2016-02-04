package onight.tfw.cass.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.datastax.driver.core.BatchStatement;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

import lombok.NoArgsConstructor;
import onight.tfw.cass.enums.Table;
import onight.tfw.cass.enums.TableType;
import onight.tfw.cass.exception.CQLGenException;
import onight.tfw.cass.mapping.CQLStatement;
import onight.tfw.cass.util.RowMapper;
import onight.tfw.ojpa.api.CASCriteria;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.KVExample;
import onight.tfw.ojpa.api.TransactionExecutor;
import onight.tfw.ojpa.api.exception.JPAException;
import onight.tfw.ojpa.api.exception.NotSuportException;
import onight.tfw.outils.serialize.SerializerUtil;

@NoArgsConstructor
public class SimpleCassandraDAO<T> implements DomainDaoSupport<T> {

	private Session session;
	private Class<?> clazz;
	private StatementSet statements;
	private String tablename;
//	private OJpaDAO dao;
	private TableType tableType;
	
	

	public SimpleCassandraDAO(Class<?> clazz,TableType tableType) throws CQLGenException {
		this.clazz = clazz;
		this.tableType = tableType;
		Table tb = (Table) clazz.getAnnotation(Table.class);
		if (tb == null) {
			throw new CQLGenException("TableName not found");
		}
		tablename = tb.name();
//		this.dao=dao;
	}

	public void initWithSession(Session session, ConsistencyLevel consistency) throws CQLGenException {
		this.session = session;
		statements = new StatementSet(clazz, session, tableType, consistency);
		statements.createTable(session);
		statements.createIndex(session);
		statements.prepare(session);
	}

	protected KVExample ex(Object oe) {
		try {
			return SerializerUtil.deserialize(oe, KVExample.class);
		} catch (NullPointerException e) {
			throw new JPAException(String.format("domain names is error.. [%s]", KVExample.class), e);
		}
	}

	public ResultSet execute(Statement stmt) {
		return session.execute(stmt);
	}

	public boolean possible(ResultSet rs) {
		// TODO result is not null?
		if (rs == null)
			return false;
		Row one = rs.one();
		if (one != null)
			return one.getBool(0);
		return true;
	}

	public int executeTorF(Statement stmt) {
		return possible(session.execute(stmt)) ? 1 : 0;
	}

	public HashMap<String, Object> mb(Object o) {
		if (o instanceof HashMap) {
			return (HashMap<String, Object>) o;
		}
		throw new JPAException("unsupport type:" + o.getClass() + "@" + o);
	}

	public HashMap<String, Object> key(Object id) {
		if (id instanceof HashMap) {
			return (HashMap<String, Object>) id;
		}
		throw new JPAException("unsupport key type:" + id.getClass() + "@" + id);
	}

	@Override
	public int insert(Object o) {
		return executeTorF(statements.insert.bind(mb(o)));
	}

	@Override
	public Object insertIfNoExist(Object o) {
		return executeTorF(statements.insertIfNoExist.bind(mb(o)));
	}

	@Override
	public int batchInsert(List<Object> mbs) {
		BatchStatement batch = new BatchStatement();
		for (Object o : mbs) {
			batch.add(statements.insert.bind(mb(o)));
		}
		return executeTorF(batch);
	}

	public int batchInsertIfNotExist(List<Object> mbs) {
		BatchStatement batch = new BatchStatement();
		for (Object o : mbs) {
			batch.add(statements.insertIfNoExist.bind(mb(o)));
		}
		return executeTorF(batch);
	}

	public String getTablename() {
		return this.tablename;
	}

	public int CreateTable() {
		return executeTorF(statements.createTable);
	}

	public Object doBySQL(String cql) {
		Object ret= execute(new SimpleStatement(cql));
		if(ret instanceof ResultSet){
			return getAllList((ResultSet)ret);
		}
		else{
			return ret;
		}
	}

	@Override
	public int updateByPrimaryKey(Object o) {
		CQLStatement statement = statements.getUpdateStatement(session, mb(o));
		return executeTorF(statement.bind(mb(o)));
	}

	@Override
	public int batchUpdate(List<Object> mbs) {
		BatchStatement batch = new BatchStatement();
		for (Object o : mbs) {
			batch.add(statements.getUpdateStatement(session, mb(o)).bind(mb(o)));
		}
		return executeTorF(batch);
	}

	@Override
	public Object selectByPrimaryKey(Object id) {
		ResultSet set = (ResultSet) execute(statements.findOne.bind(mb(id)));
		Row row = set.one();
		if (row != null) {
			return RowMapper.parseFromRow(row);
		}
		return null;
	}

	public boolean exists(Object id) {
		ResultSet set = (ResultSet) execute(statements.findOne.bind(mb(id)));
		Row row = set.one();
		return row != null;
	}

	public List<Object> getAllList(ResultSet set) {
		ArrayList<Object> list = new ArrayList<>();
		for (Row row : set.all()) {
			list.add(RowMapper.parseFromRow(row));
		}
		return list;
	}

	public List<Object> findAll() {
		ResultSet set = (ResultSet) execute(statements.findAll.bind());
		return getAllList(set);
	}

	@Override
	public List<Object> findAll(List<Object> mbs) {
		List<Object> list = new ArrayList<>();
		for (Object o : mbs) {
			Object obj = this.selectByPrimaryKey(key(o));
			if (obj != null) {
				list.add(obj);
			}
		}
		return list;
	}

	public int countAll() {
		ResultSet set = (ResultSet) execute(statements.countAll.bind());
		return set.one().getInt(0);
	}

	@Override
	public int countByExample(Object id) {
		int size = 0;
		for(Object lo:ex(id).getCriterias()){
			ResultSet set = (ResultSet) execute(statements.countAll.bind(mb(lo)));
			size += set.one().getInt(0);
		}

		return size;
		
	}

	@Override
	public int deleteByPrimaryKey(Object o) {
		return executeTorF(statements.deleteByKey.bind(mb(o)));
	}

	public int deleteIfExist(Object o) {
		return executeTorF(statements.deleteIfExist.bind(mb(o)));
	}

	@Override
	public int deleteByExample(Object oe) {
		BatchStatement batch = new BatchStatement();

		for(Object lo:ex(oe).getCriterias()){
			batch.add(statements.deleteByKey.bind(mb(lo)));
		}
		return executeTorF(batch);
	}

	@Override
	public int batchDelete(List<Object> mbs) {
		BatchStatement batch = new BatchStatement();
		for (Object o : mbs) {
			batch.add(statements.deleteIfExist.bind(mb(o)));
		}
		return executeTorF(batch);
	}

	public void deleteAll() {
		 executeTorF(statements.truncateTable);
	}

	public int truncate() {
		return executeTorF(statements.truncateTable);
	}

	@Override
	public int insertSelective(Object record) {
		return insert(record);
	}

	@Override
	public List<Object> selectByExample(Object oe) {
		BatchStatement batch = new BatchStatement();

		for(Object lo:ex(oe).getCriterias()){
			batch.add(statements.findAll.bind(mb(lo)));
		}
		return getAllList(session.execute(batch));
		
	}

	@Override
	public int updateByExampleSelective(Object record, Object example) {
		throw new NotSuportException("getExample");
	}

	@Override
	public int updateByExample(Object record, Object example) {
		throw new NotSuportException("getExample");
	}

	@Override
	public int updateByPrimaryKeySelective(Object record) {
		return updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(Object example) {
		int size = 0;
		for(Object lo:ex(example).getCriterias()){
			ResultSet set = (ResultSet) execute(statements.countAll.bind(mb(lo)));
			size += set.one().getInt(0);
		}
		return size;
	}

	@Override
	public Object getExample(Object record) {
		throw new NotSuportException("getExample");
	}


	@Override
	public Object doInTransaction(TransactionExecutor exec) throws JPAException {
		throw new NotSuportException("doInTransaction");
	}

	@Override
	public Object checkAndIncr(CASCriteria<?> arg0) throws JPAException {
		throw new NotSuportException("doInTransaction");
	}

	@Override
	public Object checkAndSet(CASCriteria<?> arg0) throws JPAException {
		throw new NotSuportException("doInTransaction");
	}

	@Override
	public Object getAndSet(Object arg0) throws JPAException {
		throw new NotSuportException("doInTransaction");
	}

	@Override
	public Object increAnGetInt(CASCriteria<?> arg0) throws JPAException {
		throw new NotSuportException("doInTransaction");
	}

	@Override
	public Object selectOneByExample(Object arg0) {
		throw new NotSuportException("doInTransaction");
	}


}
