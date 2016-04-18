package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 批量已读,客户信息,MessageManageController,POST,JSON,/ife/messagemanage/readMessageBatch.html@onight.mgame.utils.PBInfo(name = "PBIFE_messagemanage_readMessageBatch", path = "/ife/messagemanage/readMessageBatch.html") 
public class IF_批量已读 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String totalId;//  ,编号,String,不校验,否,格式：[123][1245]
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
