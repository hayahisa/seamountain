package model;

import java.io.Serializable;

public class PasswordBean implements Serializable {
	
	private String userNo;
	private String password;
	private String komePass;
	
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

	public String getKomePass() {
		return komePass;
	}

	public void setKomePass(String komePass) {
		this.komePass = komePass;
	}
	
}
