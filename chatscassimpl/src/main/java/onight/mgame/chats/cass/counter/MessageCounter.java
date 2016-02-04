package onight.mgame.chats.cass.counter;

import lombok.Data;
import onight.tfw.cass.enums.Counter;
import onight.tfw.cass.enums.Id;
import onight.tfw.cass.enums.Table;

@Table(name = "messagecounter")
public @Data class MessageCounter {

	@Id
	private String key;
	@Counter
	private long successnum;
	@Counter
	private long faildnum;
	@Counter
	private long ordernos;
	@Counter
	private long totalnum;

}
