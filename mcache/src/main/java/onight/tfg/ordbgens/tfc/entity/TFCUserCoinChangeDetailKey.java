package onight.tfg.ordbgens.tfc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TFCUserCoinChangeDetailKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_COIN_CHANGE_DETAIL.COIN_ROW_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    private String coinRowId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_COIN_CHANGE_DETAIL.COIN_ROW_ID
     *
     * @return the value of TFC_USER_COIN_CHANGE_DETAIL.COIN_ROW_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public String getCoinRowId() {
        return coinRowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_COIN_CHANGE_DETAIL.COIN_ROW_ID
     *
     * @param coinRowId the value for TFC_USER_COIN_CHANGE_DETAIL.COIN_ROW_ID
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    public void setCoinRowId(String coinRowId) {
        this.coinRowId = coinRowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_DETAIL
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
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
        TFCUserCoinChangeDetailKey other = (TFCUserCoinChangeDetailKey) that;
        return (this.getCoinRowId() == null ? other.getCoinRowId() == null : this.getCoinRowId().equals(other.getCoinRowId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_DETAIL
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCoinRowId() == null) ? 0 : getCoinRowId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_DETAIL
     *
     * @mbggenerated Mon Aug 24 14:05:58 CST 2015
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", coinRowId=").append(coinRowId);
        sb.append("]");
        return sb.toString();
    }
}