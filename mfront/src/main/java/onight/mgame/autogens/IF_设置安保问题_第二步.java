package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 设置安保问题-第二步,客户信息,SecurityQuestionManageController,POST,JSON,/ife/securityquestionmanage/setSecurityQuestionPre.html@onight.mgame.utils.PBInfo(name = "PBIFE_securityquestionmanage_setSecurityQuestionPre", path = "/ife/securityquestionmanage/setSecurityQuestionPre.html") 
public class IF_设置安保问题_第二步 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String questionCount;//  ,安保问题数量,String,不校验,否,
		String questionId_N;//  ,安保问题编号,String,不校验,否,N为编号从1-N累加
		String questionAnswer_N;//  ,安保问题答案,String,不校验,否,N为编号从1-N累加
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
