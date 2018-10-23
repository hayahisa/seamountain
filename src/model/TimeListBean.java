package model;

import java.io.Serializable;

public class TimeListBean implements Serializable{
	//時間割の名前の一覧

	private int time_id;
	private String time_name;

	public TimeListBean(){

	}

	public TimeListBean(int time_id, String time_name) {
		super();
		this.time_id = time_id;
		this.time_name = time_name;
	}

	public int getTime_id() {
		return time_id;
	}

	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}

	public String getTime_name() {
		return time_name;
	}

	public void setTime_name(String time_name) {
		this.time_name = time_name;
	}

}
