package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 加载安保问题,公共,SecurityQuestionManageController,POST,JSON,/ife/securityquestionmanage/loadSecurityQuestion.html@onight.mgame.utils.PBInfo(name = "PBIFE_securityquestionmanage_loadSecurityQuestion", path = "/ife/securityquestionmanage/loadSecurityQuestion.html") 
public class IF_加载安保问题 {
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
	public static class TcSecurityQuestionTemplateList {

				String id;//  ,安保问题PK,String,不校验,否,
				String question;//  ,安保问题内容,String,不校验,否,
				String status;//  ,状态,String,不校验,否,00-正常，01-失效
				String operator;//  ,操作者,String,不校验,否,
				String gmtCreate;//  ,创建时间,String,不校验,否,
				String gmtModify;//  ,修改时间,String,不校验,否,
}

		 List<TcSecurityQuestionTemplateList>tcSecurityQuestionTemplateList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
