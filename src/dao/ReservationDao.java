package dao;

import java.sql.Date;
import java.util.ArrayList;

import model.ReservationBean;

public class ReservationDao extends DaoBase{

	public ReservationDao(){

	}

//	予約を行う(reservation,room_state_detail）
//	reservationへinsert
	public void insertReservation(String user_no, int room_id, Date date, String day, int lecture){
		int num = 0;
		try{
			super.connection();
			String sql = "INSERT INTO `reservation`(`user_no`, `room_id`, `date`, `day`, `lecture`) "
					+ "VALUES (?,?,?,?,?)";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, user_no);
			stmt.setInt(2, room_id);
			stmt.setDate(3, date);
			stmt.setString(4, day);
			stmt.setInt(5, lecture);

			num = stmt.executeUpdate();

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
	}

//	room_state_detailを使って予約検索の処理を行う
//	教室ごとに何曜日の何限目が空いているかを取り出す

//	条件なし,roomId,dayが無し
	public ArrayList<ReservationBean> AllReservation(String x_room, int lecture){
		ArrayList<ReservationBean> reservationArray = new ArrayList<>();
		String x_room_state_id = x_room;	//何限目かを挿入
		String day = null;	//何曜日かを入れる

		try{
			super.connection();
			String sql = "SELECT rs.room_state_id, rs.room_id, r.room_name, rs.day "
					+ "FROM room r INNER JOIN room_state_detail rs "
					+ "ON r.room_id = rs.room_id "
					+ "WHERE rs." + x_room_state_id + " = 1 "
					+ "AND rs.room_id != 1 "
					+ "ORDER BY rs.room_id ASC, "
					+ "CASE rs.day WHEN 'monday' "
					+ "THEN 1 WHEN 'tuesday' "
					+ "THEN 2 WHEN 'wednesday' "
					+ "THEN 3 WHEN 'thursday' "
					+ "THEN 4 WHEN 'friday' "
					+ "THEN 5 ELSE 6 "
					+ "END";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				if(rs.getString(4).equals("monday")){
					day = "月";
				}else if(rs.getString(4).equals("tuesday")){
					day = "火";
				}else if(rs.getString(4).equals("wednesday")){
					day = "水";
				}else if(rs.getString(4).equals("thursday")){
					day = "木";
				}else if(rs.getString(4).equals("friday")){
					day = "金";
				}
				ReservationBean reservationbean = new ReservationBean(
						rs.getInt(1),rs.getInt(2),rs.getString(3),day,lecture
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

	//day,timeIdが無し
	public ArrayList<ReservationBean> dtReservation(String x_room, int lecture,int room_id){
		ArrayList<ReservationBean> reservationArray = new ArrayList<>();
		String x_room_state_id = x_room;	//何限目かを挿入
		String day = null;	//何曜日かを入れる

		try{
			super.connection();
			String sql = "SELECT rs.room_state_id, rs.room_id, r.room_name, rs.day "
					+ "FROM room r INNER JOIN room_state_detail rs "
					+ "ON r.room_id = rs.room_id "
					+ "WHERE rs." + x_room_state_id + " = 1 "
					+ "AND rs.room_id != 1 "
					+ "AND rs.room_id = ? "
					+ "ORDER BY rs.room_id ASC, "
					+ "CASE rs.day WHEN 'monday' "
					+ "THEN 1 WHEN 'tuesday' "
					+ "THEN 2 WHEN 'wednesday' "
					+ "THEN 3 WHEN 'thursday' "
					+ "THEN 4 WHEN 'friday' "
					+ "THEN 5 ELSE 6 "
					+ "END";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, room_id);
			rs = stmt.executeQuery();

			while(rs.next()){
				if(rs.getString(4).equals("monday")){
					day = "月";
				}else if(rs.getString(4).equals("tuesday")){
					day = "火";
				}else if(rs.getString(4).equals("wednesday")){
					day = "水";
				}else if(rs.getString(4).equals("thursday")){
					day = "木";
				}else if(rs.getString(4).equals("friday")){
					day = "金";
				}
				ReservationBean reservationbean = new ReservationBean(
						rs.getInt(1),rs.getInt(2),rs.getString(3),day,lecture
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

	//roomId,timeIdが無し ,roomIdが無し
	public ArrayList<ReservationBean> rtReservation(String x_room, int lecture,String days){
		ArrayList<ReservationBean> reservationArray = new ArrayList<>();
		String x_room_state_id = x_room;	//何限目かを挿入
		String day = null;	//何曜日かを入れる

		try{
			super.connection();
			String sql = "SELECT rs.room_state_id, rs.room_id, r.room_name, rs.day "
					+ "FROM room r INNER JOIN room_state_detail rs "
					+ "ON r.room_id = rs.room_id "
					+ "WHERE rs." + x_room_state_id + " = 1 "
					+ "AND rs.room_id != 1 "
					+ "AND rs.day = ? "
					+ "ORDER BY rs.room_id ASC, "
					+ "CASE rs.day WHEN 'monday' "
					+ "THEN 1 WHEN 'tuesday' "
					+ "THEN 2 WHEN 'wednesday' "
					+ "THEN 3 WHEN 'thursday' "
					+ "THEN 4 WHEN 'friday' "
					+ "THEN 5 ELSE 6 "
					+ "END";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, days);
			rs = stmt.executeQuery();

			while(rs.next()){
				if(rs.getString(4).equals("monday")){
					day = "月";
				}else if(rs.getString(4).equals("tuesday")){
					day = "火";
				}else if(rs.getString(4).equals("wednesday")){
					day = "水";
				}else if(rs.getString(4).equals("thursday")){
					day = "木";
				}else if(rs.getString(4).equals("friday")){
					day = "金";
				}
				ReservationBean reservationbean = new ReservationBean(
						rs.getInt(1),rs.getInt(2),rs.getString(3),day,lecture
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

	//dayが無し
	public ArrayList<ReservationBean> dReservation(String x_room, int lecture, int room_id){
		ArrayList<ReservationBean> reservationArray = new ArrayList<>();
		String x_room_state_id = x_room;	//何限目かを挿入
		String day = null;	//何曜日かを入れる

		try{
			super.connection();
			String sql = "SELECT rs.room_state_id, rs.room_id, r.room_name, rs.day "
				+ "FROM room r INNER JOIN room_state_detail rs "
				+ "ON r.room_id = rs.room_id "
				+ "WHERE rs." + x_room_state_id + " = 1 "
				+ "AND rs.room_id != 1 "
				+ "AND rs.room_id = ? "
				+ "ORDER BY rs.room_id ASC, "
				+ "CASE rs.day WHEN 'monday' "
				+ "THEN 1 WHEN 'tuesday' "
				+ "THEN 2 WHEN 'wednesday' "
				+ "THEN 3 WHEN 'thursday' "
				+ "THEN 4 WHEN 'friday' "
				+ "THEN 5 ELSE 6 "
				+ "END";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, room_id);
			rs = stmt.executeQuery();

			while(rs.next()){
				if(rs.getString(4).equals("monday")){
					day = "月";
				}else if(rs.getString(4).equals("tuesday")){
					day = "火";
				}else if(rs.getString(4).equals("wednesday")){
					day = "水";
				}else if(rs.getString(4).equals("thursday")){
					day = "木";
				}else if(rs.getString(4).equals("friday")){
					day = "金";
				}
				ReservationBean reservationbean = new ReservationBean(
					rs.getInt(1),rs.getInt(2),rs.getString(3),day,lecture
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

	//timeIdが無し
	public ArrayList<ReservationBean> tReservation(String x_room, int lecture, String days, int room_id){
	ArrayList<ReservationBean> reservationArray = new ArrayList<>();
	String x_room_state_id = x_room;	//何限目かを挿入
	String day = null;	//何曜日かを入れる

	try{
		super.connection();
		String sql = "SELECT rs.room_state_id, rs.room_id, r.room_name, rs.day "
				+ "FROM room r INNER JOIN room_state_detail rs "
				+ "ON r.room_id = rs.room_id "
				+ "WHERE rs." + x_room_state_id + " = 1 "
				+ "AND rs.room_id != 1 "
				+ "AND rs.room_id = ? "
				+ "AND rs.day = ? "
				+ "ORDER BY rs.room_id ASC, "
				+ "CASE rs.day WHEN 'monday' "
				+ "THEN 1 WHEN 'tuesday' "
				+ "THEN 2 WHEN 'wednesday' "
				+ "THEN 3 WHEN 'thursday' "
				+ "THEN 4 WHEN 'friday' "
				+ "THEN 5 ELSE 6 "
				+ "END";

		stmt = con.prepareStatement(sql);
		stmt.setInt(1, room_id);
		stmt.setString(2, days);
		rs = stmt.executeQuery();

		while(rs.next()){
			if(rs.getString(4).equals("monday")){
				day = "月";
			}else if(rs.getString(4).equals("tuesday")){
				day = "火";
			}else if(rs.getString(4).equals("wednesday")){
				day = "水";
			}else if(rs.getString(4).equals("thursday")){
				day = "木";
			}else if(rs.getString(4).equals("friday")){
				day = "金";
			}
			ReservationBean reservationbean = new ReservationBean(
					rs.getInt(1),rs.getInt(2),rs.getString(3),day,lecture
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

	//全て選択
	public ArrayList<ReservationBean> Reservation(String x_room, int lecture, String days, int room_id){
		ArrayList<ReservationBean> reservationArray = new ArrayList<>();
		String x_room_state_id = x_room;	//何限目かを挿入
		String day = null;	//何曜日かを入れる

		try{
			super.connection();
			String sql = "SELECT rs.room_state_id, rs.room_id, r.room_name, rs.day "
				+ "FROM room r INNER JOIN room_state_detail rs "
				+ "ON r.room_id = rs.room_id "
				+ "WHERE rs." + x_room_state_id + " = 1 "
				+ "AND rs.room_id != 1 "
				+ "AND rs.room_id = ? "
				+ "AND rs.day = ? "
				+ "ORDER BY rs.room_id ASC, "
				+ "CASE rs.day WHEN 'monday' "
				+ "THEN 1 WHEN 'tuesday' "
				+ "THEN 2 WHEN 'wednesday' "
				+ "THEN 3 WHEN 'thursday' "
				+ "THEN 4 WHEN 'friday' "
				+ "THEN 5 ELSE 6 "
				+ "END";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, room_id);
			stmt.setString(2, days);
			rs = stmt.executeQuery();

			while(rs.next()){
				if(rs.getString(4).equals("monday")){
					day = "月";
				}else if(rs.getString(4).equals("tuesday")){
					day = "火";
				}else if(rs.getString(4).equals("wednesday")){
					day = "水";
				}else if(rs.getString(4).equals("thursday")){
					day = "木";
				}else if(rs.getString(4).equals("friday")){
					day = "金";
				}
			ReservationBean reservationbean = new ReservationBean(
					rs.getInt(1),rs.getInt(2),rs.getString(3),day,lecture
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