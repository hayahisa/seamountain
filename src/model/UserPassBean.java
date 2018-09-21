package model;

import java.io.Serializable;

public class UserPassBean implements Serializable {

	private int user_no;
	private String user_pass;

	public UserPassBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public UserPassBean(int user_no,String user_pass) {
		this.user_no=user_no;
		this.user_pass=user_pass;
	}

	public int getUser_number() {
		return user_no;
	}

	public void setUser_number(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}


}
