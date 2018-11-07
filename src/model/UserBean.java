package model;

import java.io.Serializable;

public class UserBean implements Serializable {

	private String userNo;
	private int courseId;
	private int timeId;
	private String userName;
	private String mail;
	private int userYear;
	private String roleFlg;

	public UserBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getTimeId() {
		return timeId;
	}

	public void setTimeId(int timeId) {
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
