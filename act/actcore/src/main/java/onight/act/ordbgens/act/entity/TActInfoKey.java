package onight.act.ordbgens.act.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TActInfoKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.ACT_NO
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    private String actNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.ACT_NO
     *
     * @return the value of T_ACT_INFO.ACT_NO
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public String getActNo() {
        return actNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.ACT_NO
     *
     * @param actNo the value for T_ACT_INFO.ACT_NO
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
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
        TActInfoKey other = (TActInfoKey) that;
        return (this.getActNo() == null ? other.getActNo() == null : this.getActNo().equals(other.getActNo()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Mon Dec 07 00:20:52 CST 2015
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActNo() == null) ? 0 : getActNo().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
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
        sb.append("]");
        return sb.toString();
    }
}