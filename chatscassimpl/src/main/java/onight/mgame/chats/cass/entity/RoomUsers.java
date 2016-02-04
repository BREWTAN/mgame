package onight.mgame.chats.cass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import onight.tfw.cass.enums.Indexed;
import onight.tfw.cass.enums.KeyColumn;
import onight.tfw.cass.enums.KeyPart;
import onight.tfw.cass.enums.Table;

@Table(name = "roomusers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class RoomUsers {
	
	
	private String user_role="N";

	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
	private String user_id;
	
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 2)
	private String room_id;
	
	private String user_name;

	boolean is_muted=false;
	boolean is_blocked=false;
	
	
	String op_timems;// 创建时间
	String op_user;// 创建者

	String audit_user;// 审批员
	String audit_timems;// 审批时间

}