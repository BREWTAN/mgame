package onight.mgame.chats.cass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RoomUsers {

	private String user_role;

	private String user_id;
	
	private String room_id;
	
	private String user_name;

	String op_timems;// 创建时间
	String op_user_id;// 创建者

	String audit_user;// 审批员
	String audit_timems;// 审批时间
	boolean is_muted=false;
	boolean is_blocked=false;
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getOp_timems() {
		return op_timems;
	}
	public void setOp_timems(String op_timems) {
		this.op_timems = op_timems;
	}
	public String getOp_user_id() {
		return op_user_id;
	}
	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}
	public String getAudit_user() {
		return audit_user;
	}
	public void setAudit_user(String audit_user) {
		this.audit_user = audit_user;
	}
	public String getAudit_timems() {
		return audit_timems;
	}
	public void setAudit_timems(String audit_timems) {
		this.audit_timems = audit_timems;
	}
	public boolean isIs_muted() {
		return is_muted;
	}
	public void setIs_muted(boolean is_muted) {
		this.is_muted = is_muted;
	}
	public boolean isIs_blocked() {
		return is_blocked;
	}
	public void setIs_blocked(boolean is_blocked) {
		this.is_blocked = is_blocked;
	}
	
	
	
}