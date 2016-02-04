package onight.mgame.chats.cass.counter;

import lombok.Data;
import onight.tfw.cass.enums.Counter;
import onight.tfw.cass.enums.KeyColumn;
import onight.tfw.cass.enums.KeyPart;
import onight.tfw.cass.enums.Table;

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
