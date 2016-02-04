package cn.msec.ojpa.msc.cass.counter;

import lombok.Data;
import cn.msec.ojpa.cass.enums.Counter;
import cn.msec.ojpa.cass.enums.KeyColumn;
import cn.msec.ojpa.cass.enums.KeyPart;
import cn.msec.ojpa.cass.enums.Table;

@Data
@Table(name="messageidcounter")
public class MessageIDCounter {

	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
	String messageid;
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 2)
	String orderno;
	@Counter
	Long vosuccess;
	@Counter
	Long vofailed;
	
	@Counter
	Long rosuccess;
	
	@Counter
	Long rofailed;

}
