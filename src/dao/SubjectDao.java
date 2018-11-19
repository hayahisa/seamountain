package dao;

import java.util.ArrayList;

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
				SubjectBean subjectBean = new SubjectBean(rs.getInt(1),rs.getString(2));
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
			String sql = "INSERT INTO subject(subject_name) VALUES(?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, subjectname);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	//全科目の取得
	public ArrayList<SubjectBean> getSubjectList(){
		
		ArrayList<SubjectBean> subjectArray = new ArrayList<SubjectBean>();
		try {
			super.connection();
			
			String sql = "SELECT * FROM subject";
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				if(!(rs.getString(2).equals("登録されていません"))){
					SubjectBean subjectbean = new SubjectBean();
					subjectbean.setSub_id(rs.getInt(1));
					subjectbean.setSub_name(rs.getString(2));
					subjectArray.add(subjectbean);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				// エラーじはclose処理
				super.DbClose();
			} catch (Exception e) {
				System.out.println("error");
			}
		}
		return subjectArray;
	}
	
	//科目取得
	public SubjectBean getSubject(int subjectid){
		
		SubjectBean subjectbean = new SubjectBean();
		
		try {
			super.connection();
			
			String sql = "SELECT * FROM subject WHERE subject_id = ?";
			
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, subjectid);
			rs = stmt.executeQuery();
			
			rs.next();
			
			System.out.println(rs.getString(2));
			
			subjectbean.setSub_id(rs.getInt(1));
			subjectbean.setSub_name(rs.getString(2));
				
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				// エラーじはclose処理
				super.DbClose();
			} catch (Exception e) {
				System.out.println("error");
			}
		}
		return subjectbean;
	}
	
	//科目の変更
	public void subjectChange(int subjectid,String subjectname){
		
		try {
			super.connection();
			
			String sql = "UPDATE subject SET subject_name = ? WHERE subject_id = ?";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, subjectname);
			stmt.setInt(2, subjectid);
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				// エラーじはclose処理
				super.DbClose();
			} catch (Exception e) {
				System.out.println("error");
			}
		}
	}
	
	//科目の削除
	public void deleteSubject(int subjectid){
		try {
			// connection確立
			super.connection();

			String SQL = "DELETE FROM subject WHERE subject_id = ?";

			stmt = con.prepareStatement(SQL);
			// SQLの？に値のセット
			stmt.setInt(1, subjectid);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// エラー時はclose処理
				super.DbClose();
			} catch (Exception e) {
				System.out.println("error");
			}

		}
	}

}
