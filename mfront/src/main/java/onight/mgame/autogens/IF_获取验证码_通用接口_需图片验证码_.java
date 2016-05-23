package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onight.mgame.utils.PBFields;

// 获取验证码_通用接口_需图片验证码,公共,SmsValidateCodeController,POST,JSON,/ife/smsvalidatecode/sendSmsValidateCodeWithImageCode.html
@onight.mgame.utils.PBInfo(name = "PBIFE_smsvalidatecode_sendSmsValidateCodeWithImageCode", path = "/ife/smsvalidatecode/sendSmsValidateCodeWithImageCode.html")
public class IF_获取验证码_通用接口_需图片验证码_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		@PBFields(name = ",手机号,String,不校验,否,")
		String mobile;//  ,手机号,String,不校验,否,
		@PBFields(name = ",验证码类型,String,不校验,否,")
		String smsValidateCodeType;//  ,验证码类型,String,不校验,否,
		@PBFields(name = ",图片验证码,String,不校验,否,")
		String imageCode;//  ,图片验证码,String,不校验,否,
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
