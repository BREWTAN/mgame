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

import onight.tfg.ordbgens.tfc.entity.TFCOrder;
import onight.tfg.ordbgens.tfc.entity.TFCOrderExample;
import onight.tfg.ordbgens.tfc.entity.TFCOrderExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCOrderKey;
import onight.tfg.ordbgens.tfc.mapper.TFCOrderMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_ORDER")
public class TFCOrderDao extends ExtendDaoSupper<TFCOrder, TFCOrderExample, TFCOrderKey>{

	private TFCOrderMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCOrderExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCOrderExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCOrderKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCOrder record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCOrder record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCOrder> records)
			 {
		for(TFCOrder record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCOrder> records)
			 {
		for(TFCOrder record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCOrder> selectByExample(TFCOrderExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCOrder selectByPrimaryKey(TFCOrderKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCOrder> findAll(List<TFCOrder> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCOrderExample());
		}
		List<TFCOrder> list = new ArrayList();
		for(TFCOrder record : records){
			TFCOrder result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCOrder record, TFCOrderExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCOrder record, TFCOrderExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCOrder record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCOrder record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCOrderExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCOrderExample());
	}

	@Override
	public TFCOrderExample getExample(TFCOrder record) {
		TFCOrderExample example = new TFCOrderExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getOrderId()!=null){
				criteria.andOrderIdEqualTo(record.getOrderId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getOrderStatus()!=null){
				criteria.andOrderStatusEqualTo(record.getOrderStatus());
				}
				if(record.getItemId()!=null){
				criteria.andItemIdEqualTo(record.getItemId());
				}
				if(record.getCoinNum()!=null){
				criteria.andCoinNumEqualTo(record.getCoinNum());
				}
				if(record.getStorageTime()!=null){
				criteria.andStorageTimeEqualTo(record.getStorageTime());
				}
				if(record.getHandleTime()!=null){
				criteria.andHandleTimeEqualTo(record.getHandleTime());
				}

		}
		return example;
	}
	
	public TFCOrder selectOneByExample(TFCOrderExample example)
			 {
		example.setLimit(1);
		List<TFCOrder> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCOrder> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_ORDER() values");
			int i=0;
			for (TFCOrder record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getOrderId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getOrderId()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getOrderStatus()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getOrderStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getItemId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getItemId()+"'");
				}
			
				sb.append(",");
			
				if(record.getCoinNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCoinNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getStorageTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getStorageTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getHandleTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getHandleTime()+"'");
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
