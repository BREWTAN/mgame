package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 删除消息,客户信息,MessageManageController,POST,JSON,/ife/messagemanage/deleteMessage.html@onight.mgame.utils.PBInfo(name = "PBIFE_messagemanage_deleteMessage", path = "/ife/messagemanage/deleteMessage.html") 
public class IF_删除消息 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String messageIds;//  ,消息编号,String,,否,
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
