package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 获取短信验证码(签约),客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/acquireBankSmsCheckCode.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_acquireBankSmsCheckCode", path = "/ife/bankcardmanage/acquireBankSmsCheckCode.html") 
public class IF_获取短信验证码_签约_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String realName;//  ,真实姓名,String,不校验,否,
		String certificateCode;//  ,证件号,String,18,是,若未曾签约，需上传
		String certificateType;//  ,证据类型,String,不校验,是,若未曾签约，需上传
		String payChannelNo;//  ,支付渠道,String,不校验,否,
		String bankCardNo;//  ,银行卡号,String,不校验,否,
		String bankCode;//  ,银行编号,String,不校验,否,
		String bankName;//  ,银行名称,String,不校验,否,
		String validateType;//  ,校验类型,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",短信流水,String,不校验,是,")
		String serialNo;//  ,短信流水,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
