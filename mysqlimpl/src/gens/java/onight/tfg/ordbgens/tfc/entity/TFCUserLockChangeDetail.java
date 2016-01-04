package onight.tfg.ordbgens.tfc.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFC_USER_LOCK_CHANGE_DETAIL")
@AllArgsConstructor
@NoArgsConstructor
public class TFCUserLockChangeDetail extends TFCUserLockChangeDetailKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.COIN_TYPE_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private String coinTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.REC_TIME
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private Date recTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.LOCK_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private String lockId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.USER_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.CHANGE_NUM
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private Long changeNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.LOCKED_NUM
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private Long lockedNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.CHANNEL_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private String channelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.PRODUCT_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private String productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.FLOW_NUMBER
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private String flowNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.USER_IP
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private String userIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.SERVER_IP
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private String serverIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK_CHANGE_DETAIL.GAME_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    private String gameId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.COIN_TYPE_ID
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.COIN_TYPE_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String getCoinTypeId() {
        return coinTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.COIN_TYPE_ID
     *
     * @param coinTypeId the value for TFC_USER_LOCK_CHANGE_DETAIL.COIN_TYPE_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setCoinTypeId(String coinTypeId) {
        this.coinTypeId = coinTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.REC_TIME
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.REC_TIME
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public Date getRecTime() {
        return recTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.REC_TIME
     *
     * @param recTime the value for TFC_USER_LOCK_CHANGE_DETAIL.REC_TIME
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setRecTime(Date recTime) {
        this.recTime = recTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.LOCK_ID
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.LOCK_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String getLockId() {
        return lockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.LOCK_ID
     *
     * @param lockId the value for TFC_USER_LOCK_CHANGE_DETAIL.LOCK_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.USER_ID
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.USER_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.USER_ID
     *
     * @param userId the value for TFC_USER_LOCK_CHANGE_DETAIL.USER_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.CHANGE_NUM
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.CHANGE_NUM
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public Long getChangeNum() {
        return changeNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.CHANGE_NUM
     *
     * @param changeNum the value for TFC_USER_LOCK_CHANGE_DETAIL.CHANGE_NUM
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setChangeNum(Long changeNum) {
        this.changeNum = changeNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.LOCKED_NUM
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.LOCKED_NUM
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public Long getLockedNum() {
        return lockedNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.LOCKED_NUM
     *
     * @param lockedNum the value for TFC_USER_LOCK_CHANGE_DETAIL.LOCKED_NUM
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setLockedNum(Long lockedNum) {
        this.lockedNum = lockedNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.CHANNEL_ID
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.CHANNEL_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.CHANNEL_ID
     *
     * @param channelId the value for TFC_USER_LOCK_CHANGE_DETAIL.CHANNEL_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.PRODUCT_ID
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.PRODUCT_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.PRODUCT_ID
     *
     * @param productId the value for TFC_USER_LOCK_CHANGE_DETAIL.PRODUCT_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.FLOW_NUMBER
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.FLOW_NUMBER
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String getFlowNumber() {
        return flowNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.FLOW_NUMBER
     *
     * @param flowNumber the value for TFC_USER_LOCK_CHANGE_DETAIL.FLOW_NUMBER
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setFlowNumber(String flowNumber) {
        this.flowNumber = flowNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.USER_IP
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.USER_IP
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.USER_IP
     *
     * @param userIp the value for TFC_USER_LOCK_CHANGE_DETAIL.USER_IP
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.SERVER_IP
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.SERVER_IP
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.SERVER_IP
     *
     * @param serverIp the value for TFC_USER_LOCK_CHANGE_DETAIL.SERVER_IP
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.GAME_ID
     *
     * @return the value of TFC_USER_LOCK_CHANGE_DETAIL.GAME_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK_CHANGE_DETAIL.GAME_ID
     *
     * @param gameId the value for TFC_USER_LOCK_CHANGE_DETAIL.GAME_ID
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
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
        TFCUserLockChangeDetail other = (TFCUserLockChangeDetail) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getCoinTypeId() == null ? other.getCoinTypeId() == null : this.getCoinTypeId().equals(other.getCoinTypeId()))
            && (this.getRecTime() == null ? other.getRecTime() == null : this.getRecTime().equals(other.getRecTime()))
            && (this.getLockId() == null ? other.getLockId() == null : this.getLockId().equals(other.getLockId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getChangeNum() == null ? other.getChangeNum() == null : this.getChangeNum().equals(other.getChangeNum()))
            && (this.getLockedNum() == null ? other.getLockedNum() == null : this.getLockedNum().equals(other.getLockedNum()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getFlowNumber() == null ? other.getFlowNumber() == null : this.getFlowNumber().equals(other.getFlowNumber()))
            && (this.getUserIp() == null ? other.getUserIp() == null : this.getUserIp().equals(other.getUserIp()))
            && (this.getServerIp() == null ? other.getServerIp() == null : this.getServerIp().equals(other.getServerIp()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRowId() == null) ? 0 : getRowId().hashCode());
        result = prime * result + ((getCoinTypeId() == null) ? 0 : getCoinTypeId().hashCode());
        result = prime * result + ((getRecTime() == null) ? 0 : getRecTime().hashCode());
        result = prime * result + ((getLockId() == null) ? 0 : getLockId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getChangeNum() == null) ? 0 : getChangeNum().hashCode());
        result = prime * result + ((getLockedNum() == null) ? 0 : getLockedNum().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getFlowNumber() == null) ? 0 : getFlowNumber().hashCode());
        result = prime * result + ((getUserIp() == null) ? 0 : getUserIp().hashCode());
        result = prime * result + ((getServerIp() == null) ? 0 : getServerIp().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Wed Dec 16 19:48:42 CST 2015
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", coinTypeId=").append(coinTypeId);
        sb.append(", recTime=").append(recTime);
        sb.append(", lockId=").append(lockId);
        sb.append(", userId=").append(userId);
        sb.append(", changeNum=").append(changeNum);
        sb.append(", lockedNum=").append(lockedNum);
        sb.append(", channelId=").append(channelId);
        sb.append(", productId=").append(productId);
        sb.append(", flowNumber=").append(flowNumber);
        sb.append(", userIp=").append(userIp);
        sb.append(", serverIp=").append(serverIp);
        sb.append(", gameId=").append(gameId);
        sb.append("]");
        return sb.toString();
    }
}