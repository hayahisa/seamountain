package model;

import java.io.Serializable;

public class PasswordBean implements Serializable {
	
	private String userNo;
	private String password;
	
	public PasswordBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
