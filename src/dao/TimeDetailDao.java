package dao;

import model.RoomIdBean;
import model.SubjectIdBean;
import model.TimeTableBean;

public class TimeDetailDao extends DaoBase{

	//時間割を格納
	public TimeTableBean timetable(int time_id,String day){
		TimeTableBean timetable = null;
		try{
			super.connection();
			String sql = "SELECT td.time_id,t.time_name,td.day,"
					+ "td.one_room_name,td.one_subject_name,"
					+ "td.two_room_name,td.two_subject_name,"
					+ "td.three_room_name,td.three_subject_name,"
					+ "td.four_room_name,td.four_subject_name"
					+ "FROM ((time_detail td INNER JOIN time t"
							+ "ON td.time_id = t.time_id)"
							+ "INNER JOIN subject s"
							+ "ON td.one_subject_id = s.subject_id)"
							+ "INNER JOIN room r"
							+ "ON td.one_room_id = r.room_id"
					+ "WHERE td.time_id = ?"
					+ "AND td.day = '?';";

			stmt.setInt(1, time_id);
			stmt.setString(2, day);
			rs = stmt.executeQuery();
			rs.next();

			//Beanに格納
			timetable = new TimeTableBean(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getString(9),
					rs.getString(10),
					rs.getString(11)
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
		return timetable;
	}


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
