package onight.mgame.chats.cass.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class RoomMessage {
	
	private String msg_id;
	
	private String room_id;

	private String from_u;

//	private String to_u;

	private String msg;

	private long insert_timems=System.currentTimeMillis();


	private boolean readed = false;
	
	String audit_user;// 审批员
	String audit_timems;// 审批时间

}