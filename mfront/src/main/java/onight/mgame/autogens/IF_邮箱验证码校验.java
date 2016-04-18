package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 邮件验证码校验,公共,EmailValidateCodeController,POST,JSON,/ife/emailValidateCode/checkEmailValidateCode.html@onight.mgame.utils.PBInfo(name = "PBIFE_emailValidateCode_checkEmailValidateCode", path = "/ife/emailValidateCode/checkEmailValidateCode.html") 
public class IF_邮箱验证码校验 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String email;//  ,邮箱,String,不校验,否,
		String validateCodeType;//  ,验证码类型,String,不校验,否,
		String validateCode;//  ,验证码,String,不校验,否,
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
