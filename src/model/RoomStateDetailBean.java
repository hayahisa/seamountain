package model;

import java.io.Serializable;

public class RoomStateDetailBean implements Serializable{

	private int room_id;
	private String day;
	private int one_room_state_id;
	private int two_room_state_id;
	private int three_room_state_id;
	private int four_room_state_id;

	public RoomStateDetailBean(){

	}

	public RoomStateDetailBean(int room_id, String day, int one_room_state_id, int two_room_state_id,
			int three_room_state_id, int four_room_state_id) {
		super();
		this.room_id = room_id;
		this.day = day;
		this.one_room_state_id = one_room_state_id;
		this.two_room_state_id = two_room_state_id;
		this.three_room_state_id = three_room_state_id;
		this.four_room_state_id = four_room_state_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getOne_room_state_id() {
		return one_room_state_id;
	}

	public void setOne_room_state_id(int one_room_state_id) {
		this.one_room_state_id = one_room_state_id;
	}

	public int getTwo_room_state_id() {
		return two_room_state_id;
	}

	public void setTwo_room_state_id(int two_room_state_id) {
		this.two_room_state_id = two_room_state_id;
	}

	public int getThree_room_state_id() {
		return three_room_state_id;
	}

	public void setThree_room_state_id(int three_room_state_id) {
		this.three_room_state_id = three_room_state_id;
	}

	public int getFour_room_state_id() {
		return four_room_state_id;
	}

	public void setFour_room_state_id(int four_room_state_id) {
		this.four_room_state_id = four_room_state_id;
	}

}
