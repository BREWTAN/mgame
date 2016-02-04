package onight.mgame.chats.cass.entity;

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

	String insert_timems = String.valueOf(System.currentTimeMillis());// 创建时间

	private boolean readed = false;
	
	String audit_user;// 审批员
	String audit_timems;// 审批时间

}