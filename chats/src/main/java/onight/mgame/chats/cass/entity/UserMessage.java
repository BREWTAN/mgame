package onight.mgame.chats.cass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class UserMessage {

	private String to_u;

//	@KeyColumn(keyPart = KeyPart.CLUSTERING, ordinal = 2, ordering = Ordering.DESCENDING)
	private long insert_timems=System.currentTimeMillis();

	private String msg_id;

	private String from_u;

	private String msg;

	private boolean readed = false;

	String audit_user;// 审批员
	String audit_timems;// 审批时间

}