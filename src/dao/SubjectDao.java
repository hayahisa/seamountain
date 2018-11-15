package dao;

import model.SubjectBean;
import model.SubjectInfoBean;

public class SubjectDao extends DaoBase{
	public SubjectDao(){

	}
	public SubjectInfoBean getSubject(){
		SubjectInfoBean SIB=new SubjectInfoBean();
		try {
			super.connection();
			String sql = "SELECT * FROM subject;";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				SubjectBean subjectBean = new SubjectBean(rs.getString(1),rs.getString(2));
				SIB.addSubject(subjectBean);
			}
			
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		
		return SIB;
	}
	
	//科目の追加
	public void subjectAdd(String subjectname){
		
		try {
			super.connection();
			String sql = "INSERT INTO subject('subject_name') VALUES(?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, subjectname);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
