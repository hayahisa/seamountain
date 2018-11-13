package dao;

import java.util.ArrayList;

import model.ReservationBean;

public class ReservationDao extends DaoBase{

	public ReservationDao(){

	}

	public ArrayList<ReservationBean> Reservation(String x_room,int lecture){
		ArrayList<ReservationBean> reservationArray = new ArrayList<>();
		String x_room_id = x_room;	//何限目かを挿入

		try{
			super.connection();
			String sql = "SELECT r.room_id, td.day, r.room_name FROM (time_detail td "
						+ "INNER JOIN time t "
						+ "ON td.time_id = t.time_id) "
						+ "RIGHT OUTER JOIN room r "
						+ "ON r.room_id = td." + x_room_id + " "
						+ "WHERE td.one_room_id IS NULL;";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				ReservationBean reservationbean = new ReservationBean(
						rs.getInt(1),rs.getString(2),rs.getInt(3),lecture
						);
				reservationArray.add(reservationbean);
			}

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// エラー時はclose処理
				super.DbClose();
			} catch (Exception e) {
				System.out.println("error");
			}
		}
		return reservationArray;
	}
}
