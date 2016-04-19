package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 发送邮件验证码(内置),公共,EmailValidateCodeController,POST,JSON,/ife/emailValidateCode/sendEmailWithInnerAddress.html@onight.mgame.utils.PBInfo(name = "PBIFE_emailValidateCode_sendEmailWithInnerAddress", path = "/ife/emailValidateCode/sendEmailWithInnerAddress.html") 
public class IF_发送邮件验证码_内置_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",邮件验证码类型,String,不校验,否,")
		String validateCodeType;//  ,邮件验证码类型,String,不校验,否,
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
