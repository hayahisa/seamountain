package dao;

import java.util.ArrayList;

import model.TimeListBean;

public class TimeDao extends DaoBase{

	public TimeDao(){

	}

	//時間割一覧
	public ArrayList<TimeListBean> timeList(){
		ArrayList<TimeListBean> timeArray = new ArrayList<>();
		try{
			super.connection();
			String sql = "SELECT * FROM time;";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			rs.next();
			while(rs.next()){
				TimeListBean timelistbean = new TimeListBean(rs.getInt(1),rs.getString(2));
				timeArray.add(timelistbean);
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
		return timeArray;
	}

	//時間割削除
	public void deleteTimetable(int timeid){
		try{
			super.connection();
			String sql = "DELETE FROM time WHERE time_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, timeid);
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
	
	//時間割一覧
	public ArrayList<TimeListBean> timeAllList(){
		ArrayList<TimeListBean> timeArray = new ArrayList<>();
		try{
			super.connection();
			String sql = "SELECT * FROM time;";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
	
			while(rs.next()){
				TimeListBean timelistbean = new TimeListBean(rs.getInt(1),rs.getString(2));
				timeArray.add(timelistbean);
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
		return timeArray;
	}
}
