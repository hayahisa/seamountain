package dao;

public class LogoutDao extends DaoBase{

	public LogoutDao(){

	}

	//ログインフラグを変更する
	public void logout(){
		try{
			super.connection();
			String sql = "UPDATE `user` SET `login_flg`= '0' WHERE 1";
			stmt = con.prepareStatement(sql);
			stmt.executeLargeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}

}
