package model;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	private String userNo;
	private String courseId;
	private String timeId;
	private String userName;
	private String mail;
	private int userYear;
	private String roleFlg;
	private String loginFlg;

	public UserBean() {
		// TODO 自動生成されたコンストラクター・スタブ
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

	public String getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(String loginFlg) {
		this.loginFlg = loginFlg;
	}
	
	
}
