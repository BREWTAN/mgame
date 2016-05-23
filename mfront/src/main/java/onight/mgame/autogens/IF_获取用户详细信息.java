package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 获取用户详细信息,客户信息,UserBaseInfoController,POST,JSON,/ife/userbaseinfo/getUserDetailInfo.html
@onight.mgame.utils.PBInfo(name = "PBIFE_userbaseinfo_getUserDetailInfo", path = "/ife/userbaseinfo/getUserDetailInfo.html") 
public class IF_获取用户详细信息 {
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
		@PBFields(name = ",姓名,String,不校验,是,")
		String name;//  ,姓名,String,不校验,是,
		@PBFields(name = ",账户,String,不校验,是,")
		String account;//  ,账户,String,不校验,是,
		@PBFields(name = ",最后一次登录时间,String,不校验,是,")
		String lastLoginTime;//  ,最后一次登录时间,String,不校验,是,
		 @PBFields(name = ",上次登录终端,String,不校验,是,")
		String lastLoginTerminalName;//  ,上次登录终端,String,不校验,是,
		 @PBFields(name = ",资金账号,String,不校验,是,")
		String fundAccount;//  ,资金账号,String,不校验,是,
		@PBFields(name = ",交易账户,String,不校验,是,")
		String tradeAccount;//  ,交易账户,String,不校验,是,
		 @PBFields(name = ",安全等级,String,不校验,是,")
		String safeLevel;//  ,安全等级,String,不校验,是,
		 @PBFields(name = ",是否绑定银行卡,String,不校验,是,true-是，false-否")
		String isBondedCard;//  ,是否绑定银行卡,String,不校验,是,true-是，false-否
		 @PBFields(name = ",是否设置交易密码,String,不校验,是,true-是，false-否")
		String isFundPasswordSet;//  ,是否设置交易密码,String,不校验,是,true-是，false-否
		 @PBFields(name = ",是否做过风险测评,String,不校验,是,true-是，false-否")
		String isRiskTest;//  ,是否做过风险测评,String,不校验,是,true-是，false-否
		 @PBFields(name = ",风险测评是否过期,String,不校验,是,true-是，false-否")
		String isRiskExpired;//  ,风险测评是否过期,String,不校验,是,true-是，false-否
		 @PBFields(name = ",是否绑定手机号,String,不校验,是,true-是，false-否")
		String isBondedMobile;//  ,是否绑定手机号,String,不校验,是,true-是，false-否
		 @PBFields(name = ",手机号,String,不校验,是,")
		String mobile;//  ,手机号,String,不校验,是,
		 @PBFields(name = ",是否绑定邮箱,String,不校验,是,true-是，false-否")
		String isBondedEmail;//  ,是否绑定邮箱,String,不校验,是,true-是，false-否
		 @PBFields(name = ",邮箱,String,不校验,是,")
		String email;//  ,邮箱,String,不校验,是,
		 @PBFields(name = ",是否设置安保问题,String,不校验,是,")
		String isSecuritySet;//  ,是否设置安保问题,String,不校验,是,
		 @PBFields(name = ",证件号码,String,不校验,是,")
		String certificateCode;//  ,证件号码,String,不校验,是,
		 @PBFields(name = ",证件类型,String,不校验,是,")
		String certificateType;//  ,证件类型,String,不校验,是,
		 @PBFields(name = ",用户类型,String,不校验,是,")
		String userType;//  ,用户类型,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
