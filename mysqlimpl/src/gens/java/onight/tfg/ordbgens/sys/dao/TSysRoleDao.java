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

import onight.tfg.ordbgens.sys.entity.TSysRole;
import onight.tfg.ordbgens.sys.entity.TSysRoleExample;
import onight.tfg.ordbgens.sys.entity.TSysRoleExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysRoleKey;
import onight.tfg.ordbgens.sys.mapper.TSysRoleMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_ROLE")
public class TSysRoleDao extends ExtendDaoSupper<TSysRole, TSysRoleExample, TSysRoleKey>{

	private TSysRoleMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysRoleExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysRoleExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysRoleKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysRole record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysRole record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysRole> records)
			 {
		for(TSysRole record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysRole> records)
			 {
		for(TSysRole record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysRole> selectByExample(TSysRoleExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysRole selectByPrimaryKey(TSysRoleKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysRole> findAll(List<TSysRole> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysRoleExample());
		}
		List<TSysRole> list = new ArrayList();
		for(TSysRole record : records){
			TSysRole result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysRole record, TSysRoleExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysRole record, TSysRoleExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysRole record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysRole record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysRoleExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysRoleExample());
	}

	@Override
	public TSysRoleExample getExample(TSysRole record) {
		TSysRoleExample example = new TSysRoleExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getRoleId()!=null){
				criteria.andRoleIdEqualTo(record.getRoleId());
				}
				if(record.getRoleName()!=null){
				criteria.andRoleNameEqualTo(record.getRoleName());
				}
				if(record.getRoleDesc()!=null){
				criteria.andRoleDescEqualTo(record.getRoleDesc());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}

		}
		return example;
	}
	
	public TSysRole selectOneByExample(TSysRoleExample example)
			 {
		example.setLimit(1);
		List<TSysRole> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysRole> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_ROLE() values");
			int i=0;
			for (TSysRole record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getRoleId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRoleId()+"'");
				}
			
				sb.append(",");
			
				if(record.getRoleName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRoleName()+"'");
				}
			
				sb.append(",");
			
				if(record.getRoleDesc()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRoleDesc()+"'");
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
