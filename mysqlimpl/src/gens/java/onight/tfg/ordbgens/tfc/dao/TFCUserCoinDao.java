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

import onight.tfg.ordbgens.tfc.entity.TFCUserCoin;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinKey;
import onight.tfg.ordbgens.tfc.mapper.TFCUserCoinMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_USER_COIN")
public class TFCUserCoinDao extends ExtendDaoSupper<TFCUserCoin, TFCUserCoinExample, TFCUserCoinKey>{

	private TFCUserCoinMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCUserCoinExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCUserCoinExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCUserCoinKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCUserCoin record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCUserCoin record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCUserCoin> records)
			 {
		for(TFCUserCoin record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCUserCoin> records)
			 {
		for(TFCUserCoin record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCUserCoin> selectByExample(TFCUserCoinExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCUserCoin selectByPrimaryKey(TFCUserCoinKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCUserCoin> findAll(List<TFCUserCoin> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCUserCoinExample());
		}
		List<TFCUserCoin> list = new ArrayList();
		for(TFCUserCoin record : records){
			TFCUserCoin result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCUserCoin record, TFCUserCoinExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCUserCoin record, TFCUserCoinExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCUserCoin record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCUserCoin record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCUserCoinExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCUserCoinExample());
	}

	@Override
	public TFCUserCoinExample getExample(TFCUserCoin record) {
		TFCUserCoinExample example = new TFCUserCoinExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getCoinRowid()!=null){
				criteria.andCoinRowidEqualTo(record.getCoinRowid());
				}
				if(record.getCoinTypeId()!=null){
				criteria.andCoinTypeIdEqualTo(record.getCoinTypeId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getStartTime()!=null){
				criteria.andStartTimeEqualTo(record.getStartTime());
				}
				if(record.getExpireTime()!=null){
				criteria.andExpireTimeEqualTo(record.getExpireTime());
				}
				if(record.getCoinNum()!=null){
				criteria.andCoinNumEqualTo(record.getCoinNum());
				}
				if(record.getLockCount()!=null){
				criteria.andLockCountEqualTo(record.getLockCount());
				}
				if(record.getShowChild()!=null){
				criteria.andShowChildEqualTo(record.getShowChild());
				}

		}
		return example;
	}
	
	public TFCUserCoin selectOneByExample(TFCUserCoinExample example)
			 {
		example.setLimit(1);
		List<TFCUserCoin> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCUserCoin> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_USER_COIN() values");
			int i=0;
			for (TFCUserCoin record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getCoinRowid()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinRowid()+"'");
				}
			
				sb.append(",");
			
				if(record.getCoinTypeId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinTypeId()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getStartTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getStartTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getExpireTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getExpireTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getCoinNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getLockCount()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLockCount()+"'");
				}
			
				sb.append(",");
			
				if(record.getShowChild()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getShowChild()+"'");
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
