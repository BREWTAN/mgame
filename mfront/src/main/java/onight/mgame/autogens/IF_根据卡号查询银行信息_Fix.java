package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 根据卡号查询银行信息，不支持时，返回浙金支持银行列表,客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/queryBankInfo.html
@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_queryBankInfo", path = "/ife/bankcardmanage/queryBankInfo.html")
public class IF_根据卡号查询银行信息_fix {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		@PBFields(name = ",银行卡号,String,不校验,否,")
		String bankCardNo;// ,银行卡号,String,不校验,否,
		String tfw__reserved;// 保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		@Data
		@AllArgsConstructor
		@NoArgsConstructor
		public static class TCBankDitch {

			@PBFields(name = ",银行渠道信息表PK,String,不校验,是,")
			String id;// ,银行渠道信息表PK,String,不校验,是,
			@PBFields(name = ",银行号码,String,不校验,是,")
			String bankCode;// ,银行号码,String,不校验,是,
			@PBFields(name = ",银行渠道,String,不校验,是,")
			String bankName;// ,银行渠道,String,不校验,是,
			@PBFields(name = ",账户类型,String,不校验,是,")
			String accountType;// ,账户类型,String,不校验,是,
			@PBFields(name = ",支持范围,String,不校验,是,")
			String sustainRange;// ,支持范围,String,不校验,是,
			@PBFields(name = ",单笔金额,String,不校验,是,")
			String singleAmount;// ,单笔金额,String,不校验,是,
			@PBFields(name = ",回盘时间,String,不校验,是,")
			String counterofferTime;// ,回盘时间,String,不校验,是,
			@PBFields(name = ",清算时间,String,不校验,是,")
			String clearTime;// ,清算时间,String,不校验,是,
			@PBFields(name = ",单卡每月限笔,String,不校验,是,")
			String singleMonthLimit;// ,单卡每月限笔,String,不校验,是,
			@PBFields(name = ",单卡每月限额,String,不校验,是,")
			String singleAmountLimit;// ,单卡每月限额,String,不校验,是,
			@PBFields(name = ",备注,String,不校验,是,")
			String remark;// ,备注,String,不校验,是,
			@PBFields(name = ",记录产生时间,String,不校验,是,")
			String gmtCreate;// ,记录产生时间,String,不校验,是,
			@PBFields(name = ",记录最后一次修改时间,String,不校验,是,")
			String gmtModify;// ,记录最后一次修改时间,String,不校验,是,
			@PBFields(name = ",图标类型,String,不校验,是,")
			String titleType;// ,图标类型,String,不校验,是,
			@PBFields(name = ",状态,String,不校验,是,")
			String status;// ,状态,String,不校验,是,
			@PBFields(name = ",图片名称,String,不校验,是,")
			String pictName;// ,图片名称,String,不校验,是,
			@PBFields(name = ",排序,String,不校验,是,")
			String sort;// ,排序,String,不校验,是,
			@PBFields(name = ",单卡单日限制,String,不校验,是,")
			String dayLimitAmount;// ,单卡单日限制,String,不校验,是,
			@PBFields(name = ",账户标识,String,不校验,是,")
			String bankFlag;// ,账户标识,String,不校验,是,
		}

		@Data
		@AllArgsConstructor
		@NoArgsConstructor
		public static class TcBankDitchList {// ,银行信息列表,List,不校验,是,当tcBankDitch为空时有值
			@PBFields(name = ",银行渠道信息表PK,String,不校验,是,")
			String id;// ,银行渠道信息表PK,String,不校验,是,
			@PBFields(name = ",银行号码,String,不校验,是,")
			String bankCode;// ,银行号码,String,不校验,是,
			@PBFields(name = ",银行渠道,String,不校验,是,")
			String bankName;// ,银行渠道,String,不校验,是,
			@PBFields(name = ",账户类型,String,不校验,是,")
			String accountType;// ,账户类型,String,不校验,是,
			@PBFields(name = ",支持范围,String,不校验,是,")
			String sustainRange;// ,支持范围,String,不校验,是,
			@PBFields(name = ",单笔金额,String,不校验,是,")
			String singleAmount;// ,单笔金额,String,不校验,是,
			@PBFields(name = ",回盘时间,String,不校验,是,")
			String counterofferTime;// ,回盘时间,String,不校验,是,
			@PBFields(name = ",清算时间,String,不校验,是,")
			String clearTime;// ,清算时间,String,不校验,是,
			@PBFields(name = ",单卡每月限笔,String,不校验,是,")
			String singleMonthLimit;// ,单卡每月限笔,String,不校验,是,
			@PBFields(name = ",单卡每月限额,String,不校验,是,")
			String singleAmountLimit;// ,单卡每月限额,String,不校验,是,
			@PBFields(name = ",备注,String,不校验,是,")
			String remark;// ,备注,String,不校验,是,
			@PBFields(name = ",记录产生时间,String,不校验,是,")
			String gmtCreate;// ,记录产生时间,String,不校验,是,
			@PBFields(name = ",记录最后一次修改时间,String,不校验,是,")
			String gmtModify;// ,记录最后一次修改时间,String,不校验,是,
			@PBFields(name = ",图标类型,String,不校验,是,")
			String titleType;// ,图标类型,String,不校验,是,
			@PBFields(name = ",状态,String,不校验,是,")
			String status;// ,状态,String,不校验,是,
			@PBFields(name = ",图片名称,String,不校验,是,")
			String pictName;// ,图片名称,String,不校验,是,
			@PBFields(name = ",排序,String,不校验,是,")
			String sort;// ,排序,String,不校验,是,
			@PBFields(name = ",单卡单日限制,String,不校验,是,")
			String dayLimitAmount;// ,单卡单日限制,String,不校验,是,
			@PBFields(name = ",账户标识,String,不校验,是,")
			String bankFlag;// ,账户标识,String,不校验,是,
		}

		List<TcBankDitchList> tcBankDitchList;
		TCBankDitch tcBankDitch;//

		String tfw__reserved;// 保留字段

	}

}
