package onight.tfg.ordbgens.tfc.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.CustomDateSerializer;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFC_USE_LOCK_DETAIL")
@AllArgsConstructor
@NoArgsConstructor
public class TFCUseLockDetail extends TFCUseLockDetailKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.COIN_TYPE_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private String coinTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.REC_TIME
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private Date recTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.ACTIONTYPE
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private Integer actiontype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.LOCK_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private String lockId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.USER_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.SERVER_IP
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private String serverIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.GAME_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private String gameId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.SERVER_NAME
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private String serverName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.LOCK_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private Long lockNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.CHANGE_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private Long changeNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.REMAIN_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private Long remainNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USE_LOCK_DETAIL.OTHER_LOCK_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private Long otherLockNum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.COIN_TYPE_ID
     *
     * @return the value of TFC_USE_LOCK_DETAIL.COIN_TYPE_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public String getCoinTypeId() {
        return coinTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.COIN_TYPE_ID
     *
     * @param coinTypeId the value for TFC_USE_LOCK_DETAIL.COIN_TYPE_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setCoinTypeId(String coinTypeId) {
        this.coinTypeId = coinTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.REC_TIME
     *
     * @return the value of TFC_USE_LOCK_DETAIL.REC_TIME
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getRecTime() {
        return recTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.REC_TIME
     *
     * @param recTime the value for TFC_USE_LOCK_DETAIL.REC_TIME
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setRecTime(Date recTime) {
        this.recTime = recTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.ACTIONTYPE
     *
     * @return the value of TFC_USE_LOCK_DETAIL.ACTIONTYPE
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public Integer getActiontype() {
        return actiontype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.ACTIONTYPE
     *
     * @param actiontype the value for TFC_USE_LOCK_DETAIL.ACTIONTYPE
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setActiontype(Integer actiontype) {
        this.actiontype = actiontype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.LOCK_ID
     *
     * @return the value of TFC_USE_LOCK_DETAIL.LOCK_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public String getLockId() {
        return lockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.LOCK_ID
     *
     * @param lockId the value for TFC_USE_LOCK_DETAIL.LOCK_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.USER_ID
     *
     * @return the value of TFC_USE_LOCK_DETAIL.USER_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.USER_ID
     *
     * @param userId the value for TFC_USE_LOCK_DETAIL.USER_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.SERVER_IP
     *
     * @return the value of TFC_USE_LOCK_DETAIL.SERVER_IP
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.SERVER_IP
     *
     * @param serverIp the value for TFC_USE_LOCK_DETAIL.SERVER_IP
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.GAME_ID
     *
     * @return the value of TFC_USE_LOCK_DETAIL.GAME_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.GAME_ID
     *
     * @param gameId the value for TFC_USE_LOCK_DETAIL.GAME_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.SERVER_NAME
     *
     * @return the value of TFC_USE_LOCK_DETAIL.SERVER_NAME
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.SERVER_NAME
     *
     * @param serverName the value for TFC_USE_LOCK_DETAIL.SERVER_NAME
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.LOCK_NUM
     *
     * @return the value of TFC_USE_LOCK_DETAIL.LOCK_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public Long getLockNum() {
        return lockNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.LOCK_NUM
     *
     * @param lockNum the value for TFC_USE_LOCK_DETAIL.LOCK_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setLockNum(Long lockNum) {
        this.lockNum = lockNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.CHANGE_NUM
     *
     * @return the value of TFC_USE_LOCK_DETAIL.CHANGE_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public Long getChangeNum() {
        return changeNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.CHANGE_NUM
     *
     * @param changeNum the value for TFC_USE_LOCK_DETAIL.CHANGE_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setChangeNum(Long changeNum) {
        this.changeNum = changeNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.REMAIN_NUM
     *
     * @return the value of TFC_USE_LOCK_DETAIL.REMAIN_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public Long getRemainNum() {
        return remainNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.REMAIN_NUM
     *
     * @param remainNum the value for TFC_USE_LOCK_DETAIL.REMAIN_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setRemainNum(Long remainNum) {
        this.remainNum = remainNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USE_LOCK_DETAIL.OTHER_LOCK_NUM
     *
     * @return the value of TFC_USE_LOCK_DETAIL.OTHER_LOCK_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public Long getOtherLockNum() {
        return otherLockNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USE_LOCK_DETAIL.OTHER_LOCK_NUM
     *
     * @param otherLockNum the value for TFC_USE_LOCK_DETAIL.OTHER_LOCK_NUM
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setOtherLockNum(Long otherLockNum) {
        this.otherLockNum = otherLockNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USE_LOCK_DETAIL
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
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
        TFCUseLockDetail other = (TFCUseLockDetail) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getCoinTypeId() == null ? other.getCoinTypeId() == null : this.getCoinTypeId().equals(other.getCoinTypeId()))
            && (this.getRecTime() == null ? other.getRecTime() == null : this.getRecTime().equals(other.getRecTime()))
            && (this.getActiontype() == null ? other.getActiontype() == null : this.getActiontype().equals(other.getActiontype()))
            && (this.getLockId() == null ? other.getLockId() == null : this.getLockId().equals(other.getLockId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getServerIp() == null ? other.getServerIp() == null : this.getServerIp().equals(other.getServerIp()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getServerName() == null ? other.getServerName() == null : this.getServerName().equals(other.getServerName()))
            && (this.getLockNum() == null ? other.getLockNum() == null : this.getLockNum().equals(other.getLockNum()))
            && (this.getChangeNum() == null ? other.getChangeNum() == null : this.getChangeNum().equals(other.getChangeNum()))
            && (this.getRemainNum() == null ? other.getRemainNum() == null : this.getRemainNum().equals(other.getRemainNum()))
            && (this.getOtherLockNum() == null ? other.getOtherLockNum() == null : this.getOtherLockNum().equals(other.getOtherLockNum()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USE_LOCK_DETAIL
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRowId() == null) ? 0 : getRowId().hashCode());
        result = prime * result + ((getCoinTypeId() == null) ? 0 : getCoinTypeId().hashCode());
        result = prime * result + ((getRecTime() == null) ? 0 : getRecTime().hashCode());
        result = prime * result + ((getActiontype() == null) ? 0 : getActiontype().hashCode());
        result = prime * result + ((getLockId() == null) ? 0 : getLockId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getServerIp() == null) ? 0 : getServerIp().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getServerName() == null) ? 0 : getServerName().hashCode());
        result = prime * result + ((getLockNum() == null) ? 0 : getLockNum().hashCode());
        result = prime * result + ((getChangeNum() == null) ? 0 : getChangeNum().hashCode());
        result = prime * result + ((getRemainNum() == null) ? 0 : getRemainNum().hashCode());
        result = prime * result + ((getOtherLockNum() == null) ? 0 : getOtherLockNum().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USE_LOCK_DETAIL
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", coinTypeId=").append(coinTypeId);
        sb.append(", recTime=").append(recTime);
        sb.append(", actiontype=").append(actiontype);
        sb.append(", lockId=").append(lockId);
        sb.append(", userId=").append(userId);
        sb.append(", serverIp=").append(serverIp);
        sb.append(", gameId=").append(gameId);
        sb.append(", serverName=").append(serverName);
        sb.append(", lockNum=").append(lockNum);
        sb.append(", changeNum=").append(changeNum);
        sb.append(", remainNum=").append(remainNum);
        sb.append(", otherLockNum=").append(otherLockNum);
        sb.append("]");
        return sb.toString();
    }
}