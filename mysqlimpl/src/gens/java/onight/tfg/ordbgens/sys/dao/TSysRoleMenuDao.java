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

import onight.tfg.ordbgens.sys.entity.TSysRoleMenu;
import onight.tfg.ordbgens.sys.entity.TSysRoleMenuExample;
import onight.tfg.ordbgens.sys.entity.TSysRoleMenuExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysRoleMenuKey;
import onight.tfg.ordbgens.sys.mapper.TSysRoleMenuMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_ROLE_MENU")
public class TSysRoleMenuDao extends ExtendDaoSupper<TSysRoleMenu, TSysRoleMenuExample, TSysRoleMenuKey>{

	private TSysRoleMenuMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysRoleMenuExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysRoleMenuExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysRoleMenuKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysRoleMenu record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysRoleMenu record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysRoleMenu> records)
			 {
		for(TSysRoleMenu record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysRoleMenu> records)
			 {
		for(TSysRoleMenu record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysRoleMenu> selectByExample(TSysRoleMenuExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysRoleMenu selectByPrimaryKey(TSysRoleMenuKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysRoleMenu> findAll(List<TSysRoleMenu> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysRoleMenuExample());
		}
		List<TSysRoleMenu> list = new ArrayList();
		for(TSysRoleMenu record : records){
			TSysRoleMenu result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysRoleMenu record, TSysRoleMenuExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysRoleMenu record, TSysRoleMenuExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysRoleMenu record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysRoleMenu record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysRoleMenuExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysRoleMenuExample());
	}

	@Override
	public TSysRoleMenuExample getExample(TSysRoleMenu record) {
		TSysRoleMenuExample example = new TSysRoleMenuExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getMenuId()!=null){
				criteria.andMenuIdEqualTo(record.getMenuId());
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
	
	public TSysRoleMenu selectOneByExample(TSysRoleMenuExample example)
			 {
		example.setLimit(1);
		List<TSysRoleMenu> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysRoleMenu> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_ROLE_MENU() values");
			int i=0;
			for (TSysRoleMenu record : records) {
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
			
				if(record.getMenuId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMenuId()+"'");
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
