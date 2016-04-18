package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 委托撤单,产品相关,TradeController,POST,JSON,/ife/trade/delegateCancel.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_delegateCancel", path = "/ife/trade/delegateCancel.html") 
public class IF_委托撤单 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String delegationCode;//  ,委托编号,String,不校验,否,
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
