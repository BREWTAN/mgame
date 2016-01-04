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

import onight.tfg.ordbgens.sys.entity.TSysBusiness;
import onight.tfg.ordbgens.sys.entity.TSysBusinessExample;
import onight.tfg.ordbgens.sys.entity.TSysBusinessExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysBusinessKey;
import onight.tfg.ordbgens.sys.mapper.TSysBusinessMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_BUSINESS")
public class TSysBusinessDao extends ExtendDaoSupper<TSysBusiness, TSysBusinessExample, TSysBusinessKey>{

	private TSysBusinessMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysBusinessExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysBusinessExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysBusinessKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysBusiness record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysBusiness record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysBusiness> records)
			 {
		for(TSysBusiness record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysBusiness> records)
			 {
		for(TSysBusiness record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysBusiness> selectByExample(TSysBusinessExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysBusiness selectByPrimaryKey(TSysBusinessKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysBusiness> findAll(List<TSysBusiness> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysBusinessExample());
		}
		List<TSysBusiness> list = new ArrayList();
		for(TSysBusiness record : records){
			TSysBusiness result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysBusiness record, TSysBusinessExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysBusiness record, TSysBusinessExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysBusiness record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysBusiness record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysBusinessExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysBusinessExample());
	}

	@Override
	public TSysBusinessExample getExample(TSysBusiness record) {
		TSysBusinessExample example = new TSysBusinessExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getBusinessId()!=null){
				criteria.andBusinessIdEqualTo(record.getBusinessId());
				}
				if(record.getBusinessName()!=null){
				criteria.andBusinessNameEqualTo(record.getBusinessName());
				}
				if(record.getBusinessDesc()!=null){
				criteria.andBusinessDescEqualTo(record.getBusinessDesc());
				}
				if(record.getBusinessManager()!=null){
				criteria.andBusinessManagerEqualTo(record.getBusinessManager());
				}
				if(record.getBusinessMobile()!=null){
				criteria.andBusinessMobileEqualTo(record.getBusinessMobile());
				}
				if(record.getBusinessSeq()!=null){
				criteria.andBusinessSeqEqualTo(record.getBusinessSeq());
				}
				if(record.getBeginTime()!=null){
				criteria.andBeginTimeEqualTo(record.getBeginTime());
				}
				if(record.getEndTime()!=null){
				criteria.andEndTimeEqualTo(record.getEndTime());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}
				if(record.getBusinessDataPermission()!=null){
				criteria.andBusinessDataPermissionEqualTo(record.getBusinessDataPermission());
				}

		}
		return example;
	}
	
	public TSysBusiness selectOneByExample(TSysBusinessExample example)
			 {
		example.setLimit(1);
		List<TSysBusiness> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysBusiness> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_BUSINESS() values");
			int i=0;
			for (TSysBusiness record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getBusinessId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBusinessId()+"'");
				}
			
				sb.append(",");
			
				if(record.getBusinessName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBusinessName()+"'");
				}
			
				sb.append(",");
			
				if(record.getBusinessDesc()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBusinessDesc()+"'");
				}
			
				sb.append(",");
			
				if(record.getBusinessManager()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBusinessManager()+"'");
				}
			
				sb.append(",");
			
				if(record.getBusinessMobile()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBusinessMobile()+"'");
				}
			
				sb.append(",");
			
				if(record.getBusinessSeq()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBusinessSeq()+"'");
				}
			
				sb.append(",");
			
				if(record.getBeginTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBeginTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getEndTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getEndTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getBusinessDataPermission()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBusinessDataPermission()+"'");
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
