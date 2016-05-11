package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

@onight.mgame.utils.PBInfo(name = "PBIFE_trade_redemption", path = "/ife/trade/redemption.html") 
public class IF_2_1提前兑付申请提交 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		@PBFields(name = ",持仓ID,String,不校验,否,")
		String  idStr;
		@PBFields(name = ",持仓ID,String,不校验,否,")
		String  preSaleAmtStr;
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
