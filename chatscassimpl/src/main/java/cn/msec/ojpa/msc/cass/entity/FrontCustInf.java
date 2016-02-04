package cn.msec.ojpa.msc.cass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import cn.msec.ojpa.api.annotations.Tab;
import cn.msec.ojpa.cass.enums.KeyColumn;
import cn.msec.ojpa.cass.enums.KeyPart;

@Tab(name = "frontcustinf")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class FrontCustInf {
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
	private String innerCustId;

	private String certNo;
	private String custChName;
	private String custEnName;
	private String certType;
	private String brithday;
	private String natio;
	private String sex;
	private String checkFlag;
	private String status;
	private String remark;

}