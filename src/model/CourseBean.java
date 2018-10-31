package model;

import java.io.Serializable;

public class CourseBean implements Serializable {

	public CourseBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	private int course_id;
	private String Course_name;
	
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return Course_name;
	}
	public void setCourse_name(String course_name) {
		Course_name = course_name;
	}
	

}
