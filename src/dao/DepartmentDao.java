package dao;

public class DepartmentDao extends DaoBase{
	public void subjectAdd(String name) {
		try {

			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String sql = "insert into subject(subject_name) values(?)";

			stmt = con.prepareStatement(sql);

			// SQLの？に値のセット
			stmt.setString(1, name);
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
	public void subjectChange(String name,int Sub_id) {
		try {

			// connection確立
			super.connection();

			//sql
	     	 String sql = "update `subject` SET subject_name=? where subject_id=?";

			stmt.setString(1, name);
			stmt.setInt(2,Sub_id);
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
	public void subjectDelete(int subject_id){
		try {
			super.connection();

			String sql = "delete from subject where subject_id=?;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, subject_id);
			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
