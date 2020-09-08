package dao;
import java.sql.*;
import model.Word;
import java.sql.SQLException;

public class COUNTDAO {
	//DBに接続する情報
		private final String JDBC_URL=
				"jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
		private final String DB_USER = "root";
		private final String DB_PASS = "root";
		private final String drv = "com.mysql.cj.jdbc.Driver";
		  
		public int countrecord () {
		int record = 0;   
		try{
			Class.forName(drv);
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			
			//SELECT文の準備
			String sql = "SELECT COUNT(*) FROM WORD";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECT文を実行し、ResultSetを取得
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
			    record = rs.getInt("COUNT(*)");
			  
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return record;
	  }

	}
	