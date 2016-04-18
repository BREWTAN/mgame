package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 查询消息,客户信息,MessageManageController,POST,JSON,/ife/messagemanage/listMessage.html@onight.mgame.utils.PBInfo(name = "PBIFE_messagemanage_listMessage", path = "/ife/messagemanage/listMessage.html") 
public class IF_查询消息 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String startDate;//  ,开始日期,String,不校验,否,
		String endDate;//  ,结束日期,String,不校验,否,
		String content;//  ,消息内容,String,不校验,否,
		String pageIndex;//  ,当前页,String,不校验,否,
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
	public static class MessageListList {

		 @PBFields(name = ",编号,String,不校验,是,")
				String id;//  ,编号,String,不校验,是,
		 @PBFields(name = ",发送者id,String,不校验,是,")
				String sender;//  ,发送者id,String,不校验,是,
		 @PBFields(name = ",接收者id,String,不校验,是,")
				String recivier;//  ,接收者id,String,不校验,是,
		 @PBFields(name = ",消息类型,String,不校验,是,0-系统消息；1-私信")
				String msgType;//  ,消息类型,String,不校验,是,0-系统消息；1-私信
		 @PBFields(name = ",消息状态,String,不校验,是,0-正常；1-删除；2-过期")
				String msgStatus;//  ,消息状态,String,不校验,是,0-正常；1-删除；2-过期
		 @PBFields(name = ",阅读状态,String,不校验,是,0-未读；1-已读")
				String readStatus;//  ,阅读状态,String,不校验,是,0-未读；1-已读
		 @PBFields(name = ",标题,String,不校验,是,")
				String title;//  ,标题,String,不校验,是,
		 @PBFields(name = ",内容,String,不校验,是,")
				String content;//  ,内容,String,不校验,是,
		 @PBFields(name = ",创建时间,String,不校验,是,")
				String createTime;//  ,创建时间,String,不校验,是,
		 @PBFields(name = ",更新时间,String,不校验,是,")
				String updateTime;//  ,更新时间,String,不校验,是,
		 @PBFields(name = ",失效时间,String,不校验,是,")
				String expTime;//  ,失效时间,String,不校验,是,
		 @PBFields(name = ",额外消息号,String,不校验,是,若消息内容不够，需要额外表消息保存，关联此字段；默认为0不关联")
				String contentId;//  ,额外消息号,String,不校验,是,若消息内容不够，需要额外表消息保存，关联此字段；默认为0不关联
		 @PBFields(name = ",查询起始日,String,不校验,是,")
				String createTimeStart;//  ,查询起始日,String,不校验,是,
		 @PBFields(name = ",查询终止日,String,不校验,是,")
				String createTimeEnd;//  ,查询终止日,String,不校验,是,
}

		 List<MessageListList>messageListList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
