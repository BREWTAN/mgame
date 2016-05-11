package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

@onight.mgame.utils.PBInfo(name = "PBIFE_trade_subscribeCancelPre", path = "/ife/trade/subscribeCancelPre.html") 
public class IF_认购撤单预检查 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		@PBFields(name = ",产品编号,String,不校验,否,")
		String  productCode;
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",认购撤单提示信息,String,不校验,是,")
		 String msg;//  ,认购撤单提示信息,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
