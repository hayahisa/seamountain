package dao;

import java.util.ArrayList;

import model.TimeListBean;

public class SearchDao extends DaoBase{

	//時間割検索(timeNameを返す）
	public ArrayList<TimeListBean> searchTime(String word){
		ArrayList<TimeListBean> searchList = new ArrayList<>();
		try{
			super.connection();
			String sql = "SELECT * FROM time "
					+ "WHERE `time_name` LIKE ?;";

			stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + word + "%");
			rs = stmt.executeQuery();

			while(rs.next()){
				TimeListBean timelistbean = new TimeListBean(rs.getInt(1),rs.getString(2));
				searchList.add(timelistbean);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return searchList;
	}
}
