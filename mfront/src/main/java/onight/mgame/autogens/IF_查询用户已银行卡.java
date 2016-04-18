package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 查询用户已银行卡,客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/queryUserBankCard.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_queryUserBankCard", path = "/ife/bankcardmanage/queryUserBankCard.html") 
public class IF_查询用户已银行卡 {
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
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class TcCustomerChannelList {

		 @PBFields(name = ",编号,String,不校验,是,")
				String id;//  ,编号,String,不校验,是,
		 @PBFields(name = ",用户账号,String,不校验,是,")
				String account;//  ,用户账号,String,不校验,是,
		 @PBFields(name = ",用户名称,String,不校验,是,")
				String name;//  ,用户名称,String,不校验,是,
		 @PBFields(name = ",资金账号,String,不校验,是,")
				String fundAccount;//  ,资金账号,String,不校验,是,
		 @PBFields(name = ",支付渠道,String,不校验,是,")
				String payChannelNo;//  ,支付渠道,String,不校验,是,
		 @PBFields(name = ",支付渠道名称,String,不校验,是,")
				String payChannelName;//  ,支付渠道名称,String,不校验,是,
		 @PBFields(name = ",总行代码,String,不校验,是,")
				String bankCode;//  ,总行代码,String,不校验,是,
		 @PBFields(name = ",银行名称,String,不校验,是,")
				String bankName;//  ,银行名称,String,不校验,是,
		 @PBFields(name = ",银行卡号,String,不校验,是,")
				String bankCard;//  ,银行卡号,String,不校验,是,
		 @PBFields(name = ",卡号类型,String,不校验,是,")
				String cardType;//  ,卡号类型,String,不校验,是,
		 @PBFields(name = ",证件类型,String,不校验,是,")
				String certificateType;//  ,证件类型,String,不校验,是,
		 @PBFields(name = ",证件号码,String,不校验,是,")
				String certificateCode;//  ,证件号码,String,不校验,是,
		 @PBFields(name = ",备注,String,不校验,是,")
				String remark;//  ,备注,String,不校验,是,
		 @PBFields(name = ",Ip地址,String,不校验,是,")
				String ip;//  ,Ip地址,String,不校验,是,
		 @PBFields(name = ",创建时间,String,不校验,是,")
				String gmtCreate;//  ,创建时间,String,不校验,是,
		 @PBFields(name = ",修改时间,String,不校验,是,")
				String gmtModify;//  ,修改时间,String,不校验,是,
		 @PBFields(name = ",是否上次入金所选渠道,String,不校验,是,")
				String lastFlag;//  ,是否上次入金所选渠道,String,不校验,是,
		 @PBFields(name = ",状态,String,不校验,是,")
				String status;//  ,状态,String,不校验,是,
		 @PBFields(name = ",出金渠道,String,不校验,是,")
				String outNo;//  ,出金渠道,String,不校验,是,
}

		 List<TcCustomerChannelList>tcCustomerChannelList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
