package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 挂卖单,产品相关,TradeController,POST,JSON,/ife/trade/createTransferOrder.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_createTransferOrder", path = "/ife/trade/createTransferOrder.html") 
public class IF_挂卖单 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String productCode;//  ,产品编号,String,不校验,否,
		String delegateNum;//  ,委托数量,String,不校验,否,
		String actualRate;//  ,实际利率,String,不校验,否,
		String password;//  ,交易密码,String,不校验,否,
		String channelNo;//  ,渠道号,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		String delegationCode;//  ,委托编号,String,不校验,否,
		 String tfw__reserved;//保留字段 

	}

}
