package onight.tfg.ordbgens.tfc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.tfg.ordbgens.tfc.entity.TFCConfigUpdateLog;
import onight.tfg.ordbgens.tfc.entity.TFCConfigUpdateLogExample;
import onight.tfg.ordbgens.tfc.entity.TFCConfigUpdateLogExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCConfigUpdateLogKey;
import onight.tfg.ordbgens.tfc.mapper.TFCConfigUpdateLogMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_CONFIG_UPDATE_LOG")
public class TFCConfigUpdateLogDao extends ExtendDaoSupper<TFCConfigUpdateLog, TFCConfigUpdateLogExample, TFCConfigUpdateLogKey>{

	private TFCConfigUpdateLogMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCConfigUpdateLogExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCConfigUpdateLogExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCConfigUpdateLogKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCConfigUpdateLog record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCConfigUpdateLog record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCConfigUpdateLog> records)
			 {
		for(TFCConfigUpdateLog record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCConfigUpdateLog> records)
			 {
		for(TFCConfigUpdateLog record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCConfigUpdateLog> selectByExample(TFCConfigUpdateLogExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCConfigUpdateLog selectByPrimaryKey(TFCConfigUpdateLogKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCConfigUpdateLog> findAll(List<TFCConfigUpdateLog> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCConfigUpdateLogExample());
		}
		List<TFCConfigUpdateLog> list = new ArrayList();
		for(TFCConfigUpdateLog record : records){
			TFCConfigUpdateLog result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCConfigUpdateLog record, TFCConfigUpdateLogExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCConfigUpdateLog record, TFCConfigUpdateLogExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCConfigUpdateLog record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCConfigUpdateLog record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCConfigUpdateLogExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCConfigUpdateLogExample());
	}

	@Override
	public TFCConfigUpdateLogExample getExample(TFCConfigUpdateLog record) {
		TFCConfigUpdateLogExample example = new TFCConfigUpdateLogExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getConfigType()!=null){
				criteria.andConfigTypeEqualTo(record.getConfigType());
				}
				if(record.getUpdateTime()!=null){
				criteria.andUpdateTimeEqualTo(record.getUpdateTime());
				}
				if(record.getNote()!=null){
				criteria.andNoteEqualTo(record.getNote());
				}

		}
		return example;
	}
	
	public TFCConfigUpdateLog selectOneByExample(TFCConfigUpdateLogExample example)
			 {
		example.setLimit(1);
		List<TFCConfigUpdateLog> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCConfigUpdateLog> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_CONFIG_UPDATE_LOG() values");
			int i=0;
			for (TFCConfigUpdateLog record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getConfigType()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getConfigType()+"'");
				}
			
				sb.append(",");
			
				if(record.getUpdateTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUpdateTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getNote()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getNote()+"'");
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
