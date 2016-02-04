package cn.msec.ojpa.msc.cass.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import cn.msec.ojpa.api.annotations.Tab;
import cn.msec.ojpa.cass.enums.KeyColumn;
import cn.msec.ojpa.cass.enums.KeyPart;

@Tab(name = "trans201")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Trans201  {
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
    private String id;

	private String mchntId;
	private String custId;
	private String mchntRecordId;
	private String prodRecordId;
	private String transType;
	private BigDecimal transAmt;
	private BigDecimal feeAmt;
	private String digAcctNo;
	private Date transReqDate;
	private Date transRspDate;
	private String certNo;
	private String certType;
	private String settleDate;
	private String status;
	private String prodType;
	private String prodId;
	private String outProdId;
	private String outSubProdId;
	private String retMsg;
	private String mchChannelId;
	private String field1;

}