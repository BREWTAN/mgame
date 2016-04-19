package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 标记消息已读,客户信息,MessageManageController,POST,JSON,/ife/messagemanage/signMessageRead.html@onight.mgame.utils.PBInfo(name = "PBIFE_messagemanage_signMessageRead", path = "/ife/messagemanage/signMessageRead.html") 
public class IF_标记消息已读 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",消息编号,String,不校验,否,")
		String messageIds;//  ,消息编号,String,不校验,否,
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
