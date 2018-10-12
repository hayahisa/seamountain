package dao;

import model.UserBean;

public class UserDao extends DaoBase{

	public UserDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//ユーザIDの重複チェック
	public boolean userNocheck(String userno) {

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
			String sql = "insert into user(user_no,course_id,time_id,user_name,mail,user_year,role_flg) values(?,?,?,?,?,?,?)";

			stmt = con.prepareStatement(sql);

			// SQLの？に値のセット
			stmt.setString(1, ubean.getUserNo());
			stmt.setString(2, ubean.getCourseId());
			stmt.setString(3, ubean.getTimeId());
			stmt.setString(4, ubean.getUserName());
			stmt.setString(5, ubean.getMail());
			stmt.setInt(6, ubean.getUserYear());
			stmt.setString(7, ubean.getRoleFlg());
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

	public UserBean userSession(String userNo) {
		UserBean userbean = null;
		try {
			super.connection();
			//ログイン認証sql
			String sql = "SELECT * FROM user where user_no = ?";
			stmt = con.prepareStatement(sql);

			stmt.setString(1,userNo);

			rs = stmt.executeQuery();// 結果が返ってくるSQL実行文
			rs.next();

			// Beanにuse情報を格納
			userbean = new UserBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
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
		return userbean;
	}
	
	public void deleteUser(String userNo){
		try {
			// connection確立
			super.connection();

			String SQL = "DELETE FROM user WHERE user_id = ?";
			
			stmt = con.prepareStatement(SQL);
			// SQLの？に値のセット
			stmt.setString(1, userNo);
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
    
		public void userChange(String mail,String user_name,String user_no) {
			try {
				//connection確立
				super.connection();


		        String sql = "update `schedule` SET mail,user_name=?,? WHERE user_no= ?";

		        stmt = con.prepareStatement(sql);
		        stmt.setString(1,mail);
		        stmt.setString(2,user_name);
		        stmt.setString(3,user_no);
		        rs= stmt.executeQuery();

				}catch (Exception e){
					e.printStackTrace();
				}finally{
					try{
						super.DbClose();
					} catch(Exception e){
						System.out.println("error");
					}
				}
		}
}
