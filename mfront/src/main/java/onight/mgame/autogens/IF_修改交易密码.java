package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 修改交易密码,客户信息,PasswordManageController,POST,JSON,/ife/passwordmanage/alterTradePassword.html@onight.mgame.utils.PBInfo(name = "PBIFE_passwordmanage_alterTradePassword", path = "/ife/passwordmanage/alterTradePassword.html") 
public class IF_修改交易密码 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",原交易密码,String,不校验,否,")
		String password;//  ,原交易密码,String,不校验,否,
		 @PBFields(name = ",新交易密码,String,不校验,否,")
		String passwordNew;//  ,新交易密码,String,不校验,否,
		 @PBFields(name = ",确认密码,String,不校验,否,")
		String passwordSure;//  ,确认密码,String,不校验,否,
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
