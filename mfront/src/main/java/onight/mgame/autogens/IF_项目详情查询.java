package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 项目详情查询,产品相关,BadAssetController,POST,JSON,/ife/badasset/loadBadAssetProjectDetail.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_loadBadAssetProjectDetail", path = "/ife/badasset/loadBadAssetProjectDetail.html") 
public class IF_项目详情查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

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
	public static class Detail {

				String projectCode;//  ,产品编码,String,不校验,是,
				String projectName;//  ,产品名称,String,不校验,是,
				String industry;//  ,所属行业,String,不校验,是,
				String industryName;//  ,所属行业-名称,String,不校验,是,
				String assetKind;//  ,资产种类,String,不校验,是,
				String assetKindName;//  ,资产种类名称,String,不校验,是,
				String assetAddress;//  ,资产所在地,String,不校验,是,
				String debtor;//  ,债务人,String,不校验,是,
				String debtorLawsuitStatus;//  ,债务人诉讼状态,String,不校验,是,
				String debtorLawsuitStatusName;//  ,债务人诉讼状态-名称,String,不校验,是,
				String debtorManageStatus;//  ,债务人经营状态,String,不校验,是,
				String debtorManageStatusName;//  ,债务人经营状态-名称,String,不校验,是,
				String involveCrownCaseFlag;//  ,是否涉及刑事案件,String,不校验,是,
				String involveCrownCaseFlagName;//  ,是否涉及刑事案件-名称,String,不校验,是,
				String lawCompany;//  ,出具法律意见书的律师机构,String,不校验,是,
				String assessCompany;//  ,评估机构名称,String,不校验,是,
				String assessValue;//  ,评估值(万元),String,不校验,是,
				String underlyingAmount;//  ,标的金额(万元),String,不校验,是,
				String loanRightPrincipal;//  ,债权本金(万元),String,不校验,是,
				String loanRightInterest;//  ,债权利息(万元),String,不校验,是,
				String mortgagePrincipal;//  ,抵押本金(万元),String,不校验,是,
				String zortgagePrincipal;//  ,质押本金(万元),String,不校验,是,
				String ensurePrincipal;//  ,保证本金(万元),String,不校验,是,
				String secureDes;//  ,保证人描述,String,不校验,是,
				String secureForm;//  ,担保形式,String,不校验,是,
				String tradingCenterContact;//  ,交易中心联系人,String,不校验,是,
				String tradingCenterContactTel;//  ,交易中心联系电话,String,不校验,是,
				String sellerName;//  ,转让方企业(单位)名称,String,不校验,是,
				String sellerAddress;//  ,转让方所在地区,String,不校验,是,
				String legalPerson;//  ,转让方法人代表/负责人,String,不校验,是,
				String legalPersonPhone;//  ,转让方法人/负责人电话,String,不校验,是,
				String delayedDeadline;//  ,延牌期限(每期),String,不校验,是,
				String automaticQuotationTime;//  ,自动挂牌时间,String,不校验,是,
				String quotationPrice;//  ,挂牌价,String,不校验,是,
				String biddingWay;//  ,竞价方式,String,不校验,是,
				String BiddingWayName;//  ,竞价方式名称,String,不校验,是,
				String isDividePay;//  ,是否分期付款,String,不校验,是,
				String IsDividePayName;//  ,是否分期付款-名称,String,不校验,是,
				String assetType;//  ,资产类型,String,不校验,是,
				String AssetTypeName;//  ,资产类型-名称,String,不校验,是,
				String quotationEndTime;//  ,竞拍截止时间,String,不校验,是,
				String messagePublish;//  ,重大事项披露,String,不校验,是,
				String notice;//  ,处置公告,String,不校验,是,
				String buyerQualified;//  ,受让方应具备条件,String,不校验,是,
				String guaranteeName;//  ,抵押物品名称,String,不校验,是,
				String guaranteePrice;//  ,抵押物价值（万元）,String,不校验,是,
				String guaranteeProductDes;//  ,物品描述,String,不校验,是,
				String pldegeName;//  ,物品名称,String,不校验,是,
				String pledgePrice;//  ,质押物价值（万元）,String,不校验,是,
				String productDes;//  ,物品描述,String,不校验,是,
				String amount;//  ,金额,String,不校验,是,
				String marginPayFrom;//  ,保证金缴纳方式,String,不校验,是,
				String MarginPayFromName;//  ,保证金缴纳方式-名称,String,不校验,是,
				String bayWay;//  ,竞价方式,String,不校验,是,
				String BayWayName;//  ,竞价方式中文名,String,不校验,是,
				String firstDatetime;//  ,一次报价开始时间,String,不校验,是,
				String firstTime;//  ,一次竞价时长,String,不校验,是,
				String manyDatetime;//  ,多次报价竞价时间,String,不校验,是,
				String manyTime;//  ,多次竞价时长,String,不校验,是,
				String lateTime;//  ,延时时长,String,不校验,是,
				String cycleNum;//  ,多伦报价轮次数,String,不校验,是,
				String cycleDatetime;//  ,多轮开始时间,String,不校验,是,
				String cycleEveyrTime;//  ,每轮时长,String,不校验,是,
				String cycleIntervalTime;//  ,轮次间隔时长,String,不校验,是,
				String outNum;//  ,每轮淘汰人数,String,不校验,是,
				String startValue;//  ,起拍价格,String,不校验,是,
				String priceDirection;//  ,加价方向,String,不校验,是,
				String bidRate;//  ,出价幅度,String,不校验,是,
				String ishold;//  ,是否有保留价,String,不校验,是,
				String holdPrice;//  ,保留价价格,String,不校验,是,
				String currentRounds;//  ,多轮报价当前轮次,String,不校验,是,
				String eveyrStartTime;//  ,当前轮开始时间,String,不校验,是,
				String jingpaiEndDateTime;//  ,竞拍截止时间,String,不校验,是,
}

		 Detail detail;// 
 
		 String tfw__reserved;//保留字段 

	}

}
