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

import onight.tfg.ordbgens.tfc.entity.TFCUserCoinChangeLimit;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinChangeLimitExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinChangeLimitExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinChangeLimitKey;
import onight.tfg.ordbgens.tfc.mapper.TFCUserCoinChangeLimitMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_USER_COIN_CHANGE_LIMIT")
public class TFCUserCoinChangeLimitDao extends ExtendDaoSupper<TFCUserCoinChangeLimit, TFCUserCoinChangeLimitExample, TFCUserCoinChangeLimitKey>{

	private TFCUserCoinChangeLimitMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCUserCoinChangeLimitExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCUserCoinChangeLimitExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCUserCoinChangeLimitKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCUserCoinChangeLimit record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCUserCoinChangeLimit record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCUserCoinChangeLimit> records)
			 {
		for(TFCUserCoinChangeLimit record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCUserCoinChangeLimit> records)
			 {
		for(TFCUserCoinChangeLimit record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCUserCoinChangeLimit> selectByExample(TFCUserCoinChangeLimitExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCUserCoinChangeLimit selectByPrimaryKey(TFCUserCoinChangeLimitKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCUserCoinChangeLimit> findAll(List<TFCUserCoinChangeLimit> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCUserCoinChangeLimitExample());
		}
		List<TFCUserCoinChangeLimit> list = new ArrayList();
		for(TFCUserCoinChangeLimit record : records){
			TFCUserCoinChangeLimit result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCUserCoinChangeLimit record, TFCUserCoinChangeLimitExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCUserCoinChangeLimit record, TFCUserCoinChangeLimitExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCUserCoinChangeLimit record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCUserCoinChangeLimit record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCUserCoinChangeLimitExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCUserCoinChangeLimitExample());
	}

	@Override
	public TFCUserCoinChangeLimitExample getExample(TFCUserCoinChangeLimit record) {
		TFCUserCoinChangeLimitExample example = new TFCUserCoinChangeLimitExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getCoinRowId()!=null){
				criteria.andCoinRowIdEqualTo(record.getCoinRowId());
				}
				if(record.getInNum()!=null){
				criteria.andInNumEqualTo(record.getInNum());
				}
				if(record.getOutNum()!=null){
				criteria.andOutNumEqualTo(record.getOutNum());
				}
				if(record.getChangeNum()!=null){
				criteria.andChangeNumEqualTo(record.getChangeNum());
				}
				if(record.getLastupdatetime()!=null){
				criteria.andLastupdatetimeEqualTo(record.getLastupdatetime());
				}
				if(record.getResettime()!=null){
				criteria.andResettimeEqualTo(record.getResettime());
				}

		}
		return example;
	}
	
	public TFCUserCoinChangeLimit selectOneByExample(TFCUserCoinChangeLimitExample example)
			 {
		example.setLimit(1);
		List<TFCUserCoinChangeLimit> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCUserCoinChangeLimit> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_USER_COIN_CHANGE_LIMIT() values");
			int i=0;
			for (TFCUserCoinChangeLimit record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getCoinRowId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinRowId()+"'");
				}
			
				sb.append(",");
			
				if(record.getInNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getInNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getOutNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getOutNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getChangeNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getChangeNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getLastupdatetime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLastupdatetime()+"'");
				}
			
				sb.append(",");
			
				if(record.getResettime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getResettime()+"'");
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
