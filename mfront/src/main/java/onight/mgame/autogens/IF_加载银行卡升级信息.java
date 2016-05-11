package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 加载银行卡升级信息,客户信息,BankCardUpdateManageController,POST,JSON,/ife/bankcardupdatemanage/loadBankCardUpdateInfo.html
@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardupdatemanage_loadBankCardUpdateInfo", path = "/ife/bankcardupdatemanage/loadBankCardUpdateInfo.html") 
public class IF_加载银行卡升级信息 {
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
		 @PBFields(name = ",升级银行卡号,String,不校验,是,")
		String bankCard;//  ,升级银行卡号,String,不校验,是,
		 @PBFields(name = ",升级渠道,String,不校验,是,")
		String updatePayChannelNo;//  ,升级渠道,String,不校验,是,
		 @PBFields(name = ",升级银行编号,String,不校验,是,")
		String bankNo;//  ,升级银行编号,String,不校验,是,

		 String tfw__reserved;//保留字段 

	}

}
