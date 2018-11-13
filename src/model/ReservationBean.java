package model;

import java.io.Serializable;

public class ReservationBean implements Serializable{

	private int room_id;			//1
	private String day;				//2
	private int room_name;			//3
	private int lecture;

	public ReservationBean(){

	}

	public ReservationBean(int room_id, String day, int room_name, int lecture) {
		super();
		this.room_id = room_id;
		this.day = day;
		this.room_name = room_name;
		this.lecture = lecture;
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

	public int getRoom_name() {
		return room_name;
	}

	public void setRoom_name(int room_name) {
		this.room_name = room_name;
	}

	public int getLecture(){
		return lecture;
	}

	public void setLecture(int lecture){
		this.lecture = lecture;
	}
}
