package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 二级市场购买预检查第二步购买金额检查,产品相关,TradeController,POST,JSON,/ife/trade/transferOrderSec.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_transferOrderSec", path = "/ife/trade/transferOrderSec.html") 
public class IF_二级市场购买预检查第二步购买金额检查 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String delegationCode;//  ,委托编号,String,不校验,否,
		String buyNum;//  ,购买份额,String,不校验,否,
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
