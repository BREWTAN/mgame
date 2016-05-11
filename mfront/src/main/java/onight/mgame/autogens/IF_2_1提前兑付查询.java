package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryRedemptionWrap", path = "/ife/trade/queryRedemptionWrap.html") 
public class IF_2_1提前兑付查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		@PBFields(name = ",持仓ID,String,不校验,否,")
		String  idStr;
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		
		public static class RedemptionWrap {
			@PBFields(name = ",持仓ID,Long,不校验,是,")
			Long id; //持仓ID
			@PBFields(name = ",产品代码,String,不校验,是,")
			String productCode;//产品代码
			@PBFields(name = ",产品名称,String,不校验,是,")
			String productName;//产品名称
			@PBFields(name = ",持有本金,Long,不校验,是,")
			Long unit;//持有本金
			@PBFields(name = ",可转让本金,Long,不校验,是,")
			Long canTransferUnit;//可转让本金
			@PBFields(name = ",不可转让本金,Long,不校验,是,")
			Long canNotTransferUnit;//不可转让本金
			@PBFields(name = ",选择权公告开始日,String,不校验,是,")
			String optionDateStart;//选择权公告开始日
			@PBFields(name = ",选择权公告截止日,String,不校验,是,")
			String optionDateEnd;//选择权公告截止日
			@PBFields(name = ",原提前兑付本金,Long,不校验,是,")
			Long preSaleAmt;//原提前兑付本金
			@PBFields(name = ",原提前兑付申请记录Id,Long,不校验,是,")
			Long redemptionId; //原提前兑付申请记录Id
		}
		
		 RedemptionWrap redemptionWrap;
		 String tfw__reserved;//保留字段 

	}

}
