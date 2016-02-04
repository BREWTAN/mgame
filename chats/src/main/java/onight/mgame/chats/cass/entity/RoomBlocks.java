package onight.mgame.chats.cass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class RoomBlocks {
	private String room_id;

	private String buser_id;

	String add_timems;// 创建时间
	String add_user;// 创建者

	String audit_user;// 审批员
	String audit_timems;// 审批时间

}