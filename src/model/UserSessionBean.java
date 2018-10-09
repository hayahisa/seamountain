package model;

public class UserSessionBean {
	private int user_no;
	private int courser_id;
	private int time_id;
	private String user_name;
	private String mail;
	private int user_year;
	private String role_flg;
	private int login_fla;
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getCourser_id() {
		return courser_id;
	}
	public void setCourser_id(int courser_id) {
		this.courser_id = courser_id;
	}
	public int getTime_id() {
		return time_id;
	}
	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getUser_year() {
		return user_year;
	}
	public void setUser_year(int user_year) {
		this.user_year = user_year;
	}
	public String getRole_flg() {
		return role_flg;
	}
	public void setRole_flg(String role_flg) {
		this.role_flg = role_flg;
	}
	public int getLogin_fla() {
		return login_fla;
	}
	public void setLogin_fla(int login_fla) {
		this.login_fla = login_fla;
	}
}
