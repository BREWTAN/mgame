package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onight.mgame.utils.PBFields;

import java.util.List;

@onight.mgame.utils.PBInfo(name = "PBIFE_statistic_queryFundEarningsLog", path = "/ife/statistic/queryFundEarningsLog.html")
public class IF_查询我的收益 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		@PBFields(name = ",当前页,String,不校验,是,")
		String pageIndex;//  ,当前页,String,不校验,是,
		@PBFields(name = ",页大小,String,不校验,是,")
		String pageSize;//  ,页大小,String,不校验,是,
		@PBFields(name = ",开始日期,String,不校验,是,格式:yyyy-MM-dd")
		String startDate;//  ,开始日期,String,不校验,是,格式:yyyy-MM-dd
		@PBFields(name = ",结束日期,String,不校验,是,格式:yyyy-MM-dd")
		String endDate;//  ,结束日期,String,不校验,是,格式:yyyy-MM-dd
		@PBFields(name = ",收益类型,String,不校验,格式:yyyy-MM-dd,")
		String  earningsType;
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
		PageInfo pageInfo;//
		@Data
		@AllArgsConstructor
		@NoArgsConstructor
		public static class FundEarningsLogList {
			@PBFields(name = ",ID,String,不校验,是,")
			String id;//  ,ID,String,不校验,是,
			@PBFields(name = ",资金账号,String,不校验,是,")
			String fundAccount;//  ,资金账号,String,不校验,是,
			@PBFields(name = ",产品编号,String,不校验,是,")
			String productCode;//  ,产品编号,String,不校验,是,
			@PBFields(name = ",收益类型(01-净利息收入、02-季度结息、03-交易盈亏、04-转让收入),String,不校验,是,")
			String earningsType;//  ,收益类型,String,不校验,是,
			@PBFields(name = ",收益类型(01-净利息收入、02-季度结息、03-交易盈亏、04-转让收入),String,不校验,是,")
			String earningsName;//  ,收益类型,String,不校验,是,
			@PBFields(name = ",收益金额,String,不校验,是,")
			String amount;//  ,收益金额,String,不校验,是,
			@PBFields(name = ",交易日期,String,不校验,是,")
			String transDate;//  ,交易日期,String,不校验,是,
			@PBFields(name = ",交易时间,String,不校验,是,")
			String transTime;//  ,交易时间,String,不校验,是,
			@PBFields(name = ",备注,String,不校验,是,")
			String remark;//  ,备注,String,不校验,是,
			@PBFields(name = ",创建时间,String,不校验,是,")
			String gmtCreate;//  ,创建时间,String,不校验,是,
			@PBFields(name = ",修改时间,String,不校验,是,")
			String gmtModify;//  ,修改时间,String,不校验,是,
		}

		@PBFields(name = ",流水信息,List,不校验,是,")
		List<FundEarningsLogList> fundEarningsLogList;//
		 String tfw__reserved;//保留字段 

	}

}
