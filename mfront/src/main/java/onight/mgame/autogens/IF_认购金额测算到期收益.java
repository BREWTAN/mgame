package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 认购金额测算到期收益,产品相关,TradeController,POST,JSON,/ife/trade/querySubscribeProfits.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_querySubscribeProfits", path = "/ife/trade/querySubscribeProfits.html") 
public class IF_认购金额测算到期收益 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String productCode;//  ,产品编号,String,不校验,否,
		String buyAmt;//  ,购买金额,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		BigDecimal interest;//  ,利息,BigDecimal,不校验,否,
		 String tfw__reserved;//保留字段 

	}

}
