package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 手机号验证,客户信息,RegController,POST,JSON,/ife/reg/checkIfMobileUseful.html@onight.mgame.utils.PBInfo(name = "PBIFE_reg_checkIfMobileUseful", path = "/ife/reg/checkIfMobileUseful.html") 
public class IF_手机号验证 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",手机号,String,11,否,")
		String mobile;//  ,手机号,String,11,否,
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
