package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 获取短信验证码(入金),客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/acquireBankSmsCheckCode4recharge.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_acquireBankSmsCheckCode4recharge", path = "/ife/bankcardmanage/acquireBankSmsCheckCode4recharge.html") 
public class IF_获取短信验证码_入金_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String payChannelNo;//  ,支付渠道,String,不校验,否,
		String amount;//  ,金额,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		String serialNo;//  ,短信流水,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
