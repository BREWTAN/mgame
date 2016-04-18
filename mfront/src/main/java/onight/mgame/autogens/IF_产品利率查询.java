package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 产品利率查询,产品相关,TradeController,POST,JSON,/ife/trade/queryProductRate.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryProductRate", path = "/ife/trade/queryProductRate.html") 
public class IF_产品利率查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String rateDate;//  ,有限利率日期,String,不校验,否,
		String rateType;//  ,利率类型,String,不校验,否,
		String buyerSmallestAmount;//  ,起购金额,String,不校验,否,
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
	public static class RateList {

		 @PBFields(name = ",区间起,String,不校验,是,")
				String deadlineBegin;//  ,区间起,String,不校验,是,
		 @PBFields(name = ",区间止,String,不校验,是,")
				String deadlineEnd;//  ,区间止,String,不校验,是,
		 @PBFields(name = ",利率起,String,不校验,是,")
				String rateBegin;//  ,利率起,String,不校验,是,
		 @PBFields(name = ",利率止,String,不校验,是,")
				String rateEnd;//  ,利率止,String,不校验,是,
		 @PBFields(name = ",期限,String,不校验,是,")
				String deadline;//  ,期限,String,不校验,是,
}

		 List<RateList>rateList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
