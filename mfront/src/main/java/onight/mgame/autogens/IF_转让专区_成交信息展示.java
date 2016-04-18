package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 转让专区-成交信息展示,产品相关,PrdTransferQueryController,POST,JSON,/ife/prdtransferquery/prdQueryDeliveryOrderForDetail.html@onight.mgame.utils.PBInfo(name = "PBIFE_prdtransferquery_prdQueryDeliveryOrderForDetail", path = "/ife/prdtransferquery/prdQueryDeliveryOrderForDetail.html") 
public class IF_转让专区_成交信息展示 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String lineNum;//  ,页大小,String,不校验,否,
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
	public static class TcDeliveryOrderList {

		 @PBFields(name = ",成交类型,String,不校验,是,认购、转让、定价")
				String deliveryType;//  ,成交类型,String,不校验,是,认购、转让、定价
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
		 @PBFields(name = ",手续费,String,不校验,是,手续费=实际计算得到的手续费+过户费-使用佣金优惠金额")
				String extraCost;//  ,手续费,String,不校验,是,手续费=实际计算得到的手续费+过户费-使用佣金优惠金额
		 @PBFields(name = ",手续费-中文,String,不校验,是,")
				String extraCostStr;//  ,手续费-中文,String,不校验,是,
		 @PBFields(name = ",管理公司名称,String,不校验,是,")
				String companyName;//  ,管理公司名称,String,不校验,是,
		 @PBFields(name = ",资金帐号,String,不校验,是,")
				String cashAccount;//  ,资金帐号,String,不校验,是,
		 @PBFields(name = ",成交时间,String,不校验,是,")
				String fixtureDate;//  ,成交时间,String,不校验,是,
		 @PBFields(name = ",成交时间格式化,String,不校验,是,")
				String fixtureDateFmt;//  ,成交时间格式化,String,不校验,是,
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
		 @PBFields(name = ",成交编号,String,不校验,是,产品编号+成交时间+6位编号")
				String deliveryCode;//  ,成交编号,String,不校验,是,产品编号+成交时间+6位编号
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
		 @PBFields(name = ",买房名称,String,不校验,是,")
				String saleName;//  ,买房名称,String,不校验,是,
		 @PBFields(name = ",对方资金账号,String,不校验,是,")
				String optCashAccount;//  ,对方资金账号,String,不校验,是,
		 @PBFields(name = ",终端类型编号,String,不校验,是,")
				String brokerNo;//  ,终端类型编号,String,不校验,是,
		 @PBFields(name = ",经纪商编号,String,不校验,是,")
				String channelNo;//  ,经纪商编号,String,不校验,是,
		 @PBFields(name = ",额外收益,String,不校验,是,")
				String brokerCode;//  ,额外收益,String,不校验,是,
		 @PBFields(name = ",额外收益,String,不校验,是,产品编号+成交时间+6位编号")
				String tradeIncome;//  ,额外收益,String,不校验,是,产品编号+成交时间+6位编号
		 @PBFields(name = ",买卖成交编号,String,不校验,是,")
				String saleDeliveryCode;//  ,买卖成交编号,String,不校验,是,
		 @PBFields(name = ",成交利率,String,不校验,是,")
				String expectedMaxAnnualRate;//  ,成交利率,String,不校验,是,
		 @PBFields(name = ",目标利率,String,不校验,是,")
				String targetRate;//  ,目标利率,String,不校验,是,
		 @PBFields(name = ",实际利率,String,不校验,是,")
				String actualRate;//  ,实际利率,String,不校验,是,
		 @PBFields(name = ",委托时间,String,不校验,是,")
				String delegateTime;//  ,委托时间,String,不校验,是,
		 @PBFields(name = ",交易用时,String,不校验,是,")
				String userTimes;//  ,交易用时,String,不校验,是,
		 @PBFields(name = ",开始时间,String,不校验,是,")
				String startTime;//  ,开始时间,String,不校验,是,
		 @PBFields(name = ",结束时间,String,不校验,是,")
				String endTime;//  ,结束时间,String,不校验,是,
		 @PBFields(name = ",查询条件,String,不校验,是,")
				String productCodeOrName;//  ,查询条件,String,不校验,是,
}

		 @PBFields(name = ",,String,不校验,是,")
		List<TcDeliveryOrderList>tcDeliveryOrderList;// 
 
		 @PBFields(name = ",,String,不校验,是,")
		String mapAmount;//  ,,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
