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

import onight.tfg.ordbgens.tfc.entity.TFCUserLock;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockKey;
import onight.tfg.ordbgens.tfc.mapper.TFCUserLockMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_USER_LOCK")
public class TFCUserLockDao extends ExtendDaoSupper<TFCUserLock, TFCUserLockExample, TFCUserLockKey>{

	private TFCUserLockMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCUserLockExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCUserLockExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCUserLockKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCUserLock record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCUserLock record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCUserLock> records)
			 {
		for(TFCUserLock record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCUserLock> records)
			 {
		for(TFCUserLock record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCUserLock> selectByExample(TFCUserLockExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCUserLock selectByPrimaryKey(TFCUserLockKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCUserLock> findAll(List<TFCUserLock> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCUserLockExample());
		}
		List<TFCUserLock> list = new ArrayList();
		for(TFCUserLock record : records){
			TFCUserLock result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCUserLock record, TFCUserLockExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCUserLock record, TFCUserLockExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCUserLock record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCUserLock record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCUserLockExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCUserLockExample());
	}

	@Override
	public TFCUserLockExample getExample(TFCUserLock record) {
		TFCUserLockExample example = new TFCUserLockExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getRowId()!=null){
				criteria.andRowIdEqualTo(record.getRowId());
				}
				if(record.getLockId()!=null){
				criteria.andLockIdEqualTo(record.getLockId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getCoinRowId()!=null){
				criteria.andCoinRowIdEqualTo(record.getCoinRowId());
				}
				if(record.getGameId()!=null){
				criteria.andGameIdEqualTo(record.getGameId());
				}
				if(record.getServerIp()!=null){
				criteria.andServerIpEqualTo(record.getServerIp());
				}
				if(record.getServerName()!=null){
				criteria.andServerNameEqualTo(record.getServerName());
				}
				if(record.getCoinTypeId()!=null){
				criteria.andCoinTypeIdEqualTo(record.getCoinTypeId());
				}
				if(record.getLockNum()!=null){
				criteria.andLockNumEqualTo(record.getLockNum());
				}
				if(record.getRecDate()!=null){
				criteria.andRecDateEqualTo(record.getRecDate());
				}

		}
		return example;
	}
	
	public TFCUserLock selectOneByExample(TFCUserLockExample example)
			 {
		example.setLimit(1);
		List<TFCUserLock> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCUserLock> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_USER_LOCK() values");
			int i=0;
			for (TFCUserLock record : records) {
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
			
				if(record.getCoinRowId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinRowId()+"'");
				}
			
				sb.append(",");
			
				if(record.getGameId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getGameId()+"'");
				}
			
				sb.append(",");
			
				if(record.getServerIp()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getServerIp()+"'");
				}
			
				sb.append(",");
			
				if(record.getServerName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getServerName()+"'");
				}
			
				sb.append(",");
			
				if(record.getCoinTypeId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinTypeId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLockNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLockNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getRecDate()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRecDate()+"'");
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
