package onight.act.ordbgens.act.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TActTradeLogsHisKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_TRADE_LOGS_HIS.LOG_UUID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String logUuid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_TRADE_LOGS_HIS.LOG_UUID
     *
     * @return the value of T_ACT_TRADE_LOGS_HIS.LOG_UUID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getLogUuid() {
        return logUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_TRADE_LOGS_HIS.LOG_UUID
     *
     * @param logUuid the value for T_ACT_TRADE_LOGS_HIS.LOG_UUID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setLogUuid(String logUuid) {
        this.logUuid = logUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRADE_LOGS_HIS
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
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
        TActTradeLogsHisKey other = (TActTradeLogsHisKey) that;
        return (this.getLogUuid() == null ? other.getLogUuid() == null : this.getLogUuid().equals(other.getLogUuid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRADE_LOGS_HIS
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogUuid() == null) ? 0 : getLogUuid().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRADE_LOGS_HIS
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logUuid=").append(logUuid);
        sb.append("]");
        return sb.toString();
    }
}