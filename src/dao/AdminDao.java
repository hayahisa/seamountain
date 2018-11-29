package dao;

import java.util.ArrayList;

import model.AdminBean;

public class AdminDao extends DaoBase{

	public AdminDao(){

	}

	//管理者の情報取得
	public AdminBean getAdminInfo(String admin_id){

		AdminBean adminbean = new AdminBean();

		try {
			super.connection();
			String sql = "SELECT * FROM admin where admin_no = ?";
			stmt = con.prepareStatement(sql);

			stmt.setString(1,admin_id);

			rs = stmt.executeQuery();
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
	
	//管理者IDの重複チェック
	public boolean adminNocheck(String adminno) {

		boolean flg = false;

		try {
			// connection確立
			super.connection();
			String selectSQL = "select count(*) from user where admin_no = ?";

			stmt = con.prepareStatement(selectSQL);
			// SQLの？に値のセット
			stmt.setString(1, adminno);
			rs = stmt.executeQuery();
			
			rs.next();
			
			if(!(rs.getString(1).equals("0"))){
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
	// 管理者登録
	public void registrationAdmin(AdminBean abean) {
		try {
	
			// connection確立
			super.connection();
	
			// ユーザーを登録するSQL
			String sql = "insert into admin() values(?,?)";
	
			stmt = con.prepareStatement(sql);
	
			// SQLの？に値のセット
			stmt.setString(1, abean.getAdmin_id());
			stmt.setString(2, abean.getAdmin_name());
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
	
	//管理者一覧の取得
	public ArrayList<AdminBean> adminUserList() {
		
		ArrayList<AdminBean> adminArray = new ArrayList<AdminBean>();
		
		boolean flg = false;

		try {
			// connection確立
			super.connection();
			String selectSQL = "select * from admin";

			stmt = con.prepareStatement(selectSQL);
			// SQLの？に値のセット
			rs = stmt.executeQuery();
			
			while(rs.next()){
				AdminBean adminbean = new AdminBean();
				adminbean.setAdmin_id(rs.getString(1));
				adminbean.setAdmin_name(rs.getString(2));
				
				adminArray.add(adminbean);
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
		return adminArray;
	}

}
