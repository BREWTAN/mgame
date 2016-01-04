package onight.act.ordbgens.act.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="T_ACT_FUND")
@AllArgsConstructor
@NoArgsConstructor
public class TActFund extends TActFundKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.ACT_NO
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String actNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.CUST_ID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String custId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.MCHNT_ID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String mchntId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.ACT_TYPE
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String actType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.MNY_SMB
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String mnySmb;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.CATALOG
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String catalog;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.CUR_BAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private BigDecimal curBal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.FREEZE_TOTAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private BigDecimal freezeTotal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.INCOME_TOTAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private BigDecimal incomeTotal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.PAYOUT_TOTAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private BigDecimal payoutTotal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.FOTBID_AMOUNT
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private BigDecimal fotbidAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.FOTBID_FLAG
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String fotbidFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.ACT_STAT
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String actStat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.ACT_BAL_WARN_FLAG
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String actBalWarnFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_FUND.UPDATE_ACT_LOG_ID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String updateActLogId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.ACT_NO
     *
     * @return the value of T_ACT_FUND.ACT_NO
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getActNo() {
        return actNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.ACT_NO
     *
     * @param actNo the value for T_ACT_FUND.ACT_NO
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.CUST_ID
     *
     * @return the value of T_ACT_FUND.CUST_ID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getCustId() {
        return custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.CUST_ID
     *
     * @param custId the value for T_ACT_FUND.CUST_ID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.MCHNT_ID
     *
     * @return the value of T_ACT_FUND.MCHNT_ID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getMchntId() {
        return mchntId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.MCHNT_ID
     *
     * @param mchntId the value for T_ACT_FUND.MCHNT_ID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setMchntId(String mchntId) {
        this.mchntId = mchntId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.ACT_TYPE
     *
     * @return the value of T_ACT_FUND.ACT_TYPE
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getActType() {
        return actType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.ACT_TYPE
     *
     * @param actType the value for T_ACT_FUND.ACT_TYPE
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setActType(String actType) {
        this.actType = actType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.MNY_SMB
     *
     * @return the value of T_ACT_FUND.MNY_SMB
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getMnySmb() {
        return mnySmb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.MNY_SMB
     *
     * @param mnySmb the value for T_ACT_FUND.MNY_SMB
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setMnySmb(String mnySmb) {
        this.mnySmb = mnySmb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.CATALOG
     *
     * @return the value of T_ACT_FUND.CATALOG
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.CATALOG
     *
     * @param catalog the value for T_ACT_FUND.CATALOG
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.CUR_BAL
     *
     * @return the value of T_ACT_FUND.CUR_BAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public BigDecimal getCurBal() {
        return curBal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.CUR_BAL
     *
     * @param curBal the value for T_ACT_FUND.CUR_BAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setCurBal(BigDecimal curBal) {
        this.curBal = curBal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.FREEZE_TOTAL
     *
     * @return the value of T_ACT_FUND.FREEZE_TOTAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public BigDecimal getFreezeTotal() {
        return freezeTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.FREEZE_TOTAL
     *
     * @param freezeTotal the value for T_ACT_FUND.FREEZE_TOTAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setFreezeTotal(BigDecimal freezeTotal) {
        this.freezeTotal = freezeTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.INCOME_TOTAL
     *
     * @return the value of T_ACT_FUND.INCOME_TOTAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public BigDecimal getIncomeTotal() {
        return incomeTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.INCOME_TOTAL
     *
     * @param incomeTotal the value for T_ACT_FUND.INCOME_TOTAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setIncomeTotal(BigDecimal incomeTotal) {
        this.incomeTotal = incomeTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.PAYOUT_TOTAL
     *
     * @return the value of T_ACT_FUND.PAYOUT_TOTAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public BigDecimal getPayoutTotal() {
        return payoutTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.PAYOUT_TOTAL
     *
     * @param payoutTotal the value for T_ACT_FUND.PAYOUT_TOTAL
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setPayoutTotal(BigDecimal payoutTotal) {
        this.payoutTotal = payoutTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.FOTBID_AMOUNT
     *
     * @return the value of T_ACT_FUND.FOTBID_AMOUNT
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public BigDecimal getFotbidAmount() {
        return fotbidAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.FOTBID_AMOUNT
     *
     * @param fotbidAmount the value for T_ACT_FUND.FOTBID_AMOUNT
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setFotbidAmount(BigDecimal fotbidAmount) {
        this.fotbidAmount = fotbidAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.FOTBID_FLAG
     *
     * @return the value of T_ACT_FUND.FOTBID_FLAG
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getFotbidFlag() {
        return fotbidFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.FOTBID_FLAG
     *
     * @param fotbidFlag the value for T_ACT_FUND.FOTBID_FLAG
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setFotbidFlag(String fotbidFlag) {
        this.fotbidFlag = fotbidFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.ACT_STAT
     *
     * @return the value of T_ACT_FUND.ACT_STAT
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getActStat() {
        return actStat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.ACT_STAT
     *
     * @param actStat the value for T_ACT_FUND.ACT_STAT
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setActStat(String actStat) {
        this.actStat = actStat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.ACT_BAL_WARN_FLAG
     *
     * @return the value of T_ACT_FUND.ACT_BAL_WARN_FLAG
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getActBalWarnFlag() {
        return actBalWarnFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.ACT_BAL_WARN_FLAG
     *
     * @param actBalWarnFlag the value for T_ACT_FUND.ACT_BAL_WARN_FLAG
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setActBalWarnFlag(String actBalWarnFlag) {
        this.actBalWarnFlag = actBalWarnFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_FUND.UPDATE_ACT_LOG_ID
     *
     * @return the value of T_ACT_FUND.UPDATE_ACT_LOG_ID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getUpdateActLogId() {
        return updateActLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_FUND.UPDATE_ACT_LOG_ID
     *
     * @param updateActLogId the value for T_ACT_FUND.UPDATE_ACT_LOG_ID
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setUpdateActLogId(String updateActLogId) {
        this.updateActLogId = updateActLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
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
        TActFund other = (TActFund) that;
        return (this.getFundNo() == null ? other.getFundNo() == null : this.getFundNo().equals(other.getFundNo()))
            && (this.getActNo() == null ? other.getActNo() == null : this.getActNo().equals(other.getActNo()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getMchntId() == null ? other.getMchntId() == null : this.getMchntId().equals(other.getMchntId()))
            && (this.getActType() == null ? other.getActType() == null : this.getActType().equals(other.getActType()))
            && (this.getMnySmb() == null ? other.getMnySmb() == null : this.getMnySmb().equals(other.getMnySmb()))
            && (this.getCatalog() == null ? other.getCatalog() == null : this.getCatalog().equals(other.getCatalog()))
            && (this.getCurBal() == null ? other.getCurBal() == null : this.getCurBal().equals(other.getCurBal()))
            && (this.getFreezeTotal() == null ? other.getFreezeTotal() == null : this.getFreezeTotal().equals(other.getFreezeTotal()))
            && (this.getIncomeTotal() == null ? other.getIncomeTotal() == null : this.getIncomeTotal().equals(other.getIncomeTotal()))
            && (this.getPayoutTotal() == null ? other.getPayoutTotal() == null : this.getPayoutTotal().equals(other.getPayoutTotal()))
            && (this.getFotbidAmount() == null ? other.getFotbidAmount() == null : this.getFotbidAmount().equals(other.getFotbidAmount()))
            && (this.getFotbidFlag() == null ? other.getFotbidFlag() == null : this.getFotbidFlag().equals(other.getFotbidFlag()))
            && (this.getActStat() == null ? other.getActStat() == null : this.getActStat().equals(other.getActStat()))
            && (this.getActBalWarnFlag() == null ? other.getActBalWarnFlag() == null : this.getActBalWarnFlag().equals(other.getActBalWarnFlag()))
            && (this.getUpdateActLogId() == null ? other.getUpdateActLogId() == null : this.getUpdateActLogId().equals(other.getUpdateActLogId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFundNo() == null) ? 0 : getFundNo().hashCode());
        result = prime * result + ((getActNo() == null) ? 0 : getActNo().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getMchntId() == null) ? 0 : getMchntId().hashCode());
        result = prime * result + ((getActType() == null) ? 0 : getActType().hashCode());
        result = prime * result + ((getMnySmb() == null) ? 0 : getMnySmb().hashCode());
        result = prime * result + ((getCatalog() == null) ? 0 : getCatalog().hashCode());
        result = prime * result + ((getCurBal() == null) ? 0 : getCurBal().hashCode());
        result = prime * result + ((getFreezeTotal() == null) ? 0 : getFreezeTotal().hashCode());
        result = prime * result + ((getIncomeTotal() == null) ? 0 : getIncomeTotal().hashCode());
        result = prime * result + ((getPayoutTotal() == null) ? 0 : getPayoutTotal().hashCode());
        result = prime * result + ((getFotbidAmount() == null) ? 0 : getFotbidAmount().hashCode());
        result = prime * result + ((getFotbidFlag() == null) ? 0 : getFotbidFlag().hashCode());
        result = prime * result + ((getActStat() == null) ? 0 : getActStat().hashCode());
        result = prime * result + ((getActBalWarnFlag() == null) ? 0 : getActBalWarnFlag().hashCode());
        result = prime * result + ((getUpdateActLogId() == null) ? 0 : getUpdateActLogId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", actNo=").append(actNo);
        sb.append(", custId=").append(custId);
        sb.append(", mchntId=").append(mchntId);
        sb.append(", actType=").append(actType);
        sb.append(", mnySmb=").append(mnySmb);
        sb.append(", catalog=").append(catalog);
        sb.append(", curBal=").append(curBal);
        sb.append(", freezeTotal=").append(freezeTotal);
        sb.append(", incomeTotal=").append(incomeTotal);
        sb.append(", payoutTotal=").append(payoutTotal);
        sb.append(", fotbidAmount=").append(fotbidAmount);
        sb.append(", fotbidFlag=").append(fotbidFlag);
        sb.append(", actStat=").append(actStat);
        sb.append(", actBalWarnFlag=").append(actBalWarnFlag);
        sb.append(", updateActLogId=").append(updateActLogId);
        sb.append("]");
        return sb.toString();
    }
}