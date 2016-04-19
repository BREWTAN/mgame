package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 关闭提示,客户信息,UserFrontTipsSetController,POST,JSON,/ife/userfronttipsset/closeTips.html@onight.mgame.utils.PBInfo(name = "PBIFE_userfronttipsset_closeTips", path = "/ife/userfronttipsset/closeTips.html") 
public class IF_关闭提示 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",请求地址,String,不校验,否,")
		String requestAddress;//  ,请求地址,String,不校验,否,
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
