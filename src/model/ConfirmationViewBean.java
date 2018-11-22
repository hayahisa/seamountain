package model;

import java.io.Serializable;
import java.util.Date;

public class ConfirmationViewBean implements Serializable{

	private int room_id;
	private String room_name;
	private String day;
	private int lecture;
	private Date date;

	public ConfirmationViewBean(){

	}

	public ConfirmationViewBean(int room_id, String room_name, String day, int lecture, Date date) {
		super();
		this.room_id = room_id;
		this.room_name = room_name;
		this.day = day;
		this.lecture = lecture;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}