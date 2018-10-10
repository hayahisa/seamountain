package dao;

import model.RoomIdBean;
import model.SubjectIdBean;

public class TimeDetailDao extends DaoBase{

	//subject_idを取り出す
	public SubjectIdBean Subject_id(int time_id){
		SubjectIdBean subjectidbean = null;
		try{
			super.connection();
			String sql = "SELECT td.one_subject_id,"
					+ "td.two_subject_id,td."
					+ "three_subject_id,td."
					+ "four_subject_id, "
					+ "td.day"
					+ "FROM time_detail td"
					+ "WHERE td.time_id = ?";

			stmt.setInt(1, time_id);
			rs = stmt.executeQuery();
			rs.next();

			//Beanに格納
			subjectidbean = new SubjectIdBean(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5)
					);
		}catch (Exception e){
			System.out.println(e);
		}finally{
			try{
				super.DbClose();
			}catch (Exception e){
				System.out.println("error");
			}
		}
		return subjectidbean;
	}


	//room_idを取り出す
	public RoomIdBean Room_id(int time_id){
		RoomIdBean roomidbean = null;
		try{
			super.connection();
			String sql = "SELECT td.one_room_id,"
					+ "td.two_room_id,"
					+ "td.three_room_id,"
					+ "td.four_room_id,"
					+ "td.day"
					+ "FROM time_detail td"
					+ "WHERE td.time_id = ?";

			stmt.setInt(1, time_id);
			rs = stmt.executeQuery();
			rs.next();

			//Beanに格納
			roomidbean = new RoomIdBean(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5)
					);
		}catch (Exception e){
			System.out.println(e);
		}finally{
			try{
				super.DbClose();
			}catch (Exception e){
				System.out.println("error");
			}
		}
		return roomidbean;
	}

}
