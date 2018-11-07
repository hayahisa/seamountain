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

}
