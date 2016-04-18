package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 查询个人用户基本信息,客户信息,UserInfoManageController,POST,JSON,/ife/userinfomanage/userBaseInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_userinfomanage_userBaseInfo", path = "/ife/userinfomanage/userBaseInfo.html") 
public class IF_查询个人用户基本信息 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		String certificateTypeName;//  ,默认证件类型-名称,String,不校验,是,
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CertificateTypeList {

				String code;//  ,证件类型,String,不校验,是,
				String describe;//  ,证件类型-名称,String,不校验,是,
}

		 List<CertificateTypeList>certificateTypeList;// 
 
		String mobile;//  ,手机号,String,不校验,是,
		String recomandAccountName;//  ,推荐人姓名,String,不校验,是,
		String name;//  ,姓名,String,不校验,是,
		String phone;//  ,电话,String,不校验,是,
		String content;//  ,紧急联系人,String,不校验,是,
		String contentMobile;//  ,紧急联系人手机,String,不校验,是,
		String address;//  ,地址,String,不校验,是,
		String zipCode;//  ,邮编,String,不校验,是,
		String certificateType;//  ,证件类型,String,不校验,是,
		String certificateCode;//  ,证件号,String,不校验,是,
		String certificateCodeHide;//  ,证据号隐藏,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
