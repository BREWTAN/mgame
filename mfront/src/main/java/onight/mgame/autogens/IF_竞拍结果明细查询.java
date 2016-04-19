package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 竞拍结果明细查询,产品相关,BadAssetController,POST,JSON,/ife/badasset/loadBiddingResultWrap.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_loadBiddingResultWrap", path = "/ife/badasset/loadBiddingResultWrap.html") 
public class IF_竞拍结果明细查询 {
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
	public static class BiddingResultWrap {

		 @PBFields(name = ",状态,String,不校验,是,")
				String projectStatus;//  ,状态,String,不校验,是,
		 @PBFields(name = ",dealValue,String,不校验,是,")
				String dealValue;//  ,dealValue,String,不校验,是,
		 @PBFields(name = ",brandCode,String,不校验,是,")
				String brandCode;//  ,brandCode,String,不校验,是,
		 @PBFields(name = ",dealTime,String,不校验,是,")
				String dealTime;//  ,dealTime,String,不校验,是,
}

		 BiddingResultWrap biddingResultWrap;// 
 
		 String tfw__reserved;//保留字段 

	}

}
