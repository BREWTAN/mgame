package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 修改手机-第一步,客户信息,MobileManageController,POST,JSON,/ife/mobilemanage/checkUserInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_mobilemanage_checkUserInfo", path = "/ife/mobilemanage/checkUserInfo.html") 
public class IF_修改手机_第一步 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String certificateCode;//  ,身份证号,String,不校验,是,已签约校验是否为空
		String password;//  ,登陆密码,String,不校验,是,
		String securityQuestion;//  ,安保问题,String,不校验,是,已设置安保问题，需提交
		String securityQuestionAnswer;//  ,安保问题答案,String,不校验,是,已设置安保问题，需提交
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
