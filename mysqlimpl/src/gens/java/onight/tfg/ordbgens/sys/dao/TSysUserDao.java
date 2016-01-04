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

import onight.tfg.ordbgens.sys.entity.TSysUser;
import onight.tfg.ordbgens.sys.entity.TSysUserExample;
import onight.tfg.ordbgens.sys.entity.TSysUserExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysUserKey;
import onight.tfg.ordbgens.sys.mapper.TSysUserMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_USER")
public class TSysUserDao extends ExtendDaoSupper<TSysUser, TSysUserExample, TSysUserKey>{

	private TSysUserMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysUserExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysUserExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysUserKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysUser record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysUser record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysUser> records)
			 {
		for(TSysUser record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysUser> records)
			 {
		for(TSysUser record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysUser> selectByExample(TSysUserExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysUser selectByPrimaryKey(TSysUserKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysUser> findAll(List<TSysUser> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysUserExample());
		}
		List<TSysUser> list = new ArrayList();
		for(TSysUser record : records){
			TSysUser result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysUser record, TSysUserExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysUser record, TSysUserExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysUser record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysUser record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysUserExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysUserExample());
	}

	@Override
	public TSysUserExample getExample(TSysUser record) {
		TSysUserExample example = new TSysUserExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getBranchId()!=null){
				criteria.andBranchIdEqualTo(record.getBranchId());
				}
				if(record.getLoginName()!=null){
				criteria.andLoginNameEqualTo(record.getLoginName());
				}
				if(record.getUserName()!=null){
				criteria.andUserNameEqualTo(record.getUserName());
				}
				if(record.getMobile()!=null){
				criteria.andMobileEqualTo(record.getMobile());
				}
				if(record.getUserWorkaddress()!=null){
				criteria.andUserWorkaddressEqualTo(record.getUserWorkaddress());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}
				if(record.getPassword()!=null){
				criteria.andPasswordEqualTo(record.getPassword());
				}
				if(record.getUpdateTime()!=null){
				criteria.andUpdateTimeEqualTo(record.getUpdateTime());
				}
				if(record.getCreateTime()!=null){
				criteria.andCreateTimeEqualTo(record.getCreateTime());
				}
				if(record.getCreatedBy()!=null){
				criteria.andCreatedByEqualTo(record.getCreatedBy());
				}
				if(record.getModifiedBy()!=null){
				criteria.andModifiedByEqualTo(record.getModifiedBy());
				}
				if(record.getEmail()!=null){
				criteria.andEmailEqualTo(record.getEmail());
				}
				if(record.getDataEnviron()!=null){
				criteria.andDataEnvironEqualTo(record.getDataEnviron());
				}
				if(record.getIcon()!=null){
				criteria.andIconEqualTo(record.getIcon());
				}

		}
		return example;
	}
	
	public TSysUser selectOneByExample(TSysUserExample example)
			 {
		example.setLimit(1);
		List<TSysUser> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysUser> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_USER() values");
			int i=0;
			for (TSysUser record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getBranchId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBranchId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLoginName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLoginName()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserName()+"'");
				}
			
				sb.append(",");
			
				if(record.getMobile()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMobile()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserWorkaddress()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserWorkaddress()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getPassword()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getPassword()+"'");
				}
			
				sb.append(",");
			
				if(record.getUpdateTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUpdateTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getCreateTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCreateTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getCreatedBy()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCreatedBy()+"'");
				}
			
				sb.append(",");
			
				if(record.getModifiedBy()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getModifiedBy()+"'");
				}
			
				sb.append(",");
			
				if(record.getEmail()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getEmail()+"'");
				}
			
				sb.append(",");
			
				if(record.getDataEnviron()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getDataEnviron()+"'");
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
