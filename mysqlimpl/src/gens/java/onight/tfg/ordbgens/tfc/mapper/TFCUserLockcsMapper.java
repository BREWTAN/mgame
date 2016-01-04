package onight.tfg.ordbgens.tfc.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockcs;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockcsExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockcsKey;
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

public interface TFCUserLockcsMapper extends StaticTableDaoSupport<TFCUserLockcs, TFCUserLockcsExample, TFCUserLockcsKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @SelectProvider(type=TFCUserLockcsSqlProvider.class, method="countByExample")
    int countByExample(TFCUserLockcsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @DeleteProvider(type=TFCUserLockcsSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFCUserLockcsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Delete({
        "delete from TFC_USER_LOCKCS",
        "where USER_ID = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TFCUserLockcsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Insert({
        "insert into TFC_USER_LOCKCS (USER_ID, READ_COUNT, ",
        "WRITE_COUNT)",
        "values (#{userId,jdbcType=VARCHAR}, #{readCount,jdbcType=BIGINT}, ",
        "#{writeCount,jdbcType=BIGINT})"
    })
    int insert(TFCUserLockcs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @InsertProvider(type=TFCUserLockcsSqlProvider.class, method="insertSelective")
    int insertSelective(TFCUserLockcs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @SelectProvider(type=TFCUserLockcsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="READ_COUNT", property="readCount", jdbcType=JdbcType.BIGINT),
        @Result(column="WRITE_COUNT", property="writeCount", jdbcType=JdbcType.BIGINT)
    })
    List<TFCUserLockcs> selectByExample(TFCUserLockcsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Select({
        "select",
        "USER_ID, READ_COUNT, WRITE_COUNT",
        "from TFC_USER_LOCKCS",
        "where USER_ID = #{userId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="READ_COUNT", property="readCount", jdbcType=JdbcType.BIGINT),
        @Result(column="WRITE_COUNT", property="writeCount", jdbcType=JdbcType.BIGINT)
    })
    TFCUserLockcs selectByPrimaryKey(TFCUserLockcsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @UpdateProvider(type=TFCUserLockcsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFCUserLockcs record, @Param("example") TFCUserLockcsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @UpdateProvider(type=TFCUserLockcsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFCUserLockcs record, @Param("example") TFCUserLockcsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @UpdateProvider(type=TFCUserLockcsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFCUserLockcs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Update({
        "update TFC_USER_LOCKCS",
        "set READ_COUNT = #{readCount,jdbcType=BIGINT},",
          "WRITE_COUNT = #{writeCount,jdbcType=BIGINT}",
        "where USER_ID = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TFCUserLockcs record);
}