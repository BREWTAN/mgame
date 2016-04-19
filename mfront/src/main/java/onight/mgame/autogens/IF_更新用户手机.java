package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 更新用户手机,客户信息,MobileManageController,POST,JSON,/ife/mobilemanage/modifyUserMobile.html@onight.mgame.utils.PBInfo(name = "PBIFE_mobilemanage_modifyUserMobile", path = "/ife/mobilemanage/modifyUserMobile.html") 
public class IF_更新用户手机 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",手机号,String,不校验,否,")
		String mobile;//  ,手机号,String,不校验,否,
		 @PBFields(name = ",短信验证码,String,不校验,否,")
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
