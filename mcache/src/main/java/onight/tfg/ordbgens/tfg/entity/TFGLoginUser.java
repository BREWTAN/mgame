package onight.tfg.ordbgens.tfg.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.CustomDateSerializer;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFG_LOGIN_USER")
@AllArgsConstructor
@NoArgsConstructor
public class TFGLoginUser extends TFGLoginUserKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.LOGIN_ID
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private String loginId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.NICKNAME
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.EMAIL
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.MOBILE
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.THIRD_LOGINID1
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private String thirdLoginid1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.THIRD_LOGINID2
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private String thirdLoginid2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.REG_TYPE
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private String regType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.STATUS
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.PASSWORD
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.TRADE_PASSWORD
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private String tradePassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.UPDATE_TIME
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.CREATE_TIME
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.LOGIN_ID
     *
     * @return the value of TFG_LOGIN_USER.LOGIN_ID
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.LOGIN_ID
     *
     * @param loginId the value for TFG_LOGIN_USER.LOGIN_ID
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.NICKNAME
     *
     * @return the value of TFG_LOGIN_USER.NICKNAME
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.NICKNAME
     *
     * @param nickname the value for TFG_LOGIN_USER.NICKNAME
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.EMAIL
     *
     * @return the value of TFG_LOGIN_USER.EMAIL
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.EMAIL
     *
     * @param email the value for TFG_LOGIN_USER.EMAIL
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.MOBILE
     *
     * @return the value of TFG_LOGIN_USER.MOBILE
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.MOBILE
     *
     * @param mobile the value for TFG_LOGIN_USER.MOBILE
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.THIRD_LOGINID1
     *
     * @return the value of TFG_LOGIN_USER.THIRD_LOGINID1
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public String getThirdLoginid1() {
        return thirdLoginid1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.THIRD_LOGINID1
     *
     * @param thirdLoginid1 the value for TFG_LOGIN_USER.THIRD_LOGINID1
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setThirdLoginid1(String thirdLoginid1) {
        this.thirdLoginid1 = thirdLoginid1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.THIRD_LOGINID2
     *
     * @return the value of TFG_LOGIN_USER.THIRD_LOGINID2
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public String getThirdLoginid2() {
        return thirdLoginid2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.THIRD_LOGINID2
     *
     * @param thirdLoginid2 the value for TFG_LOGIN_USER.THIRD_LOGINID2
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setThirdLoginid2(String thirdLoginid2) {
        this.thirdLoginid2 = thirdLoginid2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.REG_TYPE
     *
     * @return the value of TFG_LOGIN_USER.REG_TYPE
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public String getRegType() {
        return regType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.REG_TYPE
     *
     * @param regType the value for TFG_LOGIN_USER.REG_TYPE
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setRegType(String regType) {
        this.regType = regType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.STATUS
     *
     * @return the value of TFG_LOGIN_USER.STATUS
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.STATUS
     *
     * @param status the value for TFG_LOGIN_USER.STATUS
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.PASSWORD
     *
     * @return the value of TFG_LOGIN_USER.PASSWORD
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.PASSWORD
     *
     * @param password the value for TFG_LOGIN_USER.PASSWORD
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.TRADE_PASSWORD
     *
     * @return the value of TFG_LOGIN_USER.TRADE_PASSWORD
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public String getTradePassword() {
        return tradePassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.TRADE_PASSWORD
     *
     * @param tradePassword the value for TFG_LOGIN_USER.TRADE_PASSWORD
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.UPDATE_TIME
     *
     * @return the value of TFG_LOGIN_USER.UPDATE_TIME
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.UPDATE_TIME
     *
     * @param updateTime the value for TFG_LOGIN_USER.UPDATE_TIME
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.CREATE_TIME
     *
     * @return the value of TFG_LOGIN_USER.CREATE_TIME
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.CREATE_TIME
     *
     * @param createTime the value for TFG_LOGIN_USER.CREATE_TIME
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TFGLoginUser other = (TFGLoginUser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLoginId() == null ? other.getLoginId() == null : this.getLoginId().equals(other.getLoginId()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getThirdLoginid1() == null ? other.getThirdLoginid1() == null : this.getThirdLoginid1().equals(other.getThirdLoginid1()))
            && (this.getThirdLoginid2() == null ? other.getThirdLoginid2() == null : this.getThirdLoginid2().equals(other.getThirdLoginid2()))
            && (this.getRegType() == null ? other.getRegType() == null : this.getRegType().equals(other.getRegType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getTradePassword() == null ? other.getTradePassword() == null : this.getTradePassword().equals(other.getTradePassword()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLoginId() == null) ? 0 : getLoginId().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getThirdLoginid1() == null) ? 0 : getThirdLoginid1().hashCode());
        result = prime * result + ((getThirdLoginid2() == null) ? 0 : getThirdLoginid2().hashCode());
        result = prime * result + ((getRegType() == null) ? 0 : getRegType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getTradePassword() == null) ? 0 : getTradePassword().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loginId=").append(loginId);
        sb.append(", nickname=").append(nickname);
        sb.append(", email=").append(email);
        sb.append(", mobile=").append(mobile);
        sb.append(", thirdLoginid1=").append(thirdLoginid1);
        sb.append(", thirdLoginid2=").append(thirdLoginid2);
        sb.append(", regType=").append(regType);
        sb.append(", status=").append(status);
        sb.append(", password=").append(password);
        sb.append(", tradePassword=").append(tradePassword);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}