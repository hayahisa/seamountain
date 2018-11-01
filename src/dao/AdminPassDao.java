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
			
			while(rs.next()){
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
