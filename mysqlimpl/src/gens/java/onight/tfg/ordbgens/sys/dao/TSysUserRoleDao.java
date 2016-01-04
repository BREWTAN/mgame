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

import onight.tfg.ordbgens.sys.entity.TSysUserRole;
import onight.tfg.ordbgens.sys.entity.TSysUserRoleExample;
import onight.tfg.ordbgens.sys.entity.TSysUserRoleExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysUserRoleKey;
import onight.tfg.ordbgens.sys.mapper.TSysUserRoleMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_USER_ROLE")
public class TSysUserRoleDao extends ExtendDaoSupper<TSysUserRole, TSysUserRoleExample, TSysUserRoleKey>{

	private TSysUserRoleMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysUserRoleExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysUserRoleExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysUserRoleKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysUserRole record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysUserRole record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysUserRole> records)
			 {
		for(TSysUserRole record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysUserRole> records)
			 {
		for(TSysUserRole record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysUserRole> selectByExample(TSysUserRoleExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysUserRole selectByPrimaryKey(TSysUserRoleKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysUserRole> findAll(List<TSysUserRole> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysUserRoleExample());
		}
		List<TSysUserRole> list = new ArrayList();
		for(TSysUserRole record : records){
			TSysUserRole result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysUserRole record, TSysUserRoleExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysUserRole record, TSysUserRoleExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysUserRole record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysUserRole record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysUserRoleExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysUserRoleExample());
	}

	@Override
	public TSysUserRoleExample getExample(TSysUserRole record) {
		TSysUserRoleExample example = new TSysUserRoleExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUserRoleId()!=null){
				criteria.andUserRoleIdEqualTo(record.getUserRoleId());
				}
				if(record.getRoleId()!=null){
				criteria.andRoleIdEqualTo(record.getRoleId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}

		}
		return example;
	}
	
	public TSysUserRole selectOneByExample(TSysUserRoleExample example)
			 {
		example.setLimit(1);
		List<TSysUserRole> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysUserRole> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_USER_ROLE() values");
			int i=0;
			for (TSysUserRole record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getUserRoleId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserRoleId()+"'");
				}
			
				sb.append(",");
			
				if(record.getRoleId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRoleId()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserId()+"'");
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
