package dao;

public class CreateTableDao extends DaoBase{

	public CreateTableDao(){

	}
	//時間割名を挿入そして、時間割IDを返却
	public int setTime(String time_name){
		int time_id = 0;
		try{
			super.connection();
//			挿入
			String sql = "INSERT INTO `time`(`time_id`, `time_name`) "
					+ "VALUES (0,?)";
//			IDをとる
			String sql2 = "SELECT MAX(time_id) FROM time";

			stmt = con.prepareStatement(sql);
			stmt.setString(1,time_name);
			stmt.executeUpdate();

			stmt = con.prepareStatement(sql2);
			stmt.executeQuery();
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
