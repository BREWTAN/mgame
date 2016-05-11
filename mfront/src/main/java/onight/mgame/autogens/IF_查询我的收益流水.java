package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 查询我的收益流水,客户信息,StatisticController,POST,JSON,/ife/statistic/queryFundEarningsLog.html
@onight.mgame.utils.PBInfo(name = "PBIFE_statistic_queryFundEarningsLog", path = "/ife/statistic/queryFundEarningsLog.html") 
public class IF_查询我的收益流水 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		@PBFields(name = ",当前页,String,不校验,否,")
		String pageIndex;//  ,当前页,String,不校验,否,
		 @PBFields(name = ",页大小,String,不校验,否,")
		String pageSize;//  ,页大小,String,不校验,否,
		@PBFields(name = ",开始日期,String,不校验,否,")
		String startDate;//  ,开始日期,String,不校验,否,
		 @PBFields(name = ",结束日期,String,不校验,否,")
		String endDate;//  ,结束日期,String,不校验,否,
		@PBFields(name = ",收益类型,String,不校验,否,")
		String earningsType;//  ,收益类型,String,不校验,否,
		
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

		 @PBFields(name = ",收益流水列表,List,不校验,是,")
PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class FundEarningsLogList {

		 @PBFields(name = ",流水表PK,String,不校验,是,")
				String id;//  ,流水表PK,String,不校验,是,
		 @PBFields(name = ",资金账号,String,不校验,是,")
				String fundAccount;//  ,资金账号,String,不校验,是,
		 @PBFields(name = ",产品编号,String,不校验,是,")
				String productCode;//  ,产品编号,String,不校验,是,
		 @PBFields(name = ",收益类型,String,不校验,是,")
				String earningsType;//  ,收益类型,String,不校验,是,
		 @PBFields(name = ",收益类型名称,String,不校验,是,")
				String earningsName;//  ,收益类型名称,String,不校验,是,
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
		 @PBFields(name = ",记录最后一次修改时间,String,不校验,是,")
				String gmtModify;//  ,记录最后一次修改时间,String,不校验,是,
		 
}

		 List<FundEarningsLogList>fundEarningsLogList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
