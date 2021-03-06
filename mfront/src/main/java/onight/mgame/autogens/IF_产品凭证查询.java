package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 产品凭证查询,产品相关,PrdQueryController,POST,JSON,/ife/prdquery/prdQueryCertDetails.html@onight.mgame.utils.PBInfo(name = "PBIFE_prdquery_prdQueryCertDetails", path = "/ife/prdquery/prdQueryCertDetails.html") 
public class IF_产品凭证查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",持仓编号,String,不校验,否,")
		String id;//  ,持仓编号,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",当前日期,String,不校验,是,yyyy年MM月dd日")
		String currDateZh;//  ,当前日期,String,不校验,是,yyyy年MM月dd日
		 @PBFields(name = ",当前时间,String,不校验,是,yyyy年MM月dd日HH时mm分ss秒")
		String currDateTime;//  ,当前时间,String,不校验,是,yyyy年MM月dd日HH时mm分ss秒
		 @PBFields(name = ",查询用户,String,不校验,是,")
		String currUsername;//  ,查询用户,String,不校验,是,
		 @PBFields(name = ",持仓大写,String,不校验,是,")
		String unitZh;//  ,持仓大写,String,不校验,是,
		 @PBFields(name = ",持仓,String,不校验,是,")
		String unit;//  ,持仓,String,不校验,是,
		 @PBFields(name = ",产品代码,String,不校验,是,")
		String productCode;//  ,产品代码,String,不校验,是,
		 @PBFields(name = ",产品名称,String,不校验,是,")
		String productName;//  ,产品名称,String,不校验,是,
		 @PBFields(name = ",产品起息日,String,不校验,是,")
		String manageStartDate;//  ,产品起息日,String,不校验,是,
		 @PBFields(name = ",产品到期日,String,不校验,是,")
		String manageEndDate;//  ,产品到期日,String,不校验,是,
		 @PBFields(name = ",发行机构,String,不校验,是,")
		String issueCompanyName;//  ,发行机构,String,不校验,是,
		 @PBFields(name = ",托管机构,String,不校验,是,")
		String manageCompany;//  ,托管机构,String,不校验,是,
		 @PBFields(name = ",资金监管机构,String,不校验,是,")
		String financeCompany;//  ,资金监管机构,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
