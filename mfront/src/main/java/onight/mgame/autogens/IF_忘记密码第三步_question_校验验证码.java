package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 忘记密码第三步（设置新密码）,客户信息,ForgetPasswordManageController,POST,JSON,/ife/forgetpasswordmanage/checkQuestion.html@onight.mgame.utils.PBInfo(name = "PBIFE_forgetpasswordmanage_checkQuestion", path = "/ife/forgetpasswordmanage/checkQuestion.html") 
public class IF_忘记密码第三步_question_校验验证码 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		 @PBFields(name = ",安保问题,String,不校验,否,")
		 String securityQuestion;
		 @PBFields(name = ",安保问题答案,String,不校验,否,")
		 String securityQuestionAnswer;
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
