package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 产品认购预检查,产品相关,TradeController,POST,JSON,/ife/trade/subscribeProductPre.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_subscribeProductPre", path = "/ife/trade/subscribeProductPre.html") 
public class IF_产品认购预检查 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String productCode;//  ,产品编号,String,不校验,否,
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
