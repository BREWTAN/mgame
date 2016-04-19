package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 竞拍结果查询,产品相关,BadAssetController,POST,JSON,/ife/badasset/loadBadAssetResult.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_loadBadAssetResult", path = "/ife/badasset/loadBadAssetResult.html") 
public class IF_竞拍结果查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",当前页,String,不校验,是,默认1")
		String pageIndex;//  ,当前页,String,不校验,是,默认1
		 @PBFields(name = ",页大小,String,不校验,是,默认10")
		String pageSize;//  ,页大小,String,不校验,是,默认10
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

		 @PBFields(name = ",竞拍结果列表,List,不校验,否,")
PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class TaBadProjectResultWrapList {

		 @PBFields(name = ",项目编号,String,不校验,否,")
				String projectCode;//  ,项目编号,String,不校验,否,
		 @PBFields(name = ",项目名称,String,不校验,否,")
				String projectName;//  ,项目名称,String,不校验,否,
		 @PBFields(name = ",挂牌价,String,不校验,否,")
				String quotationPrice;//  ,挂牌价,String,不校验,否,
		 @PBFields(name = ",成交价格,String,不校验,否,")
				String dealValue;//  ,成交价格,String,不校验,否,
		 @PBFields(name = ",拍卖结束时间,String,不校验,否,")
				String dealTime;//  ,拍卖结束时间,String,不校验,否,
		 @PBFields(name = ",竞价方式,String,不校验,否,")
				String bayWay;//  ,竞价方式,String,不校验,否,
		 @PBFields(name = ",竞价方式-名称,String,不校验,否,")
				String bayWayName;//  ,竞价方式-名称,String,不校验,否,
}

		 List<TaBadProjectResultWrapList>taBadProjectResultWrapList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
