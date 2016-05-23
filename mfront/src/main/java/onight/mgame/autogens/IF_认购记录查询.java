package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 认购记录查询,产品相关,PrdQueryController,POST,JSON,/ife/prdquery/prdQuerySubscribeList.html
@onight.mgame.utils.PBInfo(name = "PBIFE_prdquery_prdQuerySubscribeList", path = "/ife/prdquery/prdQuerySubscribeList.html") 
public class IF_认购记录查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",当前页,String,不校验,否,")
		String pageIndex;//  ,当前页,String,不校验,否,
		 @PBFields(name = ",页大小,String,不校验,否,")
		String pageSize;//  ,页大小,String,不校验,否,
		 @PBFields(name = ",开始日,String,不校验,是,")
		String startDate;//  ,开始日,String,不校验,是,
		 @PBFields(name = ",结束日,String,不校验,是,")
		String endDate;//  ,结束日,String,不校验,是,
		 @PBFields(name = ",产品编号/产品名称,String,不校验,是,")
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

		 @PBFields(name = ",认购记录列表,List,不校验,否,")
PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class SubscribeList {

		@PBFields(name = ",预期年化收益率,String,不校验,是,")
		String expectedMaxAnnualRate;//  ,预期年化收益率,String,不校验,是,
		@PBFields(name = ",交易开始时间,String,不校验,是,")
		String tradeStartDate;//  ,交易开始时间,String,不校验,是,
		@PBFields(name = ",交易结束时间,String,不校验,是,")
		String tradeEndDate;//  ,交易结束时间,String,不校验,是,
		@PBFields(name = ",募集开始时间,String,不校验,是,")
		String buyStartDate;//  ,募集开始时间,String,不校验,是,
		@PBFields(name = ",募集结束时间,String,不校验,是,")
		String buyEndDate;//  ,募集结束时间,String,不校验,是,
		@PBFields(name = ",状态,String,不校验,是,")
		String status;//  ,状态,String,不校验,是,
		@PBFields(name = ",状态-名称,String,不校验,是,")
		String statusName;//  ,状态-名称,String,不校验,是,
		@PBFields(name = ",委托状态,String,不校验,是,")
		String delegateStatusName;//  ,委托状态,String,不校验,是,
		@PBFields(name = ",产品认购期是否允许撤单,String,不校验,是,0 否  1是")
		String productCancel;//  ,产品认购期是否允许撤单,String,不校验,是,0 否  1是
		@PBFields(name = ",页面判断是否可以撤销标志,String,不校验,是,0 否 1 是")
		String cancelFlag;//  ,页面判断是否可以撤销标志,String,不校验,是,0 否 1 是
		@PBFields(name = ",认购编号,String,不校验,是,0 否 1 是")
		String delegationCode;//  ,认购编号,String,不校验,是,0 否 1 是
		@PBFields(name = ",产品名称,String,不校验,是,0 否 1 是")
		String productCode;//  ,产品名称,String,不校验,是,0 否 1 是
		@PBFields(name = ",页面判断是否可以撤销标志,String,不校验,是,0 否 1 是")
		String productName;//  ,页面判断是否可以撤销标志,String,不校验,是,0 否 1 是
		@PBFields(name = ",管理公司名称,String,不校验,是,0 否 1 是")
		String companyName;//  ,管理公司名称,String,不校验,是,0 否 1 是
		@PBFields(name = ",资金账户,String,不校验,是,0 否 1 是")
		String cashAccount;//  ,资金账户,String,不校验,是,0 否 1 是
		@PBFields(name = ",认购时间,String,不校验,是,0 否 1 是")
		String delegateTime;//  ,认购时间,String,不校验,是,0 否 1 是
		@PBFields(name = ",认购金额,String,不校验,是,0 否 1 是")
		String delegateAmount;//  ,认购金额,String,不校验,是,0 否 1 是
		@PBFields(name = ",认购类型,String,不校验,是,0 否 1 是")
		String delegateType;//  ,认购类型,String,不校验,是,0 否 1 是
		@PBFields(name = ",认购状态,String,不校验,是,0 否 1 是")
		String delegateStatus;//  ,认购状态,String,不校验,是,0 否 1 是
		@PBFields(name = ",认购单位,String,不校验,是,0 否 1 是")
		String delegateNum;//  ,认购单位,String,不校验,是,0 否 1 是
		@PBFields(name = ",撤单标志,String,不校验,是,0 否 1 是")
		String cancelStatus;//  ,撤单标志,String,不校验,是,0 否 1 是
		@PBFields(name = ",买卖类型(买方、卖方),String,不校验,是,0 否 1 是")
		String saleType;//  ,买卖类型(买方、卖方),String,不校验,是,0 否 1 是
		@PBFields(name = ",交易账户,String,不校验,是,0 否 1 是")
		String tradeAccount;//  ,交易账户,String,不校验,是,0 否 1 是
		@PBFields(name = ",手续费,String,不校验,是,0 否 1 是")
		String extraCost;//  ,手续费,String,不校验,是,0 否 1 是
		@PBFields(name = ",创建时间,String,不校验,是,0 否 1 是")
		String gmtCreate;//  ,创建时间,String,不校验,是,0 否 1 是
		@PBFields(name = ",修改时间,String,不校验,是,0 否 1 是")
		String gmtModify;//  ,修改时间,String,不校验,是,0 否 1 是
		@PBFields(name = ",单位金额,String,不校验,是,0 否 1 是")
		String unitAmount;//  ,单位金额,String,不校验,是,0 否 1 是
		@PBFields(name = ",销售渠道编号,String,不校验,是,0 否 1 是")
		String brokerNo;//  ,销售渠道编号,String,不校验,是,0 否 1 是
		@PBFields(name = ",终端编号,String,不校验,是,0 否 1 是")
		String channelNo;//  ,终端编号,String,不校验,是,0 否 1 是
		@PBFields(name = ",经纪商编号,String,不校验,是,0 否 1 是")
		String brokerCode;//  ,经纪商编号,String,不校验,是,0 否 1 是
		@PBFields(name = ",是否是特约标志,String,不校验,是,0 否 1 是")
		String specialFlag;//  ,是否是特约标志,String,不校验,是,0 否 1 是
		@PBFields(name = ",备注,String,不校验,是,0 否 1 是")
		String remark;//  ,备注,String,不校验,是,0 否 1 是
}

		 List<SubscribeList>subscribeList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
