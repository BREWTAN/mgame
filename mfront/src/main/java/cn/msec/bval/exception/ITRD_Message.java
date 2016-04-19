package cn.msec.bval.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ITRD_Message {

	ITM_OK("0000", "接收成功"), //

	ITM_QUERY_OK("0000", "处理成功"), //
	ITM_ERR_PROD_AUDIT_FAILED("0001","审核失败"),
	ITM_ERR_PROD_ONGOING("0002","处理中"),
	ITM_NO_ORDER("0003", "无此订单"), //
	ITM_NO_ACCOUNT_INF("0004", "无账户信息"), //
	
	
	/**
	 * 基本信息判断
	 */
	ITM_ERR_TRANS_BLANK("0101", "请求明文串为空"), //
	ITM_ERR_TRANS_JSON_ERR("0102", "请求JSON出错"), //
	ITM_ERR_BODY_ERROR("0103", "请求内容解密失败"), //
	ITM_ERR_BODY_JSON_ERR("0104", "Body内容JSON出错"), //
	ITM_ERR_MESSAGEID("0105", "流水号格式错误"), //
	ITM_ERR_MCHANT_BLANK("0106", "商户号码为空"), //
	ITM_ERR_MCHNAT_NOTFOUND("0107", "商户信息不存在"), //
	ITM_ERR_MCHNAT_STATUS_ERR("0108", "商户状态异常"), //
	ITM_ERR_MAC_INVALID("0109", "密文校验失败"), //
	ITM_ERR_MCHAT_PRODUCT_NOTOPEN("0110", "商户未开通该产品"), //
	ITM_ERR_MCHAT_PRODUCT_CLOSE("0111", "商户该产品通道关闭"), //

	ITM_ERR_MESSAGEID_DUPLICATED("0112", "消息ID重复"), //
	ITM_ERR_VERSION_ERROR("0113", "版本错误"), //
	ITM_ERR_TRANDETYPE("0114", "交易码错误"), //
	ITM_ERR_REQUESTTIME("0115", "请求时间格式错误"), //
	ITM_ERR_BODY_ZERO("0116", "请求内容个数为零"), //
	ITM_ERR_INSTID_BLANK("0117", "机构标识为空"), 
	ITM_ERR_MERCHANTDATE_ERR("0118", "交易日期格式错误"), 
	ITM_ERR_SENDER_ERR("0119", "发起方格式错误"), 
	ITM_ERR_RECEIVER_ERR("0120", "接收方格式错误"), 
	ITM_ERR_MSGSENDID_ERR("0121", "通信标识号格式错误"),
	ITM_ERR_COMPRESSMODE_ERR("0122", "压缩模式格式错误"),
	ITM_ERR_RESERVE_ERR("0123", "预留字段格式错误"),
	/**
	 * 错误信息
	 */
	ITM_ERR_MSG_MOBILEPHONE("0200", "手机号码格式错误"), //
	ITM_ERR_MSG_CHNAME("0201", "客户中文姓名格式错误"), //
	ITM_ERR_MSG_ENNAME("0202", "客户英文姓名格式错误"), //
	ITM_ERR_MSG_CERT_TYPE("0203", "客户证件类型格式错误"), //
	ITM_ERR_MSG_CERT_NO("0204", "客户证件格式错误或者客户未满18岁"), //
	ITM_ERR_MSG_ADDR("0205", "地址格式错误"), //
	ITM_ERR_MSG_POSTCODE("0206", "邮政编码格式错误"), //
	ITM_ERR_MSG_PHONE("0207", "固定电话格式错误"), //
	ITM_ERR_MSG_SEX("0208", "性别格式错误"), //
	ITM_ERR_MSG_BIRTHDAY("0209", "生日格式错误"), //
	ITM_ERR_MSG_NATION("0210", "国籍格式错误"), //
	ITM_ERR_MSG_OCCU("0211", "职业格式错误"), //
	ITM_ERR_MSG_FIELD("0212", "备注格式错误"), //
	ITM_ERR_MSG_PROD_TYPE("0213", "产品类型格式错误"), //
	ITM_ERR_MSG_PROD_ID("0214", "产品代码格式错误"), //
	ITM_ERR_MSG_RISKLEVEL("0215", "风险等级格式错误"), //
	ITM_ERR_MSG_FILETYPE("0216", "下载文件类型错误"), //
	ITM_ERR_MSG_FILEDOWNLOAD("0217", "同时只能下载一个产品文件"), //
	ITM_ERR_MSG_EMAIL("0218", "邮件地址校验失败"), //
	ITM_ERR_MSG_SUBPROD_ID("0219", "子产品代码格式错误"), //
	ITM_ERR_MSG_BANKCARD("0220", "银行卡号格式错误"), //
	ITM_ERR_MSG_ORDERNO("0221", "订单号格式错误"), //
	
	ITM_ERR_RECORDID_ERROR("0222", "记录ID格式错误"), //
	ITM_ERR_RECORDID_DUPLICATED("0223", "记录ID重复"), //

	ITM_ERR_ACCT_NO("0224", "账户格式不对"), //
	ITM_ERR_AMOUNT("0225", "申购金额不对"), //
	ITM_ERR_FEE("0226", "手续费不对"), //
	ITM_ERR_CUSTID("0227", "客户号不正确"), //
	
	ITM_ERR_FILEEXIST("0228", "文件不存在"), //
	ITM_ERR_STTLAMT("0229", "结算金额不对"),
	ITM_ERR_CURRENCY("0230", "币种格式不对"),
	ITM_ERR_PRODUCTSHARE("0231", "产品份额格式不对"),
	
	ITM_ERR_PRODNOTMCHANT("0232","产品不属于该商户或者产品状态不对"),
	ITM_ERR_MCHANTNONEXISTENTPROD("0233","该商户下不存在可用的产品"),
	ITM_ERR_COUNT_ERR("0234","数量必须为小于100的正整数"),
	ITM_ERR_PAGE_ERR("0235","页码格式有误"),
	
	ITM_ERR_ZR_AMT_ERROR("0236","转让金额错误"),
	ITM_ERR_ZR_ENDDATE_ERROR("0237","转让截止日期错误"),
	ITM_ERR_PPROVIDERID_ERR("0238","产品商户号格式错误"),
	ITM_ERR_OPENFLAG_ERR("0239","开放标识不对"),
	ITM_ERR_NAVDATENOTFOUND_ERR("0240","净值日期的记录不存在"),
	ITM_ERR_NAVDATE_ERR("0241","净值日期格式错误"),
	ITM_ERR_SETTLDATE("0242", "结算日期格式错误"), //
	
	ITM_ERR_USER_DIGITAL_NOT_OPEN("0243", "用户未开户"), //
	ITM_ERR_USER_PROD_NOT_OPEN("0244", "用户未开通"), //
	ITM_ERR_PRODUCTTYPE("0245","产品类型格式错误"),//
	ITM_ERR_0299_MSG_UNKNOW("0299", "消息格式失败"), //
	
	ITM_ERR_PROD_NOT_EXISTS("0300","产品不存在"),
	ITM_ERR_PROD_ALREADY_EXISTS("0301","产品信息已存在"),
	ITM_ERR_PROD_TYPE_NOT_EXSITS("0302","产品类型不存在"),
	ITM_ERR_PROD_STATUS_ERROR("0303","产品状态不正常"),

	ITM_ERR_PROD_NAME("0304","产品名称格式错误"),
	ITM_ERR_PROD_RISKLEVEL("0305","产品风险格式错误"),
	ITM_ERR_PROD_PRODUCTSTATUS("0306","产品状态格式错误"),
	ITM_ERR_PROD_PRODUCTTAGS("0307","产品关键字格式错误"),
	ITM_ERR_PROD_PRODUCTTITLE("0308","产品概述格式错误"),
	ITM_ERR_PROD_PRODUCTURL("0309","产品宣传地址格式错误"),

	//OFAG
	ITM_ERR_PROD_INVAMTUNIT("0310","投资单位不正确"),
	ITM_ERR_PROD_INVAMTMIN("0311","最低投资金额不正确"),
	ITM_ERR_PROD_INVAMTMAX("0312","最大投资金额不正确"),
	//CFAG
	ITM_ERR_PROD_FNCDAYS("0313","投资期限不正确"),
	ITM_ERR_PROD_FNCBEGIN("0314","起息日期不正确"),
	ITM_ERR_PROD_FNCENDS("0315","到期日期不正确"),
	ITM_ERR_PROD_ANNUALIZEDRATE("0316","本期年化收益率不正确"),
	ITM_ERR_PROD_ERNPAYTYPE("0317","收益方式不正确"),
	ITM_ERR_PROD_FNCTOTALAMT("0318","投资总额不正确"),
	ITM_ERR_PROD_FNCREMAINDERAMT("0319","剩余可投资总额度不正确"),
	ITM_ERR_PROD_PROGRESSRATE("0320","完成进度不正确"),
	ITM_ERR_PROD_INVENDTIME("0321","投资截至时间不正确"),
	ITM_ERR_PROD_INVCANRET("0322","认购期是否可赎回不正确"),
	ITM_ERR_PROD_INVCANSELL("0323","到期前是否可转让不正确"),
	ITM_ERR_PROD_INVHOLDMINDAYS("0324","可转让最少持有期限不正确"),
	ITM_ERR_PROD_STTLDATE("0325","本期结算日期不正确"),
	ITM_ERR_PROD_PRINCIPAL("0326","本期本金不正确"),
	ITM_ERR_PROD_INTEREST("0327","本期利息不正确"),
	ITM_ERR_PROD_ERNPAYDATE("0328","本期收益发放日期不正确"),
	//FUND
	ITM_ERR_PROD_FUNDMNGRID("0329","基金公司代码不正确"),
	ITM_ERR_PROD_FUNDID("0330","基金代码不正确"),
	ITM_ERR_PROD_FUNDNAME("0331","基金名称不正确"),
	ITM_ERR_PROD_FUNDTYPE("0332","基金类型不正确"),
	ITM_ERR_PROD_INVBEGINTIME("0333","发行期开始时间不正确"),
	ITM_ERR_PROD_SUBSCRIBEFEERATE("0334","认购费率不正确"),
	ITM_ERR_PROD_PURCHASEFEERATE("0335","申购费率不正确"),
	ITM_ERR_PROD_MANAGEFEERATE("0336","管理费率不正确"),
	ITM_ERR_PROD_DEPOSITFEERATE("0337","托管费率不正确"),
	ITM_ERR_PROD_M1INVRATE("0338","最近一月收益率不正确"),
	ITM_ERR_PROD_REDEEMFEERATE("0339","赎回费率不正确"),
	//FNLN

	ITM_ERR_PROD_NAVDATE("0340","净值日期不正确"),
	ITM_ERR_PROD_DAYSERN("0341","净值日每万份净值收益不正确"),
	ITM_ERR_PROD_CLSBEGINTIME("0342","封闭期开始时间不正确"),
	ITM_ERR_PROD_CLSENDTIME("0343","封闭期结束时间不正确"),
	ITM_ERR_PROD_SALESFEERATE("0344","销售服务费率不正确"),
	ITM_ERR_PROD_M3ERNRATE("0345","最近三月收益率不正确"),
	ITM_ERR_PROD_NAVAMT("0346","当前净值金额不正确"),
	ITM_ERR_PROD_HTNAVAMT("0347","历史累计净值金额不正确"),
	ITM_ERR_PROD_PRESENTANNUALIZEDRATE("0348","本期年化收益率不正确"),
	ITM_ERR_PROD_DEBTOR("0349","借款人名称不正确"),
	ITM_ERR_PROD_GUARANTOR("0350","担保人名称不正确"),
	
	ITM_ERR_PROD_NOT_BELONG_MCH("0351","产品不属于该商户"),
	
	ITM_ERR_PROD_BALANCE_NOT_EMPTY("0352","产品余额不为零"),
	
	ITM_ERR_PROD_FUNDMNGRNAME("0353","基金公司名称格式不正确"), 
	
	ITM_ERR_PROD_Y1ERNRATE("0354","最近一年收益率不正确"),
	ITM_ERR_PROD_HTERNRATE("0355","历史累积收益率不正确"),
	ITM_ERR_PROD_PROD_FLAG_N("0356","该商户没有产品上架权限"),
	ITM_ERR_PROD_RESELLMAXRATE("0357","转让收益上限比率格式不正确"),
	ITM_ERR_PROD_RESELLMINRATE("0358","转让收益下限比率格式不正确"),
	ITM_ERR_PROD_RESELLMAXDAY("0359","转让期限上限格式不正确"),
	ITM_ERR_PROD_RESELLMINDAY("0360","转让期限下限格式不正确"),
	ITM_ERR_PROD_ERNPAYCYCLE("0361","收益分配周期格式不正确"),
	ITM_ERR_ZR_SYAMT_ERROR("0362","转让收益错"),
	ITM_ERR_ZR_YQRESELLRATE_ERROR("0363","预期收益率格式错"),
	
	//MSCS.901
	ITM_ERR_COMMINFO_LEN("0920","字段长度非法"),
	ITM_INF_COMMINFO_RECVOK("0901","待确认"),
	ITM_INF_COMMINFO_PROCOK("0902","已确认"),	
	
	ITM_ERR_WAITING_TIMEOUT("0996", "等待超时"),
	ITM_ERR_SIGN("0997", "内部签名错误"), //
	ITM_ERR_CHANNELINF_UNKNOW("0998", "内部渠道错误"), //
	ITM_ERR_0999_PROC_UNKNOW("0999", "内部错误"), //
	ITM_UNKNOW("0099", "未知错误");

	@Getter
	String returncode;

	@Getter
	String desc;

	public String toString() {
		return "ITradeMessage[" + returncode + "," + desc + "]";
	}
}
