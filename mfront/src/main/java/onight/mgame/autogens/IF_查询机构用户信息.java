package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 查询机构用户信息,客户信息,UserInfoManageController,POST,JSON,/ife/userinfomanage/companyUserInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_userinfomanage_companyUserInfo", path = "/ife/userinfomanage/companyUserInfo.html") 
public class IF_查询机构用户信息 {
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
		String userSubType;//  ,用户类型,String,不校验,是,
		String name;//  ,机构名称,String,不校验,是,
		String orgShortName;//  ,简称,String,不校验,是,
		String registeFund;//  ,注册资金,String,不校验,是,
		String taxCode;//  ,税号,String,不校验,是,
		String certificateCode;//  ,证件号,String,不校验,是,
		String orgCode;//  ,组织机构代码,String,不校验,是,
		String legal;//  ,法人,String,不校验,是,
		String legalCardType;//  ,法人证件类型,String,不校验,是,
		String legalCard;//  ,法人证件号,String,不校验,是,
		String email;//  ,联系人邮箱,String,不校验,是,
		String phone;//  ,联系人手机,String,不校验,是,
		String address;//  ,公司地址,String,不校验,是,
		String zipCode;//  ,邮编,String,不校验,是,
		String managerPerson;//  ,经办人,String,不校验,是,
		String managerNationality;//  ,经办人国籍,String,不校验,是,
		String managerCardType;//  ,经办人证件类型,String,不校验,是,
		String managerCard;//  ,经办人证件号,String,不校验,是,
		String managerEmail;//  ,经办人邮箱,String,不校验,是,
		String managerMobile;//  ,经办人手机,String,不校验,是,
		String managerPhone;//  ,经办人电话,String,不校验,是,
		String managerDept;//  ,经办人部门,String,不校验,是,
		String managerPost;//  ,经办人传真,String,不校验,是,
		String content;//  ,紧急联系人,String,不校验,是,
		String contentMobile;//  ,紧急联系人手机,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
