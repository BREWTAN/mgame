package onight.tfw.cass.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;

import onight.tfw.cass.enums.TableType;
import onight.tfw.cass.exception.CQLGenException;
import onight.tfw.cass.mapping.CQLStatement;
import onight.tfw.cass.mapping.CounterStatement;
import onight.tfw.cass.mapping.DeleteStatement;
import onight.tfw.cass.mapping.IndexStatement;
import onight.tfw.cass.mapping.InsertStatement;
import onight.tfw.cass.mapping.SelectStatement;
import onight.tfw.cass.mapping.TableStatement;
import onight.tfw.cass.mapping.UpdateStatement;
import onight.tfw.cass.util.CQLStatementUtil;

public class StatementSet {

	Statement createTable;
	Statement truncateTable;

	List<Statement> indexeds;

	CQLStatement insert;
	CQLStatement insertIfNoExist;

	CQLStatement findOne;
	CQLStatement findAll;

	CQLStatement count;
	CQLStatement countAll;

	CQLStatement deleteByKey;
	CQLStatement deleteIfExist;

//	CQLStatement update;
	// CQLStatement updateIfValid;
	
	Class<?> clazz;

	ArrayList<CQLStatement> cstmts = new ArrayList<>();
	
	Map<String,CQLStatement> findByExamples = new HashMap<>();
	Map<String,CQLStatement> updates = new HashMap<>();
	Map<String,CQLStatement> inserts = new HashMap<>();
	
	ConsistencyLevel consistency = null;

	public StatementSet(Class<?> clazz, Session session,TableType tableType,ConsistencyLevel consistency) throws CQLGenException {
		this.consistency = consistency;
		this.clazz = clazz;
		indexeds = IndexStatement.createIndex(clazz);
		createTable = TableStatement.create(clazz);
		truncateTable = TableStatement.truncate(clazz);
		if(TableType.COUNTER.equals(tableType)){
			addCounterStaement(clazz);
		} else if(TableType.UNIQUE.equals(tableType)){
			addUniqueStatement(clazz);
		}else {
			addNormalStatement(clazz);
		}
		addCommonStatement(clazz);
		// cstmts.add(updateIfValid = new
		// UpdateStatement().updateIfValid(clazz));
	}
	
	private void addCounterStaement(Class<?> clazz) throws CQLGenException{
		cstmts.add(insert = new CounterStatement().increment(clazz));
		cstmts.add(deleteByKey = new CounterStatement().decrement(clazz));
	}
	
	private void  addUniqueStatement(Class<?> clazz) throws CQLGenException{
		cstmts.add(insert = new InsertStatement().insert(clazz));
		cstmts.add(insertIfNoExist = new InsertStatement().insertIfNotExist(clazz, true));
		cstmts.add(deleteIfExist = new DeleteStatement().deleteIfExist(clazz));
		cstmts.add(deleteByKey = new DeleteStatement().deleteByKey(clazz));
	}
	
	private void addNormalStatement(Class<?> clazz) throws CQLGenException{
		cstmts.add(insert = new InsertStatement().insert(clazz));
		cstmts.add(insertIfNoExist = new InsertStatement().insertIfNotExist(clazz, true));
		cstmts.add(deleteIfExist = new DeleteStatement().deleteIfExist(clazz));
		cstmts.add(deleteByKey = new DeleteStatement().deleteByKey(clazz));
	}
	
	private void addCommonStatement(Class<?> clazz) throws CQLGenException{
		cstmts.add(findOne = new SelectStatement().findOne(clazz));
		cstmts.add(findAll = new SelectStatement().findAll(clazz));
		cstmts.add(count = new SelectStatement().count(clazz));
		cstmts.add(countAll = new SelectStatement().countAll(clazz));
	}
	

	public void prepare(Session session) throws CQLGenException {
		for (CQLStatement cst : cstmts) {
			cst.prepare(session,consistency);
		}
	}

	public void createTable(Session session) throws CQLGenException {
		session.execute(createTable);
	}

	public void createIndex(Session session) throws CQLGenException {
		for (Statement index : indexeds) {
			session.execute(index);
		}
	}
	
	public CQLStatement getFindByExampleStatement(Session session,HashMap<String,Object> mb) {
		CQLStatement statement =  findByExamples.get(CQLStatementUtil.getFindKey(clazz, mb));
		if(statement==null){
			statement = new SelectStatement().findByExample(clazz, mb);
			statement.prepare(session,consistency);
			findByExamples.put(CQLStatementUtil.getFindKey(clazz, mb), statement);
		}
		return statement;
	}
	
	public CQLStatement getUpdateStatement(Session session,HashMap<String,Object> mb) {
		CQLStatement statement =  updates.get(CQLStatementUtil.getUpdateKey(clazz, mb));
		if(statement==null){
			statement = new UpdateStatement().update(clazz, mb);
			statement.prepare(session,consistency);
			updates.put(CQLStatementUtil.getUpdateKey(clazz, mb), statement);
		}
		return statement;
	}
	
}
