package dao;

public class TimeDao extends DaoBase{

	public TimeDao(){

	}

	//時間割一覧
	public void timeList(){
		try{
			super.connection();
			String sql = "SELECT * FROM time;";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			rs.next();
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
//		return
	}

}
