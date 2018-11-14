package dao;

public class AdminPassDao extends DaoBase{
	
	public AdminPassDao(){
	}
	
	public boolean adminLogin(String adminId,String encryptPass){
		
		boolean flg = false;
		
		try {
			// connection確立
			super.connection();

			String selectSQL = "select count(*) from admin_password where admin_no = ? and admin_password = ?";

			stmt = con.prepareStatement(selectSQL);
			// SQLの？に値のセット
			stmt.setString(1, adminId);
			stmt.setString(2, encryptPass);
			rs = stmt.executeQuery();
			
			rs.next();
			
			if(rs.getString(1).equals("1")){
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
	
	//パスワードの登録
	public void registrationAdminPass(String adminno,String adminpass) {
		try {
			// connection確立
			super.connection();
			
			// ユーザーを登録するSQL
			String insertSQL = "insert into admin_password values(?,?)";
			
			stmt = con.prepareStatement(insertSQL);
			// SQLの？に値のセット
			stmt.setString(1, adminno);
			stmt.setString(2, adminpass);
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
