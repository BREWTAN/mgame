package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 确认出价,产品相关,BadAssetController,POST,JSON,/ife/badasset/offer.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_offer", path = "/ife/badasset/offer.html") 
public class IF_确认出价 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String projectCode;//  ,项目编号,String,不校验,否,
		String myPay;//  ,报价金额,String,不校验,否,
		String bayWay;//  ,竞价方式,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 String tfw__reserved;//保留字段 

	}

}
