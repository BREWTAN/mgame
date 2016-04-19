package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 我的预约,产品相关,TradeController,POST,JSON,/ife/trade/queryMyOrderList.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryMyOrderList", path = "/ife/trade/queryMyOrderList.html") 
public class IF_我的预约 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",当前页,String,不校验,否,默认1")
		String pageIndex;//  ,当前页,String,不校验,否,默认1
		 @PBFields(name = ",页大小,String,不校验,否,默认10")
		String pageSize;//  ,页大小,String,不校验,否,默认10
		 @PBFields(name = ",预约提交开始日期,String,不校验,否,")
		String gmtCreateBegin;//  ,预约提交开始日期,String,不校验,否,
		 @PBFields(name = ",预约提交结束日期,String,不校验,否,")
		String gmtCreateEnd;//  ,预约提交结束日期,String,不校验,否,
		 @PBFields(name = ",履约状态,String,不校验,否,")
		String appointmentStatus;//  ,履约状态,String,不校验,否,
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

		 @PBFields(name = ",页大小,String,不校验,是,")
				String pageSize;//  ,页大小,String,不校验,是,
		 @PBFields(name = ",当前页,String,不校验,是,")
				String pageIndex;//  ,当前页,String,不校验,是,
		 @PBFields(name = ",总页数,String,不校验,是,")
				String pageCount;//  ,总页数,String,不校验,是,
		 @PBFields(name = ",总条数,String,不校验,是,")
				String totalCount;//  ,总条数,String,不校验,是,
}

		 @PBFields(name = ",预约产品列表,List,不校验,是,")
PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class TaProductOrderDetailWrapList {

		 @PBFields(name = ",预约编号,String,不校验,是,")
				String orderNum;//  ,预约编号,String,不校验,是,
		 @PBFields(name = ",预约类型,String,不校验,是,0-特约;1-普通预约;2-定值预约")
				String orderType;//  ,预约类型,String,不校验,是,0-特约;1-普通预约;2-定值预约
		 @PBFields(name = ",预约产品编号,String,不校验,是,普通预约时有，其他为空")
				String orderProductCode;//  ,预约产品编号,String,不校验,是,普通预约时有，其他为空
		 @PBFields(name = ",产品名称,String,不校验,是,")
				String productName;//  ,产品名称,String,不校验,是,
		 @PBFields(name = ",预约认购金额,String,不校验,是,")
				String orderBuyAmount;//  ,预约认购金额,String,不校验,是,
		 @PBFields(name = ",保证金比例,String,不校验,是,")
				String depositRate;//  ,保证金比例,String,不校验,是,
		 @PBFields(name = ",冻结保证金金额,String,不校验,是,")
				String freezeDeposit;//  ,冻结保证金金额,String,不校验,是,
		 @PBFields(name = ",预约状态,String,不校验,是,1-已受理;2-已撤销;3-未受理;4-审核失败")
				String orderStatus;//  ,预约状态,String,不校验,是,1-已受理;2-已撤销;3-未受理;4-审核失败
		 @PBFields(name = ",认购状态,String,不校验,是,0-未认购;1-已认购;2-已认购撤单")
				String subscrebeStatus;//  ,认购状态,String,不校验,是,0-未认购;1-已认购;2-已认购撤单
		 @PBFields(name = ",履约状态,String,不校验,是,0-未履约;1-已履约;2-已违约")
				String appointmentStatus;//  ,履约状态,String,不校验,是,0-未履约;1-已履约;2-已违约
		 @PBFields(name = ",产品利率,String,不校验,是,定制类")
				String productRate;//  ,产品利率,String,不校验,是,定制类
		 @PBFields(name = ",剩余时间,String,不校验,是,秒")
				String remainTimeOne;//  ,剩余时间,String,不校验,是,秒
		 @PBFields(name = ",剩余时间,String,不校验,是,秒")
				String remainTimeTwo;//  ,剩余时间,String,不校验,是,秒
		 @PBFields(name = ",状态,String,不校验,是,")
				String status;//  ,状态,String,不校验,是,
		 @PBFields(name = ",募集开始时间,String,不校验,是,")
				String buyStartDate;//  ,募集开始时间,String,不校验,是,
		 @PBFields(name = ",募集结束时间,String,不校验,是,")
				String buyEndDate;//  ,募集结束时间,String,不校验,是,
		 @PBFields(name = ",当前系统时间,String,不校验,是,")
				String currentDate;//  ,当前系统时间,String,不校验,是,
		 @PBFields(name = ",创建时间,String,不校验,是,")
				String gmtCreate;//  ,创建时间,String,不校验,是,
		 @PBFields(name = ",是否显示立即购买,String,不校验,是,")
				String isDisplayBuy;//  ,是否显示立即购买,String,不校验,是,
		 @PBFields(name = ",是否显示取消预约,String,不校验,是,")
				String isDisplayCancel;//  ,是否显示取消预约,String,不校验,是,
}

		 List<TaProductOrderDetailWrapList>taProductOrderDetailWrapList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
