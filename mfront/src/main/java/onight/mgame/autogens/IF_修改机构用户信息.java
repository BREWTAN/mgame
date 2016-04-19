package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 修改机构用户信息,客户信息,UserInfoManageController,POST,JSON,/ife/userinfomanage/modifyCompanyInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_userinfomanage_modifyCompanyInfo", path = "/ife/userinfomanage/modifyCompanyInfo.html") 
public class IF_修改机构用户信息 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",地址,String,不校验,否,")
		String address;//  ,地址,String,不校验,否,
		 @PBFields(name = ",邮编,String,不校验,否,")
		String zipCode;//  ,邮编,String,不校验,否,
		 @PBFields(name = ",紧急联系人,String,不校验,否,")
		String content;//  ,紧急联系人,String,不校验,否,
		 @PBFields(name = ",紧急联系人手机号,String,不校验,否,")
		String contentMobile;//  ,紧急联系人手机号,String,不校验,否,
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
