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
		
		return null;
		
	}

}
