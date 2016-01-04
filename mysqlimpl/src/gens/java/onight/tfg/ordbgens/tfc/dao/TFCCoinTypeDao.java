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

import onight.tfg.ordbgens.tfc.entity.TFCCoinType;
import onight.tfg.ordbgens.tfc.entity.TFCCoinTypeExample;
import onight.tfg.ordbgens.tfc.entity.TFCCoinTypeExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCCoinTypeKey;
import onight.tfg.ordbgens.tfc.mapper.TFCCoinTypeMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_COIN_TYPE")
public class TFCCoinTypeDao extends ExtendDaoSupper<TFCCoinType, TFCCoinTypeExample, TFCCoinTypeKey>{

	private TFCCoinTypeMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCCoinTypeExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCCoinTypeExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCCoinTypeKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCCoinType record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCCoinType record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCCoinType> records)
			 {
		for(TFCCoinType record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCCoinType> records)
			 {
		for(TFCCoinType record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCCoinType> selectByExample(TFCCoinTypeExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCCoinType selectByPrimaryKey(TFCCoinTypeKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCCoinType> findAll(List<TFCCoinType> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCCoinTypeExample());
		}
		List<TFCCoinType> list = new ArrayList();
		for(TFCCoinType record : records){
			TFCCoinType result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCCoinType record, TFCCoinTypeExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCCoinType record, TFCCoinTypeExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCCoinType record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCCoinType record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCCoinTypeExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCCoinTypeExample());
	}

	@Override
	public TFCCoinTypeExample getExample(TFCCoinType record) {
		TFCCoinTypeExample example = new TFCCoinTypeExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getCoinTypeId()!=null){
				criteria.andCoinTypeIdEqualTo(record.getCoinTypeId());
				}
				if(record.getCoinName()!=null){
				criteria.andCoinNameEqualTo(record.getCoinName());
				}
				if(record.getCoinScript()!=null){
				criteria.andCoinScriptEqualTo(record.getCoinScript());
				}
				if(record.getHaveChild()!=null){
				criteria.andHaveChildEqualTo(record.getHaveChild());
				}
				if(record.getCanSplit()!=null){
				criteria.andCanSplitEqualTo(record.getCanSplit());
				}
				if(record.getUseLevel()!=null){
				criteria.andUseLevelEqualTo(record.getUseLevel());
				}

		}
		return example;
	}
	
	public TFCCoinType selectOneByExample(TFCCoinTypeExample example)
			 {
		example.setLimit(1);
		List<TFCCoinType> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCCoinType> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_COIN_TYPE() values");
			int i=0;
			for (TFCCoinType record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getCoinTypeId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinTypeId()+"'");
				}
			
				sb.append(",");
			
				if(record.getCoinName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinName()+"'");
				}
			
				sb.append(",");
			
				if(record.getCoinScript()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinScript()+"'");
				}
			
				sb.append(",");
			
				if(record.getHaveChild()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getHaveChild()+"'");
				}
			
				sb.append(",");
			
				if(record.getCanSplit()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCanSplit()+"'");
				}
			
				sb.append(",");
			
				if(record.getUseLevel()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUseLevel()+"'");
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
