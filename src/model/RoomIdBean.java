package model;

import java.io.Serializable;

public class RoomIdBean implements Serializable{

	private String day;				//曜日
	private String one_room_id;		//１限目教室ID
	private String two_room_id;		//2限目教室ID
	private String three_room_id;	//3限目教室ID
	private String four_room_id;	//4限目教室ID

	public RoomIdBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public RoomIdBean(String day, String one_room_id, String two_room_id, String three_room_id, String four_room_id) {
		super();
		this.day = day;
		this.one_room_id = one_room_id;
		this.two_room_id = two_room_id;
		this.three_room_id = three_room_id;
		this.four_room_id = four_room_id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getOne_room_id() {
		return one_room_id;
	}

	public void setOne_room_id(String one_room_id) {
		this.one_room_id = one_room_id;
	}

	public String getTwo_room_id() {
		return two_room_id;
	}

	public void setTwo_room_id(String two_room_id) {
		this.two_room_id = two_room_id;
	}

	public String getThree_room_id() {
		return three_room_id;
	}

	public void setThree_room_id(String three_room_id) {
		this.three_room_id = three_room_id;
	}

	public String getFour_room_id() {
		return four_room_id;
	}

	public void setFour_room_id(String four_room_id) {
		this.four_room_id = four_room_id;
	}

}
