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

import onight.tfg.ordbgens.tfc.entity.TFCOrderDetail;
import onight.tfg.ordbgens.tfc.entity.TFCOrderDetailExample;
import onight.tfg.ordbgens.tfc.entity.TFCOrderDetailExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCOrderDetailKey;
import onight.tfg.ordbgens.tfc.mapper.TFCOrderDetailMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_ORDER_DETAIL")
public class TFCOrderDetailDao extends ExtendDaoSupper<TFCOrderDetail, TFCOrderDetailExample, TFCOrderDetailKey>{

	private TFCOrderDetailMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCOrderDetailExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCOrderDetailExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCOrderDetailKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCOrderDetail record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCOrderDetail record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCOrderDetail> records)
			 {
		for(TFCOrderDetail record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCOrderDetail> records)
			 {
		for(TFCOrderDetail record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCOrderDetail> selectByExample(TFCOrderDetailExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCOrderDetail selectByPrimaryKey(TFCOrderDetailKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCOrderDetail> findAll(List<TFCOrderDetail> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCOrderDetailExample());
		}
		List<TFCOrderDetail> list = new ArrayList();
		for(TFCOrderDetail record : records){
			TFCOrderDetail result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCOrderDetail record, TFCOrderDetailExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCOrderDetail record, TFCOrderDetailExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCOrderDetail record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCOrderDetail record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCOrderDetailExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFCOrderDetailExample());
	}

	@Override
	public TFCOrderDetailExample getExample(TFCOrderDetail record) {
		TFCOrderDetailExample example = new TFCOrderDetailExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getRowId()!=null){
				criteria.andRowIdEqualTo(record.getRowId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getHandleTime()!=null){
				criteria.andHandleTimeEqualTo(record.getHandleTime());
				}
				if(record.getHanldeStatus()!=null){
				criteria.andHanldeStatusEqualTo(record.getHanldeStatus());
				}
				if(record.getNumBefore()!=null){
				criteria.andNumBeforeEqualTo(record.getNumBefore());
				}
				if(record.getChangeNum()!=null){
				criteria.andChangeNumEqualTo(record.getChangeNum());
				}
				if(record.getNumAfter()!=null){
				criteria.andNumAfterEqualTo(record.getNumAfter());
				}
				if(record.getNote()!=null){
				criteria.andNoteEqualTo(record.getNote());
				}

		}
		return example;
	}
	
	public TFCOrderDetail selectOneByExample(TFCOrderDetailExample example)
			 {
		example.setLimit(1);
		List<TFCOrderDetail> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCOrderDetail> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_ORDER_DETAIL() values");
			int i=0;
			for (TFCOrderDetail record : records) {
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
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getHandleTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getHandleTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getHanldeStatus()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getHanldeStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getNumBefore()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getNumBefore()+"'");
				}
			
				sb.append(",");
			
				if(record.getChangeNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getChangeNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getNumAfter()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getNumAfter()+"'");
				}
			
				sb.append(",");
			
				if(record.getNote()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getNote()+"'");
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
