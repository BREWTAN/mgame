package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 更新用户邮箱,客户信息,UserInfoManageController,POST,JSON,/ife/userinfomanage/modifyUserEmail.html@onight.mgame.utils.PBInfo(name = "PBIFE_userinfomanage_modifyUserEmail", path = "/ife/userinfomanage/modifyUserEmail.html") 
public class IF_更新用户邮箱 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",,String,,否,")
		String email;//  ,,String,,否,
		 @PBFields(name = ",,String,,否,")
		String emailValidateCode;//  ,,String,,否,
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
