package dao;

public class LogoutDao extends DaoBase {

	public LogoutDao(){

	}

	//loginflgの変更を行う
	public void logout(){
		try{
			super.connection();
			String sql = "UPDATE `user` SET `login_flg`= '0' WHERE 1;";
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();

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
