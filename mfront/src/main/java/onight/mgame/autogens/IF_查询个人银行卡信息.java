package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 查询个人银行卡信息,客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/queryUserBankInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_queryUserBankInfo", path = "/ife/bankcardmanage/queryUserBankInfo.html") 
public class IF_查询个人银行卡信息 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String bankcard;//  ,银行卡,String,,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",支行号,String,不校验,是,")
		String branchNo;//  ,支行号,String,不校验,是,
		 @PBFields(name = ",支行名称,String,不校验,是,")
		String branchName;//  ,支行名称,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
