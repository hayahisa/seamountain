package dao;

public class TimeChangeDao extends DaoBase{

	public TimeChangeDao(){

	}

	//ユーザーの適用している時間割を変更
	public void timeChange(String userNo, int timeId){
		System.out.println(userNo);
		System.out.println(timeId);
		try{
			super.connection();
			String sql = "UPDATE `user` SET `time_id` = ? "
					+ "WHERE `user_no`  =?;";
			stmt.setInt(1, timeId);
			stmt.setString(2, userNo);
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}
}
