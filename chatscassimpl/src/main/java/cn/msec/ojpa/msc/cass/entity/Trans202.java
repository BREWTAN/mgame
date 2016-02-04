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

@Tab(name = "trans202")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Trans202  {
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
    private String id;
	private String mchntRecordId;
	private String prodRecordId;
	private String transType;
	private BigDecimal transAmt;
	private BigDecimal feeAmt;
	private Date transReqDate;
	private Date transRspDate;
	private String settleDate;
	private String digAcctNo;
	private String status;
	private String mchntId;
	private String custId;
	private String certType;
	private String certNo;
	private String prodType;
	private String prodId;
	private String outProdId;
	private String outSubProdId;
	private String retMsg;
	private String field1;

}