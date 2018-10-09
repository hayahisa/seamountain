package dao;

import model.UserBean;
import model.UserSessionBean;

public class UserDao extends DaoBase{

	public UserDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//ユーザIDの重複チェック
	public boolean userIDcheck(String userno) {

		boolean flg = false;

		try {
			// connection確立
			super.connection();

			String selectSQL = "select count(*) from user where user_no = ?";

			stmt = con.prepareStatement(selectSQL);
			// SQLの？に値のセット
			stmt.setString(1, userno);
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

	// ユーザ登録
		public void registrationUser(UserBean ubean) {
			try {

				// connection確立
				super.connection();

				// ユーザーを登録するSQL
				String sql = "insert into user(user_no,course_id,time_id,user_name,mail,user_year,role_flg,login_flg) values(?,?,?,?,?,?,?,?)";

				stmt = con.prepareStatement(sql);

				// SQLの？に値のセット
				stmt.setString(1, ubean.getUserNo());
				stmt.setString(2, ubean.getCourseId());
				stmt.setString(3, ubean.getTimeId());
				stmt.setString(4, ubean.getUserName());
				stmt.setString(5, ubean.getMail());
				stmt.setInt(6, ubean.getUserYear());
				stmt.setString(7, ubean.getRoleFlg());
				stmt.setString(8, ubean.getLoginFlg());
				stmt.executeUpdate();

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
		}

		public UserSessionBean userSession(String user_no) {
			UserSessionBean usersessionbean = null;
			try {

				// connection確立
				super.connection();

				// SQLの？に値のセット
				stmt.setString(1, userno);
				rs = stmt.executeQuery();

				rs.next();
				String selectSQL = "select * from user where user_no = ?";

				stmt = con.prepareStatement(selectSQL);
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
		}
}
