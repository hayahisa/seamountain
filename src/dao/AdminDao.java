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
	
	//ユーザIDの重複チェック
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
	// ユーザ登録
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
	
	//ユーザIDの重複チェック
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
	
	//チェックボックスで選択されたユーザーの削除
	public void adminUserCheckDelete(String userno[]){
		try {
			// connection確立
			super.connection();
			
			String insertuser = "";
			String insertuserQ = ",?";
			
			//ユーザを選択された数"?"を追加
			for(int count=0;count<userno.length - 1;count++){
				insertuser = insertuser + insertuserQ;
			}
			
			String SQL = "DELETE FROM admin WHERE admin_no IN(?" + insertuser + ")";

			stmt = con.prepareStatement(SQL);
			
			for(int stmtCount=0;stmtCount<=userno.length - 1;stmtCount++){
				stmt.setString(stmtCount + 1, userno[stmtCount]);
			}
			// SQLの？に値のセット
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
