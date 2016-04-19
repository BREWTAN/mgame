package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 委托记录查询,产品相关,PrdQueryController,POST,JSON,/ife/prdquery/prdQueryTcDelegationFinanceList.html@onight.mgame.utils.PBInfo(name = "PBIFE_prdquery_prdQueryTcDelegationFinanceList", path = "/ife/prdquery/prdQueryTcDelegationFinanceList.html") 
public class IF_委托记录查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",当前页,String,不校验,否,")
		String pageIndex;//  ,当前页,String,不校验,否,
		 @PBFields(name = ",页大小,String,不校验,否,")
		String pageSize;//  ,页大小,String,不校验,否,
		 @PBFields(name = ",开始日,String,不校验,否,")
		String startDate;//  ,开始日,String,不校验,否,
		 @PBFields(name = ",结束日,String,不校验,否,")
		String endDate;//  ,结束日,String,不校验,否,
		 @PBFields(name = ",委托编号/产品名称,String,不校验,否,")
		String delegationCodeOrName;//  ,委托编号/产品名称,String,不校验,否,
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

		 @PBFields(name = ",委托列表,List,不校验,是,")
PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class TcDelegationFinaceList {

		 @PBFields(name = ",委托表PK,String,不校验,是,")
				String id;//  ,委托表PK,String,不校验,是,
		 @PBFields(name = ",委托编号,String,不校验,是,")
				String delegationCode;//  ,委托编号,String,不校验,是,
		 @PBFields(name = ",产品代码,String,不校验,是,")
				String productCode;//  ,产品代码,String,不校验,是,
		 @PBFields(name = ",产品名称,String,不校验,是,")
				String productName;//  ,产品名称,String,不校验,是,
		 @PBFields(name = ",管理公司名称,String,不校验,是,")
				String companyName;//  ,管理公司名称,String,不校验,是,
		 @PBFields(name = ",资金账户,String,不校验,是,")
				String cashAccount;//  ,资金账户,String,不校验,是,
		 @PBFields(name = ",委托时间,String,不校验,是,")
				String delegateTime;//  ,委托时间,String,不校验,是,
		 @PBFields(name = ",委托金额,String,不校验,是,")
				String delegateAmount;//  ,委托金额,String,不校验,是,
		 @PBFields(name = ",委托类型,String,不校验,是,认购、协议卖出、定价卖出、定价买入")
				String delegateType;//  ,委托类型,String,不校验,是,认购、协议卖出、定价卖出、定价买入
		 @PBFields(name = ",委托状态,String,不校验,是,委托中、委托成功、委托失败、委托关闭")
				String delegateStatus;//  ,委托状态,String,不校验,是,委托中、委托成功、委托失败、委托关闭
		 @PBFields(name = ",委托单位,String,不校验,是,")
				String delegateNum;//  ,委托单位,String,不校验,是,
		 @PBFields(name = ",撤单标志,String,不校验,是,")
				String cancelStatus;//  ,撤单标志,String,不校验,是,
		 @PBFields(name = ",买卖类型,String,不校验,是,")
				String saleType;//  ,买卖类型,String,不校验,是,
		 @PBFields(name = ",交易账户,String,不校验,是,")
				String tradeAccount;//  ,交易账户,String,不校验,是,
		 @PBFields(name = ",手续费,String,不校验,是,")
				String extraCost;//  ,手续费,String,不校验,是,
		 @PBFields(name = ",创建时间,String,不校验,是,")
				String gmtCreate;//  ,创建时间,String,不校验,是,
		 @PBFields(name = ",修改时间,String,不校验,是,")
				String gmtModify;//  ,修改时间,String,不校验,是,
		 @PBFields(name = ",单位金额,String,不校验,是,")
				String unitAmount;//  ,单位金额,String,不校验,是,
		 @PBFields(name = ",,String,不校验,是,")
				String targetRate;//  ,,String,不校验,是,
		 @PBFields(name = ",实际利率,String,不校验,是,")
				String actualRate;//  ,实际利率,String,不校验,是,
		 @PBFields(name = ",是否允许回购,String,不校验,是,")
				String isBuyBackFlag;//  ,是否允许回购,String,不校验,是,
		 @PBFields(name = ",成交金额,String,不校验,是,")
				String transactionAmount;//  ,成交金额,String,不校验,是,
		 @PBFields(name = ",成交份额,String,不校验,是,")
				String transactionNum;//  ,成交份额,String,不校验,是,
		 @PBFields(name = ",渠道编号,String,不校验,是,")
				String brokerNo;//  ,渠道编号,String,不校验,是,
		 @PBFields(name = ",终端类型编号,String,不校验,是,")
				String channelNo;//  ,终端类型编号,String,不校验,是,
		 @PBFields(name = ",经纪商编号,String,不校验,是,")
				String brokerCode;//  ,经纪商编号,String,不校验,是,
		 @PBFields(name = ",交易收益,String,不校验,是,")
				String tradeIncome;//  ,交易收益,String,不校验,是,
		 @PBFields(name = ",预期年化收益率,String,不校验,是,")
				String expectedMaxAnnualRate;//  ,预期年化收益率,String,不校验,是,
		 @PBFields(name = ",是否浮动利率,String,不校验,是,")
				String transferIsfloat;//  ,是否浮动利率,String,不校验,是,
		 @PBFields(name = ",折扣,String,不校验,是,")
				String discountRate;//  ,折扣,String,不校验,是,
		 @PBFields(name = ",委托查询开始时间,String,不校验,是,")
				String delegateTimeStart;//  ,委托查询开始时间,String,不校验,是,
		 @PBFields(name = ",委托查询结束时间,String,不校验,是,")
				String delegateTimeEnd;//  ,委托查询结束时间,String,不校验,是,
		 @PBFields(name = ",查询委托编号或产品名称,String,不校验,是,")
				String delegationCodeOrName;//  ,查询委托编号或产品名称,String,不校验,是,
}

		 @PBFields(name = ",撤单状态,map,不校验,是,")
		List<TcDelegationFinaceList>tcDelegationFinaceList;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class EnumDelegateCancelMap {

		 @PBFields(name = ",未撤单,String,不校验,是,")
				String CANCEL_NO;//  ,未撤单,String,不校验,是,
		 @PBFields(name = ",已撤单,String,不校验,是,")
				String CANCEL_YES;//  ,已撤单,String,不校验,是,
}

		 EnumDelegateCancelMap enumDelegateCancelMap;// 
 
		 String tfw__reserved;//保留字段 

	}

}
