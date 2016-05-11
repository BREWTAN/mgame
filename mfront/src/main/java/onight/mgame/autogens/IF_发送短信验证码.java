package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 忘记密码第三步（设置新密码）,客户信息,ForgetPasswordManageController,POST,JSON,/ife/forgetpasswordmanage/sendMobileValidateCode.html@onight.mgame.utils.PBInfo(name = "PBIFE_forgetpasswordmanage_sendMobileValidateCode", path = "/ife/forgetpasswordmanage/sendMobileValidateCode.html") 
public class IF_发送短信验证码 {
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
