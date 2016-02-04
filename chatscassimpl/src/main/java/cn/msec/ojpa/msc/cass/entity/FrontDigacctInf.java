package cn.msec.ojpa.msc.cass.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import cn.msec.ojpa.api.annotations.Tab;
import cn.msec.ojpa.cass.enums.KeyColumn;
import cn.msec.ojpa.cass.enums.KeyPart;

@Tab(name = "frontdigacctinf")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class FrontDigacctInf {
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
	private String id;

	private String userId;
	private String mchntRecordId;
	private String prodRecordId;
	private String custId;
	private Date transReqTime;
	private String status;
	private String acState;
	private String digAcctNo;
	private String digAcctName;
	private String openDate;
	private String openChannel;
	private String remark;

}