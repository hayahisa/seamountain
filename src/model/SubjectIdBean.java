package model;

import java.io.Serializable;

public class SubjectIdBean implements Serializable{

	private String day;					//曜日
	private String one_subject_id;		//１限目教科ID
	private String two_subject_id;		//2限目教科ID
	private String three_subject_id;	//3限目教科ID
	private String four_subject_id;		//4限目教科ID

	public SubjectIdBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public SubjectIdBean(String day, String one_subject_id, String two_subject_id, String three_subject_id,
			String four_subject_id) {
		super();
		this.day = day;
		this.one_subject_id = one_subject_id;
		this.two_subject_id = two_subject_id;
		this.three_subject_id = three_subject_id;
		this.four_subject_id = four_subject_id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getOne_subject_id() {
		return one_subject_id;
	}

	public void setOne_subject_id(String one_subject_id) {
		this.one_subject_id = one_subject_id;
	}

	public String getTwo_subject_id() {
		return two_subject_id;
	}

	public void setTwo_subject_id(String two_subject_id) {
		this.two_subject_id = two_subject_id;
	}

	public String getThree_subject_id() {
		return three_subject_id;
	}

	public void setThree_subject_id(String three_subject_id) {
		this.three_subject_id = three_subject_id;
	}

	public String getFour_subject_id() {
		return four_subject_id;
	}

	public void setFour_subject_id(String four_subject_id) {
		this.four_subject_id = four_subject_id;
	}

}
