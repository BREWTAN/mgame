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

import onight.tfg.ordbgens.sys.entity.TSysBranch;
import onight.tfg.ordbgens.sys.entity.TSysBranchExample;
import onight.tfg.ordbgens.sys.entity.TSysBranchExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysBranchKey;
import onight.tfg.ordbgens.sys.mapper.TSysBranchMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_BRANCH")
public class TSysBranchDao extends ExtendDaoSupper<TSysBranch, TSysBranchExample, TSysBranchKey>{

	private TSysBranchMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysBranchExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysBranchExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysBranchKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysBranch record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysBranch record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysBranch> records)
			 {
		for(TSysBranch record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysBranch> records)
			 {
		for(TSysBranch record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysBranch> selectByExample(TSysBranchExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysBranch selectByPrimaryKey(TSysBranchKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysBranch> findAll(List<TSysBranch> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysBranchExample());
		}
		List<TSysBranch> list = new ArrayList();
		for(TSysBranch record : records){
			TSysBranch result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysBranch record, TSysBranchExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysBranch record, TSysBranchExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysBranch record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysBranch record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysBranchExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysBranchExample());
	}

	@Override
	public TSysBranchExample getExample(TSysBranch record) {
		TSysBranchExample example = new TSysBranchExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getBranchId()!=null){
				criteria.andBranchIdEqualTo(record.getBranchId());
				}
				if(record.getBranchDesc()!=null){
				criteria.andBranchDescEqualTo(record.getBranchDesc());
				}
				if(record.getBranchName()!=null){
				criteria.andBranchNameEqualTo(record.getBranchName());
				}
				if(record.getBranchManager()!=null){
				criteria.andBranchManagerEqualTo(record.getBranchManager());
				}
				if(record.getMobile()!=null){
				criteria.andMobileEqualTo(record.getMobile());
				}
				if(record.getBeginTime()!=null){
				criteria.andBeginTimeEqualTo(record.getBeginTime());
				}
				if(record.getEndTime()!=null){
				criteria.andEndTimeEqualTo(record.getEndTime());
				}
				if(record.getParentId()!=null){
				criteria.andParentIdEqualTo(record.getParentId());
				}
				if(record.getLeafFlag()!=null){
				criteria.andLeafFlagEqualTo(record.getLeafFlag());
				}
				if(record.getBranchSeq()!=null){
				criteria.andBranchSeqEqualTo(record.getBranchSeq());
				}
				if(record.getLevel()!=null){
				criteria.andLevelEqualTo(record.getLevel());
				}

		}
		return example;
	}
	
	public TSysBranch selectOneByExample(TSysBranchExample example)
			 {
		example.setLimit(1);
		List<TSysBranch> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysBranch> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_BRANCH() values");
			int i=0;
			for (TSysBranch record : records) {
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
			
				if(record.getBranchId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBranchId()+"'");
				}
			
				sb.append(",");
			
				if(record.getBranchDesc()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBranchDesc()+"'");
				}
			
				sb.append(",");
			
				if(record.getBranchName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBranchName()+"'");
				}
			
				sb.append(",");
			
				if(record.getBranchManager()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBranchManager()+"'");
				}
			
				sb.append(",");
			
				if(record.getMobile()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMobile()+"'");
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
			
				if(record.getBranchSeq()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBranchSeq()+"'");
				}
			
				sb.append(",");
			
				if(record.getLevel()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLevel()+"'");
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
