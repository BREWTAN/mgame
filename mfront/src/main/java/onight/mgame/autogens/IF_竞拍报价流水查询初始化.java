package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 竞拍报价流水查询初始化,产品相关,BadAssetController,POST,JSON,/ife/badasset/loadOfferSerialInit.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_loadOfferSerialInit", path = "/ife/badasset/loadOfferSerialInit.html") 
public class IF_竞拍报价流水查询初始化 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",项目编号,String,不校验,否,")
		String projectCode;//  ,项目编号,String,不校验,否,
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
	public static class OfferSerialInitWrap {

		 @PBFields(name = ",当前轮次,String,不校验,否,")
				String currentRound;//  ,当前轮次,String,不校验,否,
		 @PBFields(name = ",总轮次,String,不校验,否,")
				String totalRound;//  ,总轮次,String,不校验,否,
		 @PBFields(name = ",下一轮次开始时间,String,不校验,否,")
				String nextRoundBeginCount;//  ,下一轮次开始时间,String,不校验,否,
		 @PBFields(name = ",竞拍结束,String,不校验,否,")
				String isBiddingEnd;//  ,竞拍结束,String,不校验,否,
}

		 List<OfferSerialInitWrap>offerSerialInitWrap;// 
 
		 String tfw__reserved;//保留字段 

	}

}
