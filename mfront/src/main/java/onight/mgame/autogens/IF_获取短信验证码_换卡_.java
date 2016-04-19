package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 获取短信验证码(换卡),客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/acquireBankSmsCheckCode4changeBind.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_acquireBankSmsCheckCode4changeBind", path = "/ife/bankcardmanage/acquireBankSmsCheckCode4changeBind.html") 
public class IF_获取短信验证码_换卡_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",支付渠道,String,不校验,否,")
		String payChannelNo;//  ,支付渠道,String,不校验,否,
		 @PBFields(name = ",银行卡,String,不校验,否,")
		String bankCard;//  ,银行卡,String,不校验,否,
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
