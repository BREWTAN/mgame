package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 忘记密码第一步（校验手机号）,客户信息,ForgetPasswordManageController,POST,JSON,/ife/forgetpasswordmanage/checkUsername.html@onight.mgame.utils.PBInfo(name = "PBIFE_forgetpasswordmanage_checkUsername", path = "/ife/forgetpasswordmanage/checkUsername.html") 
public class IF_忘记密码第一步_校验用户名_获取用户信息 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",用户名,String,不校验,否,")
		String username;
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
