package onight.mgame.autogens;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onight.mgame.utils.PBFields;



//登陆,servlet,POST,JSON,/front/login.html
@onight.mgame.utils.PBInfo(name = "PBIFE_login", path = "/ife/login.html")
public class IF_登陆 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {


		 @PBFields(name = ",用户名,")
		String username;//  ,用户名,
		 @PBFields(name = ",密码,")
		String password;//  ,密码,
		 @PBFields(name = ",登陆渠道,")
		String loginType;//  ,登陆渠道,
		 @PBFields(name = ",验证码,")
		String authCode;//  ,验证码,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {

		 @PBFields(name = ",message,")
		String message;//  ,message,String,不校验,是,
		 @PBFields(name = ",result,")
		String result;//  ,result,String,不校验,是,

		 String tfw__reserved;//保留字段 

	}

}