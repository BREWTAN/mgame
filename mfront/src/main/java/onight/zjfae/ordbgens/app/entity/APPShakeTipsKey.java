package onight.zjfae.ordbgens.app.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class APPShakeTipsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_SHAKE_TIPS.UUID
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    private String uuid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_SHAKE_TIPS.UUID
     *
     * @return the value of APP_SHAKE_TIPS.UUID
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_SHAKE_TIPS.UUID
     *
     * @param uuid the value for APP_SHAKE_TIPS.UUID
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_SHAKE_TIPS
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
        APPShakeTipsKey other = (APPShakeTipsKey) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_SHAKE_TIPS
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
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
     * This method corresponds to the database table APP_SHAKE_TIPS
     *
     * @mbggenerated Tue May 17 22:12:03 CST 2016
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