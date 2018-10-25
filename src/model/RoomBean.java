package model;

import java.io.Serializable;

public class RoomBean implements Serializable{

	private String room_id;		//教室ID
	private String room_name;	//教室名
	private String ky_state_name;		//鍵ID

	public RoomBean(){

	}

	public RoomBean(String room_id, String room_name, String ky_state_name) {
		super();
		this.room_id = room_id;
		this.room_name = room_name;
		this.ky_state_name = ky_state_name;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getKy_state_name() {
		return ky_state_name;
	}

	public void setKy_state_name(String ky_state_name) {
		this.ky_state_name = ky_state_name;
	}

}
