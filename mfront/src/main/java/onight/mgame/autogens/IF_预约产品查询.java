package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 预约产品查询,产品相关,TradeController,POST,JSON,/ife/trade/queryProductOrderInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryProductOrderInfo", path = "/ife/trade/queryProductOrderInfo.html") 
public class IF_预约产品查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",当前页,String,不校验,是,默认1")
		String pageIndex;//  ,当前页,String,不校验,是,默认1
		 @PBFields(name = ",页大小,String,不校验,是,默认10")
		String pageSize;//  ,页大小,String,不校验,是,默认10
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

		 @PBFields(name = ",预约产品列表,List,不校验,是,")
PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class TaProductOrderInfoWrapList {

		 @PBFields(name = ",预约结束时间,String,不校验,是,")
				String orderEndDate;//  ,预约结束时间,String,不校验,是,
		 @PBFields(name = ",产品编码,String,不校验,是,")
				String productCode;//  ,产品编码,String,不校验,是,
		 @PBFields(name = ",认购起点金额,String,不校验,是,")
				String buyerSmallestAmount;//  ,认购起点金额,String,不校验,是,
		 @PBFields(name = ",剩余发行量,String,不校验,是,")
				String buyRemainAmount;//  ,剩余发行量,String,不校验,是,
		 @PBFields(name = ",预期年化收益率,String,不校验,是,")
				String expectedMaxAnnualRate;//  ,预期年化收益率,String,不校验,是,
		 @PBFields(name = ",募集开始时间,String,不校验,是,")
				String buyStartDate;//  ,募集开始时间,String,不校验,是,
		 @PBFields(name = ",产品名称,String,不校验,是,")
				String productName;//  ,产品名称,String,不校验,是,
		 @PBFields(name = ",保证金比例,String,不校验,是,")
				String depositRate;//  ,保证金比例,String,不校验,是,
		 @PBFields(name = ",是否已预约,String,不校验,是,")
				String isOrderFlag;//  ,是否已预约,String,不校验,是,
}

		 List<TaProductOrderInfoWrapList>taProductOrderInfoWrapList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
