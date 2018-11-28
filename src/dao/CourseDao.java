package dao;

import java.util.ArrayList;

import model.CourseBean;

public class CourseDao extends DaoBase{

	public CourseDao(){

	}

	//学科全取得
	public ArrayList<CourseBean> AllSelectCourse(){

		ArrayList<CourseBean> courseArray = new ArrayList<CourseBean>();

		try {
			super.connection();

			String sql = "SELECT * FROM course";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				CourseBean coursebean = new CourseBean();
				coursebean.setCourse_id(rs.getInt(1));
				coursebean.setCourse_name(rs.getString(2));

				if(!(coursebean.getCourse_name().equals("教務員"))){
					courseArray.add(coursebean);
				}
			}
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
		return courseArray;
	}
	
	//学科全取得
	public ArrayList<CourseBean> managementAllSelectCourse(){

		ArrayList<CourseBean> courseArray = new ArrayList<CourseBean>();

		try {
			super.connection();

			String sql = "SELECT * FROM course";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				CourseBean coursebean = new CourseBean();
				coursebean.setCourse_id(rs.getInt(1));
				coursebean.setCourse_name(rs.getString(2));
				courseArray.add(coursebean);
			}
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
		return courseArray;
	}

	//学科名取得
	public String selectCourseName(int courseId){

		String courseName = null;

		try {
			super.connection();

			String sql = "SELECT course_name FROM course where course_id = ?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1,courseId);

			rs = stmt.executeQuery();
			rs.next();

			courseName = rs.getString(1);

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

		return courseName;

	}

	//学科名追加
	public void courseAdd(String name) {
		try {

			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String sql = "insert into course(course_name) values(?)";

			stmt = con.prepareStatement(sql);

			// SQLの？に値のセット
			stmt.setString(1, name);
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
	//学科名変更
	public void courseChange(String name,int course_id) {
		try {

			// connection確立
			super.connection();

			//sql
	     	 String sql = "update `course` SET course_name= ? where course_id= ?";

	     	 stmt = con.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.setInt(2,course_id);
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
	//学科名削除
	public void courseDelete(int course_id){
		try {
			super.connection();

			String sql = "delete from course where course_id=?;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, course_id);
			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	//学科名取得
	public CourseBean selectCourse(int courseId){

		CourseBean coursebean = new CourseBean();

		try {
			super.connection();

			String sql = "SELECT * FROM course where course_id = ?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1,courseId);

			rs = stmt.executeQuery();
			rs.next();

			coursebean.setCourse_id(rs.getInt(1));
			coursebean.setCourse_name(rs.getString(2));

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

		return coursebean;

	}

}
