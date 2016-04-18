package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 入金参数加载,电子账户,FundController,GET,JSON,/ife/fund/loadRechargeBankCardInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_fund_loadRechargeBankCardInfo", path = "/ife/fund/loadRechargeBankCardInfo.html") 
public class IF_入金参数加载 {
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
		 @PBFields(name = ",用户绑定银行卡,String,不校验,否,")
		String bankCardNo;//  ,用户绑定银行卡,String,不校验,否,
		 @PBFields(name = ",用户绑定银行卡所在行,String,不校验,否,")
		String bankNo;//  ,用户绑定银行卡所在行,String,不校验,否,
		 @PBFields(name = ",绑卡渠道,String,不校验,否,")
		String payChannelNo;//  ,绑卡渠道,String,不校验,否,
		 @PBFields(name = ",是否签订入金协议,Boolean,不校验,否,")
		Boolean isWithhoidingAgreement;//  ,是否签订入金协议,Boolean,不校验,否,
		 @PBFields(name = ",重复校验码,String,不校验,否,")
		String repeatCommitCheckCode;//  ,重复校验码,String,不校验,否,
		 String tfw__reserved;//保留字段 

	}

}
