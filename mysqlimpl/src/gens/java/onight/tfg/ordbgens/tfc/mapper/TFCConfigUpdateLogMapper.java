package onight.tfg.ordbgens.tfc.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfc.entity.TFCConfigUpdateLog;
import onight.tfg.ordbgens.tfc.entity.TFCConfigUpdateLogExample;
import onight.tfg.ordbgens.tfc.entity.TFCConfigUpdateLogKey;
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

public interface TFCConfigUpdateLogMapper extends StaticTableDaoSupport<TFCConfigUpdateLog, TFCConfigUpdateLogExample, TFCConfigUpdateLogKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @SelectProvider(type=TFCConfigUpdateLogSqlProvider.class, method="countByExample")
    int countByExample(TFCConfigUpdateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @DeleteProvider(type=TFCConfigUpdateLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFCConfigUpdateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Delete({
        "delete from TFC_CONFIG_UPDATE_LOG",
        "where CONFIG_TYPE = #{configType,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TFCConfigUpdateLogKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Insert({
        "insert into TFC_CONFIG_UPDATE_LOG (CONFIG_TYPE, UPDATE_TIME, ",
        "NOTE)",
        "values (#{configType,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(TFCConfigUpdateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @InsertProvider(type=TFCConfigUpdateLogSqlProvider.class, method="insertSelective")
    int insertSelective(TFCConfigUpdateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @SelectProvider(type=TFCConfigUpdateLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="CONFIG_TYPE", property="configType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="NOTE", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<TFCConfigUpdateLog> selectByExample(TFCConfigUpdateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Select({
        "select",
        "CONFIG_TYPE, UPDATE_TIME, NOTE",
        "from TFC_CONFIG_UPDATE_LOG",
        "where CONFIG_TYPE = #{configType,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="CONFIG_TYPE", property="configType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="NOTE", property="note", jdbcType=JdbcType.VARCHAR)
    })
    TFCConfigUpdateLog selectByPrimaryKey(TFCConfigUpdateLogKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @UpdateProvider(type=TFCConfigUpdateLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFCConfigUpdateLog record, @Param("example") TFCConfigUpdateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @UpdateProvider(type=TFCConfigUpdateLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFCConfigUpdateLog record, @Param("example") TFCConfigUpdateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @UpdateProvider(type=TFCConfigUpdateLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFCConfigUpdateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Update({
        "update TFC_CONFIG_UPDATE_LOG",
        "set UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "NOTE = #{note,jdbcType=VARCHAR}",
        "where CONFIG_TYPE = #{configType,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TFCConfigUpdateLog record);
}