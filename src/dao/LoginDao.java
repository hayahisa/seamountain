package dao;

import model.UserPassBean;

public class LoginDao extends DaoBase{

	// ユーザーログイン
		public UserPassBean User_loginDao(int user_no) {
			UserPassBean UserPassBean = null;
			try {
				super.connection();

				//ログイン認証sql
				String sql = "SELECT  user_no,user_pass FROM user_pass_table where user_no = ?";
				stmt = con.prepareStatement(sql);

				stmt.setInt(1,user_no);

				rs = stmt.executeQuery();// 結果が返ってくるSQL実行文
				// データベースから返ってきた管理者ログイン情報を格納
				rs.next();

				// Beanに管理者ID.pass格納
				System.out.println(rs.getInt(1) + rs.getString(2));
				UserPassBean = new UserPassBean(rs.getInt(1), rs.getString(2));
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
			return UserPassBean;
		}
}

