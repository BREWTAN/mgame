package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 查询邮件模版内容,公共,EmailValidateCodeController,POST,JSON,/ife/emailValidateCode/queryEmailContent.html@onight.mgame.utils.PBInfo(name = "PBIFE_emailValidateCode_queryEmailContent", path = "/ife/emailValidateCode/queryEmailContent.html") 
public class IF_查询邮件模版内容 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String inviteUrl;//  ,邀请链接,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",模板内容,String,不校验,否,")
		String templateContent;//  ,模板内容,String,不校验,否,
		 @PBFields(name = ",模板名称,String,不校验,否,")
		String templateName;//  ,模板名称,String,不校验,否,
		 String tfw__reserved;//保留字段 

	}

}
