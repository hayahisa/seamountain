package model;

import java.io.Serializable;
import java.util.Date;

public class ReservationConfBean implements Serializable{

	private int reservation_no;
	private String user_no;
	private int room_id;
	private Date date;
	private String day;
	private int lecture;

	public ReservationConfBean(){

	}

	public ReservationConfBean(int reservation_no, String user_no, int room_id, Date date, String day, int lecture) {
		super();
		this.reservation_no = reservation_no;
		this.user_no = user_no;
		this.room_id = room_id;
		this.date = date;
		this.day = day;
		this.lecture = lecture;
	}

	public int getReservation_no() {
		return reservation_no;
	}

	public void setReservation_no(int reservation_no) {
		this.reservation_no = reservation_no;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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


}
