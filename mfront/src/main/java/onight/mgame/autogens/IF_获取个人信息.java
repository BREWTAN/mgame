package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 获取个人信息,客户信息,UserBaseInfoController,POST,JSON,/ife/userbaseinfo/getBasicInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_userbaseinfo_getBasicInfo", path = "/ife/userbaseinfo/getBasicInfo.html") 
public class IF_获取个人信息 {
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
		String mobile;//  ,手机号,String,不校验,是,
		String name;//  ,姓名,String,不校验,是,
		String account;//  ,账号,String,不校验,是,
		String certificateCode;//  ,证件号,String,不校验,是,
		String certificateType;//  ,证件类型,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
