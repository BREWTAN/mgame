package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 个性化定制预约产品收益及保证金测算,产品相关,TradeController,POST,JSON,/ife/trade/querySpecialProfit.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_querySpecialProfit", path = "/ife/trade/querySpecialProfit.html") 
public class IF_个性化定制预约产品收益及保证金测算 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String orderDate;//  ,期望认购日期,String,不校验,否,
		String deadline;//  ,期限,String,不校验,否,
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
	public static class SpecialProfitWrap {

				String depositRate;//  ,保证金比例,String,不校验,是,
				String depositAmount;//  ,保证金金额,String,不校验,是,
				String orderRate;//  ,利率,String,不校验,是,
				String expectProfit;//  ,预期收益,String,不校验,是,
}

		 SpecialProfitWrap specialProfitWrap;// 
 
		 String tfw__reserved;//保留字段 

	}

}
