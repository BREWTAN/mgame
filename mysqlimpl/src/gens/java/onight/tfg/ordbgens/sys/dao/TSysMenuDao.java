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

import onight.tfg.ordbgens.sys.entity.TSysMenu;
import onight.tfg.ordbgens.sys.entity.TSysMenuExample;
import onight.tfg.ordbgens.sys.entity.TSysMenuExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysMenuKey;
import onight.tfg.ordbgens.sys.mapper.TSysMenuMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_MENU")
public class TSysMenuDao extends ExtendDaoSupper<TSysMenu, TSysMenuExample, TSysMenuKey>{

	private TSysMenuMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysMenuExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysMenuExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysMenuKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysMenu record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysMenu record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysMenu> records)
			 {
		for(TSysMenu record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysMenu> records)
			 {
		for(TSysMenu record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysMenu> selectByExample(TSysMenuExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysMenu selectByPrimaryKey(TSysMenuKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysMenu> findAll(List<TSysMenu> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysMenuExample());
		}
		List<TSysMenu> list = new ArrayList();
		for(TSysMenu record : records){
			TSysMenu result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysMenu record, TSysMenuExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysMenu record, TSysMenuExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysMenu record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysMenu record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysMenuExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysMenuExample());
	}

	@Override
	public TSysMenuExample getExample(TSysMenu record) {
		TSysMenuExample example = new TSysMenuExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getMenuId()!=null){
				criteria.andMenuIdEqualTo(record.getMenuId());
				}
				if(record.getMenuName()!=null){
				criteria.andMenuNameEqualTo(record.getMenuName());
				}
				if(record.getMenuDesc()!=null){
				criteria.andMenuDescEqualTo(record.getMenuDesc());
				}
				if(record.getMenuSeq()!=null){
				criteria.andMenuSeqEqualTo(record.getMenuSeq());
				}
				if(record.getMenuUrl()!=null){
				criteria.andMenuUrlEqualTo(record.getMenuUrl());
				}
				if(record.getParentId()!=null){
				criteria.andParentIdEqualTo(record.getParentId());
				}
				if(record.getLeafFlag()!=null){
				criteria.andLeafFlagEqualTo(record.getLeafFlag());
				}
				if(record.getLevel()!=null){
				criteria.andLevelEqualTo(record.getLevel());
				}
				if(record.getIcon()!=null){
				criteria.andIconEqualTo(record.getIcon());
				}

		}
		return example;
	}
	
	public TSysMenu selectOneByExample(TSysMenuExample example)
			 {
		example.setLimit(1);
		List<TSysMenu> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysMenu> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_MENU() values");
			int i=0;
			for (TSysMenu record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getMenuId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMenuId()+"'");
				}
			
				sb.append(",");
			
				if(record.getMenuName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMenuName()+"'");
				}
			
				sb.append(",");
			
				if(record.getMenuDesc()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMenuDesc()+"'");
				}
			
				sb.append(",");
			
				if(record.getMenuSeq()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMenuSeq()+"'");
				}
			
				sb.append(",");
			
				if(record.getMenuUrl()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMenuUrl()+"'");
				}
			
				sb.append(",");
			
				if(record.getParentId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getParentId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLeafFlag()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLeafFlag()+"'");
				}
			
				sb.append(",");
			
				if(record.getLevel()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLevel()+"'");
				}
			
				sb.append(",");
			
				if(record.getIcon()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getIcon()+"'");
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
