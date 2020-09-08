package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.QuestionHistory;

public class QuestionHistoryDAO {
	
	private final String JDBC_URL=
			"jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	private final String drv = "com.mysql.cj.jdbc.Driver";
	
	public boolean create(QuestionHistory questionhistory) {
	
  try {
	    Class.forName(drv);
	    Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
		String sql ="INSERT INTO answer_hs (USERNAME, meaning, DATE, ANSWER) values"
				+ "(?, ?, ?, ?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		
		 pStmt.setString(1, questionhistory.getUsername()); 
		 pStmt.setString(2, questionhistory.getMeaning()); 
		 pStmt.setTimestamp(3, new Timestamp(System.currentTimeMillis())); 
		 pStmt.setString(4, questionhistory.getAnswer());
		
		 int rs = pStmt.executeUpdate();
		 
		 if(rs != 1) {
				return false;
			}
		
   }catch(SQLException e) {
		e.printStackTrace();
	
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	return true;
	
 }
	

}
