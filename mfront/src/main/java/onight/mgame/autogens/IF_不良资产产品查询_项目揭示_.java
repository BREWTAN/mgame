package onight.mgame.autogens;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onight.mgame.utils.PBInfo;

// 不良资产产品查询(项目揭示),产品相关,BadAssetController,POST,JSON,/ife/badasset/queryProjectReveal.html@PBInfo(name = "PBIFE_badasset_queryProjectReveal", path = "/ife/badasset/queryProjectReveal.html") 
public class IF_不良资产产品查询_项目揭示_ {
	// =======REQuest============== 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String pageIndex;//  ,当前页,String,不校验,否,默认1
		String pageSize;//  ,页大小,String,不校验,否,默认10
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
				String assetKind;//  ,资产种类,String,不校验,是,
				String assetKindName;//  ,资产种类名称,String,不校验,是,
				String assetAddress;//  ,资产所在地,String,不校验,是,
				String loanRightPrincipal;//  ,债权本金(万元),String,不校验,是,
				String tradingCenterContact;//  ,交易中心联系人,String,不校验,是,
				String tradingCenterContactTel;//  ,交易中心联系电话,String,不校验,是,
				String quotationEndTime;//  ,挂牌截止时间,String,不校验,是,
				String quotationPrice;//  ,挂牌价,String,不校验,是,
				String projectStatus;//  ,项目状态,String,不校验,是,
				String projectStatusName;//  ,项目状态,String,不校验,是,
				String isSign;//  ,是否报名 0未报名 1已报名,String,不校验,是,
}

		 List<TaBadProjectList>taBadProjectList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
