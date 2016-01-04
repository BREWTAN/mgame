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

import onight.tfg.ordbgens.sys.entity.TSysOpLogs;
import onight.tfg.ordbgens.sys.entity.TSysOpLogsExample;
import onight.tfg.ordbgens.sys.entity.TSysOpLogsExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysOpLogsKey;
import onight.tfg.ordbgens.sys.mapper.TSysOpLogsMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_OP_LOGS")
public class TSysOpLogsDao extends ExtendDaoSupper<TSysOpLogs, TSysOpLogsExample, TSysOpLogsKey>{

	private TSysOpLogsMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysOpLogsExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysOpLogsExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysOpLogsKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysOpLogs record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysOpLogs record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysOpLogs> records)
			 {
		for(TSysOpLogs record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysOpLogs> records)
			 {
		for(TSysOpLogs record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysOpLogs> selectByExample(TSysOpLogsExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysOpLogs selectByPrimaryKey(TSysOpLogsKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysOpLogs> findAll(List<TSysOpLogs> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysOpLogsExample());
		}
		List<TSysOpLogs> list = new ArrayList();
		for(TSysOpLogs record : records){
			TSysOpLogs result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysOpLogs record, TSysOpLogsExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysOpLogs record, TSysOpLogsExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysOpLogs record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysOpLogs record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysOpLogsExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysOpLogsExample());
	}

	@Override
	public TSysOpLogsExample getExample(TSysOpLogs record) {
		TSysOpLogsExample example = new TSysOpLogsExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getSkeys()!=null){
				criteria.andSkeysEqualTo(record.getSkeys());
				}
				if(record.getContents()!=null){
				criteria.andContentsEqualTo(record.getContents());
				}
				if(record.getLevel()!=null){
				criteria.andLevelEqualTo(record.getLevel());
				}
				if(record.getCrtTime()!=null){
				criteria.andCrtTimeEqualTo(record.getCrtTime());
				}

		}
		return example;
	}
	
	public TSysOpLogs selectOneByExample(TSysOpLogsExample example)
			 {
		example.setLimit(1);
		List<TSysOpLogs> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysOpLogs> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_OP_LOGS() values");
			int i=0;
			for (TSysOpLogs record : records) {
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
			
				if(record.getSkeys()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getSkeys()+"'");
				}
			
				sb.append(",");
			
				if(record.getContents()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getContents()+"'");
				}
			
				sb.append(",");
			
				if(record.getLevel()==null){
						sb.append("'"+"INFO"+"'");						
				}else{
					sb.append("'"+record.getLevel()+"'");
				}
			
				sb.append(",");
			
				if(record.getCrtTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCrtTime()+"'");
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
