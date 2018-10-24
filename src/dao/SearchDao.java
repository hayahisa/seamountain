package dao;

import java.util.ArrayList;

public class SearchDao extends DaoBase{

	//時間割検索(timeNameを返す）
	public ArrayList<String> searchTime(String word){
		ArrayList<String> searchList = new ArrayList<>();
		try{
			super.connection();
			String sql = "SELECT `time_name` FROM time "
					+ "WHERE `time_name` LIKE ?;";

			stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + word + "%");
			rs = stmt.executeQuery();

			while(rs.next()){
				String timeName = rs.getString(1);
				searchList.add(timeName);
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
