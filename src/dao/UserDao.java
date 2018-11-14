package dao;

import java.util.ArrayList;

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
	
	//メールアドレス重複チェック
	public boolean mailCheck(String mail) {
		
		boolean flg = false;
		
		try {
			// connection確立
			super.connection();
			
			String selectSQL = "select count(*) from user where mail = ?";
			
			stmt = con.prepareStatement(selectSQL);
			// SQLの？に値のセット
			stmt.setString(1, mail);
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
	public void registrationUser(UserBean ubean) {
		try {

			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String sql = "insert into user(user_no,course_id,time_id,user_name,mail,user_year,role_flg) values(?,?,?,?,?,?,?)";

			stmt = con.prepareStatement(sql);

			// SQLの？に値のセット
			stmt.setString(1, ubean.getUserNo());
			stmt.setInt(2, ubean.getCourseId());
			stmt.setInt(3, ubean.getTimeId());
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
			userbean = new UserBean();
			userbean.setUserNo(rs.getString(1));
			userbean.setCourseId(rs.getInt(2));
			userbean.setTimeId(rs.getInt(3));
			userbean.setUserName(rs.getString(4));
			userbean.setMail(rs.getString(5));
			userbean.setUserYear(rs.getInt(6));
			userbean.setRoleFlg(rs.getString(7));

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

			String SQL = "DELETE FROM user WHERE user_no = ?";

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
	}

	public void userChange(String mail,String user_name,String user_no) {
		try {
			//connection確立
			super.connection();

	        String sql = "update `user` SET mail=?,user_name=? WHERE user_no=?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1,mail);
	        stmt.setString(2,user_name);
	        stmt.setString(3,user_no);
	        stmt.executeUpdate();
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

	//年度、学科別表示
	public ArrayList<UserBean> UserGetSelect(ArrayList<Integer> yearArray,ArrayList<String> courseArray){
			
		ArrayList<UserBean> userArray = new ArrayList<UserBean>();
		
		try {
			super.connection();
			
			String insertyearQ = " or user_year = ?";
			String insertcourseQ = " or course_id = ?";
			String insertyear = "";
			String insertcourse = "";
			
			//年度を選択された数"?"を追加
			for(int count=0;count<yearArray.size()-1;count++){
				insertyear = insertyear + insertyearQ;
			}
			
			//学科を選択された数"?"を追加
			for(int count=0;count<courseArray.size()-1;count++){
				insertcourse = insertcourse + insertcourseQ;
			}
			
			String sql = "SELECT * FROM user WHERE (user_year = ?" + insertyear + ") AND (" + "course_id = ?" + insertcourse + ")";
			
			stmt = con.prepareStatement(sql);
			
			for(int stmtCount=1;stmtCount<=yearArray.size();stmtCount++){
				stmt.setInt(stmtCount, yearArray.get(stmtCount-1));
			}
			
			int countArray = 0;
			for(int stmtCount=yearArray.size()+1;stmtCount<=courseArray.size()+yearArray.size();stmtCount++){
				stmt.setString(stmtCount, courseArray.get(countArray));
				countArray++;
			}
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				UserBean userbean = new UserBean();
				userbean.setUserNo(rs.getString(1));
				userbean.setCourseId(rs.getInt(2));
				userbean.setTimeId(rs.getInt(3));
				userbean.setUserName(rs.getString(4));
				userbean.setMail(rs.getString(5));
				userbean.setUserYear(rs.getInt(6));
				userbean.setRoleFlg(rs.getString(7));
				
				userArray.add(userbean);
				
			}
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
		return userArray;
	}
	
	//チェックボックスで選択されたユーザーの削除
	public void userCheckDelete(String userno[]){
		try {
			// connection確立
			super.connection();
			
			String insertuser = "";
			String insertuserQ = ",?";
			
			System.out.println(userno.length);
			
			//ユーザを選択された数"?"を追加
			for(int count=0;count<userno.length - 1;count++){
				insertuser = insertuser + insertuserQ;
			}
			
			String SQL = "DELETE FROM user WHERE user_no IN(?" + insertuser + ")";

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
