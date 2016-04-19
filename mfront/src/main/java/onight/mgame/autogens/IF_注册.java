package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 注册,客户信息,RegController,POST,JSON,/ife/reg/register.html@onight.mgame.utils.PBInfo(name = "PBIFE_reg_register", path = "/ife/reg/register.html") 
public class IF_注册 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",手机号,String,11,否,,")
		String mobile;//  ,手机号,String,11,否,,
		 @PBFields(name = ",图片验证码,String,5,否,,")
		String imageCode;//  ,图片验证码,String,5,否,,
		 @PBFields(name = ",手机验证码,String,5,否,,")
		String checkCode;//  ,手机验证码,String,5,否,,
		 @PBFields(name = ",登录密码,String,不校验,否,,")
		String loginPassword;//  ,登录密码,String,不校验,否,,
		 @PBFields(name = ",登陆密码第二次输入,String,不校验,否,,")
		String loginPasswordSure;//  ,登陆密码第二次输入,String,不校验,否,,
		 @PBFields(name = ",渠道编号,String,不校验,否,,")
		String channelNo;//  ,渠道编号,String,不校验,否,,
		 @PBFields(name = ",推荐人手机号,String,11,是,,")
		String recommendMobile;//  ,推荐人手机号,String,11,是,,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",图片验证码,String,4,否,,")
		String authCode;//  ,图片验证码,String,4,否,,
		 String tfw__reserved;//保留字段 

	}

}
