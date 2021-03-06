package onight.tfg.ordbgens.tfc.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;
import onight.tfg.ordbgens.tfc.entity.TFCOrderDetail;
import onight.tfg.ordbgens.tfc.entity.TFCOrderDetailExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCOrderDetailExample.Criterion;
import onight.tfg.ordbgens.tfc.entity.TFCOrderDetailExample;

public class TFCOrderDetailSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String countByExample(TFCOrderDetailExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TFC_ORDER_DETAIL");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String deleteByExample(TFCOrderDetailExample example) {
        BEGIN();
        DELETE_FROM("TFC_ORDER_DETAIL");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String insertSelective(TFCOrderDetail record) {
        BEGIN();
        INSERT_INTO("TFC_ORDER_DETAIL");
        
        if (record.getRowId() != null) {
            VALUES("ROW_ID", "#{rowId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            VALUES("USER_ID", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getHandleTime() != null) {
            VALUES("HANDLE_TIME", "#{handleTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHanldeStatus() != null) {
            VALUES("HANLDE_STATUS", "#{hanldeStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNumBefore() != null) {
            VALUES("NUM_BEFORE", "#{numBefore,jdbcType=BIGINT}");
        }
        
        if (record.getChangeNum() != null) {
            VALUES("CHANGE_NUM", "#{changeNum,jdbcType=BIGINT}");
        }
        
        if (record.getNumAfter() != null) {
            VALUES("NUM_AFTER", "#{numAfter,jdbcType=BIGINT}");
        }
        
        if (record.getNote() != null) {
            VALUES("NOTE", "#{note,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String selectByExample(TFCOrderDetailExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ROW_ID");
        } else {
            SELECT("ROW_ID");
        }
        SELECT("USER_ID");
        SELECT("HANDLE_TIME");
        SELECT("HANLDE_STATUS");
        SELECT("NUM_BEFORE");
        SELECT("CHANGE_NUM");
        SELECT("NUM_AFTER");
        SELECT("NOTE");
        FROM("TFC_ORDER_DETAIL");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        if(example!=null&&example.getSelectCols()!=null&&example.getSelectCols().trim().length()>0){
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT(example.getSelectCols());
		} else {
				SELECT(example.getSelectCols());
		}
				applyWhere(example, false);
		}
        if(example != null){
            return SQL().concat(" limit "+example.getOffset()+","+example.getLimit());
        }
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TFCOrderDetail record = (TFCOrderDetail) parameter.get("record");
        TFCOrderDetailExample example = (TFCOrderDetailExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TFC_ORDER_DETAIL");
        
        if (record.getRowId() != null) {
            SET("ROW_ID = #{record.rowId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            SET("USER_ID = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getHandleTime() != null) {
            SET("HANDLE_TIME = #{record.handleTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHanldeStatus() != null) {
            SET("HANLDE_STATUS = #{record.hanldeStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNumBefore() != null) {
            SET("NUM_BEFORE = #{record.numBefore,jdbcType=BIGINT}");
        }
        
        if (record.getChangeNum() != null) {
            SET("CHANGE_NUM = #{record.changeNum,jdbcType=BIGINT}");
        }
        
        if (record.getNumAfter() != null) {
            SET("NUM_AFTER = #{record.numAfter,jdbcType=BIGINT}");
        }
        
        if (record.getNote() != null) {
            SET("NOTE = #{record.note,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TFC_ORDER_DETAIL");
        
        SET("ROW_ID = #{record.rowId,jdbcType=VARCHAR}");
        SET("USER_ID = #{record.userId,jdbcType=BIGINT}");
        SET("HANDLE_TIME = #{record.handleTime,jdbcType=TIMESTAMP}");
        SET("HANLDE_STATUS = #{record.hanldeStatus,jdbcType=INTEGER}");
        SET("NUM_BEFORE = #{record.numBefore,jdbcType=BIGINT}");
        SET("CHANGE_NUM = #{record.changeNum,jdbcType=BIGINT}");
        SET("NUM_AFTER = #{record.numAfter,jdbcType=BIGINT}");
        SET("NOTE = #{record.note,jdbcType=VARCHAR}");
        
        TFCOrderDetailExample example = (TFCOrderDetailExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String updateByPrimaryKeySelective(TFCOrderDetail record) {
        BEGIN();
        UPDATE("TFC_ORDER_DETAIL");
        
        if (record.getUserId() != null) {
            SET("USER_ID = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getHandleTime() != null) {
            SET("HANDLE_TIME = #{handleTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHanldeStatus() != null) {
            SET("HANLDE_STATUS = #{hanldeStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNumBefore() != null) {
            SET("NUM_BEFORE = #{numBefore,jdbcType=BIGINT}");
        }
        
        if (record.getChangeNum() != null) {
            SET("CHANGE_NUM = #{changeNum,jdbcType=BIGINT}");
        }
        
        if (record.getNumAfter() != null) {
            SET("NUM_AFTER = #{numAfter,jdbcType=BIGINT}");
        }
        
        if (record.getNote() != null) {
            SET("NOTE = #{note,jdbcType=VARCHAR}");
        }
        
        WHERE("ROW_ID = #{rowId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    protected void applyWhere(TFCOrderDetailExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}