package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 短信验证码校验(内置手机),公共,SmsValidateCodeController,POST,JSON,/ife/smsvalidatecode/sendSmsValidateCodeWithInnerMobile.html@onight.mgame.utils.PBInfo(name = "PBIFE_smsvalidatecode_sendSmsValidateCodeWithInnerMobile", path = "/ife/smsvalidatecode/sendSmsValidateCodeWithInnerMobile.html") 
public class IF_短信验证码校验_内置手机_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String smsValidateCodeType;//  ,验证码类型,String,不校验,否,
		String smsValidateCode;//  ,验证码,String,不校验,否,
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
