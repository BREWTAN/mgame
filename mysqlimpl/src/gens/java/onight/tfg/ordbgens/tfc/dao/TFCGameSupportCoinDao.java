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

import onight.tfg.ordbgens.tfc.entity.TFCGameSupportCoin;
import onight.tfg.ordbgens.tfc.entity.TFCGameSupportCoinExample;
import onight.tfg.ordbgens.tfc.entity.TFCGameSupportCoinExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCGameSupportCoinKey;
import onight.tfg.ordbgens.tfc.mapper.TFCGameSupportCoinMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_GAME_SUPPORT_COIN")
public class TFCGameSupportCoinDao extends ExtendDaoSupper<TFCGameSupportCoin, TFCGameSupportCoinExample, TFCGameSupportCoinKey>{

	private TFCGameSupportCoinMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCGameSupportCoinExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCGameSupportCoinExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCGameSupportCoinKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCGameSupportCoin record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCGameSupportCoin record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCGameSupportCoin> records)
			 {
		for(TFCGameSupportCoin record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCGameSupportCoin> records)
			 {
		for(TFCGameSupportCoin record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCGameSupportCoin> selectByExample(TFCGameSupportCoinExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCGameSupportCoin selectByPrimaryKey(TFCGameSupportCoinKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCGameSupportCoin> findAll(List<TFCGameSupportCoin> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCGameSupportCoinExample());
		}
		List<TFCGameSupportCoin> list = new ArrayList();
		for(TFCGameSupportCoin record : records){
			TFCGameSupportCoin result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCGameSupportCoin record, TFCGameSupportCoinExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCGameSupportCoin record, TFCGameSupportCoinExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCGameSupportCoin record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCGameSupportCoin record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCGameSupportCoinExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCGameSupportCoinExample());
	}

	@Override
	public TFCGameSupportCoinExample getExample(TFCGameSupportCoin record) {
		TFCGameSupportCoinExample example = new TFCGameSupportCoinExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getRowId()!=null){
				criteria.andRowIdEqualTo(record.getRowId());
				}
				if(record.getCoinTypeId()!=null){
				criteria.andCoinTypeIdEqualTo(record.getCoinTypeId());
				}
				if(record.getGameId()!=null){
				criteria.andGameIdEqualTo(record.getGameId());
				}

		}
		return example;
	}
	
	public TFCGameSupportCoin selectOneByExample(TFCGameSupportCoinExample example)
			 {
		example.setLimit(1);
		List<TFCGameSupportCoin> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCGameSupportCoin> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_GAME_SUPPORT_COIN() values");
			int i=0;
			for (TFCGameSupportCoin record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getRowId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRowId()+"'");
				}
			
				sb.append(",");
			
				if(record.getCoinTypeId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinTypeId()+"'");
				}
			
				sb.append(",");
			
				if(record.getGameId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getGameId()+"'");
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
