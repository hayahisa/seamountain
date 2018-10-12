package model;

import java.io.Serializable;

public class TimeTableBean implements Serializable {
	//時間割の表示に使用

	private int time_id;				//時間割ID
	private String time_name;			//時間割名
	private String day;					//曜日
	private String one_room_name;		//１限目教室名
	private String one_subject_name;	//１限目教科名
	private String two_room_name;		//2限目教室名
	private String two_subject_name;	//2限目教科名
	private String three_room_name;		//3限目教室名
	private String three_subject_name;	//3限目教科名
	private String four_room_name;		//4限目教室名
	private String four_subject_name;	//4限目教科名

	public TimeTableBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public TimeTableBean(int time_id, String time_name, String day,String one_room_name, String one_subject_name,
			String two_room_name, String two_subject_name, String three_room_name, String three_subject_name,
			String four_room_name, String four_subject_name) {
		super();
		//10項目
		this.time_id = time_id;
		this.time_name = time_name;
		this.day = day;
		this.one_room_name = one_room_name;
		this.one_subject_name = one_subject_name;
		this.two_room_name = two_room_name;
		this.two_subject_name = two_subject_name;
		this.three_room_name = three_room_name;
		this.three_subject_name = three_subject_name;
		this.four_room_name = four_room_name;
		this.four_subject_name = four_subject_name;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getOne_room_name() {
		return one_room_name;
	}

	public void setOne_room_name(String one_room_name) {
		this.one_room_name = one_room_name;
	}

	public String getOne_subject_name() {
		return one_subject_name;
	}

	public void setOne_subject_name(String one_subject_name) {
		this.one_subject_name = one_subject_name;
	}

	public String getTwo_room_name() {
		return two_room_name;
	}

	public void setTwo_room_name(String two_room_name) {
		this.two_room_name = two_room_name;
	}

	public String getTwo_subject_name() {
		return two_subject_name;
	}

	public void setTwo_subject_name(String two_subject_name) {
		this.two_subject_name = two_subject_name;
	}

	public String getThree_room_name() {
		return three_room_name;
	}

	public void setThree_room_name(String three_room_name) {
		this.three_room_name = three_room_name;
	}

	public String getThree_subject_name() {
		return three_subject_name;
	}

	public void setThree_subject_name(String three_subject_name) {
		this.three_subject_name = three_subject_name;
	}

	public String getFour_room_name() {
		return four_room_name;
	}

	public void setFour_room_name(String four_room_name) {
		this.four_room_name = four_room_name;
	}

	public String getFour_subject_name() {
		return four_subject_name;
	}

	public void setFour_subject_name(String four_subject_name) {
		this.four_subject_name = four_subject_name;
	}

}
