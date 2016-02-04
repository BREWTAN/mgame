package onight.mgame.chats.cass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import onight.tfw.cass.enums.KeyColumn;
import onight.tfw.cass.enums.KeyPart;
import onight.tfw.cass.enums.Table;

@Table(name = "roomblocks")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class RoomBlocks {
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
	private String room_id;

	@KeyColumn(keyPart = KeyPart.CLUSTERING, ordinal = 2)
	private String buser_id;

	String add_timems;// 创建时间
	String add_user;// 创建者

	String audit_user;// 审批员
	String audit_timems;// 审批时间

}