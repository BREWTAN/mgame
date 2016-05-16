package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 出金银行卡信息加载,电子账户,FundController,GET,JSON,/ife/fund/loadWithDrawBankInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_fund_loadWithDrawBankInfo", path = "/ife/fund/loadWithDrawBankInfo.html") 
public class IF_出金银行卡信息加载 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",提现备注,String,不校验,否,")
		String remark;//  ,提现备注,String,不校验,否,
		 @PBFields(name = ",是否需要支行信息,Boolean,不校验,否,")
		 String isNeedSubbranch;//  ,是否需要支行信息,Boolean,不校验,否,
		 @PBFields(name = ",单次最多提现金额,BigDecimal,不校验,否,")
		BigDecimal pMaxAmount;//  ,单次最多提现金额,BigDecimal,不校验,否,
		 @PBFields(name = ",当日最多提现金额,BigDecimal,不校验,否,")
		BigDecimal dMaxAmount;//  ,当日最多提现金额,BigDecimal,不校验,否,
		 @PBFields(name = ",可取金额,BigDecimal,不校验,否,")
		BigDecimal balanceQ;//  ,可取金额,BigDecimal,不校验,否,
		 @PBFields(name = ",重复校验码,String,不校验,否,")
		String repeatCommitCheckCode;//  ,重复校验码,String,不校验,否,
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class FundCorrelateRecordList {

		 @PBFields(name = ",提现银行卡号,String,不校验,是,")
				String bankAccount;//  ,提现银行卡号,String,不校验,是,
		 @PBFields(name = ",提现银行卡所在行名,String,不校验,是,")
				String bankName;//  ,提现银行卡所在行名,String,不校验,是,
		 @PBFields(name = ",提现银行卡编号,String,不校验,是,")
				String id;//  ,提现银行卡编号,String,不校验,是,
}

		 @PBFields(name = ",签约所在行号,String,不校验,是,当用户已签约银行卡，提现默认此方式与线下充值取一")
		List<FundCorrelateRecordList>fundCorrelateRecordList;// 
 
		 @PBFields(name = ",签约所在行号,String,不校验,是,当用户已签约银行卡，提现默认此方式与线下充值取一")
		String bankCode;//  ,签约所在行号,String,不校验,是,当用户已签约银行卡，提现默认此方式与线下充值取一
		 @PBFields(name = ",签约银行卡号,String,不校验,是,")
		String bankCardNo;//  ,签约银行卡号,String,不校验,是,
		 @PBFields(name = ",支行行号,String,不校验,是,")
		String branchNo;//  ,支行行号,String,不校验,是,
		 @PBFields(name = ",支行行名,String,不校验,是,")
		String branchName;//  ,支行行名,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
