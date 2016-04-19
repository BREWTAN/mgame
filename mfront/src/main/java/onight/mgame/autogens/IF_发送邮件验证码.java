package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 发送邮件验证码,公共,EmailValidateCodeController,POST,JSON,/ife/emailValidateCode/sendEmail.html@onight.mgame.utils.PBInfo(name = "PBIFE_emailValidateCode_sendEmail", path = "/ife/emailValidateCode/sendEmail.html") 
public class IF_发送邮件验证码 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",邮件验证码类型,String,不校验,否,")
		String validateCodeType;//  ,邮件验证码类型,String,不校验,否,
		 @PBFields(name = ",邮箱,String,不校验,否,符合邮箱标准")
		String email;//  ,邮箱,String,不校验,否,符合邮箱标准
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
