package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 二级市场购买,产品相关,TradeController,POST,JSON,/ife/trade/transferOrder.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_transferOrder", path = "/ife/trade/transferOrder.html") 
public class IF_二级市场购买 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String delegationCode;//  ,委托编号,String,不校验,否,
		String buyNum;//  ,购买数量,String,不校验,否,
		String channelNo;//  ,渠道,String,不校验,否,
		String payType;//  ,支付类型,String,不校验,否,
		String password;//  ,交易密码,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		String delegationCode;//  ,成交编号,String,不校验,否,
		 String tfw__reserved;//保留字段 

	}

}
