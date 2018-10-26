package dao;

public class PassDao extends DaoBase{
	
	public PassDao(){
		
	}
	
	//パスワードの登録
	public void registrationPassword(String userno,String pass) {
		try {
			// connection確立
			super.connection();
			
			// ユーザーを登録するSQL
			String insertSQL = "insert into password values(?,?)";
			
			stmt = con.prepareStatement(insertSQL);
			// SQLの？に値のセット
			stmt.setString(1, userno);
			stmt.setString(2, pass);
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
	
	public boolean passwordCheck(String userNo,String pass){
		boolean flg = false;
		try {
			// connection確立
			super.connection();

			String SQL = "SELECT * FROM password WHERE user_no = ? and password = ?";

			stmt = con.prepareStatement(SQL);
			// SQLの？に値のセット
			stmt.setString(1, userNo);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				flg = true;
			}

		} catch (Exception e) {
			System.out.println("kkkkkkk");
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
