package dao;

import model.TimeDetailBean;

public class CreateTableDao extends DaoBase{

	public CreateTableDao(){

	}
	//時間割を挿入
	public void setTimeTable(TimeDetailBean timedetailbean){
		int num = 0;
		TimeDetailBean timedetail = timedetailbean;
		try{
			super.connection();
			String sql = "INSERT INTO `time_detail`(`time_id`, `day`, "
					+ "`one_subject_id`, `one_subject_name`, `one_room_id`, `one_room_name`, "
					+ "`two_subject_id`, `two_subject_name`, `two_room_id`, `two_room_name`, "
					+ "`three_subject_id`, `three_subject_name`, `three_room_id`, `three_room_name`, "
					+ "`four_subject_id`, `four_subject_name`, `four_room_id`, `four_room_name`) "
					+ "VALUES ( "
					+ "?,?, "
					+ "?,?,?,?, "
					+ "?,?,?,?, "
					+ "?,?,?,?, "
					+ "?,?,?,? "
					+ ");";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1,timedetail.getTime_id());
			stmt.setString(2,timedetail.getDay());
			stmt.setInt(3,timedetail.getOne_subject_id());
			stmt.setString(4,timedetail.getOne_subject_name());
			stmt.setInt(5,timedetail.getOne_room_id());
			stmt.setString(6,timedetail.getOne_room_name());
			stmt.setInt(7,timedetail.getTwo_subject_id());
			stmt.setString(8,timedetail.getTwo_subject_name());
			stmt.setInt(9,timedetail.getTwo_room_id());
			stmt.setString(10,timedetail.getTwo_room_name());
			stmt.setInt(11,timedetail.getThree_subject_id());
			stmt.setString(12,timedetail.getThree_subject_name());
			stmt.setInt(13,timedetail.getThree_room_id());
			stmt.setString(14,timedetail.getThree_room_name());
			stmt.setInt(15,timedetail.getFour_subject_id());
			stmt.setString(16,timedetail.getFour_subject_name());
			stmt.setInt(17,timedetail.getFour_room_id());
			stmt.setString(18,timedetail.getFour_room_name());

			num = stmt.executeUpdate();

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}

	//時間割名を挿入
	public void setTime(String time_name){
		try{
			super.connection();
//			挿入
			String sql = "INSERT INTO `time`(`time_id`, `time_name`) "
					+ "VALUES (0,?)";

			stmt = con.prepareStatement(sql);
			stmt.setString(1,time_name);
			stmt.executeUpdate();

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}

//	IDをとる
	public int getTimeId(){
		System.out.println("in getTimeId dao");
		int time_id = 0;
		try{
			super.connection();
			String sql = "SELECT MAX(t.time_id) FROM time t";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			time_id = rs.getInt(1);
			System.out.println("*T="+rs.getInt(1));

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		System.out.println("time_id="+time_id);
		return time_id;
	}

	//IDを渡されたら名前を返す(room)
	public String roomName(int room_id){
		String room_name = null;
		try{
			super.connection();
			String sql = "SELECT r.room_name FROM room r "
					+ "WHERE r.room_id = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,room_id);
			rs = stmt.executeQuery();
			rs.next();

			room_name = rs.getString(1);

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
		return room_name;
	}

	//IDを渡されたら名前を返す(subject)
		public String subjectName(int subject_id){
			String subject_name = null;
			try{
				super.connection();
				String sql = "SELECT s.subject_name FROM subject s "
						+ "WHERE s.subject_id = ? ";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1,subject_id);
				rs = stmt.executeQuery();
				rs.next();

				subject_name = rs.getString(1);

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
			return subject_name;
		}
}
