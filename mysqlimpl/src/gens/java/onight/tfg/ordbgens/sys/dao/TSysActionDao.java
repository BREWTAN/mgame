package onight.tfg.ordbgens.sys.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.tfg.ordbgens.sys.entity.TSysAction;
import onight.tfg.ordbgens.sys.entity.TSysActionExample;
import onight.tfg.ordbgens.sys.entity.TSysActionExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysActionKey;
import onight.tfg.ordbgens.sys.mapper.TSysActionMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_ACTION")
public class TSysActionDao extends ExtendDaoSupper<TSysAction, TSysActionExample, TSysActionKey>{

	private TSysActionMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysActionExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysActionExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysActionKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysAction record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysAction record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysAction> records)
			 {
		for(TSysAction record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysAction> records)
			 {
		for(TSysAction record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysAction> selectByExample(TSysActionExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysAction selectByPrimaryKey(TSysActionKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysAction> findAll(List<TSysAction> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysActionExample());
		}
		List<TSysAction> list = new ArrayList();
		for(TSysAction record : records){
			TSysAction result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysAction record, TSysActionExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysAction record, TSysActionExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysAction record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysAction record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysActionExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysActionExample());
	}

	@Override
	public TSysActionExample getExample(TSysAction record) {
		TSysActionExample example = new TSysActionExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getActionId()!=null){
				criteria.andActionIdEqualTo(record.getActionId());
				}
				if(record.getActionFlag()!=null){
				criteria.andActionFlagEqualTo(record.getActionFlag());
				}
				if(record.getActionName()!=null){
				criteria.andActionNameEqualTo(record.getActionName());
				}
				if(record.getActionDesc()!=null){
				criteria.andActionDescEqualTo(record.getActionDesc());
				}
				if(record.getActionMenu()!=null){
				criteria.andActionMenuEqualTo(record.getActionMenu());
				}
				if(record.getField1()!=null){
				criteria.andField1EqualTo(record.getField1());
				}

		}
		return example;
	}
	
	public TSysAction selectOneByExample(TSysActionExample example)
			 {
		example.setLimit(1);
		List<TSysAction> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysAction> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_ACTION() values");
			int i=0;
			for (TSysAction record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getActionId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getActionId()+"'");
				}
			
				sb.append(",");
			
				if(record.getActionFlag()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getActionFlag()+"'");
				}
			
				sb.append(",");
			
				if(record.getActionName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getActionName()+"'");
				}
			
				sb.append(",");
			
				if(record.getActionDesc()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getActionDesc()+"'");
				}
			
				sb.append(",");
			
				if(record.getActionMenu()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getActionMenu()+"'");
				}
			
				sb.append(",");
			
				if(record.getField1()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getField1()+"'");
				}
							sb.append(")");
			
			}
			result=st.executeUpdate(sb.toString());
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			if(st!=null){
				try {
					st.close();
				} catch (Exception est) {
					est.printStackTrace();
				}
			}
			session.close();
		}
		return result;
	}
	
	
}
