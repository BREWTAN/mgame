package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 查询分支银行,客户信息,BankCardManageController,POST,JSON,/ife/bankcardmanage/loadTmbBankInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_bankcardmanage_loadTmbBankInfo", path = "/ife/bankcardmanage/loadTmbBankInfo.html") 
public class IF_查询分支银行 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String branchName;//  ,分支行名称,String,不校验,是,
		String pno;//  ,省编号,String,不校验,是,
		String cno;//  ,城市编号,String,不校验,是,
		String bankCode;//  ,银行编号,String,不校验,否,
		String pageIndex;//  ,当前页,String,不校验,否,默认1
		String pageSize;//  ,页大小,String,不校验,否,默认10
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
	public static class TmbsubbankList {

				String id;//  ,编号,String,不校验,是,
				String sbno;//  ,支付行编号,String,不校验,是,
				String bankno;//  ,所属行编号,String,不校验,是,
				String sbname;//  ,支付行名称,String,不校验,是,
				String sbjc;//  ,支付行简称,String,不校验,是,
				String nodeno;//  ,所在节点代码,String,不校验,是,
				String stat;//  ,状态,String,不校验,是,
				String gmtCreate;//  ,创建时间,String,不校验,是,
				String gmtModify;//  ,创建时间,String,不校验,是,
				String remark;//  ,备注,String,不校验,是,
				String remark1;//  ,备注1,String,不校验,是,
				String remark2;//  ,备注2,String,不校验,是,
				String remark3;//  ,备注3,String,不校验,是,
}

		 List<TmbsubbankList>tmbsubbankList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
