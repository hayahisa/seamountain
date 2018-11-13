package dao;

import java.util.ArrayList;

import model.RoomStateDetailBean;
import model.TimeDetailBean;

public class CreateTableDao extends DaoBase{

	public CreateTableDao(){

	}

	//行があるかの確認←いらないのでは？
	public int countRoom(int room_id){
		int count = 0;
		try{
			super.connection();
			String sql = "SELECT COUNT(*) FROM room_state_detail rs "
						+ "WHERE rs.room_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, room_id);

			rs.next();
			count = rs.getInt(1);

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return count;
	}

	//room_state_detailにinsert(初期化）
	public void insertRoom(int room_id,String day){
		int num = 0;
		try{
			super.connection();
			String sql = "INSERT INTO `room_state_detail` "
					+ "(`room_id`, `day`, "
					+ "`one_room_state_id`, `two_room_state_id`, `three_room_state_id`, `four_room_state_id`) "
					+ "VALUES (?,?,?,?,?,?)";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1,room_id);
			stmt.setString(2,day);
			stmt.setInt(3,1);
			stmt.setInt(4,1);
			stmt.setInt(5,1);
			stmt.setInt(6,1);
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

	//room_state_detailにroom_id,day,x_room_state_idを入れる
	public void updateRoomStateId(String x_room, int room_id, String day, int state_id){
		int num = 0;
		try{
			super.connection();
			String sql = "UPDATE `room_state_detail` "
					+ "SET " + x_room + "= ? "
					+ "WHERE room_id = ? "
					+ "AND day = ?";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, state_id);
			stmt.setInt(2, room_id);
			stmt.setString(3, day);
			num = stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}

	//現状のroom_state_detailを取り出す
	public ArrayList<RoomStateDetailBean> getRoomStateAll(){
		ArrayList<RoomStateDetailBean> roomStateArray = new ArrayList<>();
		try{
			super.connection();
			String sql = "SELECT * FROM room_state_detail rs "
					+ "ORDER BY "
					+ "rs.room_id ASC, "
					+ "CASE rs.day "
					+ "WHEN 'monday' THEN 1 "
					+ "WHEN 'tuesday' THEN 2 "
					+ "WHEN 'wednesday' THEN 3 "
					+ "WHEN 'thursday' THEN 4 "
					+ "WHEN 'friday' THEN 5 "
					+ "ELSE 6 "
					+ "END;";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				RoomStateDetailBean roomstatedetailbean = new RoomStateDetailBean(
						rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)
						);
				roomStateArray.add(roomstatedetailbean);
			}
		}catch (Exception e){
			System.out.println(e);
		}finally{
			try{
				super.DbClose();
			}catch (Exception e){
				System.out.println("error");
			}
		}
		return roomStateArray;
	}

	//room_state_detailをupdate(時間割作成を行われるたびにアップデートする）
	public void updateRoom(int room_id, String day, int one, int two, int three, int four){
		int num = 0;
		try{
			super.connection();
			String sql = "UPDATE `room_state_detail` "
					+ "SET `one_room_state_id`= ? ,`two_room_state_id`= ?, "
					+ "`three_room_state_id`= ?,`four_room_state_id`= ? "
					+ "WHERE room_id = ? "
					+ "AND day = ?";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1,one);
			stmt.setInt(2,two);
			stmt.setInt(3,three);
			stmt.setInt(4,four);
			stmt.setInt(5,room_id);
			stmt.setString(6, day);

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
		int time_id = 0;
		try{
			super.connection();
			String sql = "SELECT MAX(t.time_id) FROM time t";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			time_id = rs.getInt(1);

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
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
