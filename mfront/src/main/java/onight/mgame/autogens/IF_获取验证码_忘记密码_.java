package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 获取验证码（忘记密码）,公共,SmsValidateCodeController,POST,JSON,/ife/smsvalidatecode/sendForgetPasswordSmsCode.html@onight.mgame.utils.PBInfo(name = "PBIFE_smsvalidatecode_sendForgetPasswordSmsCode", path = "/ife/smsvalidatecode/sendForgetPasswordSmsCode.html") 
public class IF_获取验证码_忘记密码_ {
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
