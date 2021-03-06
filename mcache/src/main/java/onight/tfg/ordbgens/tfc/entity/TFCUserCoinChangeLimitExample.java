package onight.tfg.ordbgens.tfc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TFCUserCoinChangeLimitExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    protected List<Criteria> oredCriteria;

    protected int offset;

    protected int limit;

    protected String sumCol;

    protected String groupSelClause;

    protected String groupByClause;

    String selectCols;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public TFCUserCoinChangeLimitExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        this.offset= 0;
        this.limit= Integer.MAX_VALUE;
        this.sumCol=null;
        this.groupSelClause=null;
        this.groupByClause=null;
    }

    public void setOffset(int offset) {
         this.offset = offset;
    }

    public int getOffset() {
          return offset;
    }

    public void setLimit(int limit) {
         this.limit = limit;
    }

    public int getLimit() {
          return limit;
    }

    public void setSumCol(String sumCol) {
         this.sumCol = sumCol;
    }

    public String getSumCol() {
          return sumCol;
    }

    public void setGroupSelClause(String groupSelClause) {
         this.groupSelClause = groupSelClause;
    }

    public String getGroupSelClause() {
          return groupSelClause;
    }

    public void setGroupByClause(String groupByClause) {
         this.groupByClause = groupByClause;
    }

    public String getGroupByClause() {
          return groupByClause;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    @Data
    public abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        public GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        public void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        public void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        public void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCoinRowIdIsNull() {
            addCriterion("COIN_ROW_ID is null");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdIsNotNull() {
            addCriterion("COIN_ROW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdEqualTo(String value) {
            addCriterion("COIN_ROW_ID =", value, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdNotEqualTo(String value) {
            addCriterion("COIN_ROW_ID <>", value, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdGreaterThan(String value) {
            addCriterion("COIN_ROW_ID >", value, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdGreaterThanOrEqualTo(String value) {
            addCriterion("COIN_ROW_ID >=", value, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdLessThan(String value) {
            addCriterion("COIN_ROW_ID <", value, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdLessThanOrEqualTo(String value) {
            addCriterion("COIN_ROW_ID <=", value, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdLike(String value) {
            addCriterion("COIN_ROW_ID like", value, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdNotLike(String value) {
            addCriterion("COIN_ROW_ID not like", value, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdIn(List<String> values) {
            addCriterion("COIN_ROW_ID in", values, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdNotIn(List<String> values) {
            addCriterion("COIN_ROW_ID not in", values, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdBetween(String value1, String value2) {
            addCriterion("COIN_ROW_ID between", value1, value2, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdNotBetween(String value1, String value2) {
            addCriterion("COIN_ROW_ID not between", value1, value2, "coinRowId");
            return (Criteria) this;
        }

        public Criteria andInNumIsNull() {
            addCriterion("IN_NUM is null");
            return (Criteria) this;
        }

        public Criteria andInNumIsNotNull() {
            addCriterion("IN_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andInNumEqualTo(Long value) {
            addCriterion("IN_NUM =", value, "inNum");
            return (Criteria) this;
        }

        public Criteria andInNumNotEqualTo(Long value) {
            addCriterion("IN_NUM <>", value, "inNum");
            return (Criteria) this;
        }

        public Criteria andInNumGreaterThan(Long value) {
            addCriterion("IN_NUM >", value, "inNum");
            return (Criteria) this;
        }

        public Criteria andInNumGreaterThanOrEqualTo(Long value) {
            addCriterion("IN_NUM >=", value, "inNum");
            return (Criteria) this;
        }

        public Criteria andInNumLessThan(Long value) {
            addCriterion("IN_NUM <", value, "inNum");
            return (Criteria) this;
        }

        public Criteria andInNumLessThanOrEqualTo(Long value) {
            addCriterion("IN_NUM <=", value, "inNum");
            return (Criteria) this;
        }

        public Criteria andInNumIn(List<Long> values) {
            addCriterion("IN_NUM in", values, "inNum");
            return (Criteria) this;
        }

        public Criteria andInNumNotIn(List<Long> values) {
            addCriterion("IN_NUM not in", values, "inNum");
            return (Criteria) this;
        }

        public Criteria andInNumBetween(Long value1, Long value2) {
            addCriterion("IN_NUM between", value1, value2, "inNum");
            return (Criteria) this;
        }

        public Criteria andInNumNotBetween(Long value1, Long value2) {
            addCriterion("IN_NUM not between", value1, value2, "inNum");
            return (Criteria) this;
        }

        public Criteria andOutNumIsNull() {
            addCriterion("OUT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andOutNumIsNotNull() {
            addCriterion("OUT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andOutNumEqualTo(Long value) {
            addCriterion("OUT_NUM =", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumNotEqualTo(Long value) {
            addCriterion("OUT_NUM <>", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumGreaterThan(Long value) {
            addCriterion("OUT_NUM >", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumGreaterThanOrEqualTo(Long value) {
            addCriterion("OUT_NUM >=", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumLessThan(Long value) {
            addCriterion("OUT_NUM <", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumLessThanOrEqualTo(Long value) {
            addCriterion("OUT_NUM <=", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumIn(List<Long> values) {
            addCriterion("OUT_NUM in", values, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumNotIn(List<Long> values) {
            addCriterion("OUT_NUM not in", values, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumBetween(Long value1, Long value2) {
            addCriterion("OUT_NUM between", value1, value2, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumNotBetween(Long value1, Long value2) {
            addCriterion("OUT_NUM not between", value1, value2, "outNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumIsNull() {
            addCriterion("CHANGE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andChangeNumIsNotNull() {
            addCriterion("CHANGE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andChangeNumEqualTo(Long value) {
            addCriterion("CHANGE_NUM =", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumNotEqualTo(Long value) {
            addCriterion("CHANGE_NUM <>", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumGreaterThan(Long value) {
            addCriterion("CHANGE_NUM >", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumGreaterThanOrEqualTo(Long value) {
            addCriterion("CHANGE_NUM >=", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumLessThan(Long value) {
            addCriterion("CHANGE_NUM <", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumLessThanOrEqualTo(Long value) {
            addCriterion("CHANGE_NUM <=", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumIn(List<Long> values) {
            addCriterion("CHANGE_NUM in", values, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumNotIn(List<Long> values) {
            addCriterion("CHANGE_NUM not in", values, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumBetween(Long value1, Long value2) {
            addCriterion("CHANGE_NUM between", value1, value2, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumNotBetween(Long value1, Long value2) {
            addCriterion("CHANGE_NUM not between", value1, value2, "changeNum");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNull() {
            addCriterion("LASTUPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNotNull() {
            addCriterion("LASTUPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeEqualTo(Date value) {
            addCriterion("LASTUPDATETIME =", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotEqualTo(Date value) {
            addCriterion("LASTUPDATETIME <>", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThan(Date value) {
            addCriterion("LASTUPDATETIME >", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LASTUPDATETIME >=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThan(Date value) {
            addCriterion("LASTUPDATETIME <", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("LASTUPDATETIME <=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIn(List<Date> values) {
            addCriterion("LASTUPDATETIME in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotIn(List<Date> values) {
            addCriterion("LASTUPDATETIME not in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeBetween(Date value1, Date value2) {
            addCriterion("LASTUPDATETIME between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("LASTUPDATETIME not between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andResettimeIsNull() {
            addCriterion("RESETTIME is null");
            return (Criteria) this;
        }

        public Criteria andResettimeIsNotNull() {
            addCriterion("RESETTIME is not null");
            return (Criteria) this;
        }

        public Criteria andResettimeEqualTo(Date value) {
            addCriterion("RESETTIME =", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeNotEqualTo(Date value) {
            addCriterion("RESETTIME <>", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeGreaterThan(Date value) {
            addCriterion("RESETTIME >", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RESETTIME >=", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeLessThan(Date value) {
            addCriterion("RESETTIME <", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeLessThanOrEqualTo(Date value) {
            addCriterion("RESETTIME <=", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeIn(List<Date> values) {
            addCriterion("RESETTIME in", values, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeNotIn(List<Date> values) {
            addCriterion("RESETTIME not in", values, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeBetween(Date value1, Date value2) {
            addCriterion("RESETTIME between", value1, value2, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeNotBetween(Date value1, Date value2) {
            addCriterion("RESETTIME not between", value1, value2, "resettime");
            return (Criteria) this;
        }

        public Criteria andCoinRowIdLikeInsensitive(String value) {
            addCriterion("upper(COIN_ROW_ID) like", value.toUpperCase(), "coinRowId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated do_not_delete_during_merge Mon Aug 24 14:05:58 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    @Data
    @NoArgsConstructor
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        public Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        public Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        public Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        public Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        public Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}