package model;

import java.io.Serializable;

public class KyBean implements Serializable {
	
	
    private static final long serialVersionUID = 1L;

    private int Ky_id;
    private String Ky_name; 
	public KyBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public KyBean(int id,String Kyn){
		setKy_id(id);
		setKy_name(Kyn);
	}
	public int getKy_id() {
		return Ky_id;
	}
	public void setKy_id(int ky_id) {
		Ky_id = ky_id;
	}
	public String getKy_name() {
		return Ky_name;
	}
	public void setKy_name(String ky_name) {
		Ky_name = ky_name;
	}
	

}
