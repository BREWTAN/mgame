package onight.mgame.chats.cass.counter;

import lombok.Data;


public @Data class RoomCounters {

	private String room_id;
	
	private long usernum;
	private long blocknum;
	private long onlinenum;

}
