package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 更新个人用户基本信息,客户信息,UserInfoManageController,POST,JSON,/ife/userinfomanage/modifyUserBaseInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_userinfomanage_modifyUserBaseInfo", path = "/ife/userinfomanage/modifyUserBaseInfo.html") 
public class IF_更新个人用户基本信息 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",邮编,String,不校验,是,")
		String zipCode;//  ,邮编,String,不校验,是,
		 @PBFields(name = ",地址,String,不校验,是,")
		String address;//  ,地址,String,不校验,是,
		 @PBFields(name = ",手机号,String,11,是,")
		String phone;//  ,手机号,String,11,是,
		 @PBFields(name = ",紧急联系人,String,不校验,是,")
		String content;//  ,紧急联系人,String,不校验,是,
		 @PBFields(name = ",紧急联系人手机号,String,11,是,")
		String contentMobile;//  ,紧急联系人手机号,String,11,是,
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
