package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 获取用户详细信息,客户信息,UserBaseInfoController,POST,JSON,/ife/userbaseinfo/getUserDetailInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_userbaseinfo_getUserDetailInfo", path = "/ife/userbaseinfo/getUserDetailInfo.html") 
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
		String lastLoginTime;//  ,最后一次登录时间,String,不校验,是,
		String fundAccount;//  ,资金账号,String,不校验,是,
		String safeLevel;//  ,安全等级,String,不校验,是,
		String isBondedCard;//  ,是否绑定银行卡,String,不校验,是,true-是，false-否
		String isFundPasswordSet;//  ,是否设置交易密码,String,不校验,是,true-是，false-否
		String isRiskTest;//  ,是否做过风险测评,String,不校验,是,true-是，false-否
		String isBondedMobile;//  ,是否绑定手机号,String,不校验,是,true-是，false-否
		String mobile;//  ,手机号,String,不校验,是,
		String isBondedEmail;//  ,是否绑定邮箱,String,不校验,是,true-是，false-否
		String email;//  ,邮箱,String,不校验,是,
		String isSecuritySet;//  ,是否设置安保问题,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
