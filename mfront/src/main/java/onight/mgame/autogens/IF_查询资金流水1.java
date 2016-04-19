package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 查询资金流水,电子账户,FundController,POST,JSON,/ife/statistic/queryFundAccountLog.html@onight.mgame.utils.PBInfo(name = "PBIFE_statistic_queryFundAccountLog", path = "/ife/statistic/queryFundAccountLog.html") 
public class IF_查询资金流水1 {
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

		 @PBFields(name = ",流水信息,List,不校验,是,")
PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class FundAccountLogList {

		 @PBFields(name = ",交易序列,String,不校验,是,")
				String bizNo;//  ,交易序列,String,不校验,是,
		 @PBFields(name = ",交易创建时间,String,不校验,是,")
				String gmtCreate;//  ,交易创建时间,String,不校验,是,
		 @PBFields(name = ",交易码,String,不校验,是,")
				String transCode;//  ,交易码,String,不校验,是,
		 @PBFields(name = ",子交易码,String,不校验,是,")
				String subTransCode;//  ,子交易码,String,不校验,是,
		 @PBFields(name = ",子交易码中文名,String,不校验,是,")
				String subTransCodeName;//  ,子交易码中文名,String,不校验,是,
		 @PBFields(name = ",交易金额,String,不校验,是,")
				String transAmount;//  ,交易金额,String,不校验,是,
		 @PBFields(name = ",交易后余额,String,不校验,是,")
				String postAmount;//  ,交易后余额,String,不校验,是,
		 @PBFields(name = ",备注,String,不校验,是,")
				String memo;//  ,备注,String,不校验,是,
}

		 List<FundAccountLogList>fundAccountLogList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
