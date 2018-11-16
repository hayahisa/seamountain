package model;

import java.io.Serializable;

public class ReservationBean implements Serializable{

	private int room_state_id;
	private int room_id;
	private String room_name;
	private String day;
	private int lecture;
	private String resDate;


	public ReservationBean(){

	}

	public ReservationBean(int room_state_id, int room_id, String room_name, String day, int lecture, String resDate) {
		super();
		this.room_state_id = room_state_id;
		this.room_id = room_id;
		this.room_name = room_name;
		this.day = day;
		this.lecture = lecture;
		this.resDate = resDate;
	}

	public int getRoom_state_id() {
		return room_state_id;
	}

	public void setRoom_state_id(int room_state_id) {
		this.room_state_id = room_state_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getLecture() {
		return lecture;
	}

	public void setLecture(int lecture) {
		this.lecture = lecture;
	}

	public String getResDate(){
		return resDate;
	}

	public void setResDate(String resDate){
		this.resDate = resDate;
	}

}
