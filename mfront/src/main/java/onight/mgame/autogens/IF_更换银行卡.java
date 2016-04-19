package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 更换银行卡,客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/changeBankCard.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_changeBankCard", path = "/ife/bankcardmanage/changeBankCard.html") 
public class IF_更换银行卡 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",交易密码,String,不校验,否,")
		String password;//  ,交易密码,String,不校验,否,
		 @PBFields(name = ",银行卡号,String,不校验,否,")
		String bankCard;//  ,银行卡号,String,不校验,否,
		 @PBFields(name = ",支付渠道,String,不校验,否,")
		String payChannelNo;//  ,支付渠道,String,不校验,否,
		 @PBFields(name = ",短信验证码,String,不校验,否,")
		String checkCode;//  ,短信验证码,String,不校验,否,
		 @PBFields(name = ",短信验证码流水,String,不校验,否,")
		String checkCodeSerialNo;//  ,短信验证码流水,String,不校验,否,
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
