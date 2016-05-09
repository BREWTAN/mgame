package onight.zjfae.ordbgens.app.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class APPFunctionsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.UUID
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    private String uuid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.UUID
     *
     * @return the value of APP_FUNCTIONS.UUID
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.UUID
     *
     * @param uuid the value for APP_FUNCTIONS.UUID
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_FUNCTIONS
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
        APPFunctionsKey other = (APPFunctionsKey) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_FUNCTIONS
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_FUNCTIONS
     *
     * @mbggenerated Mon May 09 10:59:33 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append("]");
        return sb.toString();
    }
}