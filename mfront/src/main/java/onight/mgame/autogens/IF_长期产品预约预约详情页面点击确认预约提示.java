package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryProductOrderTips", path = "/ife/trade/queryProductOrderTips.html") 
public class IF_长期产品预约预约详情页面点击确认预约提示 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		@PBFields(name = ",预约产品编号,String,不校验,否,")
		String  orderProductCode;
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		@PBFields(name = ",预约提示信息,String,不校验,是,")
		 String msg;
		 String tfw__reserved;//保留字段 

	}

}
