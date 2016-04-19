package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 好友推荐邮件发送,公共,EmailValidateCodeController,POST,JSON,/ife/emailValidateCode/sendRecommedEmail.html@onight.mgame.utils.PBInfo(name = "PBIFE_emailValidateCode_sendRecommedEmail", path = "/ife/emailValidateCode/sendRecommedEmail.html") 
public class IF_好友推荐邮件发送 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",邮件验证码类型,String,不校验,否,")
		String smsValidateCodeType;//  ,邮件验证码类型,String,不校验,否,
		 @PBFields(name = ",图片验证码,String,不校验,否,")
		String emailImageCode;//  ,图片验证码,String,不校验,否,
		 @PBFields(name = ",邮箱列表,String,不校验,否,")
		String emailList;//  ,邮箱列表,String,不校验,否,
		 @PBFields(name = ",邀请链接,String,不校验,否,")
		String inviteUrl;//  ,邀请链接,String,不校验,否,
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
