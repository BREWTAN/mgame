package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 查询短信模版内容,公共,SmsValidateCodeController,POST,JSON,/ife/smsvalidatecode/queryMessageContent.html@onight.mgame.utils.PBInfo(name = "PBIFE_smsvalidatecode_queryMessageContent", path = "/ife/smsvalidatecode/queryMessageContent.html") 
public class IF_查询短信模版内容 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",,String,,否,")
		String inviteUrl;//  ,,String,,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",短信模板内容,String,不校验,否,")
		String templateContent;//  ,短信模板内容,String,不校验,否,
		 String tfw__reserved;//保留字段 

	}

}
