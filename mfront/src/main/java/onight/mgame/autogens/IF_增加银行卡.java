package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 增加银行卡,客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/addBankCard.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_addBankCard", path = "/ife/bankcardmanage/addBankCard.html") 
public class IF_增加银行卡 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String realName;//  ,真实姓名,String,不校验,否,未曾签约需要上送
		String certificateCode;//  ,证件号,String,不校验,否,未曾签约需要上送
		String certificateType;//  ,证件类型,String,不校验,否,
		String payChannelNo;//  ,支付渠道,String,不校验,否,
		String bankCardNo;//  ,银行卡号,String,不校验,否,
		String bankCode;//  ,银行编号,String,不校验,否,
		String bankName;//  ,银行名,String,不校验,否,
		String checkCode;//  ,验证码,String,不校验,否,
		String checkCodeSerialNo;//  ,验证码流水,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 String tfw__reserved;//保留字段 

	}

}
