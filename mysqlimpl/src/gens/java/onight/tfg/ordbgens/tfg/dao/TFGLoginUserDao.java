package onight.tfg.ordbgens.tfg.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.tfg.ordbgens.tfg.entity.TFGLoginUser;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUserExample;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUserExample.Criteria;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUserKey;
import onight.tfg.ordbgens.tfg.mapper.TFGLoginUserMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFG_LOGIN_USER")
public class TFGLoginUserDao extends ExtendDaoSupper<TFGLoginUser, TFGLoginUserExample, TFGLoginUserKey>{

	private TFGLoginUserMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFGLoginUserExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFGLoginUserExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFGLoginUserKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFGLoginUser record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFGLoginUser record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFGLoginUser> records)
			 {
		for(TFGLoginUser record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFGLoginUser> records)
			 {
		for(TFGLoginUser record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFGLoginUser> selectByExample(TFGLoginUserExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFGLoginUser selectByPrimaryKey(TFGLoginUserKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFGLoginUser> findAll(List<TFGLoginUser> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFGLoginUserExample());
		}
		List<TFGLoginUser> list = new ArrayList();
		for(TFGLoginUser record : records){
			TFGLoginUser result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFGLoginUser record, TFGLoginUserExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFGLoginUser record, TFGLoginUserExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFGLoginUser record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFGLoginUser record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFGLoginUserExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFGLoginUserExample());
	}

	@Override
	public TFGLoginUserExample getExample(TFGLoginUser record) {
		TFGLoginUserExample example = new TFGLoginUserExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getLoginId()!=null){
				criteria.andLoginIdEqualTo(record.getLoginId());
				}
				if(record.getNickname()!=null){
				criteria.andNicknameEqualTo(record.getNickname());
				}
				if(record.getEmail()!=null){
				criteria.andEmailEqualTo(record.getEmail());
				}
				if(record.getMobile()!=null){
				criteria.andMobileEqualTo(record.getMobile());
				}
				if(record.getThirdLoginid1()!=null){
				criteria.andThirdLoginid1EqualTo(record.getThirdLoginid1());
				}
				if(record.getThirdLoginid2()!=null){
				criteria.andThirdLoginid2EqualTo(record.getThirdLoginid2());
				}
				if(record.getRegType()!=null){
				criteria.andRegTypeEqualTo(record.getRegType());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}
				if(record.getPassword()!=null){
				criteria.andPasswordEqualTo(record.getPassword());
				}
				if(record.getTradePassword()!=null){
				criteria.andTradePasswordEqualTo(record.getTradePassword());
				}
				if(record.getUpdateTime()!=null){
				criteria.andUpdateTimeEqualTo(record.getUpdateTime());
				}
				if(record.getCreateTime()!=null){
				criteria.andCreateTimeEqualTo(record.getCreateTime());
				}

		}
		return example;
	}
	
	public TFGLoginUser selectOneByExample(TFGLoginUserExample example)
			 {
		example.setLimit(1);
		List<TFGLoginUser> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFGLoginUser> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFG_LOGIN_USER() values");
			int i=0;
			for (TFGLoginUser record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLoginId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLoginId()+"'");
				}
			
				sb.append(",");
			
				if(record.getNickname()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getNickname()+"'");
				}
			
				sb.append(",");
			
				if(record.getEmail()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getEmail()+"'");
				}
			
				sb.append(",");
			
				if(record.getMobile()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMobile()+"'");
				}
			
				sb.append(",");
			
				if(record.getThirdLoginid1()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getThirdLoginid1()+"'");
				}
			
				sb.append(",");
			
				if(record.getThirdLoginid2()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getThirdLoginid2()+"'");
				}
			
				sb.append(",");
			
				if(record.getRegType()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRegType()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getPassword()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getPassword()+"'");
				}
			
				sb.append(",");
			
				if(record.getTradePassword()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getTradePassword()+"'");
				}
			
				sb.append(",");
			
				if(record.getUpdateTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUpdateTime()+"'");
				}
			
				sb.append(",");
			
				if(record.getCreateTime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getCreateTime()+"'");
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
