package onight.zjfae.ordbgens.app.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class APPDictionaryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    protected List<Criteria> oredCriteria;

    protected int offset;

    protected int limit;

    protected String sumCol;

    protected String groupSelClause;

    protected boolean forUpdate;

    protected String groupByClause;

    String selectCols;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public APPDictionaryExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
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
     * This method corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
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
        this.forUpdate=false;
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

    public void setForUpdate(boolean forUpdate) {
         this.forUpdate = forUpdate;
    }

    public boolean isForUpdate() {
          return forUpdate;
    }

    public void setGroupByClause(String groupByClause) {
         this.groupByClause = groupByClause;
    }

    public String getGroupByClause() {
          return groupByClause;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
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

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("UUID like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("UUID not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andKeyNoIsNull() {
            addCriterion("KEY_NO is null");
            return (Criteria) this;
        }

        public Criteria andKeyNoIsNotNull() {
            addCriterion("KEY_NO is not null");
            return (Criteria) this;
        }

        public Criteria andKeyNoEqualTo(String value) {
            addCriterion("KEY_NO =", value, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNoNotEqualTo(String value) {
            addCriterion("KEY_NO <>", value, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNoGreaterThan(String value) {
            addCriterion("KEY_NO >", value, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNoGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_NO >=", value, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNoLessThan(String value) {
            addCriterion("KEY_NO <", value, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNoLessThanOrEqualTo(String value) {
            addCriterion("KEY_NO <=", value, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNoLike(String value) {
            addCriterion("KEY_NO like", value, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNoNotLike(String value) {
            addCriterion("KEY_NO not like", value, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNoIn(List<String> values) {
            addCriterion("KEY_NO in", values, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNoNotIn(List<String> values) {
            addCriterion("KEY_NO not in", values, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNoBetween(String value1, String value2) {
            addCriterion("KEY_NO between", value1, value2, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNoNotBetween(String value1, String value2) {
            addCriterion("KEY_NO not between", value1, value2, "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNameIsNull() {
            addCriterion("KEY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andKeyNameIsNotNull() {
            addCriterion("KEY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andKeyNameEqualTo(String value) {
            addCriterion("KEY_NAME =", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotEqualTo(String value) {
            addCriterion("KEY_NAME <>", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameGreaterThan(String value) {
            addCriterion("KEY_NAME >", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_NAME >=", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameLessThan(String value) {
            addCriterion("KEY_NAME <", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameLessThanOrEqualTo(String value) {
            addCriterion("KEY_NAME <=", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameLike(String value) {
            addCriterion("KEY_NAME like", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotLike(String value) {
            addCriterion("KEY_NAME not like", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameIn(List<String> values) {
            addCriterion("KEY_NAME in", values, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotIn(List<String> values) {
            addCriterion("KEY_NAME not in", values, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameBetween(String value1, String value2) {
            addCriterion("KEY_NAME between", value1, value2, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotBetween(String value1, String value2) {
            addCriterion("KEY_NAME not between", value1, value2, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyCodeIsNull() {
            addCriterion("KEY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andKeyCodeIsNotNull() {
            addCriterion("KEY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andKeyCodeEqualTo(String value) {
            addCriterion("KEY_CODE =", value, "keyCode");
            return (Criteria) this;
        }

        public Criteria andKeyCodeNotEqualTo(String value) {
            addCriterion("KEY_CODE <>", value, "keyCode");
            return (Criteria) this;
        }

        public Criteria andKeyCodeGreaterThan(String value) {
            addCriterion("KEY_CODE >", value, "keyCode");
            return (Criteria) this;
        }

        public Criteria andKeyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_CODE >=", value, "keyCode");
            return (Criteria) this;
        }

        public Criteria andKeyCodeLessThan(String value) {
            addCriterion("KEY_CODE <", value, "keyCode");
            return (Criteria) this;
        }

        public Criteria andKeyCodeLessThanOrEqualTo(String value) {
            addCriterion("KEY_CODE <=", value, "keyCode");
            return (Criteria) this;
        }

        public Criteria andKeyCodeLike(String value) {
            addCriterion("KEY_CODE like", value, "keyCode");
            return (Criteria) this;
        }

        public Criteria andKeyCodeNotLike(String value) {
            addCriterion("KEY_CODE not like", value, "keyCode");
            return (Criteria) this;
        }

        public Criteria andKeyCodeIn(List<String> values) {
            addCriterion("KEY_CODE in", values, "keyCode");
            return (Criteria) this;
        }

        public Criteria andKeyCodeNotIn(List<String> values) {
            addCriterion("KEY_CODE not in", values, "keyCode");
            return (Criteria) this;
        }

        public Criteria andKeyCodeBetween(String value1, String value2) {
            addCriterion("KEY_CODE between", value1, value2, "keyCode");
            return (Criteria) this;
        }

        public Criteria andKeyCodeNotBetween(String value1, String value2) {
            addCriterion("KEY_CODE not between", value1, value2, "keyCode");
            return (Criteria) this;
        }

        public Criteria andDataValueIsNull() {
            addCriterion("DATA_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDataValueIsNotNull() {
            addCriterion("DATA_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDataValueEqualTo(String value) {
            addCriterion("DATA_VALUE =", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueNotEqualTo(String value) {
            addCriterion("DATA_VALUE <>", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueGreaterThan(String value) {
            addCriterion("DATA_VALUE >", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_VALUE >=", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueLessThan(String value) {
            addCriterion("DATA_VALUE <", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueLessThanOrEqualTo(String value) {
            addCriterion("DATA_VALUE <=", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueLike(String value) {
            addCriterion("DATA_VALUE like", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueNotLike(String value) {
            addCriterion("DATA_VALUE not like", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueIn(List<String> values) {
            addCriterion("DATA_VALUE in", values, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueNotIn(List<String> values) {
            addCriterion("DATA_VALUE not in", values, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueBetween(String value1, String value2) {
            addCriterion("DATA_VALUE between", value1, value2, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueNotBetween(String value1, String value2) {
            addCriterion("DATA_VALUE not between", value1, value2, "dataValue");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNull() {
            addCriterion("CRT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNotNull() {
            addCriterion("CRT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeEqualTo(Date value) {
            addCriterion("CRT_TIME =", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotEqualTo(Date value) {
            addCriterion("CRT_TIME <>", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThan(Date value) {
            addCriterion("CRT_TIME >", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME >=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThan(Date value) {
            addCriterion("CRT_TIME <", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME <=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIn(List<Date> values) {
            addCriterion("CRT_TIME in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotIn(List<Date> values) {
            addCriterion("CRT_TIME not in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME not between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNull() {
            addCriterion("UPD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNotNull() {
            addCriterion("UPD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeEqualTo(Date value) {
            addCriterion("UPD_TIME =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Date value) {
            addCriterion("UPD_TIME <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Date value) {
            addCriterion("UPD_TIME >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPD_TIME >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Date value) {
            addCriterion("UPD_TIME <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPD_TIME <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Date> values) {
            addCriterion("UPD_TIME in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Date> values) {
            addCriterion("UPD_TIME not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Date value1, Date value2) {
            addCriterion("UPD_TIME between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPD_TIME not between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andPlatformsIsNull() {
            addCriterion("PLATFORMS is null");
            return (Criteria) this;
        }

        public Criteria andPlatformsIsNotNull() {
            addCriterion("PLATFORMS is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformsEqualTo(String value) {
            addCriterion("PLATFORMS =", value, "platforms");
            return (Criteria) this;
        }

        public Criteria andPlatformsNotEqualTo(String value) {
            addCriterion("PLATFORMS <>", value, "platforms");
            return (Criteria) this;
        }

        public Criteria andPlatformsGreaterThan(String value) {
            addCriterion("PLATFORMS >", value, "platforms");
            return (Criteria) this;
        }

        public Criteria andPlatformsGreaterThanOrEqualTo(String value) {
            addCriterion("PLATFORMS >=", value, "platforms");
            return (Criteria) this;
        }

        public Criteria andPlatformsLessThan(String value) {
            addCriterion("PLATFORMS <", value, "platforms");
            return (Criteria) this;
        }

        public Criteria andPlatformsLessThanOrEqualTo(String value) {
            addCriterion("PLATFORMS <=", value, "platforms");
            return (Criteria) this;
        }

        public Criteria andPlatformsLike(String value) {
            addCriterion("PLATFORMS like", value, "platforms");
            return (Criteria) this;
        }

        public Criteria andPlatformsNotLike(String value) {
            addCriterion("PLATFORMS not like", value, "platforms");
            return (Criteria) this;
        }

        public Criteria andPlatformsIn(List<String> values) {
            addCriterion("PLATFORMS in", values, "platforms");
            return (Criteria) this;
        }

        public Criteria andPlatformsNotIn(List<String> values) {
            addCriterion("PLATFORMS not in", values, "platforms");
            return (Criteria) this;
        }

        public Criteria andPlatformsBetween(String value1, String value2) {
            addCriterion("PLATFORMS between", value1, value2, "platforms");
            return (Criteria) this;
        }

        public Criteria andPlatformsNotBetween(String value1, String value2) {
            addCriterion("PLATFORMS not between", value1, value2, "platforms");
            return (Criteria) this;
        }

        public Criteria andAppVersIsNull() {
            addCriterion("APP_VERS is null");
            return (Criteria) this;
        }

        public Criteria andAppVersIsNotNull() {
            addCriterion("APP_VERS is not null");
            return (Criteria) this;
        }

        public Criteria andAppVersEqualTo(String value) {
            addCriterion("APP_VERS =", value, "appVers");
            return (Criteria) this;
        }

        public Criteria andAppVersNotEqualTo(String value) {
            addCriterion("APP_VERS <>", value, "appVers");
            return (Criteria) this;
        }

        public Criteria andAppVersGreaterThan(String value) {
            addCriterion("APP_VERS >", value, "appVers");
            return (Criteria) this;
        }

        public Criteria andAppVersGreaterThanOrEqualTo(String value) {
            addCriterion("APP_VERS >=", value, "appVers");
            return (Criteria) this;
        }

        public Criteria andAppVersLessThan(String value) {
            addCriterion("APP_VERS <", value, "appVers");
            return (Criteria) this;
        }

        public Criteria andAppVersLessThanOrEqualTo(String value) {
            addCriterion("APP_VERS <=", value, "appVers");
            return (Criteria) this;
        }

        public Criteria andAppVersLike(String value) {
            addCriterion("APP_VERS like", value, "appVers");
            return (Criteria) this;
        }

        public Criteria andAppVersNotLike(String value) {
            addCriterion("APP_VERS not like", value, "appVers");
            return (Criteria) this;
        }

        public Criteria andAppVersIn(List<String> values) {
            addCriterion("APP_VERS in", values, "appVers");
            return (Criteria) this;
        }

        public Criteria andAppVersNotIn(List<String> values) {
            addCriterion("APP_VERS not in", values, "appVers");
            return (Criteria) this;
        }

        public Criteria andAppVersBetween(String value1, String value2) {
            addCriterion("APP_VERS between", value1, value2, "appVers");
            return (Criteria) this;
        }

        public Criteria andAppVersNotBetween(String value1, String value2) {
            addCriterion("APP_VERS not between", value1, value2, "appVers");
            return (Criteria) this;
        }

        public Criteria andTtlIsNull() {
            addCriterion("TTL is null");
            return (Criteria) this;
        }

        public Criteria andTtlIsNotNull() {
            addCriterion("TTL is not null");
            return (Criteria) this;
        }

        public Criteria andTtlEqualTo(Integer value) {
            addCriterion("TTL =", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlNotEqualTo(Integer value) {
            addCriterion("TTL <>", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlGreaterThan(Integer value) {
            addCriterion("TTL >", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlGreaterThanOrEqualTo(Integer value) {
            addCriterion("TTL >=", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlLessThan(Integer value) {
            addCriterion("TTL <", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlLessThanOrEqualTo(Integer value) {
            addCriterion("TTL <=", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlIn(List<Integer> values) {
            addCriterion("TTL in", values, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlNotIn(List<Integer> values) {
            addCriterion("TTL not in", values, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlBetween(Integer value1, Integer value2) {
            addCriterion("TTL between", value1, value2, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlNotBetween(Integer value1, Integer value2) {
            addCriterion("TTL not between", value1, value2, "ttl");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUuidLikeInsensitive(String value) {
            addCriterion("upper(UUID) like", value.toUpperCase(), "uuid");
            return (Criteria) this;
        }

        public Criteria andKeyNoLikeInsensitive(String value) {
            addCriterion("upper(KEY_NO) like", value.toUpperCase(), "keyNo");
            return (Criteria) this;
        }

        public Criteria andKeyNameLikeInsensitive(String value) {
            addCriterion("upper(KEY_NAME) like", value.toUpperCase(), "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyCodeLikeInsensitive(String value) {
            addCriterion("upper(KEY_CODE) like", value.toUpperCase(), "keyCode");
            return (Criteria) this;
        }

        public Criteria andDataValueLikeInsensitive(String value) {
            addCriterion("upper(DATA_VALUE) like", value.toUpperCase(), "dataValue");
            return (Criteria) this;
        }

        public Criteria andPlatformsLikeInsensitive(String value) {
            addCriterion("upper(PLATFORMS) like", value.toUpperCase(), "platforms");
            return (Criteria) this;
        }

        public Criteria andAppVersLikeInsensitive(String value) {
            addCriterion("upper(APP_VERS) like", value.toUpperCase(), "appVers");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated do_not_delete_during_merge Mon May 09 10:59:33 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table APP_DICTIONARY
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
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