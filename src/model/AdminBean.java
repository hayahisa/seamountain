package model;

import java.io.Serializable;

public class AdminBean implements Serializable {

	public AdminBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	private String admin_id;
	private String admin_name;
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	
}
