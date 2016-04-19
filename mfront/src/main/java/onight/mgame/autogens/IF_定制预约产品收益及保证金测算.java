package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 定制预约产品收益及保证金测算,产品相关,TradeController,POST,JSON,/ife/trade/queryCustomProfit.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryCustomProfit", path = "/ife/trade/queryCustomProfit.html") 
public class IF_定制预约产品收益及保证金测算 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",期望认购日期,String,不校验,否,")
		String orderDate;//  ,期望认购日期,String,不校验,否,
		 @PBFields(name = ",期限,String,不校验,否,")
		String deadline;//  ,期限,String,不校验,否,
		 @PBFields(name = ",预约认购金额,String,不校验,否,")
		String orderBuyAmount;//  ,预约认购金额,String,不校验,否,
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
	public static class CustomProfitWrap {

		 @PBFields(name = ",区间起,String,不校验,是,")
				String deadlineBegin;//  ,区间起,String,不校验,是,
		 @PBFields(name = ",区间止,String,不校验,是,")
				String deadlineEnd;//  ,区间止,String,不校验,是,
		 @PBFields(name = ",收益起,String,不校验,是,")
				String profitBegin;//  ,收益起,String,不校验,是,
		 @PBFields(name = ",收益止,String,不校验,是,")
				String profitEnd;//  ,收益止,String,不校验,是,
		 @PBFields(name = ",利率,String,不校验,是,")
				String orderRate;//  ,利率,String,不校验,是,
		 @PBFields(name = ",保证金金额,String,不校验,是,")
				String depositAmount;//  ,保证金金额,String,不校验,是,
}

		 CustomProfitWrap customProfitWrap;// 
 
		 String tfw__reserved;//保留字段 

	}

}
