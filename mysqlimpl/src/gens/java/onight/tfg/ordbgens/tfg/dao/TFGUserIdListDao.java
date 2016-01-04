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

import onight.tfg.ordbgens.tfg.entity.TFGUserIdList;
import onight.tfg.ordbgens.tfg.entity.TFGUserIdListExample;
import onight.tfg.ordbgens.tfg.entity.TFGUserIdListExample.Criteria;
import onight.tfg.ordbgens.tfg.entity.TFGUserIdListKey;
import onight.tfg.ordbgens.tfg.mapper.TFGUserIdListMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFG_USER_ID_LIST")
public class TFGUserIdListDao extends ExtendDaoSupper<TFGUserIdList, TFGUserIdListExample, TFGUserIdListKey>{

	private TFGUserIdListMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFGUserIdListExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFGUserIdListExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFGUserIdListKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFGUserIdList record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFGUserIdList record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFGUserIdList> records)
			 {
		for(TFGUserIdList record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFGUserIdList> records)
			 {
		for(TFGUserIdList record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFGUserIdList> selectByExample(TFGUserIdListExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFGUserIdList selectByPrimaryKey(TFGUserIdListKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFGUserIdList> findAll(List<TFGUserIdList> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFGUserIdListExample());
		}
		List<TFGUserIdList> list = new ArrayList();
		for(TFGUserIdList record : records){
			TFGUserIdList result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFGUserIdList record, TFGUserIdListExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFGUserIdList record, TFGUserIdListExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFGUserIdList record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFGUserIdList record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFGUserIdListExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFGUserIdListExample());
	}

	@Override
	public TFGUserIdListExample getExample(TFGUserIdList record) {
		TFGUserIdListExample example = new TFGUserIdListExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}

		}
		return example;
	}
	
	public TFGUserIdList selectOneByExample(TFGUserIdListExample example)
			 {
		example.setLimit(1);
		List<TFGUserIdList> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFGUserIdList> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFG_USER_ID_LIST() values");
			int i=0;
			for (TFGUserIdList record : records) {
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
