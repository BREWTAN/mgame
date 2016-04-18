package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 受让金额测算,产品相关,TradeController,POST,JSON,/ife/trade/queryTransferBuyProfits.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryTransferBuyProfits", path = "/ife/trade/queryTransferBuyProfits.html") 
public class IF_受让金额测算 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String productCode;//  ,产品编号,String,不校验,否,
		String delegateNum;//  ,购买数量,String,不校验,否,
		String actualRate;//  ,实际利率,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",转让收益,String,不校验,否,")
		String transferIncome;//  ,转让收益,String,不校验,否,
		 @PBFields(name = ",浮动盈亏,String,不校验,否,")
		String floatingProfit;//  ,浮动盈亏,String,不校验,否,
		 @PBFields(name = ",转让总价,String,不校验,否,")
		String amount;//  ,转让总价,String,不校验,否,
		 @PBFields(name = ",手续费,String,不校验,否,")
		String extraCost;//  ,手续费,String,不校验,否,
		 String tfw__reserved;//保留字段 

	}

}
