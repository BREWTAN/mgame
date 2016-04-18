package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 普通预约产品保证金测算,产品相关,TradeController,POST,JSON,/ife/trade/queryProductOrderDeposit.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryProductOrderDeposit", path = "/ife/trade/queryProductOrderDeposit.html") 
public class IF_普通预约产品保证金测算 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String productCode;//  ,产品编号,String,不校验,否,
		String orderBuyAmount;//  ,预约金额,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DepositWrap {

		 @PBFields(name = ",保证金比例,String,不校验,否,")
				String depositRate;//  ,保证金比例,String,不校验,否,
		 @PBFields(name = ",保证金金额,String,不校验,否,")
				String depositAmount;//  ,保证金金额,String,不校验,否,
}

		 DepositWrap depositWrap;// 
 
		 String tfw__reserved;//保留字段 

	}

}
