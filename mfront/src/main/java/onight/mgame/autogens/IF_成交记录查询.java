package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 成交记录查询,产品相关,PrdQueryController,POST,JSON,/ife/prdquery/prdQueryTcDeliveryList.html@onight.mgame.utils.PBInfo(name = "PBIFE_prdquery_prdQueryTcDeliveryList", path = "/ife/prdquery/prdQueryTcDeliveryList.html") 
public class IF_成交记录查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String pageIndex;//  ,当前页,String,不校验,否,
		String pageSize;//  ,页大小,String,不校验,否,
		String startDate;//  ,开始日,String,不校验,是,
		String endDate;//  ,结束日,String,不校验,是,
		String productCodeOrName;//  ,产品编号/产品名称,String,不校验,是,
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

		 @PBFields(name = ",成交列表,List,不校验,是,")
PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class BargainList {

		 @PBFields(name = ",成交表PK,String,不校验,是,")
				String id;//  ,成交表PK,String,不校验,是,
		 @PBFields(name = ",成交类型,String,不校验,是,")
				String deliveryType;//  ,成交类型,String,不校验,是,
		 @PBFields(name = ",产品代码,String,不校验,是,")
				String productCode;//  ,产品代码,String,不校验,是,
		 @PBFields(name = ",产品名称,String,不校验,是,")
				String productName;//  ,产品名称,String,不校验,是,
		 @PBFields(name = ",成交金额,String,不校验,是,")
				String amount;//  ,成交金额,String,不校验,是,
		 @PBFields(name = ",字符串形式,String,不校验,是,")
				String amountStr;//  ,字符串形式,String,不校验,是,
		 @PBFields(name = ",大写金额,String,不校验,是,")
				String amountZh;//  ,大写金额,String,不校验,是,
		 @PBFields(name = ",成交单位,String,不校验,是,")
				String deliveryNum;//  ,成交单位,String,不校验,是,
		 @PBFields(name = ",大写成交单位,String,不校验,是,")
				String deliveryNumZh;//  ,大写成交单位,String,不校验,是,
		 @PBFields(name = ",手续费,String,不校验,是,")
				String extraCost;//  ,手续费,String,不校验,是,
		 @PBFields(name = ",手续费,String,不校验,是,")
				String extraCostStr;//  ,手续费,String,不校验,是,
		 @PBFields(name = ",管理公司名称,String,不校验,是,")
				String companyName;//  ,管理公司名称,String,不校验,是,
		 @PBFields(name = ",资金帐号,String,不校验,是,")
				String cashAccount;//  ,资金帐号,String,不校验,是,
		 @PBFields(name = ",成交时间,String,不校验,是,")
				String fixtureDate;//  ,成交时间,String,不校验,是,
		 @PBFields(name = ",成交时间,String,不校验,是,")
				String fixtureDateFmt;//  ,成交时间,String,不校验,是,
		 @PBFields(name = ",委托编号,String,不校验,是,")
				String delegationId;//  ,委托编号,String,不校验,是,
		 @PBFields(name = ",买卖类型,String,不校验,是,")
				String saleType;//  ,买卖类型,String,不校验,是,
		 @PBFields(name = ",交易账户,String,不校验,是,")
				String tradeAccount;//  ,交易账户,String,不校验,是,
		 @PBFields(name = ",买方姓名,String,不校验,是,")
				String buyerName;//  ,买方姓名,String,不校验,是,
		 @PBFields(name = ",创建时间,String,不校验,是,")
				String gmtCreate;//  ,创建时间,String,不校验,是,
		 @PBFields(name = ",修改时间,String,不校验,是,")
				String gmtModify;//  ,修改时间,String,不校验,是,
		 @PBFields(name = ",成交编号,String,不校验,是,")
				String deliveryCode;//  ,成交编号,String,不校验,是,
		 @PBFields(name = ",单位金额,String,不校验,是,")
				String unitAmount;//  ,单位金额,String,不校验,是,
		 @PBFields(name = ",过户费,String,不校验,是,")
				String transferFee;//  ,过户费,String,不校验,是,
		 @PBFields(name = ",使用佣金优惠金额,String,不校验,是,")
				String useFavorableAmount;//  ,使用佣金优惠金额,String,不校验,是,
		 @PBFields(name = ",日终解冻处理结果,String,不校验,是,")
				String dealStatus;//  ,日终解冻处理结果,String,不校验,是,
		 @PBFields(name = ",错误消息,String,不校验,是,")
				String errorInfo;//  ,错误消息,String,不校验,是,
		 @PBFields(name = ",对方交易账号,String,不校验,是,")
				String optTradeAccount;//  ,对方交易账号,String,不校验,是,
		 @PBFields(name = ",卖方姓名,String,不校验,是,")
				String saleName;//  ,卖方姓名,String,不校验,是,
		 @PBFields(name = ",对方资金账号,String,不校验,是,")
				String optCashAccount;//  ,对方资金账号,String,不校验,是,
		 @PBFields(name = ",渠道编号,String,不校验,是,")
				String brokerNo;//  ,渠道编号,String,不校验,是,
		 @PBFields(name = ",终端类型编号,String,不校验,是,")
				String channelNo;//  ,终端类型编号,String,不校验,是,
		 @PBFields(name = ",经纪商编号,String,不校验,是,")
				String brokerCode;//  ,经纪商编号,String,不校验,是,
		 @PBFields(name = ",额外收益,String,不校验,是,")
				String tradeIncome;//  ,额外收益,String,不校验,是,
		 @PBFields(name = ",买卖成交编号,String,不校验,是,")
				String saleDeliveryCode;//  ,买卖成交编号,String,不校验,是,
		 @PBFields(name = ",成交利率,String,不校验,是,")
				String expectedMaxAnnualRate;//  ,成交利率,String,不校验,是,
		 @PBFields(name = ",TARGET_RATE,String,不校验,是,")
				String targetRate;//  ,TARGET_RATE,String,不校验,是,
		 @PBFields(name = ",实际利率,String,不校验,是,")
				String actualRate;//  ,实际利率,String,不校验,是,
		 @PBFields(name = ",委托时间,String,不校验,是,")
				String delegateTime;//  ,委托时间,String,不校验,是,
		 @PBFields(name = ",交易用时,String,不校验,是,")
				String userTimes;//  ,交易用时,String,不校验,是,
		 @PBFields(name = ",查询条件,String,不校验,是,")
				String startTime;//  ,查询条件,String,不校验,是,
		 @PBFields(name = ",查询条件,String,不校验,是,")
				String endTime;//  ,查询条件,String,不校验,是,
		 @PBFields(name = ",产品代码或者产品名称,String,不校验,是,")
				String productCodeOrName;//  ,产品代码或者产品名称,String,不校验,是,
}

		 List<BargainList>bargainList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
