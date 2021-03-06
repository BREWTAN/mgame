package onight.tfg.ordbgens.tfg.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfg.entity.TFGUserInfo;
import onight.tfg.ordbgens.tfg.entity.TFGUserInfoExample;
import onight.tfg.ordbgens.tfg.entity.TFGUserInfoKey;
import onight.tfw.ojpa.ordb.StaticTableDaoSupport;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TFGUserInfoMapper extends StaticTableDaoSupport<TFGUserInfo, TFGUserInfoExample, TFGUserInfoKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @SelectProvider(type=TFGUserInfoSqlProvider.class, method="countByExample")
    int countByExample(TFGUserInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @DeleteProvider(type=TFGUserInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFGUserInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Delete({
        "delete from TFG_USER_INFO",
        "where USER_ID = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(TFGUserInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Insert({
        "insert into TFG_USER_INFO (USER_ID, NICKNAME, ",
        "SECURITY_EMAIL, USER_NAME, ",
        "ADDRESS, STATUS, ",
        "ID_NO, UPDATE_TIME, ",
        "CREATE_TIME, QQ_ID, ",
        "WECHAT_ID, MOBILE, ",
        "EMAIL, RENREN, WEIBO, ",
        "FACE, FACE_URL, GENDER, ",
        "BIRTHDAY, COUNTRY, ",
        "CITY, REG_TIME, ",
        "REG_IP, LAST_LOGIN_TIME, ",
        "LAST_LOGIN_IP)",
        "values (#{userId,jdbcType=BIGINT}, #{nickname,jdbcType=VARCHAR}, ",
        "#{securityEmail,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{idNo,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{qqId,jdbcType=VARCHAR}, ",
        "#{wechatId,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{renren,jdbcType=VARCHAR}, #{weibo,jdbcType=VARCHAR}, ",
        "#{face,jdbcType=INTEGER}, #{faceUrl,jdbcType=VARCHAR}, #{gender,jdbcType=INTEGER}, ",
        "#{birthday,jdbcType=DATE}, #{country,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{regTime,jdbcType=TIMESTAMP}, ",
        "#{regIp,jdbcType=VARCHAR}, #{lastLoginTime,jdbcType=TIMESTAMP}, ",
        "#{lastLoginIp,jdbcType=VARCHAR})"
    })
    int insert(TFGUserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @InsertProvider(type=TFGUserInfoSqlProvider.class, method="insertSelective")
    int insertSelective(TFGUserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @SelectProvider(type=TFGUserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="NICKNAME", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="SECURITY_EMAIL", property="securityEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="ID_NO", property="idNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="QQ_ID", property="qqId", jdbcType=JdbcType.VARCHAR),
        @Result(column="WECHAT_ID", property="wechatId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MOBILE", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="RENREN", property="renren", jdbcType=JdbcType.VARCHAR),
        @Result(column="WEIBO", property="weibo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FACE", property="face", jdbcType=JdbcType.INTEGER),
        @Result(column="FACE_URL", property="faceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="GENDER", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="BIRTHDAY", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="COUNTRY", property="country", jdbcType=JdbcType.VARCHAR),
        @Result(column="CITY", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="REG_TIME", property="regTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REG_IP", property="regIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_LOGIN_TIME", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_LOGIN_IP", property="lastLoginIp", jdbcType=JdbcType.VARCHAR)
    })
    List<TFGUserInfo> selectByExample(TFGUserInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Select({
        "select",
        "USER_ID, NICKNAME, SECURITY_EMAIL, USER_NAME, ADDRESS, STATUS, ID_NO, UPDATE_TIME, ",
        "CREATE_TIME, QQ_ID, WECHAT_ID, MOBILE, EMAIL, RENREN, WEIBO, FACE, FACE_URL, ",
        "GENDER, BIRTHDAY, COUNTRY, CITY, REG_TIME, REG_IP, LAST_LOGIN_TIME, LAST_LOGIN_IP",
        "from TFG_USER_INFO",
        "where USER_ID = #{userId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="NICKNAME", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="SECURITY_EMAIL", property="securityEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="ID_NO", property="idNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="QQ_ID", property="qqId", jdbcType=JdbcType.VARCHAR),
        @Result(column="WECHAT_ID", property="wechatId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MOBILE", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="RENREN", property="renren", jdbcType=JdbcType.VARCHAR),
        @Result(column="WEIBO", property="weibo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FACE", property="face", jdbcType=JdbcType.INTEGER),
        @Result(column="FACE_URL", property="faceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="GENDER", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="BIRTHDAY", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="COUNTRY", property="country", jdbcType=JdbcType.VARCHAR),
        @Result(column="CITY", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="REG_TIME", property="regTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REG_IP", property="regIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_LOGIN_TIME", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_LOGIN_IP", property="lastLoginIp", jdbcType=JdbcType.VARCHAR)
    })
    TFGUserInfo selectByPrimaryKey(TFGUserInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @UpdateProvider(type=TFGUserInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFGUserInfo record, @Param("example") TFGUserInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @UpdateProvider(type=TFGUserInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFGUserInfo record, @Param("example") TFGUserInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @UpdateProvider(type=TFGUserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFGUserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Update({
        "update TFG_USER_INFO",
        "set NICKNAME = #{nickname,jdbcType=VARCHAR},",
          "SECURITY_EMAIL = #{securityEmail,jdbcType=VARCHAR},",
          "USER_NAME = #{userName,jdbcType=VARCHAR},",
          "ADDRESS = #{address,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=INTEGER},",
          "ID_NO = #{idNo,jdbcType=VARCHAR},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "QQ_ID = #{qqId,jdbcType=VARCHAR},",
          "WECHAT_ID = #{wechatId,jdbcType=VARCHAR},",
          "MOBILE = #{mobile,jdbcType=VARCHAR},",
          "EMAIL = #{email,jdbcType=VARCHAR},",
          "RENREN = #{renren,jdbcType=VARCHAR},",
          "WEIBO = #{weibo,jdbcType=VARCHAR},",
          "FACE = #{face,jdbcType=INTEGER},",
          "FACE_URL = #{faceUrl,jdbcType=VARCHAR},",
          "GENDER = #{gender,jdbcType=INTEGER},",
          "BIRTHDAY = #{birthday,jdbcType=DATE},",
          "COUNTRY = #{country,jdbcType=VARCHAR},",
          "CITY = #{city,jdbcType=VARCHAR},",
          "REG_TIME = #{regTime,jdbcType=TIMESTAMP},",
          "REG_IP = #{regIp,jdbcType=VARCHAR},",
          "LAST_LOGIN_TIME = #{lastLoginTime,jdbcType=TIMESTAMP},",
          "LAST_LOGIN_IP = #{lastLoginIp,jdbcType=VARCHAR}",
        "where USER_ID = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TFGUserInfo record);
}