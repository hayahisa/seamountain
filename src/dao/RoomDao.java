package dao;

import java.util.ArrayList;

import model.RoomBean;

public class RoomDao extends DaoBase {

	public RoomDao(){

	}

	//教室一覧
	public ArrayList<RoomBean> roomList(){
		ArrayList<RoomBean> roomArray = new ArrayList<>();
		try{
			super.connection();
			String sql = "SELECT r.room_id,r.room_name,ks.ky_state_name "
					+ "FROM (room r "
					+ "INNER JOIN ky k "
					+ "ON r.ky_id = k.ky_id) "
					+ "INNER JOIN ky_state ks "
					+ "ON k.ky_state_id = ks.ky_state_id;";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			rs.next();
			while(rs.next()){
				RoomBean roomlistbean = new RoomBean(rs.getString(1),rs.getString(2),rs.getString(3));
				roomArray.add(roomlistbean);
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
		return roomArray;
	}

}
