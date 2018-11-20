package dao;

import model.KyBean;
import model.KyInfoBean;

public class KyDao extends DaoBase{
	public KyDao(){

	}
	public KyInfoBean getKyall(){
		KyInfoBean KIB = new KyInfoBean();
		try {
			super.connection();
			String sql = "SELECT * FROM ky;";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				KyBean kyBean = new KyBean(rs.getInt(1),rs.getString(2));
				KIB.addky(kyBean);
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return KIB;

	}

	public int getKy(String roomId) {

		int ky_id = 0;
		try {
			System.out.println(roomId+"aaaaaaaaaaa");
			super.connection();
			String sql = "SELECT ky_id FROM room where room_name=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,roomId);
			rs = stmt.executeQuery();
			rs.next();

			 ky_id = rs.getInt(1);

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
		return ky_id;

	}
	public void DeleteKy(int ky_id){
		try {
			super.connection();

			String sql = "delete from ky where ky_id=?;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ky_id);
			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
	public void UpdateKy(int ky_id,String Ky_name){
		try {
			super.connection();
			String sql = "update ky set ky_name=? where ky_id=?;";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Ky_name);
			stmt.setInt(2, ky_id);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public void ChangeKyState(int ky_id){
		try {
			super.connection();
			String sql = "update ky set ky_state_id=4 where ky_id=?;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ky_id);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public void CancelKyState(int ky_id){
		try {
			super.connection();
			String sql = "update ky set ky_state_id=2 where ky_id=?;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ky_id);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}


	public int getKyStateId(int ky_id) {
		int ky_state_id=0;
		try {

			super.connection();
			String sql = "SELECT ky_state_id FROM ky where ky_id=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,ky_id);
			rs = stmt.executeQuery();
			rs.next();
			ky_state_id=rs.getInt(1);
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
		return ky_state_id;

	}

}
