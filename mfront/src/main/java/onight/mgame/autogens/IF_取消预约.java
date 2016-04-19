package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 取消预约,产品相关,TradeController,POST,JSON,/ife/trade/cancelOrder.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_cancelOrder", path = "/ife/trade/cancelOrder.html") 
public class IF_取消预约 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",预约编号,String,不校验,否,")
		String orderNum;//  ,预约编号,String,不校验,否,
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
