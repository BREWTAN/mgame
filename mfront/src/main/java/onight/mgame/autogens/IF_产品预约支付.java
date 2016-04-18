package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 产品预约支付,产品相关,TradeController,POST,JSON,/ife/trade/productOrderPay.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_productOrderPay", path = "/ife/trade/productOrderPay.html") 
public class IF_产品预约支付 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String orderType;//  ,预约类型,String,不校验,否,
		String payType;//  ,是否使用余额支付,String,不校验,否,
		String password;//  ,交易密码,String,不校验,否,
		String orderProductCode;//  ,产品编号,String,不校验,否,
		String orderDate;//  ,期望认购日期,String,不校验,否,
		String deadline;//  ,期限,String,不校验,否,
		String orderBuyAmount;//  ,预约金额,String,不校验,否,
		String repeatCommitCheckCode;//  ,重复校验码,String,不校验,否,
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
