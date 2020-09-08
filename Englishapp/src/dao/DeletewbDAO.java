package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.*;

import model.Word;

public class DeletewbDAO {

	private final String JDBC_URL=
			"jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	String drv = "com.mysql.cj.jdbc.Driver";
	
	
	public boolean delete(String user, String word){
	
	try{
		Class.forName(drv);
		Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		
		//UPDATE文の準備
		String sql1 ="DELETE FROM my_wb WHERE username = ? and word = ?";
	    PreparedStatement pStmt = conn.prepareStatement(sql1);
	    
	    pStmt.setString(1, user);
	    pStmt.setString(2, word);
	    
         int rs = pStmt.executeUpdate();
		
		if(rs != 1) {
			return false;
		}
	    

	}catch(SQLException e1) {
		e1.printStackTrace();
	
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}

	return true;
  }
	
	
	
}
