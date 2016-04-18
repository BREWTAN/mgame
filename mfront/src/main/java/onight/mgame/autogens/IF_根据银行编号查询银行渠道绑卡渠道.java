package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 根据银行编号查询银行渠道绑卡渠道,客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/queryFundBankInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_queryFundBankInfo", path = "/ife/bankcardmanage/queryFundBankInfo.html") 
public class IF_根据银行编号查询银行渠道绑卡渠道 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String bankCode;//  ,银行编号,String,,否,
		String transType;//  ,交易类型,String,,否,0-绑卡，1-入金
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
	public static class FundBankDict {

				String id;//  ,编号,String,不校验,是,
				String bankNo;//  ,渠道号,String,不校验,是,
				String bankName;//  ,渠道名称,String,不校验,是,
				String bankId;//  ,所属银行代号,String,不校验,是,
				String bankIdName;//  ,所属银行,String,不校验,是,
				String hMaxAmount;//  ,单笔限额,String,不校验,是,
				String maxNum;//  ,单日限笔,String,不校验,是,
				String maxAmount;//  ,当日限额,String,不校验,是,
				String mMaxNum;//  ,单月限笔,String,不校验,是,
				String mMaxAmount;//  ,当月限额,String,不校验,是,
				String status;//  ,状态,String,不校验,是,0关闭，1打开，2暂停
				String memo;//  ,备注,String,不校验,是,
				String feeAmount;//  ,手续费,String,不校验,是,
				String bankType;//  ,终端,String,不校验,是,0：手机 1：网页
				String transType;//  ,操作类型,String,不校验,是,0：绑卡 1：入金
				String remark;//  ,状态变更说明,String,不校验,是,
}

		 FundBankDict fundBankDict;// 
 
		 String tfw__reserved;//保留字段 

	}

}
