package dao;

import model.AdminBean;

public class AdminDao extends DaoBase{
	
	public AdminDao(){
		
	}
	
	//管理者の情報取得
	public AdminBean getAdminInfo(String admin_id){
		
		AdminBean adminbean = new AdminBean();
		
		try {
			super.connection();
			//ログイン認証sql
			String sql = "SELECT * FROM admin where admin_no = ?";
			stmt = con.prepareStatement(sql);

			stmt.setString(1,admin_id);

			rs = stmt.executeQuery();// 結果が返ってくるSQL実行文
			// データベースから返ってきた管理者ログイン情報を格納
			rs.next();
			
			adminbean.setAdmin_id(rs.getString(1));
			adminbean.setAdmin_name(rs.getString(2));
			
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
		
		return adminbean;
		
	}
	
}
