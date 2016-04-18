package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 查看开户协议,客户信息,RegController,GET,文件流,/ife/reg/viewRegisterAgreement.html@onight.mgame.utils.PBInfo(name = "PBIFE_reg_viewRegisterAgreement", path = "/ife/reg/viewRegisterAgreement.html") 
public class IF_查看开户协议 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

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
