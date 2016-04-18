package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 产品利率查询,产品相关,TradeController,POST,JSON,/ife/trade/queryValidOrderDate.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryValidOrderDate", path = "/ife/trade/queryValidOrderDate.html") 
public class IF_产品利率查询1 {
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
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ValidOrderDate {

		 @PBFields(name = ",有效日期,String,不校验,是,")
				String tradeDay;//  ,有效日期,String,不校验,是,
}

		 List<ValidOrderDate>validOrderDate;// 
 
		 String tfw__reserved;//保留字段 

	}

}
