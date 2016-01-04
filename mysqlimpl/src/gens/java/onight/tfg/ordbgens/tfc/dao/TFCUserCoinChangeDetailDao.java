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

import onight.tfg.ordbgens.tfc.entity.TFCUserCoinChangeDetail;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinChangeDetailExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinChangeDetailExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinChangeDetailKey;
import onight.tfg.ordbgens.tfc.mapper.TFCUserCoinChangeDetailMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_USER_COIN_CHANGE_DETAIL")
public class TFCUserCoinChangeDetailDao extends ExtendDaoSupper<TFCUserCoinChangeDetail, TFCUserCoinChangeDetailExample, TFCUserCoinChangeDetailKey>{

	private TFCUserCoinChangeDetailMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCUserCoinChangeDetailExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCUserCoinChangeDetailExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCUserCoinChangeDetailKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCUserCoinChangeDetail record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCUserCoinChangeDetail record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCUserCoinChangeDetail> records)
			 {
		for(TFCUserCoinChangeDetail record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCUserCoinChangeDetail> records)
			 {
		for(TFCUserCoinChangeDetail record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCUserCoinChangeDetail> selectByExample(TFCUserCoinChangeDetailExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCUserCoinChangeDetail selectByPrimaryKey(TFCUserCoinChangeDetailKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCUserCoinChangeDetail> findAll(List<TFCUserCoinChangeDetail> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCUserCoinChangeDetailExample());
		}
		List<TFCUserCoinChangeDetail> list = new ArrayList();
		for(TFCUserCoinChangeDetail record : records){
			TFCUserCoinChangeDetail result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCUserCoinChangeDetail record, TFCUserCoinChangeDetailExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCUserCoinChangeDetail record, TFCUserCoinChangeDetailExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCUserCoinChangeDetail record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCUserCoinChangeDetail record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCUserCoinChangeDetailExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCUserCoinChangeDetailExample());
	}

	@Override
	public TFCUserCoinChangeDetailExample getExample(TFCUserCoinChangeDetail record) {
		TFCUserCoinChangeDetailExample example = new TFCUserCoinChangeDetailExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getCoinRowId()!=null){
				criteria.andCoinRowIdEqualTo(record.getCoinRowId());
				}
				if(record.getCoinTypeId()!=null){
				criteria.andCoinTypeIdEqualTo(record.getCoinTypeId());
				}
				if(record.getRecTime()!=null){
				criteria.andRecTimeEqualTo(record.getRecTime());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getChangeNum()!=null){
				criteria.andChangeNumEqualTo(record.getChangeNum());
				}
				if(record.getRemainNum()!=null){
				criteria.andRemainNumEqualTo(record.getRemainNum());
				}
				if(record.getLockId()!=null){
				criteria.andLockIdEqualTo(record.getLockId());
				}
				if(record.getChannelId()!=null){
				criteria.andChannelIdEqualTo(record.getChannelId());
				}
				if(record.getProductId()!=null){
				criteria.andProductIdEqualTo(record.getProductId());
				}
				if(record.getFlowNumber()!=null){
				criteria.andFlowNumberEqualTo(record.getFlowNumber());
				}
				if(record.getUserIp()!=null){
				criteria.andUserIpEqualTo(record.getUserIp());
				}
				if(record.getServerIp()!=null){
				criteria.andServerIpEqualTo(record.getServerIp());
				}
				if(record.getGameId()!=null){
				criteria.andGameIdEqualTo(record.getGameId());
				}

		}
		return example;
	}
	
	public TFCUserCoinChangeDetail selectOneByExample(TFCUserCoinChangeDetailExample example)
			 {
		example.setLimit(1);
		List<TFCUserCoinChangeDetail> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCUserCoinChangeDetail> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_USER_COIN_CHANGE_DETAIL() values");
			int i=0;
			for (TFCUserCoinChangeDetail record : records) {
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
			
				if(record.getCoinTypeId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinTypeId()+"'");
				}
			
				sb.append(",");
			
				if(record.getRecTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRecTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getChangeNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getChangeNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getRemainNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRemainNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getLockId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLockId()+"'");
				}
			
				sb.append(",");
			
				if(record.getChannelId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getChannelId()+"'");
				}
			
				sb.append(",");
			
				if(record.getProductId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getProductId()+"'");
				}
			
				sb.append(",");
			
				if(record.getFlowNumber()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getFlowNumber()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserIp()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserIp()+"'");
				}
			
				sb.append(",");
			
				if(record.getServerIp()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getServerIp()+"'");
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
