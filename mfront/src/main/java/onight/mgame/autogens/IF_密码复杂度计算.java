package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 密码复杂度计算,客户信息,MobileManageController,POST,JSON,/ife/passwordmanage/calculatePasswordComplexity.html@onight.mgame.utils.PBInfo(name = "PBIFE_passwordmanage_calculatePasswordComplexity", path = "/ife/passwordmanage/calculatePasswordComplexity.html") 
public class IF_密码复杂度计算 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String password;//  ,密码,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		String passwordLevel;//  ,密码强度,String,不校验,否,
		 String tfw__reserved;//保留字段 

	}

}
