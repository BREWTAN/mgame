package onight.tfg.ordbgens.sys.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TSysBranchKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_BRANCH.ID
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    private String id;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_BRANCH.ID
     *
     * @return the value of T_SYS_BRANCH.ID
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_BRANCH.ID
     *
     * @param id the value for T_SYS_BRANCH.ID
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
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
        TSysBranchKey other = (TSysBranchKey) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Mon Aug 24 14:05:57 CST 2015
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}