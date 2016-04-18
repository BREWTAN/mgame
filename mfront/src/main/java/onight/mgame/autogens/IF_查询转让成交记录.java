package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 查询转让成交记录,产品相关,PrdTransferQueryController,POST,JSON,/ife/prdtransferquery/queryDeliveryOrderForReport.html@onight.mgame.utils.PBInfo(name = "PBIFE_prdtransferquery_queryDeliveryOrderForReport", path = "/ife/prdtransferquery/queryDeliveryOrderForReport.html") 
public class IF_查询转让成交记录 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String deliveryCode;//  ,委托编号,String,不校验,否,
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
	public static class TcDeliveryOrder {

				String saleName;//  ,卖方姓名,String,不校验,是,
				String buyerName;//  ,买方姓名,String,不校验,是,
				String productName;//  ,产品名称,String,不校验,是,
				String productCode;//  ,产品编号,String,不校验,是,
				String companyName;//  ,公司名称,String,不校验,是,
				String deliveryNum;//  ,委托数量,String,不校验,是,
				String deliveryNumZh;//  ,委托数量大写,String,不校验,是,
				String amountStr;//  ,委托金额,String,不校验,是,
				String amountZh;//  ,委托金额大写,String,不校验,是,
				String extraCost;//  ,手续费,String,不校验,是,
				String extraCostStr;//  ,手续费大写,String,不校验,是,
				String fixtureDateFmt;//  ,成交时间,String,不校验,是,格式yyyy-MM-dd hh:mm:ss
}

		 TcDeliveryOrder tcDeliveryOrder;// 
 
		String name;//  ,查询人账户名,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
