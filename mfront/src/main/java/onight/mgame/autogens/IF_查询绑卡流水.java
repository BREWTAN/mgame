package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 查询绑卡流水,客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/loadTcBindingBankInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_loadTcBindingBankInfo", path = "/ife/bankcardmanage/loadTcBindingBankInfo.html") 
public class IF_查询绑卡流水 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String pageIndex;//  ,当前页,String,不校验,否,
		String pageSize;//  ,页大小,String,不校验,否,
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
	public static class PageInfo {

				String pageSize;//  ,页大小,String,不校验,是,
				String pageIndex;//  ,当前页,String,不校验,是,
				String pageCount;//  ,总页数,String,不校验,是,
				String totalCount;//  ,总条数,String,不校验,是,
}

		 PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class TcBindingBankInfoList {

				String id;//  ,银行绑定流水表PK,String,不校验,是,
				String account;//  ,账号,String,不校验,是,
				String name;//  ,名称,String,不校验,是,
				String bankCode;//  ,银行号码,String,不校验,是,
				String bankName;//  ,银行名称,String,不校验,是,
				String idCard;//  ,证件号码,String,不校验,是,
				String bankCard;//  ,银行卡号,String,不校验,是,
				String mobile;//  ,手机,String,不校验,是,
				String gmtCreate;//  ,记录产生时间,String,不校验,是,
				String gmtModify;//  ,记录最后一次修改时间,String,不校验,是,
				String status;//  ,状态,String,不校验,是,
				String remark;//  ,备注,String,不校验,是,
				String type;//  ,内外签约标志,String,不校验,是,
				String certificateType;//  ,证件类型,String,不校验,是,
				String channelNo;//  ,支付渠道,String,不校验,是,
				String outNo;//  ,出金渠道,String,不校验,是,
				String ip;//  ,ip地址,String,不校验,是,
				String bizNo;//  ,流水号,String,不校验,是,
				String cExit;//  ,统计错误率用到,String,不校验,是,
				String cFailTyp;//  ,更新错误类型,String,不校验,是,
				String bankType;//  ,终端类型,String,不校验,是,
}

		 List<TcBindingBankInfoList>tcBindingBankInfoList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
