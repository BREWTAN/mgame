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

import onight.act.ordbgens.act.entity.TActLogs;
import onight.act.ordbgens.act.entity.TActLogsExample;
import onight.act.ordbgens.act.entity.TActLogsExample.Criteria;
import onight.act.ordbgens.act.entity.TActLogsKey;
import onight.act.ordbgens.act.mapper.TActLogsMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_ACT_LOGS")
public class TActLogsDao extends ExtendDaoSupper<TActLogs, TActLogsExample, TActLogsKey>{

	private TActLogsMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TActLogsExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TActLogsExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TActLogsKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TActLogs record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TActLogs record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TActLogs> records)
			 {
		for(TActLogs record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TActLogs> records)
			 {
		for(TActLogs record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TActLogs> selectByExample(TActLogsExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TActLogs selectByPrimaryKey(TActLogsKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TActLogs> findAll(List<TActLogs> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TActLogsExample());
		}
		List<TActLogs> list = new ArrayList();
		for(TActLogs record : records){
			TActLogs result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TActLogs record, TActLogsExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TActLogs record, TActLogsExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TActLogs record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TActLogs record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TActLogsExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TActLogsExample());
	}

	@Override
	public TActLogsExample getExample(TActLogs record) {
		TActLogsExample example = new TActLogsExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUuid()!=null){
				criteria.andUuidEqualTo(record.getUuid());
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
				if(record.getMsgType()!=null){
				criteria.andMsgTypeEqualTo(record.getMsgType());
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
				if(record.getActBalAfter()!=null){
				criteria.andActBalAfterEqualTo(record.getActBalAfter());
				}
				if(record.getActBalBefore()!=null){
				criteria.andActBalBeforeEqualTo(record.getActBalBefore());
				}
				if(record.getUpdtTime()!=null){
				criteria.andUpdtTimeEqualTo(record.getUpdtTime());
				}

		}
		return example;
	}
	
	public TActLogs selectOneByExample(TActLogsExample example)
			 {
		example.setLimit(1);
		List<TActLogs> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TActLogs> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_ACT_LOGS() values");
			int i=0;
			for (TActLogs record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getUuid()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUuid()+"'");
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
			
				if(record.getMsgType()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMsgType()+"'");
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
			
				if(record.getUpdtTime()==null){
						sb.append("'"+"CURRENT_TIMESTAMP"+"'");						
				}else{
					sb.append("'"+record.getUpdtTime()+"'");
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
