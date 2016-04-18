package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 统计未读消息总数,客户信息,MessageManageController,POST,JSON,/ife/messagemanage/countMessage.html@onight.mgame.utils.PBInfo(name = "PBIFE_messagemanage_countMessage", path = "/ife/messagemanage/countMessage.html") 
public class IF_统计未读消息总数 {
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
		String unReadMessageCount;//  ,未读消息总数,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
