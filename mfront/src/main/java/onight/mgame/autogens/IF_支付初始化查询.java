package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 支付初始化查询,产品相关,TradeController,POST,JSON,/ife/trade/queryPayInit.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryPayInit", path = "/ife/trade/queryPayInit.html") 
public class IF_支付初始化查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",产品编号,String,不校验,否,")
		String productCode;//  ,产品编号,String,不校验,否,
		 @PBFields(name = ",购买金额,String,不校验,否,")
		String delegateNum;//  ,购买金额,String,不校验,否,
		 @PBFields(name = ",支付类型,String,不校验,否,")
		String payType;//  ,支付类型,String,不校验,否,
		 @PBFields(name = ",预约类型,String,不校验,是,")
		String orderType;//  ,预约类型,String,不校验,是,
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
	public static class PayInitWrap {

		 @PBFields(name = ",支付总金额,String,不校验,否,")
				String payAmount;//  ,支付总金额,String,不校验,否,
		 @PBFields(name = ",已冻结保证金金额,String,不校验,是,")
				String freezeDeposit;//  ,已冻结保证金金额,String,不校验,是,
		 @PBFields(name = ",可用余额,String,不校验,是,")
				String balanceY;//  ,可用余额,String,不校验,是,
		 @PBFields(name = ",余额支付金额,String,不校验,否,")
				String payAmountWithBalance;//  ,余额支付金额,String,不校验,否,
		 @PBFields(name = ",余额支付充值金额,String,不校验,是,")
				String inAmountWithBalance;//  ,余额支付充值金额,String,不校验,是,
		 @PBFields(name = ",非余额支付充值金额,String,不校验,是,")
				String inAmountWithoutBalance;//  ,非余额支付充值金额,String,不校验,是,
		 @PBFields(name = ",重复提交校验码,String,不校验,否,")
				String repeatCommitCheckCode;//  ,重复提交校验码,String,不校验,否,
}

		 PayInitWrap payInitWrap;// 
 
		 String tfw__reserved;//保留字段 

	}

}
