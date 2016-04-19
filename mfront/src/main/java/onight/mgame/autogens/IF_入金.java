package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 入金,电子账户,FundController,POST,JSON,/ife/fund/recharge.html@onight.mgame.utils.PBInfo(name = "PBIFE_fund_recharge", path = "/ife/fund/recharge.html") 
public class IF_入金 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",金额,String,不校验,否,")
		String amount;//  ,金额,String,不校验,否,
		 @PBFields(name = ",交易密码,String,不校验,否,")
		String password;//  ,交易密码,String,不校验,否,
		 @PBFields(name = ",重复校验码,String,不校验,否,")
		String repeatCommitCheckCode;//  ,重复校验码,String,不校验,否,
		 @PBFields(name = ",渠道,String,不校验,否,")
		String payChannelNo;//  ,渠道,String,不校验,否,
		 @PBFields(name = ",验证码,String,不校验,是,")
		String checkCode;//  ,验证码,String,不校验,是,
		 @PBFields(name = ",验证码序号,String,不校验,是,")
		String checkCodeSerialNo;//  ,验证码序号,String,不校验,是,
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
