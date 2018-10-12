package dao;

import model.UserPassBean;

public class LoginDao extends DaoBase{

	// ユーザーログイン
		public UserPassBean User_loginDao(String user_no) {
			UserPassBean userpassbean = null;
			try {
				super.connection();
				//ログイン認証sql
				String sql = "SELECT user_no,password FROM password where user_no = ?";
				stmt = con.prepareStatement(sql);

				stmt.setString(1,user_no);

				rs = stmt.executeQuery();// 結果が返ってくるSQL実行文
				// データベースから返ってきた管理者ログイン情報を格納
				rs.next();

				// Beanに管理者ID.pass格納
				userpassbean = new UserPassBean(rs.getInt(1), rs.getString(2));
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					// エラーじはclose処理
					super.DbClose();
				} catch (Exception e) {
					System.out.println("error");
				}
			}
			return userpassbean;
		}
}

