package dao;

public class KyStateDao extends DaoBase{
	public KyStateDao(){

	}

	//鍵の状態取得
	public String getKeyState(String roomId){

		String ky_id = null;
		String ky_state_id=null;

		try {
			System.out.println(roomId+"aaaaaaaaaaa");
			super.connection();
			String sql = "SELECT ky_id FROM room where room_name=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,roomId);
			rs = stmt.executeQuery();
			rs.next();
			System.out.println(ky_id+"qwe");
			ky_id = rs.getString(1);
			System.out.println(ky_id);

		    sql = "SELECT ky_state_id FROM ky where ky_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,ky_id);

			rs = stmt.executeQuery();
			rs.next();
			ky_state_id = rs.getString(1);
			System.out.println(ky_state_id);

		    sql = "SELECT ky_state_name FROM ky_state where ky_state_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,ky_state_id);

			rs = stmt.executeQuery();
			rs.next();
			ky_state_id = rs.getString(1);
			System.out.println(ky_state_id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// エラー時はclose処理
				super.DbClose();
			} catch (Exception e) {
				System.out.println("error");
			}
		}	return ky_state_id;

	}




}
