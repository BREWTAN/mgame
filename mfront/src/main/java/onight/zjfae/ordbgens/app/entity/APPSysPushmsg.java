package onight.zjfae.ordbgens.app.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="APP_SYS_PUSHMSG")
@AllArgsConstructor
@NoArgsConstructor
public class APPSysPushmsg extends APPSysPushmsgKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_PUSHMSG.MSG_TITLE
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    private String msgTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_PUSHMSG.SRCID
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    private String srcid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_PUSHMSG.OPERATOR_ID
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    private String operatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_PUSHMSG.CONTENTS
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    private String contents;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_PUSHMSG.STATUS
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_PUSHMSG.TOTAL_SEND_COUNT
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    private Integer totalSendCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_PUSHMSG.RECV_COUNT
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    private Integer recvCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_PUSHMSG.SEND_COUNT
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    private Integer sendCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_PUSHMSG.INSERTTIME
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    private Date inserttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_PUSHMSG.UPDATETIME
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    private Date updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_PUSHMSG.MSG_TITLE
     *
     * @return the value of APP_SYS_PUSHMSG.MSG_TITLE
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public String getMsgTitle() {
        return msgTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_PUSHMSG.MSG_TITLE
     *
     * @param msgTitle the value for APP_SYS_PUSHMSG.MSG_TITLE
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_PUSHMSG.SRCID
     *
     * @return the value of APP_SYS_PUSHMSG.SRCID
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public String getSrcid() {
        return srcid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_PUSHMSG.SRCID
     *
     * @param srcid the value for APP_SYS_PUSHMSG.SRCID
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setSrcid(String srcid) {
        this.srcid = srcid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_PUSHMSG.OPERATOR_ID
     *
     * @return the value of APP_SYS_PUSHMSG.OPERATOR_ID
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_PUSHMSG.OPERATOR_ID
     *
     * @param operatorId the value for APP_SYS_PUSHMSG.OPERATOR_ID
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_PUSHMSG.CONTENTS
     *
     * @return the value of APP_SYS_PUSHMSG.CONTENTS
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public String getContents() {
        return contents;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_PUSHMSG.CONTENTS
     *
     * @param contents the value for APP_SYS_PUSHMSG.CONTENTS
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_PUSHMSG.STATUS
     *
     * @return the value of APP_SYS_PUSHMSG.STATUS
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_PUSHMSG.STATUS
     *
     * @param status the value for APP_SYS_PUSHMSG.STATUS
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_PUSHMSG.TOTAL_SEND_COUNT
     *
     * @return the value of APP_SYS_PUSHMSG.TOTAL_SEND_COUNT
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public Integer getTotalSendCount() {
        return totalSendCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_PUSHMSG.TOTAL_SEND_COUNT
     *
     * @param totalSendCount the value for APP_SYS_PUSHMSG.TOTAL_SEND_COUNT
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setTotalSendCount(Integer totalSendCount) {
        this.totalSendCount = totalSendCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_PUSHMSG.RECV_COUNT
     *
     * @return the value of APP_SYS_PUSHMSG.RECV_COUNT
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public Integer getRecvCount() {
        return recvCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_PUSHMSG.RECV_COUNT
     *
     * @param recvCount the value for APP_SYS_PUSHMSG.RECV_COUNT
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setRecvCount(Integer recvCount) {
        this.recvCount = recvCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_PUSHMSG.SEND_COUNT
     *
     * @return the value of APP_SYS_PUSHMSG.SEND_COUNT
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public Integer getSendCount() {
        return sendCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_PUSHMSG.SEND_COUNT
     *
     * @param sendCount the value for APP_SYS_PUSHMSG.SEND_COUNT
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_PUSHMSG.INSERTTIME
     *
     * @return the value of APP_SYS_PUSHMSG.INSERTTIME
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public Date getInserttime() {
        return inserttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_PUSHMSG.INSERTTIME
     *
     * @param inserttime the value for APP_SYS_PUSHMSG.INSERTTIME
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_PUSHMSG.UPDATETIME
     *
     * @return the value of APP_SYS_PUSHMSG.UPDATETIME
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_PUSHMSG.UPDATETIME
     *
     * @param updatetime the value for APP_SYS_PUSHMSG.UPDATETIME
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_SYS_PUSHMSG
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
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
        APPSysPushmsg other = (APPSysPushmsg) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getMsgTitle() == null ? other.getMsgTitle() == null : this.getMsgTitle().equals(other.getMsgTitle()))
            && (this.getSrcid() == null ? other.getSrcid() == null : this.getSrcid().equals(other.getSrcid()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getContents() == null ? other.getContents() == null : this.getContents().equals(other.getContents()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTotalSendCount() == null ? other.getTotalSendCount() == null : this.getTotalSendCount().equals(other.getTotalSendCount()))
            && (this.getRecvCount() == null ? other.getRecvCount() == null : this.getRecvCount().equals(other.getRecvCount()))
            && (this.getSendCount() == null ? other.getSendCount() == null : this.getSendCount().equals(other.getSendCount()))
            && (this.getInserttime() == null ? other.getInserttime() == null : this.getInserttime().equals(other.getInserttime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_SYS_PUSHMSG
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getMsgTitle() == null) ? 0 : getMsgTitle().hashCode());
        result = prime * result + ((getSrcid() == null) ? 0 : getSrcid().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getContents() == null) ? 0 : getContents().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTotalSendCount() == null) ? 0 : getTotalSendCount().hashCode());
        result = prime * result + ((getRecvCount() == null) ? 0 : getRecvCount().hashCode());
        result = prime * result + ((getSendCount() == null) ? 0 : getSendCount().hashCode());
        result = prime * result + ((getInserttime() == null) ? 0 : getInserttime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_SYS_PUSHMSG
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", msgTitle=").append(msgTitle);
        sb.append(", srcid=").append(srcid);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", contents=").append(contents);
        sb.append(", status=").append(status);
        sb.append(", totalSendCount=").append(totalSendCount);
        sb.append(", recvCount=").append(recvCount);
        sb.append(", sendCount=").append(sendCount);
        sb.append(", inserttime=").append(inserttime);
        sb.append(", updatetime=").append(updatetime);
        sb.append("]");
        return sb.toString();
    }
}