package onight.zjfae.ordbgens.app.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="APP_SYS_OP_LOGS")
@AllArgsConstructor
@NoArgsConstructor
public class APPSysOpLogs extends APPSysOpLogsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.SKEYS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private String skeys;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.CONTENTS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private String contents;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.LEVEL
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private String level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.OP_ID
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private String opId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.OP_NAME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private String opName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.OP_STARTTIME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private Date opStarttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.OP_ENDTIME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private Date opEndtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.OP_COST_MS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private Integer opCostMs;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.OP_DATE
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private String opDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.OP_IP
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private String opIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.OP_TYPE
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private String opType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_OP_LOGS.CRT_TIME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    private Date crtTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.SKEYS
     *
     * @return the value of APP_SYS_OP_LOGS.SKEYS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public String getSkeys() {
        return skeys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.SKEYS
     *
     * @param skeys the value for APP_SYS_OP_LOGS.SKEYS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setSkeys(String skeys) {
        this.skeys = skeys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.CONTENTS
     *
     * @return the value of APP_SYS_OP_LOGS.CONTENTS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public String getContents() {
        return contents;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.CONTENTS
     *
     * @param contents the value for APP_SYS_OP_LOGS.CONTENTS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.LEVEL
     *
     * @return the value of APP_SYS_OP_LOGS.LEVEL
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.LEVEL
     *
     * @param level the value for APP_SYS_OP_LOGS.LEVEL
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.OP_ID
     *
     * @return the value of APP_SYS_OP_LOGS.OP_ID
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public String getOpId() {
        return opId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.OP_ID
     *
     * @param opId the value for APP_SYS_OP_LOGS.OP_ID
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setOpId(String opId) {
        this.opId = opId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.OP_NAME
     *
     * @return the value of APP_SYS_OP_LOGS.OP_NAME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public String getOpName() {
        return opName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.OP_NAME
     *
     * @param opName the value for APP_SYS_OP_LOGS.OP_NAME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setOpName(String opName) {
        this.opName = opName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.OP_STARTTIME
     *
     * @return the value of APP_SYS_OP_LOGS.OP_STARTTIME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public Date getOpStarttime() {
        return opStarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.OP_STARTTIME
     *
     * @param opStarttime the value for APP_SYS_OP_LOGS.OP_STARTTIME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setOpStarttime(Date opStarttime) {
        this.opStarttime = opStarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.OP_ENDTIME
     *
     * @return the value of APP_SYS_OP_LOGS.OP_ENDTIME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public Date getOpEndtime() {
        return opEndtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.OP_ENDTIME
     *
     * @param opEndtime the value for APP_SYS_OP_LOGS.OP_ENDTIME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setOpEndtime(Date opEndtime) {
        this.opEndtime = opEndtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.OP_COST_MS
     *
     * @return the value of APP_SYS_OP_LOGS.OP_COST_MS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public Integer getOpCostMs() {
        return opCostMs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.OP_COST_MS
     *
     * @param opCostMs the value for APP_SYS_OP_LOGS.OP_COST_MS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setOpCostMs(Integer opCostMs) {
        this.opCostMs = opCostMs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.OP_DATE
     *
     * @return the value of APP_SYS_OP_LOGS.OP_DATE
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public String getOpDate() {
        return opDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.OP_DATE
     *
     * @param opDate the value for APP_SYS_OP_LOGS.OP_DATE
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.OP_IP
     *
     * @return the value of APP_SYS_OP_LOGS.OP_IP
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public String getOpIp() {
        return opIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.OP_IP
     *
     * @param opIp the value for APP_SYS_OP_LOGS.OP_IP
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setOpIp(String opIp) {
        this.opIp = opIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.OP_TYPE
     *
     * @return the value of APP_SYS_OP_LOGS.OP_TYPE
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public String getOpType() {
        return opType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.OP_TYPE
     *
     * @param opType the value for APP_SYS_OP_LOGS.OP_TYPE
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setOpType(String opType) {
        this.opType = opType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_OP_LOGS.CRT_TIME
     *
     * @return the value of APP_SYS_OP_LOGS.CRT_TIME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_OP_LOGS.CRT_TIME
     *
     * @param crtTime the value for APP_SYS_OP_LOGS.CRT_TIME
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_SYS_OP_LOGS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
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
        APPSysOpLogs other = (APPSysOpLogs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSkeys() == null ? other.getSkeys() == null : this.getSkeys().equals(other.getSkeys()))
            && (this.getContents() == null ? other.getContents() == null : this.getContents().equals(other.getContents()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getOpId() == null ? other.getOpId() == null : this.getOpId().equals(other.getOpId()))
            && (this.getOpName() == null ? other.getOpName() == null : this.getOpName().equals(other.getOpName()))
            && (this.getOpStarttime() == null ? other.getOpStarttime() == null : this.getOpStarttime().equals(other.getOpStarttime()))
            && (this.getOpEndtime() == null ? other.getOpEndtime() == null : this.getOpEndtime().equals(other.getOpEndtime()))
            && (this.getOpCostMs() == null ? other.getOpCostMs() == null : this.getOpCostMs().equals(other.getOpCostMs()))
            && (this.getOpDate() == null ? other.getOpDate() == null : this.getOpDate().equals(other.getOpDate()))
            && (this.getOpIp() == null ? other.getOpIp() == null : this.getOpIp().equals(other.getOpIp()))
            && (this.getOpType() == null ? other.getOpType() == null : this.getOpType().equals(other.getOpType()))
            && (this.getCrtTime() == null ? other.getCrtTime() == null : this.getCrtTime().equals(other.getCrtTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_SYS_OP_LOGS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSkeys() == null) ? 0 : getSkeys().hashCode());
        result = prime * result + ((getContents() == null) ? 0 : getContents().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getOpId() == null) ? 0 : getOpId().hashCode());
        result = prime * result + ((getOpName() == null) ? 0 : getOpName().hashCode());
        result = prime * result + ((getOpStarttime() == null) ? 0 : getOpStarttime().hashCode());
        result = prime * result + ((getOpEndtime() == null) ? 0 : getOpEndtime().hashCode());
        result = prime * result + ((getOpCostMs() == null) ? 0 : getOpCostMs().hashCode());
        result = prime * result + ((getOpDate() == null) ? 0 : getOpDate().hashCode());
        result = prime * result + ((getOpIp() == null) ? 0 : getOpIp().hashCode());
        result = prime * result + ((getOpType() == null) ? 0 : getOpType().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_SYS_OP_LOGS
     *
     * @mbggenerated Thu May 26 19:21:32 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", skeys=").append(skeys);
        sb.append(", contents=").append(contents);
        sb.append(", level=").append(level);
        sb.append(", opId=").append(opId);
        sb.append(", opName=").append(opName);
        sb.append(", opStarttime=").append(opStarttime);
        sb.append(", opEndtime=").append(opEndtime);
        sb.append(", opCostMs=").append(opCostMs);
        sb.append(", opDate=").append(opDate);
        sb.append(", opIp=").append(opIp);
        sb.append(", opType=").append(opType);
        sb.append(", crtTime=").append(crtTime);
        sb.append("]");
        return sb.toString();
    }
}