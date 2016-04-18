package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 获取来源渠道信息,客户信息,RegController,GET,JSON,/ife/reg/getChannelInfoList.html@onight.mgame.utils.PBInfo(name = "PBIFE_reg_getChannelInfoList", path = "/ife/reg/getChannelInfoList.html") 
public class IF_获取来源渠道信息 {
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
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ChannelInfoList {

		 @PBFields(name = ",渠道编号,String,不校验,是,")
				String channelNo;//  ,渠道编号,String,不校验,是,
		 @PBFields(name = ",渠道名,String,不校验,是,")
				String channelName;//  ,渠道名,String,不校验,是,
}

		 List<ChannelInfoList>channelInfoList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
