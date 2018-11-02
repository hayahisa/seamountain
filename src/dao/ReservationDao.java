package dao;

import java.util.ArrayList;

import model.ReservationBean;

public class ReservationDao extends DaoBase{

	public ReservationDao(){

	}

	//対象の時間割の検索
	public ArrayList<ReservationBean> reservatioin(int time_id,String day){
		ArrayList<ReservationBean> reservatioinArray = new ArrayList<>();
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
						rs.getInt(15),rs.getString(16),rs.getInt(17),rs.getString(18)
						);
				reservatioinArray.add(reservationbean);
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
		return reservatioinArray;
	}

}
