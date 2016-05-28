package onight.zjfae.ordbgens.app.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="APP_IFE_LOG")
@AllArgsConstructor
@NoArgsConstructor
public class APPIfeLog extends APPIfeLogKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.PB_ACTION
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String pbAction;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.REQ_STR
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String reqStr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.RES_STR
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String resStr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.RET_CODE
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String retCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.RET_MSG
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String retMsg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.INSERTTIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private Date inserttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.REQ_TIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private Date reqTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.PROXY_TIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private Date proxyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.RES_TIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private Date resTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.USER_COOKIES
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String userCookies;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.USER_IP
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String userIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.PLATFORM
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String platform;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.CLIENT_OSVER
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String clientOsver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.APP_VERSION
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String appVersion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_LOG.COST_MS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private Integer costMs;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.PB_ACTION
     *
     * @return the value of APP_IFE_LOG.PB_ACTION
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getPbAction() {
        return pbAction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.PB_ACTION
     *
     * @param pbAction the value for APP_IFE_LOG.PB_ACTION
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setPbAction(String pbAction) {
        this.pbAction = pbAction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.REQ_STR
     *
     * @return the value of APP_IFE_LOG.REQ_STR
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getReqStr() {
        return reqStr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.REQ_STR
     *
     * @param reqStr the value for APP_IFE_LOG.REQ_STR
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setReqStr(String reqStr) {
        this.reqStr = reqStr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.RES_STR
     *
     * @return the value of APP_IFE_LOG.RES_STR
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getResStr() {
        return resStr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.RES_STR
     *
     * @param resStr the value for APP_IFE_LOG.RES_STR
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setResStr(String resStr) {
        this.resStr = resStr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.RET_CODE
     *
     * @return the value of APP_IFE_LOG.RET_CODE
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getRetCode() {
        return retCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.RET_CODE
     *
     * @param retCode the value for APP_IFE_LOG.RET_CODE
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.RET_MSG
     *
     * @return the value of APP_IFE_LOG.RET_MSG
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getRetMsg() {
        return retMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.RET_MSG
     *
     * @param retMsg the value for APP_IFE_LOG.RET_MSG
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.INSERTTIME
     *
     * @return the value of APP_IFE_LOG.INSERTTIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public Date getInserttime() {
        return inserttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.INSERTTIME
     *
     * @param inserttime the value for APP_IFE_LOG.INSERTTIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.REQ_TIME
     *
     * @return the value of APP_IFE_LOG.REQ_TIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public Date getReqTime() {
        return reqTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.REQ_TIME
     *
     * @param reqTime the value for APP_IFE_LOG.REQ_TIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.PROXY_TIME
     *
     * @return the value of APP_IFE_LOG.PROXY_TIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public Date getProxyTime() {
        return proxyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.PROXY_TIME
     *
     * @param proxyTime the value for APP_IFE_LOG.PROXY_TIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setProxyTime(Date proxyTime) {
        this.proxyTime = proxyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.RES_TIME
     *
     * @return the value of APP_IFE_LOG.RES_TIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public Date getResTime() {
        return resTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.RES_TIME
     *
     * @param resTime the value for APP_IFE_LOG.RES_TIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setResTime(Date resTime) {
        this.resTime = resTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.USER_COOKIES
     *
     * @return the value of APP_IFE_LOG.USER_COOKIES
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getUserCookies() {
        return userCookies;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.USER_COOKIES
     *
     * @param userCookies the value for APP_IFE_LOG.USER_COOKIES
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setUserCookies(String userCookies) {
        this.userCookies = userCookies;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.USER_IP
     *
     * @return the value of APP_IFE_LOG.USER_IP
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.USER_IP
     *
     * @param userIp the value for APP_IFE_LOG.USER_IP
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.PLATFORM
     *
     * @return the value of APP_IFE_LOG.PLATFORM
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.PLATFORM
     *
     * @param platform the value for APP_IFE_LOG.PLATFORM
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.CLIENT_OSVER
     *
     * @return the value of APP_IFE_LOG.CLIENT_OSVER
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getClientOsver() {
        return clientOsver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.CLIENT_OSVER
     *
     * @param clientOsver the value for APP_IFE_LOG.CLIENT_OSVER
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setClientOsver(String clientOsver) {
        this.clientOsver = clientOsver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.APP_VERSION
     *
     * @return the value of APP_IFE_LOG.APP_VERSION
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getAppVersion() {
        return appVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.APP_VERSION
     *
     * @param appVersion the value for APP_IFE_LOG.APP_VERSION
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_LOG.COST_MS
     *
     * @return the value of APP_IFE_LOG.COST_MS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public Integer getCostMs() {
        return costMs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_LOG.COST_MS
     *
     * @param costMs the value for APP_IFE_LOG.COST_MS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setCostMs(Integer costMs) {
        this.costMs = costMs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_IFE_LOG
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
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
        APPIfeLog other = (APPIfeLog) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getPbAction() == null ? other.getPbAction() == null : this.getPbAction().equals(other.getPbAction()))
            && (this.getReqStr() == null ? other.getReqStr() == null : this.getReqStr().equals(other.getReqStr()))
            && (this.getResStr() == null ? other.getResStr() == null : this.getResStr().equals(other.getResStr()))
            && (this.getRetCode() == null ? other.getRetCode() == null : this.getRetCode().equals(other.getRetCode()))
            && (this.getRetMsg() == null ? other.getRetMsg() == null : this.getRetMsg().equals(other.getRetMsg()))
            && (this.getInserttime() == null ? other.getInserttime() == null : this.getInserttime().equals(other.getInserttime()))
            && (this.getReqTime() == null ? other.getReqTime() == null : this.getReqTime().equals(other.getReqTime()))
            && (this.getProxyTime() == null ? other.getProxyTime() == null : this.getProxyTime().equals(other.getProxyTime()))
            && (this.getResTime() == null ? other.getResTime() == null : this.getResTime().equals(other.getResTime()))
            && (this.getUserCookies() == null ? other.getUserCookies() == null : this.getUserCookies().equals(other.getUserCookies()))
            && (this.getUserIp() == null ? other.getUserIp() == null : this.getUserIp().equals(other.getUserIp()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getClientOsver() == null ? other.getClientOsver() == null : this.getClientOsver().equals(other.getClientOsver()))
            && (this.getAppVersion() == null ? other.getAppVersion() == null : this.getAppVersion().equals(other.getAppVersion()))
            && (this.getCostMs() == null ? other.getCostMs() == null : this.getCostMs().equals(other.getCostMs()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_IFE_LOG
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getPbAction() == null) ? 0 : getPbAction().hashCode());
        result = prime * result + ((getReqStr() == null) ? 0 : getReqStr().hashCode());
        result = prime * result + ((getResStr() == null) ? 0 : getResStr().hashCode());
        result = prime * result + ((getRetCode() == null) ? 0 : getRetCode().hashCode());
        result = prime * result + ((getRetMsg() == null) ? 0 : getRetMsg().hashCode());
        result = prime * result + ((getInserttime() == null) ? 0 : getInserttime().hashCode());
        result = prime * result + ((getReqTime() == null) ? 0 : getReqTime().hashCode());
        result = prime * result + ((getProxyTime() == null) ? 0 : getProxyTime().hashCode());
        result = prime * result + ((getResTime() == null) ? 0 : getResTime().hashCode());
        result = prime * result + ((getUserCookies() == null) ? 0 : getUserCookies().hashCode());
        result = prime * result + ((getUserIp() == null) ? 0 : getUserIp().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getClientOsver() == null) ? 0 : getClientOsver().hashCode());
        result = prime * result + ((getAppVersion() == null) ? 0 : getAppVersion().hashCode());
        result = prime * result + ((getCostMs() == null) ? 0 : getCostMs().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_IFE_LOG
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pbAction=").append(pbAction);
        sb.append(", reqStr=").append(reqStr);
        sb.append(", resStr=").append(resStr);
        sb.append(", retCode=").append(retCode);
        sb.append(", retMsg=").append(retMsg);
        sb.append(", inserttime=").append(inserttime);
        sb.append(", reqTime=").append(reqTime);
        sb.append(", proxyTime=").append(proxyTime);
        sb.append(", resTime=").append(resTime);
        sb.append(", userCookies=").append(userCookies);
        sb.append(", userIp=").append(userIp);
        sb.append(", platform=").append(platform);
        sb.append(", clientOsver=").append(clientOsver);
        sb.append(", appVersion=").append(appVersion);
        sb.append(", costMs=").append(costMs);
        sb.append("]");
        return sb.toString();
    }
}