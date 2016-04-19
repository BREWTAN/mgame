package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 认购撤单,产品相关,TradeController,POST,JSON,/ife/trade/subscribeCancel.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_subscribeCancel", path = "/ife/trade/subscribeCancel.html") 
public class IF_认购撤单 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",成交编号,String,不校验,否,")
		String delegationCode;//  ,成交编号,String,不校验,否,
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
