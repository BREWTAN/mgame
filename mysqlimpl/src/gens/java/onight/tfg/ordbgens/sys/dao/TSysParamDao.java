package onight.tfg.ordbgens.sys.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.tfg.ordbgens.sys.entity.TSysParam;
import onight.tfg.ordbgens.sys.entity.TSysParamExample;
import onight.tfg.ordbgens.sys.entity.TSysParamExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysParamKey;
import onight.tfg.ordbgens.sys.mapper.TSysParamMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_PARAM")
public class TSysParamDao extends ExtendDaoSupper<TSysParam, TSysParamExample, TSysParamKey>{

	private TSysParamMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysParamExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysParamExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysParamKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysParam record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysParam record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysParam> records)
			 {
		for(TSysParam record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysParam> records)
			 {
		for(TSysParam record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysParam> selectByExample(TSysParamExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysParam selectByPrimaryKey(TSysParamKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysParam> findAll(List<TSysParam> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysParamExample());
		}
		List<TSysParam> list = new ArrayList();
		for(TSysParam record : records){
			TSysParam result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysParam record, TSysParamExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysParam record, TSysParamExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysParam record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysParam record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysParamExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysParamExample());
	}

	@Override
	public TSysParamExample getExample(TSysParam record) {
		TSysParamExample example = new TSysParamExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getParamId()!=null){
				criteria.andParamIdEqualTo(record.getParamId());
				}
				if(record.getParamType()!=null){
				criteria.andParamTypeEqualTo(record.getParamType());
				}
				if(record.getParamValue()!=null){
				criteria.andParamValueEqualTo(record.getParamValue());
				}
				if(record.getDsc()!=null){
				criteria.andDscEqualTo(record.getDsc());
				}
				if(record.getCrtTime()!=null){
				criteria.andCrtTimeEqualTo(record.getCrtTime());
				}
				if(record.getField1()!=null){
				criteria.andField1EqualTo(record.getField1());
				}
				if(record.getField2()!=null){
				criteria.andField2EqualTo(record.getField2());
				}
				if(record.getField3()!=null){
				criteria.andField3EqualTo(record.getField3());
				}

		}
		return example;
	}
	
	public TSysParam selectOneByExample(TSysParamExample example)
			 {
		example.setLimit(1);
		List<TSysParam> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysParam> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_PARAM() values");
			int i=0;
			for (TSysParam record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getParamId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getParamId()+"'");
				}
			
				sb.append(",");
			
				if(record.getParamType()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getParamType()+"'");
				}
			
				sb.append(",");
			
				if(record.getParamValue()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getParamValue()+"'");
				}
			
				sb.append(",");
			
				if(record.getDsc()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getDsc()+"'");
				}
			
				sb.append(",");
			
				if(record.getCrtTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCrtTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getField1()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getField1()+"'");
				}
			
				sb.append(",");
			
				if(record.getField2()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getField2()+"'");
				}
			
				sb.append(",");
			
				if(record.getField3()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getField3()+"'");
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
