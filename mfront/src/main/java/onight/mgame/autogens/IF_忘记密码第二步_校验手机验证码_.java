package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 忘记密码第二步（校验手机验证码）,客户信息,ForgetPasswordManageController,POST,JSON,/ife/forgetpasswordmanage/checkSmsCode.html@onight.mgame.utils.PBInfo(name = "PBIFE_forgetpasswordmanage_checkSmsCode", path = "/ife/forgetpasswordmanage/checkSmsCode.html") 
public class IF_忘记密码第二步_校验手机验证码_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",短信验证码,String,不校验,否,")
		String mobileValidateCode;//  ,短信验证码,String,不校验,否,
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
