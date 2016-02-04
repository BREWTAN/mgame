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

@Tab(name = "frontuserinf")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class FrontUserInf {
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
	private String userId;
	private String mchntId;
	private String status;
	private String custId;
	private BigDecimal transAmt;
	private Date transReqDate;
	private String phone;
	private String telNo;
	private String email;
	private String postCode;
	private String addr;
	private String certType;
	private String certNo;
	private String channelNo;
	private BigDecimal dayljAmt;
	private String field1;
}