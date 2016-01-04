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

import onight.tfg.ordbgens.sys.entity.TSysRspCode;
import onight.tfg.ordbgens.sys.entity.TSysRspCodeExample;
import onight.tfg.ordbgens.sys.entity.TSysRspCodeExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysRspCodeKey;
import onight.tfg.ordbgens.sys.mapper.TSysRspCodeMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="T_SYS_RSP_CODE")
public class TSysRspCodeDao extends ExtendDaoSupper<TSysRspCode, TSysRspCodeExample, TSysRspCodeKey>{

	private TSysRspCodeMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TSysRspCodeExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TSysRspCodeExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TSysRspCodeKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TSysRspCode record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TSysRspCode record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TSysRspCode> records)
			 {
		for(TSysRspCode record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TSysRspCode> records)
			 {
		for(TSysRspCode record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TSysRspCode> selectByExample(TSysRspCodeExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TSysRspCode selectByPrimaryKey(TSysRspCodeKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TSysRspCode> findAll(List<TSysRspCode> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TSysRspCodeExample());
		}
		List<TSysRspCode> list = new ArrayList();
		for(TSysRspCode record : records){
			TSysRspCode result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TSysRspCode record, TSysRspCodeExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TSysRspCode record, TSysRspCodeExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TSysRspCode record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TSysRspCode record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TSysRspCodeExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TSysRspCodeExample());
	}

	@Override
	public TSysRspCodeExample getExample(TSysRspCode record) {
		TSysRspCodeExample example = new TSysRspCodeExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getProdId()!=null){
				criteria.andProdIdEqualTo(record.getProdId());
				}
				if(record.getOutRspCode()!=null){
				criteria.andOutRspCodeEqualTo(record.getOutRspCode());
				}
				if(record.getInRspCode2()!=null){
				criteria.andInRspCode2EqualTo(record.getInRspCode2());
				}
				if(record.getRspDesc()!=null){
				criteria.andRspDescEqualTo(record.getRspDesc());
				}

		}
		return example;
	}
	
	public TSysRspCode selectOneByExample(TSysRspCodeExample example)
			 {
		example.setLimit(1);
		List<TSysRspCode> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TSysRspCode> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO T_SYS_RSP_CODE() values");
			int i=0;
			for (TSysRspCode record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getId()+"'");
				}
			
				sb.append(",");
			
				if(record.getProdId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getProdId()+"'");
				}
			
				sb.append(",");
			
				if(record.getOutRspCode()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getOutRspCode()+"'");
				}
			
				sb.append(",");
			
				if(record.getInRspCode2()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getInRspCode2()+"'");
				}
			
				sb.append(",");
			
				if(record.getRspDesc()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRspDesc()+"'");
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
