package model;

import java.io.Serializable;

public class UserBean implements Serializable {

	private String userNo;
	private String courseId;
	private String courseName;
	private String timeId;
	private String userName;
	private String mail;
	private int userYear;
	private String roleFlg;

	public UserBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public UserBean(String string, String string2, String string3, String string4, String string5, int int1,
			String string6, String string7) {
		this.userNo = string;
		this.courseId = string2;
		this.timeId = string3;
		this.userName = string4;
		this.mail = string5;
		this.userYear = int1;
		this.roleFlg = string6;

	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTimeId() {
		return timeId;
	}

	public void setTimeId(String timeId) {
		this.timeId = timeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getUserYear() {
		return userYear;
	}

	public void setUserYear(int userYear) {
		this.userYear = userYear;
	}

	public String getRoleFlg() {
		return roleFlg;
	}

	public void setRoleFlg(String roleFlg) {
		this.roleFlg = roleFlg;
	}

}
