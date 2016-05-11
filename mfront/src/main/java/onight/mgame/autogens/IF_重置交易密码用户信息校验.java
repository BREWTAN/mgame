package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 重置交易密码用户信息校验,客户信息,PasswordManageController,POST,JSON,/ife/passwordmanage/checkUserInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_passwordmanage_checkUserInfo", path = "/ife/passwordmanage/checkUserInfo.html") 
public class IF_重置交易密码用户信息校验 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",安保问题,String,不校验,是,已设置安保问题不能为空")
		String securityQuestion;//  ,安保问题,String,不校验,是,已设置安保问题不能为空
		 @PBFields(name = ",安保问题答案,String,不校验,是,已设置安保问题不能为空")
		String securityQuestionAnswer;//  ,安保问题答案,String,不校验,是,已设置安保问题不能为空
		 @PBFields(name = ",身份证,String,不校验,是,已签约不能为空")
		String certificateCode;//  ,身份证,String,不校验,是,已签约不能为空
		 @PBFields(name = ",短信验证码,String,不校验,是,")
		String smsValidateCode;//  ,短信验证码,String,不校验,是,
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
