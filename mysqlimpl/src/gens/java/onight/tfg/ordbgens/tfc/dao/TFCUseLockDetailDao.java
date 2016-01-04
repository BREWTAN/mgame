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

import onight.tfg.ordbgens.tfc.entity.TFCUseLockDetail;
import onight.tfg.ordbgens.tfc.entity.TFCUseLockDetailExample;
import onight.tfg.ordbgens.tfc.entity.TFCUseLockDetailExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCUseLockDetailKey;
import onight.tfg.ordbgens.tfc.mapper.TFCUseLockDetailMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_USE_LOCK_DETAIL")
public class TFCUseLockDetailDao extends ExtendDaoSupper<TFCUseLockDetail, TFCUseLockDetailExample, TFCUseLockDetailKey>{

	private TFCUseLockDetailMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCUseLockDetailExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCUseLockDetailExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCUseLockDetailKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCUseLockDetail record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCUseLockDetail record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCUseLockDetail> records)
			 {
		for(TFCUseLockDetail record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCUseLockDetail> records)
			 {
		for(TFCUseLockDetail record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCUseLockDetail> selectByExample(TFCUseLockDetailExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCUseLockDetail selectByPrimaryKey(TFCUseLockDetailKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCUseLockDetail> findAll(List<TFCUseLockDetail> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCUseLockDetailExample());
		}
		List<TFCUseLockDetail> list = new ArrayList();
		for(TFCUseLockDetail record : records){
			TFCUseLockDetail result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCUseLockDetail record, TFCUseLockDetailExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCUseLockDetail record, TFCUseLockDetailExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCUseLockDetail record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCUseLockDetail record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCUseLockDetailExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCUseLockDetailExample());
	}

	@Override
	public TFCUseLockDetailExample getExample(TFCUseLockDetail record) {
		TFCUseLockDetailExample example = new TFCUseLockDetailExample();
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
				if(record.getActiontype()!=null){
				criteria.andActiontypeEqualTo(record.getActiontype());
				}
				if(record.getLockId()!=null){
				criteria.andLockIdEqualTo(record.getLockId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getServerIp()!=null){
				criteria.andServerIpEqualTo(record.getServerIp());
				}
				if(record.getGameId()!=null){
				criteria.andGameIdEqualTo(record.getGameId());
				}
				if(record.getServerName()!=null){
				criteria.andServerNameEqualTo(record.getServerName());
				}
				if(record.getLockNum()!=null){
				criteria.andLockNumEqualTo(record.getLockNum());
				}
				if(record.getChangeNum()!=null){
				criteria.andChangeNumEqualTo(record.getChangeNum());
				}
				if(record.getRemainNum()!=null){
				criteria.andRemainNumEqualTo(record.getRemainNum());
				}
				if(record.getOtherLockNum()!=null){
				criteria.andOtherLockNumEqualTo(record.getOtherLockNum());
				}

		}
		return example;
	}
	
	public TFCUseLockDetail selectOneByExample(TFCUseLockDetailExample example)
			 {
		example.setLimit(1);
		List<TFCUseLockDetail> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCUseLockDetail> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_USE_LOCK_DETAIL() values");
			int i=0;
			for (TFCUseLockDetail record : records) {
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
			
				if(record.getActiontype()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getActiontype()+"'");
				}
			
				sb.append(",");
			
				if(record.getLockId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLockId()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserId()+"'");
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
			
				sb.append(",");
			
				if(record.getServerName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getServerName()+"'");
				}
			
				sb.append(",");
			
				if(record.getLockNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLockNum()+"'");
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
			
				if(record.getOtherLockNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getOtherLockNum()+"'");
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
