package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 预约产品详情查询,产品相关,TradeController,POST,JSON,/ife/trade/queryProductOrderInfoDetail.html@onight.mgame.utils.PBInfo(name = "PBIFE_trade_queryProductOrderInfoDetail", path = "/ife/trade/queryProductOrderInfoDetail.html") 
public class IF_预约产品详情查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String productCode;//  ,产品编号,String,不校验,否,
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
	public static class TaProductOrderInfo {

		 @PBFields(name = ",预约开始时间,String,不校验,是,")
				String orderStartDate;//  ,预约开始时间,String,不校验,是,
		 @PBFields(name = ",预约结束时间,String,不校验,是,")
				String orderEndDate;//  ,预约结束时间,String,不校验,是,
		 @PBFields(name = ",产品编码,String,不校验,是,")
				String productCode;//  ,产品编码,String,不校验,是,
		 @PBFields(name = ",是否可转让,String,不校验,是,")
				String isTransfer;//  ,是否可转让,String,不校验,是,
		 @PBFields(name = ",风险级别,String,不校验,是,")
				String riskLevel;//  ,风险级别,String,不校验,是,
		 @PBFields(name = ",认购起点金额,String,不校验,是,")
				String buyerSmallestAmount;//  ,认购起点金额,String,不校验,是,
		 @PBFields(name = ",最低持有本金,String,不校验,是,")
				String leastHoldAmount;//  ,最低持有本金,String,不校验,是,
		 @PBFields(name = ",发行规模,String,不校验,是,")
				String buyTotalAmount;//  ,发行规模,String,不校验,是,
		 @PBFields(name = ",实际发行总量,String,不校验,是,")
				String buySmallestAmount;//  ,实际发行总量,String,不校验,是,
		 @PBFields(name = ",剩余发行量,String,不校验,是,")
				String buyRemainAmount;//  ,剩余发行量,String,不校验,是,
		 @PBFields(name = ",预期年化收益率,String,不校验,是,")
				String expectedMaxAnnualRate;//  ,预期年化收益率,String,不校验,是,
		 @PBFields(name = ",募集开始时间,String,不校验,是,")
				String buyStartDate;//  ,募集开始时间,String,不校验,是,
		 @PBFields(name = ",延期天数,String,不校验,是,")
				String delayDays;//  ,延期天数,String,不校验,是,
		 @PBFields(name = ",超出收益分成比例,String,不校验,是,")
				String outIncomeRate;//  ,超出收益分成比例,String,不校验,是,
		 @PBFields(name = ",,String,不校验,是,")
				String taxDesc;//  ,,String,不校验,是,
		 @PBFields(name = ",,String,不校验,是,")
				String actualAnnualRateTemp;//  ,,String,不校验,是,
		 @PBFields(name = ",,String,不校验,是,")
				String issueConfirmTime;//  ,,String,不校验,是,
		 @PBFields(name = ",,String,不校验,是,")
				String clearConfirmTime;//  ,,String,不校验,是,
		 @PBFields(name = ",停牌原因,String,不校验,是,")
				String suspendReason;//  ,停牌原因,String,不校验,是,
		 @PBFields(name = ",,String,不校验,是,")
				String isIssueClearEnd;//  ,,String,不校验,是,
		 @PBFields(name = ",存续期限,String,不校验,是,")
				String deadline;//  ,存续期限,String,不校验,是,
		 @PBFields(name = ",认购递增金额,String,不校验,是,")
				String unActualPriceIncreases;//  ,认购递增金额,String,不校验,是,
		 @PBFields(name = ",会员认购等级,String,不校验,是,")
				String unActualBuyUserLevel;//  ,会员认购等级,String,不校验,是,
		 @PBFields(name = ",认购价格,String,不校验,是,")
				String unActualPrice;//  ,认购价格,String,不校验,是,
		 @PBFields(name = ",交易费率,String,不校验,是,")
				String unActualTradeApplyRate;//  ,交易费率,String,不校验,是,
		 @PBFields(name = ",利率下限,String,不校验,是,")
				String zsjRate;//  ,利率下限,String,不校验,是,
		 @PBFields(name = ",利率上限,String,不校验,是,")
				String currentRate;//  ,利率上限,String,不校验,是,
		 @PBFields(name = ",过户费,String,不校验,是,")
				String transferFee;//  ,过户费,String,不校验,是,
		 @PBFields(name = ",挂牌方式,String,不校验,是,")
				String productSubType;//  ,挂牌方式,String,不校验,是,
		 @PBFields(name = ",认购最低持有时间,String,不校验,是,")
				String leastHoldDays;//  ,认购最低持有时间,String,不校验,是,
		 @PBFields(name = ",是否开放,String,不校验,是,")
				String isOpen;//  ,是否开放,String,不校验,是,
		 @PBFields(name = ",下一个开放日,String,不校验,是,")
				String nextOpenDate;//  ,下一个开放日,String,不校验,是,
		 @PBFields(name = ",最小赎回单位,String,不校验,是,")
				String redeemSmallestAmount;//  ,最小赎回单位,String,不校验,是,
		 @PBFields(name = ",发行机构,String,不校验,是,")
				String issueCompany;//  ,发行机构,String,不校验,是,
		 @PBFields(name = ",发行机构,String,不校验,是,")
				String issueCompanyName;//  ,发行机构,String,不校验,是,
		 @PBFields(name = ",回购机构,String,不校验,是,")
				String salesCompany;//  ,回购机构,String,不校验,是,
		 @PBFields(name = ",附件1的路径,String,不校验,是,")
				String filePath1;//  ,附件1的路径,String,不校验,是,
		 @PBFields(name = ",附件1的路径,String,不校验,是,")
				String filePath2;//  ,附件1的路径,String,不校验,是,
		 @PBFields(name = ",附件1的路径,String,不校验,是,")
				String filePath3;//  ,附件1的路径,String,不校验,是,
		 @PBFields(name = ",附件1的路径,String,不校验,是,")
				String filePath4;//  ,附件1的路径,String,不校验,是,
		 @PBFields(name = ",附件1的路径,String,不校验,是,")
				String filePath5;//  ,附件1的路径,String,不校验,是,
		 @PBFields(name = ",附件1的路径,String,不校验,是,")
				String filePath6;//  ,附件1的路径,String,不校验,是,
		 @PBFields(name = ",产品销售对象,String,不校验,是,")
				String saleObject;//  ,产品销售对象,String,不校验,是,
		 @PBFields(name = ",对方银行,String,不校验,是,发行方账户名")
				String opstBankCode;//  ,对方银行,String,不校验,是,发行方账户名
		 @PBFields(name = ",对方银行账号,String,不校验,是,发行方账号")
				String opstBankAccount;//  ,对方银行账号,String,不校验,是,发行方账号
		 @PBFields(name = ",划款截至时间,String,不校验,是,")
				String tranEndDate;//  ,划款截至时间,String,不校验,是,
		 @PBFields(name = ",承诺回购利率,String,不校验,是,")
				String dayRate;//  ,承诺回购利率,String,不校验,是,
		 @PBFields(name = ",日承诺回购金额,String,不校验,是,")
				String dayAmount;//  ,日承诺回购金额,String,不校验,是,
		 @PBFields(name = ",计息方式,String,不校验,是,")
				String yearDay;//  ,计息方式,String,不校验,是,
		 @PBFields(name = ",分配方式,String,不校验,是,")
				String irstCycle;//  ,分配方式,String,不校验,是,
		 @PBFields(name = ",最高认购金额,String,不校验,是,")
				String mostHoldAmount;//  ,最高认购金额,String,不校验,是,
		 @PBFields(name = ",认购人数,String,不校验,是,")
				String mostHolderNum;//  ,认购人数,String,不校验,是,
		 @PBFields(name = ",收益类型,String,不校验,是,")
				String incomeType;//  ,收益类型,String,不校验,是,
		 @PBFields(name = ",收益税率,String,不校验,是,")
				String incomeRate;//  ,收益税率,String,不校验,是,
		 @PBFields(name = ",违约比例,String,不校验,是,")
				String defaultRatio;//  ,违约比例,String,不校验,是,
		 @PBFields(name = ",延期兑付年化收益率,String,不校验,是,")
				String delayCashRate;//  ,延期兑付年化收益率,String,不校验,是,
		 @PBFields(name = ",是否承诺回购,String,不校验,是,")
				String isBuyBack;//  ,是否承诺回购,String,不校验,是,
		 @PBFields(name = ",产品小类,String,不校验,是,")
				String prodSubType;//  ,产品小类,String,不校验,是,
		 @PBFields(name = ",付息方式,String,不校验,是,")
				String payStyle;//  ,付息方式,String,不校验,是,
		 @PBFields(name = ",付息频率,String,不校验,是,")
				String payFrequency;//  ,付息频率,String,不校验,是,
		 @PBFields(name = ",发行方信用评级,String,不校验,是,")
				String issueCreditLevel;//  ,发行方信用评级,String,不校验,是,
		 @PBFields(name = ",定向融资计划信用评级,String,不校验,是,")
				String directFinanceCreditLevel;//  ,定向融资计划信用评级,String,不校验,是,
		 @PBFields(name = ",发行方银行账户开户行,String,不校验,是,")
				String issueBank;//  ,发行方银行账户开户行,String,不校验,是,
		 @PBFields(name = ",资金监管机构,String,不校验,是,")
				String financeCompany;//  ,资金监管机构,String,不校验,是,
		 @PBFields(name = ",评级机构,String,不校验,是,")
				String levelCompany;//  ,评级机构,String,不校验,是,
		 @PBFields(name = ",担保机构全称,String,不校验,是,增信机构")
				String guaranteeCompany;//  ,担保机构全称,String,不校验,是,增信机构
		 @PBFields(name = ",担保机构信用级别,String,不校验,是,增信机构信用评级")
				String guaranteeLevel;//  ,担保机构信用级别,String,不校验,是,增信机构信用评级
		 @PBFields(name = ",担保方式,String,不校验,是,增信机构增信方式")
				String guaranteeWay;//  ,担保方式,String,不校验,是,增信机构增信方式
		 @PBFields(name = ",延期兑付日息,String,不校验,是,")
				String delayDayRate;//  ,延期兑付日息,String,不校验,是,
		 @PBFields(name = ",持有人数,String,不校验,是,")
				String holdersNum;//  ,持有人数,String,不校验,是,
		 @PBFields(name = ",是否份额化,String,不校验,是,")
				String isShare;//  ,是否份额化,String,不校验,是,
		 @PBFields(name = ",产品起息日,String,不校验,是,")
				String productStartDate;//  ,产品起息日,String,不校验,是,
		 @PBFields(name = ",承销机构,String,不校验,是,")
				String consignCompany;//  ,承销机构,String,不校验,是,
		 @PBFields(name = ",发行机构,String,不校验,是,")
				String fxjg;//  ,发行机构,String,不校验,是,
		 @PBFields(name = ",产品提供方,String,不校验,是,")
				String cptgf;//  ,产品提供方,String,不校验,是,
		 @PBFields(name = ",是否已售罄,String,不校验,是,0 否 1是")
				String isOver;//  ,是否已售罄,String,不校验,是,0 否 1是
		 @PBFields(name = ",到期类型,String,不校验,是,")
				String deadlineType;//  ,到期类型,String,不校验,是,
		 @PBFields(name = ",付息频率单位,String,不校验,是,")
				String payFrequencyUnit;//  ,付息频率单位,String,不校验,是,
		 @PBFields(name = ",二级市场转让对象,String,不校验,是,0-个人和机构客户  1-个人客户  2-机构客户")
				String transferObject;//  ,二级市场转让对象,String,不校验,是,0-个人和机构客户  1-个人客户  2-机构客户
		 @PBFields(name = ",,String,不校验,是,")
				String groupId;//  ,,String,不校验,是,
		 @PBFields(name = ",,String,不校验,是,")
				String batchId;//  ,,String,不校验,是,
		 @PBFields(name = ",产品文件路径,String,不校验,是,")
				String productFilePath;//  ,产品文件路径,String,不校验,是,
		 @PBFields(name = ",普通份额,String,不校验,是,")
				String generalCustomerUsedNum;//  ,普通份额,String,不校验,是,
		 @PBFields(name = ",预约份额,String,不校验,是,")
				String specialCustomerUsedNum;//  ,预约份额,String,不校验,是,
		 @PBFields(name = ",产品名称,String,不校验,是,")
				String productName;//  ,产品名称,String,不校验,是,
		 @PBFields(name = ",托管机构,String,不校验,是,")
				String manageCompany;//  ,托管机构,String,不校验,是,
		 @PBFields(name = ",投资币种,String,不校验,是,")
				String currency;//  ,投资币种,String,不校验,是,
		 @PBFields(name = ",状态,String,不校验,是,")
				String status;//  ,状态,String,不校验,是,
		 @PBFields(name = ",,String,不校验,是,")
				String afterStatus;//  ,,String,不校验,是,
		 @PBFields(name = ",,String,不校验,是,")
				String relationTable;//  ,,String,不校验,是,
		 @PBFields(name = ",审核原因,String,不校验,是,")
				String aduitReason;//  ,审核原因,String,不校验,是,
		 @PBFields(name = ",创建时间,String,不校验,是,")
				String gmtCreate;//  ,创建时间,String,不校验,是,
		 @PBFields(name = ",修改时间,String,不校验,是,")
				String gmtModify;//  ,修改时间,String,不校验,是,
		 @PBFields(name = ",市场类别,String,不校验,是,")
				String productType;//  ,市场类别,String,不校验,是,
		 @PBFields(name = ",产品类别,String,不校验,是,")
				String subjectType;//  ,产品类别,String,不校验,是,
		 @PBFields(name = ",产品大图片路径,String,不校验,是,")
				String picUrl;//  ,产品大图片路径,String,不校验,是,
		 @PBFields(name = ",产品小图片地址,String,不校验,是,")
				String picSUrl;//  ,产品小图片地址,String,不校验,是,
		 @PBFields(name = ",产品排序,String,不校验,是,")
				String productSort;//  ,产品排序,String,不校验,是,
		 @PBFields(name = ",产品图片路径,String,不校验,是,")
				String picManageUrl;//  ,产品图片路径,String,不校验,是,
		 @PBFields(name = ",产品副标题,String,不校验,是,")
				String productSubtitle;//  ,产品副标题,String,不校验,是,
		 @PBFields(name = ",是否同步,String,不校验,是,1:同步 0:不同步")
				String isSynchronized;//  ,是否同步,String,不校验,是,1:同步 0:不同步
		 @PBFields(name = ",银登产品编号,String,不校验,是,")
				String csdProductCode;//  ,银登产品编号,String,不校验,是,
		 @PBFields(name = ",保证金比例,String,不校验,是,")
				String depositRate;//  ,保证金比例,String,不校验,是,
		 @PBFields(name = ",保证金比例,String,不校验,是,")
				String transferFloatBegin;//  ,保证金比例,String,不校验,是,
}

		 TaProductOrderInfo taProductOrderInfo;// 
 
		 String tfw__reserved;//保留字段 

	}

}
