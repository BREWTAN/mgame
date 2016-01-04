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

import onight.tfg.ordbgens.tfc.entity.TFCUserCoinReclaimDetail;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinReclaimDetailExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinReclaimDetailExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinReclaimDetailKey;
import onight.tfg.ordbgens.tfc.mapper.TFCUserCoinReclaimDetailMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_USER_COIN_RECLAIM_DETAIL")
public class TFCUserCoinReclaimDetailDao extends ExtendDaoSupper<TFCUserCoinReclaimDetail, TFCUserCoinReclaimDetailExample, TFCUserCoinReclaimDetailKey>{

	private TFCUserCoinReclaimDetailMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCUserCoinReclaimDetailExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCUserCoinReclaimDetailExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCUserCoinReclaimDetailKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCUserCoinReclaimDetail record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCUserCoinReclaimDetail record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCUserCoinReclaimDetail> records)
			 {
		for(TFCUserCoinReclaimDetail record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCUserCoinReclaimDetail> records)
			 {
		for(TFCUserCoinReclaimDetail record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCUserCoinReclaimDetail> selectByExample(TFCUserCoinReclaimDetailExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCUserCoinReclaimDetail selectByPrimaryKey(TFCUserCoinReclaimDetailKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCUserCoinReclaimDetail> findAll(List<TFCUserCoinReclaimDetail> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCUserCoinReclaimDetailExample());
		}
		List<TFCUserCoinReclaimDetail> list = new ArrayList();
		for(TFCUserCoinReclaimDetail record : records){
			TFCUserCoinReclaimDetail result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCUserCoinReclaimDetail record, TFCUserCoinReclaimDetailExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCUserCoinReclaimDetail record, TFCUserCoinReclaimDetailExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCUserCoinReclaimDetail record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCUserCoinReclaimDetail record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCUserCoinReclaimDetailExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCUserCoinReclaimDetailExample());
	}

	@Override
	public TFCUserCoinReclaimDetailExample getExample(TFCUserCoinReclaimDetail record) {
		TFCUserCoinReclaimDetailExample example = new TFCUserCoinReclaimDetailExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getRowId()!=null){
				criteria.andRowIdEqualTo(record.getRowId());
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
				if(record.getReclaimNum()!=null){
				criteria.andReclaimNumEqualTo(record.getReclaimNum());
				}
				if(record.getReqNum()!=null){
				criteria.andReqNumEqualTo(record.getReqNum());
				}
				if(record.getChangedNum()!=null){
				criteria.andChangedNumEqualTo(record.getChangedNum());
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
	
	public TFCUserCoinReclaimDetail selectOneByExample(TFCUserCoinReclaimDetailExample example)
			 {
		example.setLimit(1);
		List<TFCUserCoinReclaimDetail> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCUserCoinReclaimDetail> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_USER_COIN_RECLAIM_DETAIL() values");
			int i=0;
			for (TFCUserCoinReclaimDetail record : records) {
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
			
				if(record.getReclaimNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getReclaimNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getReqNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getReqNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getChangedNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getChangedNum()+"'");
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
