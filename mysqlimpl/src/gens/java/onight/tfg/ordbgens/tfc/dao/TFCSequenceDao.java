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

import onight.tfg.ordbgens.tfc.entity.TFCSequence;
import onight.tfg.ordbgens.tfc.entity.TFCSequenceExample;
import onight.tfg.ordbgens.tfc.entity.TFCSequenceExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCSequenceKey;
import onight.tfg.ordbgens.tfc.mapper.TFCSequenceMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_SEQUENCE")
public class TFCSequenceDao extends ExtendDaoSupper<TFCSequence, TFCSequenceExample, TFCSequenceKey>{

	private TFCSequenceMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCSequenceExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCSequenceExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCSequenceKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCSequence record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCSequence record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCSequence> records)
			 {
		for(TFCSequence record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCSequence> records)
			 {
		for(TFCSequence record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCSequence> selectByExample(TFCSequenceExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCSequence selectByPrimaryKey(TFCSequenceKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCSequence> findAll(List<TFCSequence> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCSequenceExample());
		}
		List<TFCSequence> list = new ArrayList();
		for(TFCSequence record : records){
			TFCSequence result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCSequence record, TFCSequenceExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCSequence record, TFCSequenceExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCSequence record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCSequence record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCSequenceExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCSequenceExample());
	}

	@Override
	public TFCSequenceExample getExample(TFCSequence record) {
		TFCSequenceExample example = new TFCSequenceExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getName()!=null){
				criteria.andNameEqualTo(record.getName());
				}
				if(record.getCurrentValue()!=null){
				criteria.andCurrentValueEqualTo(record.getCurrentValue());
				}
				if(record.getIncrement()!=null){
				criteria.andIncrementEqualTo(record.getIncrement());
				}

		}
		return example;
	}
	
	public TFCSequence selectOneByExample(TFCSequenceExample example)
			 {
		example.setLimit(1);
		List<TFCSequence> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCSequence> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_SEQUENCE() values");
			int i=0;
			for (TFCSequence record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getName()+"'");
				}
			
				sb.append(",");
			
				if(record.getCurrentValue()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCurrentValue()+"'");
				}
			
				sb.append(",");
			
				if(record.getIncrement()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getIncrement()+"'");
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
