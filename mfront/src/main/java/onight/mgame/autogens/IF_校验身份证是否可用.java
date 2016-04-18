package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 校验身份证是否可用,客户信息,UserInfoManageController,POST,JSON,/ife/userinfomanage/checkIdCard.html@onight.mgame.utils.PBInfo(name = "PBIFE_userinfomanage_checkIdCard", path = "/ife/userinfomanage/checkIdCard.html") 
public class IF_校验身份证是否可用 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String idCard;//  ,身份证,String,18,否,
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
