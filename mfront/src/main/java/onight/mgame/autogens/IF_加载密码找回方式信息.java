package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;

import onight.mgame.autogens.IF_忘记密码第二步_所有找回方式.Response.TcSecurityQuestionAnswer;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 忘记密码第三步（设置新密码）,客户信息,ForgetPasswordManageController,POST,JSON,/ife/forgetpasswordmanage/loadFindWaysInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_forgetpasswordmanage_loadFindWaysInfo", path = "/ife/forgetpasswordmanage/loadFindWaysInfo.html") 
public class IF_加载密码找回方式信息 {
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
		
		public class TcSecurityQuestionAnswer {
			/*安保问题答案PK*/
			@PBFields(name = ",安保问题答案PK,BigDecimal,不校验,是,")
		    BigDecimal id;
		    /*安保问题答案*/
		    @PBFields(name = ",安保问题答案,String,不校验,是,")
		    String answer;
		}
		
		List<TcSecurityQuestionAnswer> tcSecurityQuestionAnswerList;
		@PBFields(name = ",是否设置安保问题,boolean,不校验,是,")
		boolean isSecuritySet;
		@PBFields(name = ",邮箱信息,String,不校验,是,")
		String email;
		@PBFields(name = ",手机信息,String,不校验,是,")
		String mobile;
		
		 String tfw__reserved;//保留字段 

	}

}
