package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 获取用户资产信息,电子账户,FundController,GET,JSON,/ife/fund/loadUserAssetsInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_fund_loadUserAssetsInfo", path = "/ife/fund/loadUserAssetsInfo.html") 
public class IF_获取用户资产信息 {
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
		String bankCode;//  ,用户绑定银行卡所在行,String,不校验,否,
		BigDecimal balanceY;//  ,可用金额,BigDecimal,不校验,否,
		BigDecimal balanceQ;//  ,可取金额,BigDecimal,不校验,否,
		BigDecimal freezeTotal;//  ,冻结基恩,BigDecimal,不校验,否,
		BigDecimal amount;//  ,总余额,BigDecimal,不校验,否,
		BigDecimal allUnit;//  ,总持仓,BigDecimal,不校验,否,
		BigDecimal yesterdayProfit;//  ,昨日收益,BigDecimal,不校验,否,
		BigDecimal allProfit;//  ,累计收益,BigDecimal,不校验,否,
		 String tfw__reserved;//保留字段 

	}

}
