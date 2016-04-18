package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 定制预约额度查询（普通定制）,产品相关,TradeController,POST,JSON,/ife/trade/queryOrderQuota.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryOrderQuota", path = "/ife/trade/queryOrderQuota.html") 
public class IF_定制预约额度查询_普通定制_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String orderDate;//  ,期望认购日期,String,不校验,否,
		String deadline;//  ,期限,String,不校验,否,
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
	public static class OrderQuotaWrap {

		 @PBFields(name = ",额度编号,String,不校验,是,")
				String amountCode;//  ,额度编号,String,不校验,是,
		 @PBFields(name = ",预约总额度,String,不校验,是,")
				String orderTotalAmount;//  ,预约总额度,String,不校验,是,
		 @PBFields(name = ",剩余额度,String,不校验,是,")
				String orderRemainAmount;//  ,剩余额度,String,不校验,是,
		 @PBFields(name = ",保证金比例,String,不校验,是,")
				String depositRate;//  ,保证金比例,String,不校验,是,
		 @PBFields(name = ",预约起点金额,String,不校验,是,")
				String orderStartAmount;//  ,预约起点金额,String,不校验,是,
}

		 OrderQuotaWrap orderQuotaWrap;// 
 
		 String tfw__reserved;//保留字段 

	}

}
