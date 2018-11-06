package model;

import java.util.ArrayList;

public class SubjectInfoBean {

	public SubjectInfoBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	private ArrayList<SubjectBean> Subject_MoreBean = new ArrayList<SubjectBean>();

	private static final long serialVersionUID = 1L;
	public ArrayList<SubjectBean> getSubjectArray() {
		return Subject_MoreBean;
		}
	public void setSubjectArray(ArrayList<SubjectBean> Subject_MoreBean) {
		this.Subject_MoreBean = Subject_MoreBean;
		}
	public void addSubject(SubjectBean obj){
		Subject_MoreBean.add(obj);
		}
	public int getArraySize(){
		return Subject_MoreBean.size();
	}
}
