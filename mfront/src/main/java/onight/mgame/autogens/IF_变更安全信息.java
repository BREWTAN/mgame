package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onight.mgame.utils.PBFields;

// 变更安全信息,客户信息,UserBaseInfoController,POST,JSON,/ife/userbaseinfo/verifySecurityInfo.html
@onight.mgame.utils.PBInfo(name = "PBIFE_userbaseinfo_verifySecurityInfo", path = "/ife/userbaseinfo/verifySecurityInfo.html")
public class IF_变更安全信息 {
    // =======REQuest==============

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        @PBFields(name = ",证件类型,String,不校验,是,")
        String certificateType;//  ,证件类型,String,不校验,是,
        @PBFields(name = ",证件号,String,不校验,是,")
        String idCardNo;//  ,证件号,String,不校验,是,
        @PBFields(name = ",登录密码,String,不校验,是,")
        String password;//  ,登录密码,String,不校验,是,
        @PBFields(name = ",安保问题编号,String,不校验,是,")
        String securityQuestion;//  ,安保问题编号,String,不校验,是,
        @PBFields(name = ",安保问题答案,String,不校验,是,")
        String securityQuestionAnswer;//  ,安保问题答案,String,不校验,是,
        String tfw__reserved;//保留字段
    }

    // ======RESponse==========
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        @PBFields(name = ",安保问题校验结果 true-是，false-否,String,不校验,是,")
        String answerValid;//  ,安保问题校验结果,String,不校验,是,
        @PBFields(name = ",证件号校验结果 true-是，false-否,String,不校验,是,")
        String cardValid;//  ,证件号校验结果,String,不校验,是,
        @PBFields(name = ",登录密码校验结果 true-是，false-否,String,不校验,是,")
        String passwordValid;//  ,登录密码校验结果,String,不校验,是,
        String tfw__reserved;//保留字段
    }
}
