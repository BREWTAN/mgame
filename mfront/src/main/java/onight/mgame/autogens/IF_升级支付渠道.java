package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onight.mgame.utils.PBFields;

// 升级支付渠道,客户信息,BankCardUpdateManageController,POST,JSON,/ife/bankcardupdatemanage/updatePayChannel.html
@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardupdatemanage_updatePayChannel", path = "/ife/bankcardupdatemanage/updatePayChannel.html") 
public class IF_升级支付渠道 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		@PBFields(name = ",手机验证码,String,不校验,否,")
		String checkCode;//  ,手机验证码,String,不校验,否,
		 @PBFields(name = ",手机验证码流水,String,不校验,否,")
		String checkCodeSerialNo;//  ,手机验证码流水,String,不校验,否,
		@PBFields(name = ",支付渠道编号,String,不校验,否,")
		String updatePayChannelNo;//  ,支付渠道编号,String,不校验,否,
		
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
