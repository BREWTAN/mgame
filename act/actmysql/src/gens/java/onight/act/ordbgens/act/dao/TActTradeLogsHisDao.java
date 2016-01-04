package onight.act.ordbgens.act.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.act.ordbgens.act.entity.TActTradeLogsHis;
import onight.act.ordbgens.act.entity.TActTradeLogsHisExample;
import onight.act.ordbgens.act.entity.TActTradeLogsHisExample.Criteria;
import onight.act.ordbgens.act.entity.TActTradeLogsHisKey;
import onight.act.ordbgens.act.mapper.TActTradeLogsHisMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_ACT_TRADE_LOGS_HIS")
public class TActTradeLogsHisDao extends ExtendDaoSupper<TActTradeLogsHis, TActTradeLogsHisExample, TActTradeLogsHisKey>{

	private TActTradeLogsHisMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TActTradeLogsHisExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TActTradeLogsHisExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TActTradeLogsHisKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TActTradeLogsHis record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TActTradeLogsHis record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TActTradeLogsHis> records)
			 {
		for(TActTradeLogsHis record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TActTradeLogsHis> records)
			 {
		for(TActTradeLogsHis record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TActTradeLogsHis> selectByExample(TActTradeLogsHisExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TActTradeLogsHis selectByPrimaryKey(TActTradeLogsHisKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TActTradeLogsHis> findAll(List<TActTradeLogsHis> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TActTradeLogsHisExample());
		}
		List<TActTradeLogsHis> list = new ArrayList();
		for(TActTradeLogsHis record : records){
			TActTradeLogsHis result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TActTradeLogsHis record, TActTradeLogsHisExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TActTradeLogsHis record, TActTradeLogsHisExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TActTradeLogsHis record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TActTradeLogsHis record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TActTradeLogsHisExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TActTradeLogsHisExample());
	}

	@Override
	public TActTradeLogsHisExample getExample(TActTradeLogsHis record) {
		TActTradeLogsHisExample example = new TActTradeLogsHisExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getLogUuid()!=null){
				criteria.andLogUuidEqualTo(record.getLogUuid());
				}
				if(record.getSettDate()!=null){
				criteria.andSettDateEqualTo(record.getSettDate());
				}
				if(record.getConsDate()!=null){
				criteria.andConsDateEqualTo(record.getConsDate());
				}
				if(record.getTxSno()!=null){
				criteria.andTxSnoEqualTo(record.getTxSno());
				}
				if(record.getSendMchntId()!=null){
				criteria.andSendMchntIdEqualTo(record.getSendMchntId());
				}
				if(record.getTransCode()!=null){
				criteria.andTransCodeEqualTo(record.getTransCode());
				}
				if(record.getSubTransCode()!=null){
				criteria.andSubTransCodeEqualTo(record.getSubTransCode());
				}
				if(record.getFundNo()!=null){
				criteria.andFundNoEqualTo(record.getFundNo());
				}
				if(record.getActNo()!=null){
				criteria.andActNoEqualTo(record.getActNo());
				}
				if(record.getBizType()!=null){
				criteria.andBizTypeEqualTo(record.getBizType());
				}
				if(record.getBizDtlType()!=null){
				criteria.andBizDtlTypeEqualTo(record.getBizDtlType());
				}
				if(record.getDebtCustId()!=null){
				criteria.andDebtCustIdEqualTo(record.getDebtCustId());
				}
				if(record.getCrdtCustId()!=null){
				criteria.andCrdtCustIdEqualTo(record.getCrdtCustId());
				}
				if(record.getDcType()!=null){
				criteria.andDcTypeEqualTo(record.getDcType());
				}
				if(record.getAmt()!=null){
				criteria.andAmtEqualTo(record.getAmt());
				}
				if(record.getFlagCancel()!=null){
				criteria.andFlagCancelEqualTo(record.getFlagCancel());
				}
				if(record.getRelatedTransId()!=null){
				criteria.andRelatedTransIdEqualTo(record.getRelatedTransId());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}
				if(record.getActBalAfter()!=null){
				criteria.andActBalAfterEqualTo(record.getActBalAfter());
				}
				if(record.getActBalBefore()!=null){
				criteria.andActBalBeforeEqualTo(record.getActBalBefore());
				}
				if(record.getCreateTime()!=null){
				criteria.andCreateTimeEqualTo(record.getCreateTime());
				}
				if(record.getUpdateTime()!=null){
				criteria.andUpdateTimeEqualTo(record.getUpdateTime());
				}

		}
		return example;
	}
	
	public TActTradeLogsHis selectOneByExample(TActTradeLogsHisExample example)
			 {
		example.setLimit(1);
		List<TActTradeLogsHis> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TActTradeLogsHis> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_ACT_TRADE_LOGS_HIS() values");
			int i=0;
			for (TActTradeLogsHis record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getLogUuid()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLogUuid()+"'");
				}
			
				sb.append(",");
			
				if(record.getSettDate()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getSettDate()+"'");
				}
			
				sb.append(",");
			
				if(record.getConsDate()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getConsDate()+"'");
				}
			
				sb.append(",");
			
				if(record.getTxSno()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getTxSno()+"'");
				}
			
				sb.append(",");
			
				if(record.getSendMchntId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getSendMchntId()+"'");
				}
			
				sb.append(",");
			
				if(record.getTransCode()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getTransCode()+"'");
				}
			
				sb.append(",");
			
				if(record.getSubTransCode()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getSubTransCode()+"'");
				}
			
				sb.append(",");
			
				if(record.getFundNo()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getFundNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getActNo()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getActNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getBizType()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBizType()+"'");
				}
			
				sb.append(",");
			
				if(record.getBizDtlType()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBizDtlType()+"'");
				}
			
				sb.append(",");
			
				if(record.getDebtCustId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getDebtCustId()+"'");
				}
			
				sb.append(",");
			
				if(record.getCrdtCustId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCrdtCustId()+"'");
				}
			
				sb.append(",");
			
				if(record.getDcType()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getDcType()+"'");
				}
			
				sb.append(",");
			
				if(record.getAmt()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getAmt()+"'");
				}
			
				sb.append(",");
			
				if(record.getFlagCancel()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getFlagCancel()+"'");
				}
			
				sb.append(",");
			
				if(record.getRelatedTransId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRelatedTransId()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("'"+"0000"+"'");						
				}else{
					sb.append("'"+record.getStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getActBalAfter()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getActBalAfter()+"'");
				}
			
				sb.append(",");
			
				if(record.getActBalBefore()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getActBalBefore()+"'");
				}
			
				sb.append(",");
			
				if(record.getCreateTime()==null){
						sb.append("'"+"CURRENT_TIMESTAMP"+"'");						
				}else{
					sb.append("'"+record.getCreateTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getUpdateTime()==null){
						sb.append("'"+"CURRENT_TIMESTAMP"+"'");						
				}else{
					sb.append("'"+record.getUpdateTime()+"'");
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
