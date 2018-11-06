package dao;

import model.SubjectBean;
import model.SubjectInfoBean;
import model.TimeListBean;

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

}
