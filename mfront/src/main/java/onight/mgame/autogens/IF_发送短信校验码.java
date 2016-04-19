package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 发送短信验证码,公共,SmsValidateCodeController,POST,JSON,/ife/smsvalidatecode/sendSmsValidateCode.html@onight.mgame.utils.PBInfo(name = "PBIFE_smsvalidatecode_sendSmsValidateCode", path = "/ife/smsvalidatecode/sendSmsValidateCode.html") 
public class IF_发送短信校验码 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",验证码类型,String,不校验,否,")
		String smsValidateCodeType;//  ,验证码类型,String,不校验,否,
		 @PBFields(name = ",手机号码,String,不校验,否,")
		String mobile;//  ,手机号码,String,不校验,否,
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
