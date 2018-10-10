package dao;

public class CourseDao extends DaoBase{
	
	public CourseDao(){
		
	}
	
	//学科名取得
	public String selectCourseName(String courseId){
		
		String courseName = null;
		
		try {
			super.connection();
			
			String sql = "SELECT course_name FROM course where course_id = ?";
			stmt = con.prepareStatement(sql);

			stmt.setString(1,courseId);

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
