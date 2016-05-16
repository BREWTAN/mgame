package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 个性化定制初始化查询,产品相关,TradeController,POST,JSON,/ife/trade/queryOrderInit.html
@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryOrderInit", path = "/ife/trade/queryOrderInit.html")
public class IF_个性化定制初始化查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		String orderType;// orderType 预约类型
		String queryOrderInit;// 字段
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
	public static class OrderInitWrap {

		 @PBFields(name = ",保证金比例,String,不校验,是,")
				String depositRate;//  ,保证金比例,String,不校验,是,
		 @PBFields(name = ",预约起点金额,String,不校验,是,")
				String orderStartAmount;//  ,预约起点金额,String,不校验,是,
}

		OrderInitWrap orderInitWrap;//
 
		 String tfw__reserved;//保留字段 

	}

}
