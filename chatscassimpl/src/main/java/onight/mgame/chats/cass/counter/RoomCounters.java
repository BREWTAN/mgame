package onight.mgame.chats.cass.counter;

import lombok.Data;
import onight.tfw.cass.enums.Counter;
import onight.tfw.cass.enums.Id;
import onight.tfw.cass.enums.Table;

@Table(name = "roomcounter")

public @Data class RoomCounters {

	@Id
	private String room_id;
	
	
	@Counter
	private long usernum;
	@Counter
	private long blocknum;
	@Counter
	private long onlinenum;

}
