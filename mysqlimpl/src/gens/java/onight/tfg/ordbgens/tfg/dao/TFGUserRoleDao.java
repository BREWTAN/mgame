package onight.tfg.ordbgens.tfg.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.tfg.ordbgens.tfg.entity.TFGUserRole;
import onight.tfg.ordbgens.tfg.entity.TFGUserRoleExample;
import onight.tfg.ordbgens.tfg.entity.TFGUserRoleExample.Criteria;
import onight.tfg.ordbgens.tfg.entity.TFGUserRoleKey;
import onight.tfg.ordbgens.tfg.mapper.TFGUserRoleMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFG_USER_ROLE")
public class TFGUserRoleDao extends ExtendDaoSupper<TFGUserRole, TFGUserRoleExample, TFGUserRoleKey>{

	private TFGUserRoleMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFGUserRoleExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFGUserRoleExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFGUserRoleKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFGUserRole record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFGUserRole record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFGUserRole> records)
			 {
		for(TFGUserRole record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFGUserRole> records)
			 {
		for(TFGUserRole record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFGUserRole> selectByExample(TFGUserRoleExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFGUserRole selectByPrimaryKey(TFGUserRoleKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFGUserRole> findAll(List<TFGUserRole> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFGUserRoleExample());
		}
		List<TFGUserRole> list = new ArrayList();
		for(TFGUserRole record : records){
			TFGUserRole result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFGUserRole record, TFGUserRoleExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFGUserRole record, TFGUserRoleExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFGUserRole record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFGUserRole record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFGUserRoleExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFGUserRoleExample());
	}

	@Override
	public TFGUserRoleExample getExample(TFGUserRole record) {
		TFGUserRoleExample example = new TFGUserRoleExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUserRoleId()!=null){
				criteria.andUserRoleIdEqualTo(record.getUserRoleId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
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
	
	public TFGUserRole selectOneByExample(TFGUserRoleExample example)
			 {
		example.setLimit(1);
		List<TFGUserRole> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFGUserRole> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFG_USER_ROLE() values");
			int i=0;
			for (TFGUserRole record : records) {
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
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserId()+"'");
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
