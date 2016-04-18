package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 发送短信验证码(内置手机号),公共,SmsValidateCodeController,POST,JSON,/ife/smsvalidatecode/sendSmsValidateCodeWithInnerMobile.html@onight.mgame.utils.PBInfo(name = "PBIFE_smsvalidatecode_sendSmsValidateCodeWithInnerMobile", path = "/ife/smsvalidatecode/sendSmsValidateCodeWithInnerMobile.html") 
public class IF_发送短信验证码_内置手机号_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String smsValidateCodeType;//  ,,String,不校验,否,
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
