package onight.zjfae.ordbgens.app.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="APP_FUNCTIONS")
@AllArgsConstructor
@NoArgsConstructor
public class APPFunctions extends APPFunctionsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.FUNC_CODE
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String funcCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.FUNC_NAME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String funcName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.FUNC_ICON
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String funcIcon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.ANI_METHOD
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String aniMethod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.ANI_PARAMS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String aniParams;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.FUNC_URL
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String funcUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.PLATFORMS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String platforms;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.APP_VERS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private String appVers;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.USER_ID_LEVEL
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private Integer userIdLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.INSERTTIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private Date inserttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP_FUNCTIONS.STATUS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.FUNC_CODE
     *
     * @return the value of APP_FUNCTIONS.FUNC_CODE
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getFuncCode() {
        return funcCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.FUNC_CODE
     *
     * @param funcCode the value for APP_FUNCTIONS.FUNC_CODE
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.FUNC_NAME
     *
     * @return the value of APP_FUNCTIONS.FUNC_NAME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getFuncName() {
        return funcName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.FUNC_NAME
     *
     * @param funcName the value for APP_FUNCTIONS.FUNC_NAME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.FUNC_ICON
     *
     * @return the value of APP_FUNCTIONS.FUNC_ICON
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getFuncIcon() {
        return funcIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.FUNC_ICON
     *
     * @param funcIcon the value for APP_FUNCTIONS.FUNC_ICON
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setFuncIcon(String funcIcon) {
        this.funcIcon = funcIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.ANI_METHOD
     *
     * @return the value of APP_FUNCTIONS.ANI_METHOD
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getAniMethod() {
        return aniMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.ANI_METHOD
     *
     * @param aniMethod the value for APP_FUNCTIONS.ANI_METHOD
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setAniMethod(String aniMethod) {
        this.aniMethod = aniMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.ANI_PARAMS
     *
     * @return the value of APP_FUNCTIONS.ANI_PARAMS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getAniParams() {
        return aniParams;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.ANI_PARAMS
     *
     * @param aniParams the value for APP_FUNCTIONS.ANI_PARAMS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setAniParams(String aniParams) {
        this.aniParams = aniParams;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.FUNC_URL
     *
     * @return the value of APP_FUNCTIONS.FUNC_URL
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getFuncUrl() {
        return funcUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.FUNC_URL
     *
     * @param funcUrl the value for APP_FUNCTIONS.FUNC_URL
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.PLATFORMS
     *
     * @return the value of APP_FUNCTIONS.PLATFORMS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getPlatforms() {
        return platforms;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.PLATFORMS
     *
     * @param platforms the value for APP_FUNCTIONS.PLATFORMS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.APP_VERS
     *
     * @return the value of APP_FUNCTIONS.APP_VERS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public String getAppVers() {
        return appVers;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.APP_VERS
     *
     * @param appVers the value for APP_FUNCTIONS.APP_VERS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setAppVers(String appVers) {
        this.appVers = appVers;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.USER_ID_LEVEL
     *
     * @return the value of APP_FUNCTIONS.USER_ID_LEVEL
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public Integer getUserIdLevel() {
        return userIdLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.USER_ID_LEVEL
     *
     * @param userIdLevel the value for APP_FUNCTIONS.USER_ID_LEVEL
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setUserIdLevel(Integer userIdLevel) {
        this.userIdLevel = userIdLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.INSERTTIME
     *
     * @return the value of APP_FUNCTIONS.INSERTTIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public Date getInserttime() {
        return inserttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.INSERTTIME
     *
     * @param inserttime the value for APP_FUNCTIONS.INSERTTIME
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP_FUNCTIONS.STATUS
     *
     * @return the value of APP_FUNCTIONS.STATUS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP_FUNCTIONS.STATUS
     *
     * @param status the value for APP_FUNCTIONS.STATUS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_FUNCTIONS
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
        APPFunctions other = (APPFunctions) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getFuncCode() == null ? other.getFuncCode() == null : this.getFuncCode().equals(other.getFuncCode()))
            && (this.getFuncName() == null ? other.getFuncName() == null : this.getFuncName().equals(other.getFuncName()))
            && (this.getFuncIcon() == null ? other.getFuncIcon() == null : this.getFuncIcon().equals(other.getFuncIcon()))
            && (this.getAniMethod() == null ? other.getAniMethod() == null : this.getAniMethod().equals(other.getAniMethod()))
            && (this.getAniParams() == null ? other.getAniParams() == null : this.getAniParams().equals(other.getAniParams()))
            && (this.getFuncUrl() == null ? other.getFuncUrl() == null : this.getFuncUrl().equals(other.getFuncUrl()))
            && (this.getPlatforms() == null ? other.getPlatforms() == null : this.getPlatforms().equals(other.getPlatforms()))
            && (this.getAppVers() == null ? other.getAppVers() == null : this.getAppVers().equals(other.getAppVers()))
            && (this.getUserIdLevel() == null ? other.getUserIdLevel() == null : this.getUserIdLevel().equals(other.getUserIdLevel()))
            && (this.getInserttime() == null ? other.getInserttime() == null : this.getInserttime().equals(other.getInserttime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_FUNCTIONS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getFuncCode() == null) ? 0 : getFuncCode().hashCode());
        result = prime * result + ((getFuncName() == null) ? 0 : getFuncName().hashCode());
        result = prime * result + ((getFuncIcon() == null) ? 0 : getFuncIcon().hashCode());
        result = prime * result + ((getAniMethod() == null) ? 0 : getAniMethod().hashCode());
        result = prime * result + ((getAniParams() == null) ? 0 : getAniParams().hashCode());
        result = prime * result + ((getFuncUrl() == null) ? 0 : getFuncUrl().hashCode());
        result = prime * result + ((getPlatforms() == null) ? 0 : getPlatforms().hashCode());
        result = prime * result + ((getAppVers() == null) ? 0 : getAppVers().hashCode());
        result = prime * result + ((getUserIdLevel() == null) ? 0 : getUserIdLevel().hashCode());
        result = prime * result + ((getInserttime() == null) ? 0 : getInserttime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP_FUNCTIONS
     *
     * @mbggenerated Thu May 26 19:21:31 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", funcCode=").append(funcCode);
        sb.append(", funcName=").append(funcName);
        sb.append(", funcIcon=").append(funcIcon);
        sb.append(", aniMethod=").append(aniMethod);
        sb.append(", aniParams=").append(aniParams);
        sb.append(", funcUrl=").append(funcUrl);
        sb.append(", platforms=").append(platforms);
        sb.append(", appVers=").append(appVers);
        sb.append(", userIdLevel=").append(userIdLevel);
        sb.append(", inserttime=").append(inserttime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}