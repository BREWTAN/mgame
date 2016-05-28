package onight.zjfae.ordbgens.app.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="APP_IFE_MATCH")
@AllArgsConstructor
@NoArgsConstructor
public class APPIfeMatch extends APPIfeMatchKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_MATCH.PB_ACTION
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String pbAction;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_IFE_MATCH.STATUS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_MATCH.PB_ACTION
     *
     * @return the value of APP_IFE_MATCH.PB_ACTION
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getPbAction() {
        return pbAction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_MATCH.PB_ACTION
     *
     * @param pbAction the value for APP_IFE_MATCH.PB_ACTION
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setPbAction(String pbAction) {
        this.pbAction = pbAction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_IFE_MATCH.STATUS
     *
     * @return the value of APP_IFE_MATCH.STATUS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_IFE_MATCH.STATUS
     *
     * @param status the value for APP_IFE_MATCH.STATUS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_IFE_MATCH
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
        APPIfeMatch other = (APPIfeMatch) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getPbAction() == null ? other.getPbAction() == null : this.getPbAction().equals(other.getPbAction()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_IFE_MATCH
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getPbAction() == null) ? 0 : getPbAction().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_IFE_MATCH
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
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}