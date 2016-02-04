package cn.msec.ojpa.msc.cass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import cn.msec.ojpa.api.annotations.Tab;
import cn.msec.ojpa.cass.enums.KeyColumn;
import cn.msec.ojpa.cass.enums.KeyPart;

@Tab(name = "frontuserprodInf")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class FrontUserProdInf {
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
	private String id;

	@KeyColumn(keyPart = KeyPart.CLUSTERING, ordinal = 2)
	private String userId;

	private String digAcctNo;

	@KeyColumn(keyPart = KeyPart.CLUSTERING, ordinal = 3)
	private String mchntId;
	private String mchntRecordId;
	private String prodRecordId;
	private String custId;
	private String transType;
	private String prodType;
	private String prodId;
	private String openProdChannel;
	private String status;
	private String field2;

}