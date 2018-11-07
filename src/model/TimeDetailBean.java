package model;

import java.io.Serializable;

public class TimeDetailBean implements Serializable{

	public TimeDetailBean(){

	}

	private int time_id;				//1
	private String day;					//2
	private int one_subject_id;			//3
	private String one_subject_name;	//4
	private int one_room_id;			//5
	private String one_room_name;		//6
	private int two_subject_id;			//7
	private String two_subject_name;	//8
	private int two_room_id;			//9
	private String two_room_name;		//10
	private int three_subject_id;		//11
	private String three_subject_name;	//12
	private int three_room_id;			//13
	private String three_room_name;		//14
	private int four_subject_id;		//15
	private String four_subject_name;	//16
	private int four_room_id;			//17
	private String four_room_name;		//18

	public TimeDetailBean(
			int time_id, String day,
			int one_subject_id, String one_subject_name, int one_room_id,String one_room_name,
			int two_subject_id, String two_subject_name, int two_room_id, String two_room_name,
			int three_subject_id, String three_subject_name, int three_room_id, String three_room_name,
			int four_subject_id, String four_subject_name, int four_room_id, String four_room_name) {

		super();
		this.time_id = time_id;
		this.day = day;
		this.one_subject_id = one_subject_id;
		this.one_subject_name = one_subject_name;
		this.one_room_id = one_room_id;
		this.one_room_name = one_room_name;
		this.two_subject_id = two_subject_id;
		this.two_subject_name = two_subject_name;
		this.two_room_id = two_room_id;
		this.two_room_name = two_room_name;
		this.three_subject_id = three_subject_id;
		this.three_subject_name = three_subject_name;
		this.three_room_id = three_room_id;
		this.three_room_name = three_room_name;
		this.four_subject_id = four_subject_id;
		this.four_subject_name = four_subject_name;
		this.four_room_id = four_room_id;
		this.four_room_name = four_room_name;
	}

	public int getTime_id() {
		return time_id;
	}

	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getOne_subject_id() {
		return one_subject_id;
	}

	public void setOne_subject_id(int one_subject_id) {
		this.one_subject_id = one_subject_id;
	}

	public String getOne_subject_name() {
		return one_subject_name;
	}

	public void setOne_subject_name(String one_subject_name) {
		this.one_subject_name = one_subject_name;
	}

	public int getOne_room_id() {
		return one_room_id;
	}

	public void setOne_room_id(int one_room_id) {
		this.one_room_id = one_room_id;
	}

	public String getOne_room_name() {
		return one_room_name;
	}

	public void setOne_room_name(String one_room_name) {
		this.one_room_name = one_room_name;
	}

	public int getTwo_subject_id() {
		return two_subject_id;
	}

	public void setTwo_subject_id(int two_subject_id) {
		this.two_subject_id = two_subject_id;
	}

	public String getTwo_subject_name() {
		return two_subject_name;
	}

	public void setTwo_subject_name(String two_subject_name) {
		this.two_subject_name = two_subject_name;
	}

	public int getTwo_room_id() {
		return two_room_id;
	}

	public void setTwo_room_id(int two_room_id) {
		this.two_room_id = two_room_id;
	}

	public String getTwo_room_name() {
		return two_room_name;
	}

	public void setTwo_room_name(String two_room_name) {
		this.two_room_name = two_room_name;
	}

	public int getThree_subject_id() {
		return three_subject_id;
	}

	public void setThree_subject_id(int three_subject_id) {
		this.three_subject_id = three_subject_id;
	}

	public String getThree_subject_name() {
		return three_subject_name;
	}

	public void setThree_subject_name(String three_subject_name) {
		this.three_subject_name = three_subject_name;
	}

	public int getThree_room_id() {
		return three_room_id;
	}

	public void setThree_room_id(int three_room_id) {
		this.three_room_id = three_room_id;
	}

	public String getThree_room_name() {
		return three_room_name;
	}

	public void setThree_room_name(String three_room_name) {
		this.three_room_name = three_room_name;
	}

	public int getFour_subject_id() {
		return four_subject_id;
	}

	public void setFour_subject_id(int four_subject_id) {
		this.four_subject_id = four_subject_id;
	}

	public String getFour_subject_name() {
		return four_subject_name;
	}

	public void setFour_subject_name(String four_subject_name) {
		this.four_subject_name = four_subject_name;
	}

	public int getFour_room_id() {
		return four_room_id;
	}

	public void setFour_room_id(int four_room_id) {
		this.four_room_id = four_room_id;
	}

	public String getFour_room_name() {
		return four_room_name;
	}

	public void setFour_room_name(String four_room_name) {
		this.four_room_name = four_room_name;
	}



}
