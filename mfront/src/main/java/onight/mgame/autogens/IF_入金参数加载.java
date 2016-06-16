package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onight.mgame.utils.PBFields;

// 入金参数加载,电子账户,FundController,GET,JSON,/ife/fund/loadRechargeBankCardInfo.html
@onight.mgame.utils.PBInfo(name = "PBIFE_fund_loadRechargeBankCardInfo", path = "/ife/fund/loadRechargeBankCardInfo.html")
public class IF_入金参数加载 {
    // =======REQuest==============
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        String tfw__reserved;//保留字段
    }

    // ======RESponse==========
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        @PBFields(name = ",用户绑定银行卡,String,不校验,否,")
        String bankCardNo;//  ,用户绑定银行卡,String,不校验,否,
        @PBFields(name = ",用户绑定银行卡所在行,String,不校验,否,")
        String bankNo;//  ,用户绑定银行卡所在行,String,不校验,否,
        @PBFields(name = ",绑卡渠道,String,不校验,否,")
        String payChannelNo;//  ,绑卡渠道,String,不校验,否,
        @PBFields(name = ",是否签订入金协议,String,不校验,否,")
        String isWithhoidingAgreement;//  ,是否签订入金协议0-未签订 1-已签订,String,不校验,否,
        @PBFields(name = ",重复校验码,String,不校验,否,")
        String repeatCommitCheckCode;//  ,重复校验码,String,不校验,否,
        @PBFields(name = ",账号,String,不校验,否,")
        String account;//  ,账号,String,不校验,否,
        @PBFields(name = ",姓名,String,不校验,否,")
        String realName;//  ,姓名,String,不校验,否,
        @PBFields(name = ",证件号,String,不校验,否,")
        String certificateCode;//  ,证件号,String,不校验,否,
        @PBFields(name = ",银行卡,String,不校验,否,")
        String bankCard;//  ,银行卡,String,不校验,否,
        @PBFields(name = ",银行名,String,不校验,否,")
        String bankName;//  ,银行名,String,不校验,否,
        String tfw__reserved;//保留字段
    }
}