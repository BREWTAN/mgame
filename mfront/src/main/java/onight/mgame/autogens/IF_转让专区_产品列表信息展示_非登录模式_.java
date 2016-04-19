package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 转让专区-产品列表信息展示（非登录模式）,产品相关,PrdTransferQueryController,POST,JSON,/ife/prdtransferquery/queryTransferProductListNoLogon.html@onight.mgame.utils.PBInfo(name = "PBIFE_prdtransferquery_queryTransferProductListNoLogon", path = "/ife/prdtransferquery/queryTransferProductListNoLogon.html") 
public class IF_转让专区_产品列表信息展示_非登录模式_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",当前页,String,不校验,是,默认1")
		String pageIndex;//  ,当前页,String,不校验,是,默认1
		 @PBFields(name = ",页大小,String,不校验,是,默认10")
		String pageSize;//  ,页大小,String,不校验,是,默认10
		 @PBFields(name = ",委托类型,String,不校验,是,")
		String delegateType;//  ,委托类型,String,不校验,是,
		 @PBFields(name = ",产品编号,String,不校验,是,")
		String productCode;//  ,产品编号,String,不校验,是,
		 @PBFields(name = ",产品名,String,不校验,是,")
		String productName;//  ,产品名,String,不校验,是,
		 @PBFields(name = ",排序列名,String,不校验,是,")
		String orderBy;//  ,排序列名,String,不校验,是,
		 @PBFields(name = ",排序顺序,String,不校验,是,")
		String orderAsc;//  ,排序顺序,String,不校验,是,
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

		 @PBFields(name = ",转让产品列表,List,不校验,否,")
PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ProductTradeInfoList {

		 @PBFields(name = ",委托表PK,String,不校验,否,")
				String delegationId;//  ,委托表PK,String,不校验,否,
		 @PBFields(name = ",委托编号,String,不校验,否,产品编号+委托时间+6位编号")
				String delegationCode;//  ,委托编号,String,不校验,否,产品编号+委托时间+6位编号
		 @PBFields(name = ",产品代码,String,不校验,否,")
				String productCode;//  ,产品代码,String,不校验,否,
		 @PBFields(name = ",产品名称,String,不校验,否,")
				String productName;//  ,产品名称,String,不校验,否,
		 @PBFields(name = ",管理公司名称,String,不校验,否,")
				String companyName;//  ,管理公司名称,String,不校验,否,
		 @PBFields(name = ",资金账户,String,不校验,否,")
				String cashAccount;//  ,资金账户,String,不校验,否,
		 @PBFields(name = ",委托时间,String,不校验,否,")
				String delegateTime;//  ,委托时间,String,不校验,否,
		 @PBFields(name = ",委托金额,String,不校验,否,")
				String delegateAmount;//  ,委托金额,String,不校验,否,
		 @PBFields(name = ",委托类型,String,不校验,否,认购、协议卖出、定价卖出、定价买入")
				String delegateType;//  ,委托类型,String,不校验,否,认购、协议卖出、定价卖出、定价买入
		 @PBFields(name = ",委托状态,String,不校验,否,委托中、委托成功、委托失败、委托关闭")
				String delegateStatus;//  ,委托状态,String,不校验,否,委托中、委托成功、委托失败、委托关闭
		 @PBFields(name = ",委托单位,String,不校验,否,")
				String delegateNum;//  ,委托单位,String,不校验,否,
		 @PBFields(name = ",撤单标志,String,不校验,否,")
				String cancelStatus;//  ,撤单标志,String,不校验,否,
		 @PBFields(name = ",买卖类型,String,不校验,否,买方、卖方")
				String saleType;//  ,买卖类型,String,不校验,否,买方、卖方
		 @PBFields(name = ",交易账户,String,不校验,否,")
				String tradeAccount;//  ,交易账户,String,不校验,否,
		 @PBFields(name = ",手续费,String,不校验,否,")
				String extraCost;//  ,手续费,String,不校验,否,
		 @PBFields(name = ",创建时间,String,不校验,否,")
				String gmtCreate;//  ,创建时间,String,不校验,否,
		 @PBFields(name = ",修改时间,String,不校验,否,")
				String gmtModify;//  ,修改时间,String,不校验,否,
		 @PBFields(name = ",单位金额,String,不校验,否,")
				String unitAmount;//  ,单位金额,String,不校验,否,
		 @PBFields(name = ",预期年化收益率,String,不校验,否,")
				String expectedMaxAnnualRate;//  ,预期年化收益率,String,不校验,否,
		 @PBFields(name = ",实际年化收益率,String,不校验,否,")
				String actualAnnualRate;//  ,实际年化收益率,String,不校验,否,
		 @PBFields(name = ",管理期限开始时间,String,不校验,否,")
				String manageStartDate;//  ,管理期限开始时间,String,不校验,否,
		 @PBFields(name = ",管理期限开始时间,String,不校验,否,")
				String manageEndDate;//  ,管理期限开始时间,String,不校验,否,
		 @PBFields(name = ",管理期限结束时间,String,不校验,否,")
				String unActualPrice;//  ,管理期限结束时间,String,不校验,否,
		 @PBFields(name = ",交易开始日期,String,不校验,否,")
				String tradeStartDate;//  ,交易开始日期,String,不校验,否,
		 @PBFields(name = ",交易结束日期,String,不校验,否,")
				String tradeEndDate;//  ,交易结束日期,String,不校验,否,
		 @PBFields(name = ",最少持有份额,String,不校验,否,")
				String leastHoldAmount;//  ,最少持有份额,String,不校验,否,
		 @PBFields(name = ",发行机构,String,不校验,否,")
				String issueCompany;//  ,发行机构,String,不校验,否,
		 @PBFields(name = ",发行机构名称,String,不校验,否,")
				String issueCompanyName;//  ,发行机构名称,String,不校验,否,
		 @PBFields(name = ",参考收益率,String,不校验,否,")
				String targetRate;//  ,参考收益率,String,不校验,否,
		 @PBFields(name = ",实际收益率,String,不校验,否,")
				String actualRate;//  ,实际收益率,String,不校验,否,
		 @PBFields(name = ",交易最低持有时间,String,不校验,否,")
				String tradeLeastHoldDay;//  ,交易最低持有时间,String,不校验,否,
		 @PBFields(name = ",最低转让份额,String,不校验,否,")
				String leastTranAmount;//  ,最低转让份额,String,不校验,否,
		 @PBFields(name = ",交易增量,String,不校验,否,")
				String tradeIncrease;//  ,交易增量,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String transactionAmount;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String transactionNum;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String isBuyBackFlag;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String marketingChannel;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String terminalNo;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String brokerCode;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String riskLevel;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String discountRate;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String deadline;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String yearDay;//  ,,String,不校验,否,
		 @PBFields(name = ",已存续天数,String,不校验,否,")
				String holdDayNum;//  ,已存续天数,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String productStartDate;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String brokerNo;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String channelNo;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String picUrl;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String picSUrl;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String subjectType;//  ,,String,不校验,否,
		 @PBFields(name = ",,String,不校验,否,")
				String prodSubType;//  ,,String,不校验,否,
		 @PBFields(name = ",下次确权日,String,不校验,否,")
				String nextPayDate;//  ,下次确权日,String,不校验,否,
		 @PBFields(name = ",每万元利息折让,String,不校验,否,")
				String cutAmount;//  ,每万元利息折让,String,不校验,否,
		 @PBFields(name = ",剩余天数,String,不校验,否,")
				String leftDays;//  ,剩余天数,String,不校验,否,
		 @PBFields(name = ",公正资金账号,String,不校验,否,")
				String rejectFundAccount;//  ,公正资金账号,String,不校验,否,
		 @PBFields(name = ",排序,String,不校验,否,")
				String orderBy;//  ,排序,String,不校验,否,
		 @PBFields(name = ",按照产品编号或名称模糊查询,String,不校验,否,")
				String productNameOrCode;//  ,按照产品编号或名称模糊查询,String,不校验,否,
		 @PBFields(name = ",交易对象,String,不校验,否,")
				String transferObject;//  ,交易对象,String,不校验,否,
		 @PBFields(name = ",最小购买金额,String,不校验,否,")
				String buyerSmallestAmount;//  ,最小购买金额,String,不校验,否,
		 @PBFields(name = ",销售对象,String,不校验,否,")
				String saleObject;//  ,销售对象,String,不校验,否,
		 @PBFields(name = ",产品剩余期限查询条件,List,不校验,否,")
				String deadLineList;//  ,产品剩余期限查询条件,List,不校验,否,
		 @PBFields(name = ",预期收益率查询条件,List,不校验,否,")
				String expectedMaxAnnualRateList;//  ,预期收益率查询条件,List,不校验,否,
		 @PBFields(name = ",风险等级查询条件,List,不校验,否,")
				String riskLevelList;//  ,风险等级查询条件,List,不校验,否,
		 @PBFields(name = ",产品类型查询条件,List,不校验,否,")
				String subjectTypeList;//  ,产品类型查询条件,List,不校验,否,
		 @PBFields(name = ",起购金额查询条件,List,不校验,否,")
				String buyerSmallestAmountList;//  ,起购金额查询条件,List,不校验,否,
		 @PBFields(name = ",销售对象查询条件,List,不校验,否,")
				String saleObjectList;//  ,销售对象查询条件,List,不校验,否,
		 @PBFields(name = ",可买人数,String,不校验,否,")
				String canBuyNum;//  ,可买人数,String,不校验,否,
}

		 List<ProductTradeInfoList>productTradeInfoList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
