package onight.zjfae.ordbgens.app.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="APP_SYS_BRANCH")
@AllArgsConstructor
@NoArgsConstructor
public class APPSysBranch extends APPSysBranchKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_BRANCH.BRANCH_DESC
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    private String branchDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_BRANCH.BRANCH_NAME
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    private String branchName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_BRANCH.BRANCH_MANAGER
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    private String branchManager;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_BRANCH.MOBILE
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_BRANCH.BEGIN_TIME
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    private Date beginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_BRANCH.END_TIME
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_BRANCH.PARENT_ID
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_BRANCH.LEAF_FLAG
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    private Integer leafFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_BRANCH.BRANCH_SEQ
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    private Integer branchSeq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SYS_BRANCH.LEVEL
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    private Integer level;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_BRANCH.BRANCH_DESC
     *
     * @return the value of APP_SYS_BRANCH.BRANCH_DESC
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public String getBranchDesc() {
        return branchDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_BRANCH.BRANCH_DESC
     *
     * @param branchDesc the value for APP_SYS_BRANCH.BRANCH_DESC
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public void setBranchDesc(String branchDesc) {
        this.branchDesc = branchDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_BRANCH.BRANCH_NAME
     *
     * @return the value of APP_SYS_BRANCH.BRANCH_NAME
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_BRANCH.BRANCH_NAME
     *
     * @param branchName the value for APP_SYS_BRANCH.BRANCH_NAME
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_BRANCH.BRANCH_MANAGER
     *
     * @return the value of APP_SYS_BRANCH.BRANCH_MANAGER
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public String getBranchManager() {
        return branchManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_BRANCH.BRANCH_MANAGER
     *
     * @param branchManager the value for APP_SYS_BRANCH.BRANCH_MANAGER
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public void setBranchManager(String branchManager) {
        this.branchManager = branchManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_BRANCH.MOBILE
     *
     * @return the value of APP_SYS_BRANCH.MOBILE
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_BRANCH.MOBILE
     *
     * @param mobile the value for APP_SYS_BRANCH.MOBILE
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_BRANCH.BEGIN_TIME
     *
     * @return the value of APP_SYS_BRANCH.BEGIN_TIME
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_BRANCH.BEGIN_TIME
     *
     * @param beginTime the value for APP_SYS_BRANCH.BEGIN_TIME
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_BRANCH.END_TIME
     *
     * @return the value of APP_SYS_BRANCH.END_TIME
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_BRANCH.END_TIME
     *
     * @param endTime the value for APP_SYS_BRANCH.END_TIME
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_BRANCH.PARENT_ID
     *
     * @return the value of APP_SYS_BRANCH.PARENT_ID
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_BRANCH.PARENT_ID
     *
     * @param parentId the value for APP_SYS_BRANCH.PARENT_ID
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_BRANCH.LEAF_FLAG
     *
     * @return the value of APP_SYS_BRANCH.LEAF_FLAG
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public Integer getLeafFlag() {
        return leafFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_BRANCH.LEAF_FLAG
     *
     * @param leafFlag the value for APP_SYS_BRANCH.LEAF_FLAG
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public void setLeafFlag(Integer leafFlag) {
        this.leafFlag = leafFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_BRANCH.BRANCH_SEQ
     *
     * @return the value of APP_SYS_BRANCH.BRANCH_SEQ
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public Integer getBranchSeq() {
        return branchSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_BRANCH.BRANCH_SEQ
     *
     * @param branchSeq the value for APP_SYS_BRANCH.BRANCH_SEQ
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public void setBranchSeq(Integer branchSeq) {
        this.branchSeq = branchSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SYS_BRANCH.LEVEL
     *
     * @return the value of APP_SYS_BRANCH.LEVEL
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SYS_BRANCH.LEVEL
     *
     * @param level the value for APP_SYS_BRANCH.LEVEL
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_SYS_BRANCH
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
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
        APPSysBranch other = (APPSysBranch) that;
        return (this.getBranchId() == null ? other.getBranchId() == null : this.getBranchId().equals(other.getBranchId()))
            && (this.getBranchDesc() == null ? other.getBranchDesc() == null : this.getBranchDesc().equals(other.getBranchDesc()))
            && (this.getBranchName() == null ? other.getBranchName() == null : this.getBranchName().equals(other.getBranchName()))
            && (this.getBranchManager() == null ? other.getBranchManager() == null : this.getBranchManager().equals(other.getBranchManager()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getLeafFlag() == null ? other.getLeafFlag() == null : this.getLeafFlag().equals(other.getLeafFlag()))
            && (this.getBranchSeq() == null ? other.getBranchSeq() == null : this.getBranchSeq().equals(other.getBranchSeq()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_SYS_BRANCH
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBranchId() == null) ? 0 : getBranchId().hashCode());
        result = prime * result + ((getBranchDesc() == null) ? 0 : getBranchDesc().hashCode());
        result = prime * result + ((getBranchName() == null) ? 0 : getBranchName().hashCode());
        result = prime * result + ((getBranchManager() == null) ? 0 : getBranchManager().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getLeafFlag() == null) ? 0 : getLeafFlag().hashCode());
        result = prime * result + ((getBranchSeq() == null) ? 0 : getBranchSeq().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_SYS_BRANCH
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", branchDesc=").append(branchDesc);
        sb.append(", branchName=").append(branchName);
        sb.append(", branchManager=").append(branchManager);
        sb.append(", mobile=").append(mobile);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", parentId=").append(parentId);
        sb.append(", leafFlag=").append(leafFlag);
        sb.append(", branchSeq=").append(branchSeq);
        sb.append(", level=").append(level);
        sb.append("]");
        return sb.toString();
    }
}