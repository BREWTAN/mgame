package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 获取用户类型,客户信息,UserBaseInfoController,POST,JSON,/ife/userbaseinfo/getUserType.html@onight.mgame.utils.PBInfo(name = "PBIFE_userbaseinfo_getUserType", path = "/ife/userbaseinfo/getUserType.html") 
public class IF_获取用户类型 {
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
		String userType;//  ,用户类型,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
