package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryOrderBlack", path = "/ife/trade/queryOrderBlack.html") 
public class IF_预约黑名单检查 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		@PBFields(name = ",期望认购日期,String,不校验,否,")
		String  orderDate;
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",预约黑名单提示信息,String,不校验,是,")
		 String msg;
		 String tfw__reserved;//保留字段 

	}

}
