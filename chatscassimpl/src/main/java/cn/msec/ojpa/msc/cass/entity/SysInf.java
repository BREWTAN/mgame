package cn.msec.ojpa.msc.cass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import cn.msec.ojpa.api.annotations.Tab;
import cn.msec.ojpa.cass.enums.KeyColumn;
import cn.msec.ojpa.cass.enums.KeyPart;

@Tab(name = "sysinfo")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class SysInf  {
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
    private String paramId;
	private String paramType;
	private String paramValue;
	private String dsc;
	private String crtTime;
	private String field1;
	private String field2;
	private String field3;

}