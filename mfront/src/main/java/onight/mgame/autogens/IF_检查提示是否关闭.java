package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 检查提示是否关闭,客户信息,UserFrontTipsSetController,POST,JSON,/ife/userfronttipsset/checkTips.html@onight.mgame.utils.PBInfo(name = "PBIFE_userfronttipsset_checkTips", path = "/ife/userfronttipsset/checkTips.html") 
public class IF_检查提示是否关闭 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String requestAddress;//  ,请求地址,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",是否关闭,String,不校验,是,true-是，false-否")
		String closed;//  ,是否关闭,String,不校验,是,true-是，false-否
		 String tfw__reserved;//保留字段 

	}

}
