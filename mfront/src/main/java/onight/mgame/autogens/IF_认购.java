package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 认购,产品相关,TradeController,POST,JSON,/ife/trade/rengou.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_rengou", path = "/ife/trade/rengou.html") 
public class IF_认购 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String productCode;//  ,产品编号,String,不校验,否,
		String delegateNum;//  ,购买金额,String,不校验,否,
		String password;//  ,交易密码,String,不校验,否,
		String payType;//  ,支付类型,String,不校验,否,
		String channelNo;//  ,渠道号,String,不校验,是,
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
