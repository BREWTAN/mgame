package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 邀请好友短信发送,公共,SmsValidateCodeController,POST,JSON,/ife/smsvalidatecode/sendRecommendMessage.html@onight.mgame.utils.PBInfo(name = "PBIFE_smsvalidatecode_sendRecommendMessage", path = "/ife/smsvalidatecode/sendRecommendMessage.html") 
public class IF_邀请好友短信发送 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",图片验证码,String,不校验,否,")
		String imageCode;//  ,图片验证码,String,不校验,否,
		 @PBFields(name = ",手机号码列表,String,不校验,否,'格式''[124xxx][123xxx]'''")
		String mobileList;//  ,手机号码列表,String,不校验,否,"格式""[124xxx][123xxx]"""
		 @PBFields(name = ",验证码类型,String,不校验,否,")
		String smsValidateCodeType;//  ,验证码类型,String,不校验,否,
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
