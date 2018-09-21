package dao;

public class UserDao extends DaoBase{
	
	public UserDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public boolean userIDcheck(String userid) {

		boolean flg = false;

		try {
			// connection確立
			super.connection();

			String selectSQL = "select count(*) from user where user_no = ?";

			stmt = con.prepareStatement(selectSQL);
			// SQLの？に値のセット
			stmt.setString(1, userid);
			rs = stmt.executeQuery();

			rs.next();

			if (rs.getInt(1) > 0) {
				flg = false;
			} else {
				flg = true;
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
		return flg;
	}
}
