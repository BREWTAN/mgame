package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 加载我设置的安保问题,客户信息,SecurityQuestionManageController,POST,JSON,/ife/securityquestionmanage/loadMySecurityQuestion.html@onight.mgame.utils.PBInfo(name = "PBIFE_securityquestionmanage_loadMySecurityQuestion", path = "/ife/securityquestionmanage/loadMySecurityQuestion.html") 
public class IF_加载我设置的安保问题 {
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
		 @PBFields(name = ",是否设置安保问题,String,不校验,否,")
		String isSecuritySet;//  ,是否设置安保问题,String,不校验,否,
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class TcSecurityQuestionAnswerList {

		 @PBFields(name = ",安保问题编号,String,不校验,否,")
				String id;//  ,安保问题编号,String,不校验,否,
		 @PBFields(name = ",安保问题,String,不校验,否,")
				String question;//  ,安保问题,String,不校验,否,
}

		 List<TcSecurityQuestionAnswerList>tcSecurityQuestionAnswerList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
