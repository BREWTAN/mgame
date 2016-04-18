package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 设置安保问题-第一步,公共,SecurityQuestionManageController,POST,JSON,/ife/securityquestionmanage/checkUserInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_securityquestionmanage_checkUserInfo", path = "/ife/securityquestionmanage/checkUserInfo.html") 
public class IF_设置安保问题_第一步 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String certificateCode;//  ,身份证号,String,不校验,否,
		String password;//  ,交易密码,String,不校验,否,
		String smsValidateCode;//  ,短信验证码,String,不校验,否,
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
