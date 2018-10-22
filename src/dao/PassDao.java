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
}
