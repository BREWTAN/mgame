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

import onight.tfg.ordbgens.sys.entity.TSysRoleAction;
import onight.tfg.ordbgens.sys.entity.TSysRoleActionExample;
import onight.tfg.ordbgens.sys.entity.TSysRoleActionExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysRoleActionKey;
import onight.tfg.ordbgens.sys.mapper.TSysRoleActionMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_ROLE_ACTION")
public class TSysRoleActionDao extends ExtendDaoSupper<TSysRoleAction, TSysRoleActionExample, TSysRoleActionKey>{

	private TSysRoleActionMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysRoleActionExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysRoleActionExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysRoleActionKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysRoleAction record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysRoleAction record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysRoleAction> records)
			 {
		for(TSysRoleAction record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysRoleAction> records)
			 {
		for(TSysRoleAction record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysRoleAction> selectByExample(TSysRoleActionExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysRoleAction selectByPrimaryKey(TSysRoleActionKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysRoleAction> findAll(List<TSysRoleAction> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysRoleActionExample());
		}
		List<TSysRoleAction> list = new ArrayList();
		for(TSysRoleAction record : records){
			TSysRoleAction result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysRoleAction record, TSysRoleActionExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysRoleAction record, TSysRoleActionExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysRoleAction record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysRoleAction record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysRoleActionExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysRoleActionExample());
	}

	@Override
	public TSysRoleActionExample getExample(TSysRoleAction record) {
		TSysRoleActionExample example = new TSysRoleActionExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getActionId()!=null){
				criteria.andActionIdEqualTo(record.getActionId());
				}
				if(record.getRoleId()!=null){
				criteria.andRoleIdEqualTo(record.getRoleId());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}

		}
		return example;
	}
	
	public TSysRoleAction selectOneByExample(TSysRoleActionExample example)
			 {
		example.setLimit(1);
		List<TSysRoleAction> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysRoleAction> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_ROLE_ACTION() values");
			int i=0;
			for (TSysRoleAction record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getId()+"'");
				}
			
				sb.append(",");
			
				if(record.getActionId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getActionId()+"'");
				}
			
				sb.append(",");
			
				if(record.getRoleId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRoleId()+"'");
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
