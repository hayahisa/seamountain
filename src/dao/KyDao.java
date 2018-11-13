package dao;

import model.KyBean;
import model.KyInfoBean;
import model.SubjectBean;

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

}
