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

import onight.tfg.ordbgens.sys.entity.TSysRoleMutex;
import onight.tfg.ordbgens.sys.entity.TSysRoleMutexExample;
import onight.tfg.ordbgens.sys.entity.TSysRoleMutexExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysRoleMutexKey;
import onight.tfg.ordbgens.sys.mapper.TSysRoleMutexMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_ROLE_MUTEX")
public class TSysRoleMutexDao extends ExtendDaoSupper<TSysRoleMutex, TSysRoleMutexExample, TSysRoleMutexKey>{

	private TSysRoleMutexMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysRoleMutexExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysRoleMutexExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysRoleMutexKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysRoleMutex record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysRoleMutex record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysRoleMutex> records)
			 {
		for(TSysRoleMutex record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysRoleMutex> records)
			 {
		for(TSysRoleMutex record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysRoleMutex> selectByExample(TSysRoleMutexExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysRoleMutex selectByPrimaryKey(TSysRoleMutexKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysRoleMutex> findAll(List<TSysRoleMutex> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysRoleMutexExample());
		}
		List<TSysRoleMutex> list = new ArrayList();
		for(TSysRoleMutex record : records){
			TSysRoleMutex result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysRoleMutex record, TSysRoleMutexExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysRoleMutex record, TSysRoleMutexExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysRoleMutex record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysRoleMutex record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysRoleMutexExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysRoleMutexExample());
	}

	@Override
	public TSysRoleMutexExample getExample(TSysRoleMutex record) {
		TSysRoleMutexExample example = new TSysRoleMutexExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getRoleMutexId()!=null){
				criteria.andRoleMutexIdEqualTo(record.getRoleMutexId());
				}
				if(record.getRoleIdA()!=null){
				criteria.andRoleIdAEqualTo(record.getRoleIdA());
				}
				if(record.getRoleIdB()!=null){
				criteria.andRoleIdBEqualTo(record.getRoleIdB());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}

		}
		return example;
	}
	
	public TSysRoleMutex selectOneByExample(TSysRoleMutexExample example)
			 {
		example.setLimit(1);
		List<TSysRoleMutex> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysRoleMutex> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_ROLE_MUTEX() values");
			int i=0;
			for (TSysRoleMutex record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getRoleMutexId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRoleMutexId()+"'");
				}
			
				sb.append(",");
			
				if(record.getRoleIdA()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRoleIdA()+"'");
				}
			
				sb.append(",");
			
				if(record.getRoleIdB()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRoleIdB()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getStatus()+"'");
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
