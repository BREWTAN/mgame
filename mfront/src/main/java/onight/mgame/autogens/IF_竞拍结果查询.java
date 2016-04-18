package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 竞拍结果查询,产品相关,BadAssetController,POST,JSON,/ife/badasset/loadBadAssetResult.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_loadBadAssetResult", path = "/ife/badasset/loadBadAssetResult.html") 
public class IF_竞拍结果查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String pageIndex;//  ,当前页,String,不校验,是,默认1
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

				String pageSize;//  ,页大小,String,不校验,是,
				String pageIndex;//  ,当前页,String,不校验,是,
				String pageCount;//  ,总页数,String,不校验,是,
				String totalCount;//  ,总条数,String,不校验,是,
}

		 PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class TaBadProjectResultWrapList {

				String projectCode;//  ,项目编号,String,不校验,否,
				String projectName;//  ,项目名称,String,不校验,否,
				String quotationPrice;//  ,挂牌价,String,不校验,否,
				String dealValue;//  ,成交价格,String,不校验,否,
				String dealTime;//  ,拍卖结束时间,String,不校验,否,
				String bayWay;//  ,竞价方式,String,不校验,否,
				String bayWayName;//  ,竞价方式-名称,String,不校验,否,
}

		 List<TaBadProjectResultWrapList>taBadProjectResultWrapList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
