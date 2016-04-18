package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 可竞价产品查询（竞价大厅列表查询）,产品相关,BadAssetController,POST,JSON,/ife/badasset/loadMyApplyList.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_loadMyApplyList", path = "/ife/badasset/loadMyApplyList.html") 
public class IF_可竞价产品查询 {
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
	public static class TaBadProjectList {

				String projectCode;//  ,项目编号,String,不校验,是,
				String projectName;//  ,项目名称,String,不校验,是,
				String bayWay;//  ,竞价方式,String,不校验,是,
				String bayWayName;//  ,竞价方式,String,不校验,是,
				String firstDatetime;//  ,一次报价开始时间,String,不校验,是,
				String manyDatetime;//  ,多次报价竞价时间,String,不校验,是,
				String cycleDatetime;//  ,多轮开始时间,String,不校验,是,
				String startTime;//  ,开始时间,String,不校验,是,
				String startValue;//  ,起拍价格,String,不校验,是,
				String biddingWay;//  ,竞价方式,String,不校验,是,
				String biddingWayName;//  ,竞拍方式-名称,String,不校验,是,
				String projectStatus;//  ,项目状态,String,不校验,是,
				String projectStatusName;//  ,项目状态-名称,String,不校验,是,
				String canAdmission;//  ,是否能入场,String,不校验,是,1-是，0-否
				String brandCode;//  ,竞买人编号,String,不校验,是,
}

		 List<TaBadProjectList>taBadProjectList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
