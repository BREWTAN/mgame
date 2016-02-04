package onight.mgame.chats.cass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class RoomInfo {
	private String room_id;
	
	private String room_name; 

	String create_timems;// 创建时间
	String create_user;// 创建者

	String audit_user;// 审批员
	String audit_timems;// 审批时间
	int max_user = Integer.MAX_VALUE;// 最大人数

	private String field1;

}