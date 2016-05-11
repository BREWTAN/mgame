package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 忘记密码第二步（校验手机验证码）,客户信息,ForgetPasswordManageController,POST,JSON,/ife/forgetpasswordmanage/findWaysInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_forgetpasswordmanage_findWaysInfo", path = "/ife/forgetpasswordmanage/findWaysInfo.html") 
public class IF_忘记密码第二步_所有找回方式 {
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
			 String tfw__reserved;//保留字段 

		}
		
		List<TcSecurityQuestionAnswer> tcSecurityQuestionAnswerList;
		@PBFields(name = ",是否设置安保问题,boolean,不校验,是,")
		boolean isSecuritySet;
		@PBFields(name = ",会员编号,String,不校验,是,")
		String memberCode;
		@PBFields(name = ",邮箱信息,String,不校验,是,")
		String email;
		@PBFields(name = ",手机信息,String,不校验,是,")
		String mobile;
		
		 String tfw__reserved;//保留字段 

	}

}
