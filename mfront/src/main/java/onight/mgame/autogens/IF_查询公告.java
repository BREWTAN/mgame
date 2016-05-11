package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 查询消息,客户信息,MessageManageController,POST,JSON,/ife/messagemanage/listInnerMessage.html@onight.mgame.utils.PBInfo(name = "PBIFE_messagemanage_listInnerMessage", path = "/ife/messagemanage/listInnerMessage.html") 
public class IF_查询公告 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",当前页,String,不校验,否,")
		String pageIndex;//  ,当前页,String,不校验,否,
		 @PBFields(name = ",页大小,String,不校验,否,")
		String pageSize;//  ,页大小,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class PageInfo {

		 @PBFields(name = ",页大小,String,不校验,是,")
				String pageSize;//  ,页大小,String,不校验,是,
		 @PBFields(name = ",当前页,String,不校验,是,")
				String pageIndex;//  ,当前页,String,不校验,是,
		 @PBFields(name = ",总页数,String,不校验,是,")
				String pageCount;//  ,总页数,String,不校验,是,
		 @PBFields(name = ",总条数,String,不校验,是,")
				String totalCount;//  ,总条数,String,不校验,是,
}

		 @PBFields(name = ",消息列表,List,不校验,是,")
			PageInfo pageInfo;// 
 
			@Data
			@AllArgsConstructor
			@NoArgsConstructor
			public static class msgInnerMessageListList {

				 @PBFields(name = ",编号,String,不校验,是,")
						String id;//  ,编号,String,不校验,是,
				 @PBFields(name = ",发送者id,String,不校验,是,")
						String sender;//  ,发送者id,String,不校验,是,
				@PBFields(name = ",发送者名称,String,不校验,是,")
						String senderName;//  ,发送者名称,String,不校验,是,
				 @PBFields(name = ",接收者id,String,不校验,是,")
						String recivier;//  ,接收者id,String,不校验,是,
				@PBFields(name = ",接收者名称,String,不校验,是,")
						String reciverName;//  ,接收者名称,String,不校验,是,
				 @PBFields(name = ",阅读状态,String,不校验,是,")
						String readStatus;//  ,阅读状态,String,不校验,是,
				 @PBFields(name = ",标题,String,不校验,是,")
						String title;//  ,标题,String,不校验,是,
				 @PBFields(name = ",消息内容关联id,String,不校验,是,")
						String message;//  ,消息内容关联id,String,不校验,是,
				 @PBFields(name = ",所属的客户端系统,String,不校验,是,")
						String client;//  ,所属的客户端系统,String,不校验,是,
				 @PBFields(name = ",创建时间,String,不校验,是,")
						String gmtCreate;//  ,创建时间,String,不校验,是,
				 @PBFields(name = ",公告内容,List,不校验,是,")
					List<MsgMessage> msgMessage;// ,公告内容,List,不校验,是,

					@Data
					@AllArgsConstructor
					@NoArgsConstructor
					public static class MsgMessage {

						@PBFields(name = ",PK,String,不校验,是,")
						String id;// ,PK,String,不校验,是,
						@PBFields(name = ",标题,String,不校验,是,")
						String title;// ,标题,String,不校验,是,
						@PBFields(name = ",所属的客户端系统,String,不校验,是,")
						String client;// ,所属的客户端系统,String,不校验,是,
						@PBFields(name = ",创建时间,String,不校验,是,")
						String gmtCreate;// ,创建时间,String,不校验,是,
						@PBFields(name = ",内容,String,不校验,是,")
						String content;// ,内容,String,不校验,是,
						
					}
			}

		 List<msgInnerMessageListList>msgInnerMessageListList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
