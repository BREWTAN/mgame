package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 删除银行卡,客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/deleteBankCard.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_deleteBankCard", path = "/ife/bankcardmanage/deleteBankCard.html") 
public class IF_删除银行卡 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",交易密码,String,不校验,否,")
		String password;//  ,交易密码,String,不校验,否,
		 @PBFields(name = ",支付渠道,String,不校验,否,")
		String payChannelNo;//  ,支付渠道,String,不校验,否,
		 @PBFields(name = ",短信验证码,String,不校验,是,")
		String checkCode;//  ,短信验证码,String,不校验,是,
		 @PBFields(name = ",短信验证码流水,String,不校验,是,")
		String checkCodeSerialNo;//  ,短信验证码流水,String,不校验,是,
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
