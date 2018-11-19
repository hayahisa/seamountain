package model;

import java.io.Serializable;

public class SubjectBean implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private int sub_id;
    private String sub_name; 

	public SubjectBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public SubjectBean(int sub_id,String sub_name) {
		setSub_id(sub_id);
		setSub_name(sub_name);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	

}
