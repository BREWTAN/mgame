package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 预约认购产品详情查询,产品相关,PrdQueryController,POST,JSON,/ife/prdquery/prdQueryOrderProductDetails.html@onight.mgame.utils.PBInfo(name = "PBIFE_prdquery_prdQueryOrderProductDetails", path = "/ife/prdquery/prdQueryOrderProductDetails.html") 
public class IF_预约认购产品详情查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String orderProductCode;//  ,预约产品编号,String,不校验,否,
		String orderType;//  ,预约类型,String,不校验,否,
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
	public static class TaProductFinanceDetail {

				String orderType;//  ,预约类型,String,不校验,是,0-特约;1-普通预约;2-定值预约
				String orderProductCode;//  ,预约产品编号,String,不校验,是,
				String productCode;//  ,产品code,String,不校验,是,
				String productName;//  ,产品名称,String,不校验,是,
				String productStatusStr;//  ,产品状态,String,不校验,是,
				String buyStartDate;//  ,认购开始时间,String,不校验,是,
				String buyEndDate;//  ,认购结束时间,String,不校验,是,
				String buyEndTimes;//  ,认购剩余时长,String,不校验,是,
				String manageStartDateStr;//  ,管理期限开始时间,String,不校验,是,
				String manageEndDateStr;//  ,管理期限结束时间,String,不校验,是,
				String manageStartDate;//  ,管理期限开始时间,String,不校验,是,
				String manageEndDate;//  ,管理期限结束时间,String,不校验,是,
				String tradeStartDate;//  ,交易开始时间,String,不校验,是,
				String tradeEndDate;//  ,交易结束时间,String,不校验,是,
				String currency;//  ,币种,String,不校验,是,
				String isTransferStr;//  ,是否可转让前台展示,String,不校验,是,
				String riskLevel;//  ,风险等级,String,不校验,是,
				String riskLevelStr;//  ,风险等级前台展示,String,不校验,是,
				String buyerSmallestAmount;//  ,买家最小购买单位,String,不校验,是,
				String buyTotalAmount;//  ,发行总规模,String,不校验,是,
				String buySmallestAmount;//  ,发行最低下限,String,不校验,是,
				String buyRemainAmount;//  ,发行剩余量,String,不校验,是,
				String suspendReason;//  ,停牌原因,String,不校验,是,
				String serialNoStr;//  ,,String,不校验,是,
				String subjectTypeName;//  ,,String,不校验,是,
				String prodSubType;//  ,,String,不校验,是,
				String deadline;//  ,理财期限,String,不校验,是,
				String expectedMaxAnnualRate;//  ,预期年化收益率,String,不校验,是,
				String actualAnnualRate;//  ,实际年化收益率,String,不校验,是,
				String productSubType;//  ,挂牌方式,String,不校验,是,
				String isTransfer;//  ,是否可转让,String,不校验,是,
				String transferIsfloat;//  ,转让是否支持浮动利率,String,不校验,是,
				String transferIsfloatName;//  ,转让是否支持浮动利率-名称,String,不校验,是,
				String transferFloat;//  ,转让浮动利率幅度,String,不校验,是,
				String transferFloatBegin;//  ,转让浮动利率开始利率,String,不校验,是,
				String transferFloatEnd;//  ,转让浮动利率结束利率,String,不校验,是,
				String buyRate;//  ,发行率,String,不校验,是,
				String custodyRate;//  ,保管费,String,不校验,是,
				String delayDays;//  ,延期天数,String,不校验,是,
				String outIncomeRate;//  ,超出收益分成比例,String,不校验,是,
				String taxDesc;//  ,税收说明,String,不校验,是,
				String actualAnnualRateTemp;//  ,估算的临时值,String,不校验,是,
				String productDesc;//  ,产品描述,String,不校验,是,
				String remark;//  ,备注,String,不校验,是,
				String issueConfirmTime;//  ,发行确认时间,String,不校验,是,
				String clearConfirmTime;//  ,兑付确认时间,String,不校验,是,
				String isIssueClearEnd;//  ,发行清算是否结束,String,不校验,是,
				String status;//  ,产品的状态,String,不校验,是,
				String unActualPriceIncreases;//  ,,String,不校验,是,
				String unActualBuyUserLevel;//  ,,String,不校验,是,
				String unActualPrice;//  ,,String,不校验,是,
				String unActualTradeApplyRate;//  ,,String,不校验,是,
				String financeCode;//  ,,String,不校验,是,
				String zsjRate;//  ,,String,不校验,是,
				String currentRate;//  ,,String,不校验,是,
				String transferFee;//  ,过户费,String,不校验,是,
				String leastHoldDays;//  ,最少持有天數,String,不校验,是,
				String isOpen;//  ,是否开放,String,不校验,是,
				String nextOpenDate;//  ,下一个开放日,String,不校验,是,
				String redeemSmallestAmount;//  ,最小赎回单位,String,不校验,是,
				String leastHoldAmount;//  ,最少持有份额,String,不校验,是,
				String issueCompany;//  ,发行机构,String,不校验,是,
				String issueCompanyName;//  ,发行机构名称,String,不校验,是,
				String salesCompany;//  ,销售机构,String,不校验,是,
				String salesCompanyName;//  ,销售机构名称,String,不校验,是,
				String filePath1;//  ,,String,不校验,是,
				String filePath2;//  ,,String,不校验,是,
				String filePath3;//  ,,String,不校验,是,
				String filePath4;//  ,,String,不校验,是,
				String filePath5;//  ,,String,不校验,是,
				String filePath6;//  ,,String,不校验,是,
				String tranEndDate;//  ,,String,不校验,是,
				String opstBankCode;//  ,,String,不校验,是,
				String opstBankAccount;//  ,,String,不校验,是,
				String saleObject;//  ,,String,不校验,是,
				String saleObjectName;//  ,,String,不校验,是,
				String operType;//  ,,String,不校验,是,
				String opType;//  ,,String,不校验,是,
				String comToday;//  ,募集开始时间与今天的关系,String,不校验,是,
				String totalPerson;//  ,认购总人数,String,不校验,是,
				String totalMoney;//  ,认购总金额,String,不校验,是,
				String dayRate;//  ,当日承诺回购价格,String,不校验,是,
				String dayAmount;//  ,当日承诺回购余额,String,不校验,是,
				String yearDay;//  ,年度天数,String,不校验,是,
				String yearDayName;//  ,年度天数-名称,String,不校验,是,
				String irstCycle;//  ,付息周期,String,不校验,是,
				String mostHoldAmount;//  ,最高认购份额,String,不校验,是,
				String mostHolderNum;//  ,认购人数,String,不校验,是,
				String discountRate;//  ,折扣,String,不校验,是,
				String incomeType;//  ,收益类型,String,不校验,是,
				String incomeRate;//  ,收益税率,String,不校验,是,
				String defaultRatio;//  ,违约比例,String,不校验,是,
				String tradeLeastHoldDay;//  ,交易最低持有时间,String,不校验,是,
				String leastTranAmount;//  ,最低转让份额,String,不校验,是,
				String delayCashRate;//  ,延期兑付年化收益率,String,不校验,是,
				String tradeIncrease;//  ,交易增量,String,不校验,是,
				String tradeObject;//  ,交易费收取对象,String,不校验,是,
				String isBuyBack;//  ,是否承诺回购,String,不校验,是,
				String buyRateNo;//  ,挂牌手续费,String,不校验,是,
				String manageRateNo;//  ,管理手续费,String,不校验,是,
				String riskTest;//  ,是否做风险测评,String,不校验,是,
				String cashType;//  ,兑付资金来源,String,不校验,是,
				String imputType;//  ,归集资金来源,String,不校验,是,
				String collectionDestination;//  ,归集资金去向,String,不校验,是,
				String cashDestination;//  ,兑付资金去向,String,不校验,是,
				String specialAmount;//  ,特约份额,String,不校验,是,
				String specialCustomerNum;//  ,特约客户人数,String,不校验,是,
				String payStyle;//  ,付息方式,String,不校验,是,
				String firstCashDate;//  ,首次确权日,String,不校验,是,
				String payNum;//  ,付息日,String,不校验,是,
				String payFrequency;//  ,付息频率,String,不校验,是,
				String issueCreditLevel;//  ,发行方信用评级,String,不校验,是,
				String directFinanceCreditLevel;//  ,定向融资计划信用评级,String,不校验,是,
				String issueBank;//  ,发行方银行账户开户行,String,不校验,是,
				String financeCompany;//  ,资金监管机构,String,不校验,是,
				String levelCompany;//  ,评级机构,String,不校验,是,
				String guaranteeCompany;//  ,担保机构全称,String,不校验,是,增信机构
				String guaranteeLevel;//  ,担保机构信用级别,String,不校验,是,增信机构信用评级
				String guaranteeWay;//  ,担保方式,String,不校验,是,增信机构增信方式
				String delayDayRate;//  ,延期兑付日息,String,不校验,是,
				String holdersNum;//  ,持有人数（上限）,String,不校验,是,
				String specialBuyAmount;//  ,特约认购起点金额,String,不校验,是,
				String specialIncreaseAmount;//  ,特约增量份额,String,不校验,是,
				String isShare;//  ,是否份额化,String,不校验,是,
				String productStartDate;//  ,产品开始,String,不校验,是,
				String delayOptionRate;//  ,延期利率,String,不校验,是,
				String delayOptionRemark;//  ,延期备注,String,不校验,是,
				String optionTriggerType;//  ,展期触发类型,String,不校验,是,
				String optionType;//  ,展期类型,String,不校验,是,
				String optionDateStart;//  ,展期开始日,String,不校验,是,
				String optionDateEnd;//  ,展期结束日,String,不校验,是,
				String delayDateStart;//  ,延期开始日,String,不校验,是,
				String delayDateEnd;//  ,延期结束日,String,不校验,是,
				String consignCompany;//  ,,String,不校验,是,
				String picUrl;//  ,图片地址,String,不校验,是,
				String auditStatus;//  ,挂牌修改审核状态,String,不校验,是,
				String auditRemark;//  ,挂牌修改审核备注,String,不校验,是,
				String fxjg;//  ,发行机构,String,不校验,是,
				String zjhkfs;//  ,资金划款方式,String,不校验,是,
				String cptgf;//  ,产品提供方,String,不校验,是,
				String zcbcplx;//  ,招财宝产品类型,String,不校验,是,
				String jkrsfzhm;//  ,借款人身份证号码,String,不校验,是,
				String zcbyhbh;//  ,招财宝用户ID,String,不校验,是,
				String sss;//  ,所属省,String,不校验,是,
				String ssc;//  ,所属市,String,不校验,是,
				String jkrkhfzh;//  ,借款人开户分支行,String,不校验,是,
				String jkryhzh;//  ,借款人银行账号,String,不校验,是,
				String dgzhbz;//  ,对公账户标志,String,不校验,是,
				String cphtbh;//  ,产品合同ID,String,不校验,是,
				String cpms;//  ,产品描述,String,不校验,是,
				String cpsysm;//  ,产品收益说明,String,不校验,是,
				String cpfxsm;//  ,产品风险说明,String,不校验,是,
				String cpxgnlsx;//  ,产品限购年龄上限,String,不校验,是,
				String cpxgnlxx;//  ,产品限购年龄下限,String,不校验,是,
				String sfxyfxpc;//  ,是否需要风险评测,String,不校验,是,
				String zcbcpfxdj;//  ,招财宝产品风险等级,String,不校验,是,
				String syjslx;//  ,收益计算类型,String,不校验,是,
				String jkr;//  ,借款人,String,不校验,是,
				String bz;//  ,备注,String,不校验,是,
				String bdnhll;//  ,保底年化利率,String,不校验,是,
				String zdmjcgje;//  ,最低募集成功金额,String,不校验,是,
				String sylx;//  ,收益类型,String,不校验,是,
				String jkrzcbzh;//  ,借款人招财宝账户,String,不校验,是,
				String jkrkhyh;//  ,借款人开户银行,String,不校验,是,
				String sfyzcbxs;//  ,是否由 招财宝销售,String,不校验,是,
				String hkbzwa;//  ,还款保障文案,String,不校验,是,
				String isOver;//  ,是否已售罄,String,不校验,是,
				String deadlineType;//  ,到期类型,String,不校验,是,
				String tradeDept;//  ,交易平台,String,不校验,是,
				String transferObject;//  ,交易对象,String,不校验,是,
				String productBrands;//  ,产品分类,String,不校验,是,
				String payFrequencyUnit;//  ,付息平率,String,不校验,是,
				String groupId;//  ,分组,String,不校验,是,
				String orderBy;//  ,排序,String,不校验,是,
				String orderAsc;//  ,升降序,String,不校验,是,
				String brokerCodeList;//  ,渠道列表,List,不校验,是,
				String brokerNoList;//  ,渠道列表,List,不校验,是,
				String channelNoList;//  ,终端列表,List,不校验,是,
				String statusList;//  ,产品状态列表,List,不校验,是,
				String buyDate;//  ,购买时间,String,不校验,是,
				String currentDate;//  ,当前系统时间,String,不校验,是,
				String warnFlag;//  ,是否开始销售,String,不校验,是,0表示没有  1表示已经开始
				String isSpecial;//  ,是否是特约客户,String,不校验,是,0 否 1是
				String remainSepcialAmount;//  ,特约剩余份额,String,不校验,是,
				String onlyMobile;//  ,是否手机专享,String,不校验,是,0 否 1是
				String onlyWeiXin;//  ,是否微信专享,String,不校验,是,0 否 1是
				String account;//  ,账户号,String,不校验,是,
				String isAccepted;//  ,是否认购,String,不校验,是,
				String generalCustomerUsedNum;//  ,普通已认购数,String,不校验,是,
				String specialCustomerUsedNum;//  ,特约已认购人数,String,不校验,是,
				String deadLineList;//  ,产品剩余期限查询条件,List,不校验,是,
				String expectedMaxAnnualRateList;//  ,预期收益率查询条件,List,不校验,是,
				String riskLevelList;//  ,风险等级查询条件,List,不校验,是,
				String subjectTypeList;//  ,产品类型查询条件,List,不校验,是,
				String buyerSmallestAmountList;//  ,起购金额查询条件,List,不校验,是,
				String saleObjectList;//  ,销售对象查询条件,List,不校验,是,
				String onlyNew;//  ,新用户专享字段,String,不校验,是,"0,老用户;1,新用户"
				String process;//  ,剩余百分比进度条,String,不校验,是,
				String orderBuyAmount;//  ,预约额度,String,不校验,是,
}

		 TaProductFinanceDetail taProductFinanceDetail;// 
 
		 String tfw__reserved;//保留字段 

	}

}
