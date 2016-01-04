package onight.tfg.ordbgens.tfg.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TFGLoginUserKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_LOGIN_USER.USER_ID
     *
     * @mbggenerated Sun Dec 06 19:45:29 CST 2015
     */
    private Long userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_LOGIN_USER.USER_ID
     *
     * @return the value of TFG_LOGIN_USER.USER_ID
     *
     * @mbggenerated Sun Dec 06 19:45:29 CST 2015
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_LOGIN_USER.USER_ID
     *
     * @param userId the value for TFG_LOGIN_USER.USER_ID
     *
     * @mbggenerated Sun Dec 06 19:45:29 CST 2015
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Dec 06 19:45:29 CST 2015
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
        TFGLoginUserKey other = (TFGLoginUserKey) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Dec 06 19:45:29 CST 2015
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Dec 06 19:45:29 CST 2015
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}