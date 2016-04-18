package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 从缓存加载已设置的安保问题,客户信息,SecurityQuestionManageController,POST,JSON,/ife/securityquestionmanage/loadSecuritySetFromCache.html@onight.mgame.utils.PBInfo(name = "PBIFE_securityquestionmanage_loadSecuritySetFromCache", path = "/ife/securityquestionmanage/loadSecuritySetFromCache.html") 
public class IF_从缓存加载已设置的安保问题 {
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
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class TcSecurityQuestionAnswerList {

				String question;//  ,问题,String,不校验,否,
				String answer;//  ,答案,String,不校验,否,
}

		 List<TcSecurityQuestionAnswerList>tcSecurityQuestionAnswerList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
