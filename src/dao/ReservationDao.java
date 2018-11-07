package dao;

import java.util.ArrayList;

import model.ReservationBean;

public class ReservationDao extends DaoBase{

	public ReservationDao(){

	}

	//月曜の１限目について
	public void monOneReser(){
		try{
			super.connection();
			String sql = "";
			stmt = con.prepareStatement(sql);
//			stmt.setInt(1,time_id);
			rs = stmt.executeQuery();

			while(rs.next()){
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
	}


	//選択全て無し(全て表示）
	public ArrayList<ReservationBean> rdtReservation(){
		ArrayList<ReservationBean> reservationArray = new ArrayList<>();
		try{
			super.connection();
			String sql = "SELECT td.time_id, td.day, "
						+ "td.one_subject_id, td.one_subject_name, td.one_room_id, td.one_room_name, "
						+ "td.two_subject_id, td.two_subject_name, td.two_room_id, td.two_room_name, "
						+ "td.three_subject_id, td.three_subject_name, td.three_room_id, td.three_room_name, "
						+ "td.four_subject_id, td.four_subject_name,td.four_room_id,td.four_room_name, "
						+ "t.time_name "
						+ "FROM time_detail td "
						+ "INNER JOIN time t "
						+ "ON td.time_id = t.time_id "
					+ "ORDER BY "
					+ "td.time_id ASC, "
					+ "CASE td.day "
					+ "WHEN 'monday' THEN 1 "
					+ "WHEN 'tuesday' THEN 2 "
					+ "WHEN 'wednesday' THEN 3 "
					+ "WHEN 'thursday' THEN 4 "
					+ "WHEN 'friday' THEN 5 "
					+ "ELSE 6 "
						+ "END";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				ReservationBean reservationbean = new ReservationBean(
						rs.getInt(1),rs.getString(2),
						rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),
						rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),
						rs.getInt(11),rs.getString(12),rs.getInt(13),rs.getString(14),
						rs.getInt(15),rs.getString(16),rs.getInt(17),rs.getString(18),
						rs.getString(19)
						);
				reservationArray.add(reservationbean);
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
		return reservationArray;
	}

	//roomId,dayが無し
	public ArrayList<ReservationBean> rdReservation(){
		ArrayList<ReservationBean> reservationArray = new ArrayList<>();
		try{
			super.connection();
			String sql = "SELECT td.time_id, td.day, "
					+ "td.one_subject_id, td.one_subject_name, td.one_room_id, td.one_room_name, "
					+ "td.two_subject_id, td.two_subject_name, td.two_room_id, td.two_room_name, "
					+ "td.three_subject_id, td.three_subject_name, td.three_room_id, td.three_room_name, "
					+ "td.four_subject_id, td.four_subject_name,td.four_room_id,td.four_room_name, "
					+ "t.time_name "
					+ "FROM time_detail td "
					+ "INNER JOIN time t "
					+ "ON td.time_id = t.time_id "
					+ "ORDER BY "
					+ "td.time_id ASC, "
					+ "CASE td.day "
					+ "WHEN 'monday' THEN 1 "
					+ "WHEN 'tuesday' THEN 2 "
					+ "WHEN 'wednesday' THEN 3 "
					+ "WHEN 'thursday' THEN 4 "
					+ "WHEN 'friday' THEN 5 "
					+ "ELSE 6 "
					+ "END";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				ReservationBean reservationbean = new ReservationBean(
						rs.getInt(1),rs.getString(2),
						rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),
						rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),
						rs.getInt(11),rs.getString(12),rs.getInt(13),rs.getString(14),
						rs.getInt(15),rs.getString(16),rs.getInt(17),rs.getString(18),
						rs.getString(19)
						);
				reservationArray.add(reservationbean);
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
		return reservationArray;
	}
	//day,timeId無し(roomIdのみ)
		public ArrayList<ReservationBean> dtReservation(int roomId){
			ArrayList<ReservationBean> reservationArray = new ArrayList<>();
			try{
				super.connection();
				String sql = "SELECT td.time_id, td.day, "
						+ "td.one_subject_id, td.one_subject_name, td.one_room_id, td.one_room_name, "
						+ "td.two_subject_id, td.two_subject_name, td.two_room_id, td.two_room_name, "
						+ "td.three_subject_id, td.three_subject_name, td.three_room_id, td.three_room_name, "
						+ "td.four_subject_id, td.four_subject_name,td.four_room_id,td.four_room_name, "
						+ "t.time_name "
						+ "FROM time_detail td "
						+ "INNER JOIN time t "
						+ "ON td.time_id = t.time_id "
					+ "ORDER BY "
					+ "td.time_id ASC, "
					+ "CASE td.day "
					+ "WHEN 'monday' THEN 1 "
					+ "WHEN 'tuesday' THEN 2 "
					+ "WHEN 'wednesday' THEN 3 "
					+ "WHEN 'thursday' THEN 4 "
					+ "WHEN 'friday' THEN 5 "
					+ "ELSE 6 "
						+ "END";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				ReservationBean reservationbean = new ReservationBean(
						rs.getInt(1),rs.getString(2),
						rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),
						rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),
						rs.getInt(11),rs.getString(12),rs.getInt(13),rs.getString(14),
						rs.getInt(15),rs.getString(16),rs.getInt(17),rs.getString(18),
							rs.getString(19)
						);
				reservationArray.add(reservationbean);
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
		return reservationArray;
	}

	//対象の時間割の検索
	public ArrayList<ReservationBean> reservatioin(int time_id,String day){
		ArrayList<ReservationBean> reservationArray = new ArrayList<>();
		try{
			super.connection();
			String sql = "SELECT * FROM time_detail td "
					+ "WHERE td.time_id = ? "
					+ "AND td.day = ? ";

			stmt = con.prepareStatement(sql);

			stmt.setInt(1,time_id);
			stmt.setString(2,day);

			rs = stmt.executeQuery();

			while(rs.next()){
				ReservationBean reservationbean = new ReservationBean(
						rs.getInt(1),rs.getString(2),
						rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),
						rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),
						rs.getInt(11),rs.getString(12),rs.getInt(13),rs.getString(14),
						rs.getInt(15),rs.getString(16),rs.getInt(17),rs.getString(18),
						rs.getString(20)
						);
				reservationArray.add(reservationbean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return reservationArray;
	}

}
