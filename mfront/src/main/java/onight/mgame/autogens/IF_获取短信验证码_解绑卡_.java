package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 获取短信验证码(解绑卡),客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/acquireBankSmsCheckCode4unBind.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_acquireBankSmsCheckCode4unBind", path = "/ife/bankcardmanage/acquireBankSmsCheckCode4unBind.html") 
public class IF_获取短信验证码_解绑卡_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",支付渠道,String,不校验,否,")
		String payChannelNo;//  ,支付渠道,String,不校验,否,
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
