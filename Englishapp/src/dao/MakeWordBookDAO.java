package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.*;

import model.Word;

public class MakeWordBookDAO {

	private final String JDBC_URL=
			"jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	String drv = "com.mysql.cj.jdbc.Driver";
	
	
	public boolean create(Word word){
	
	try{
		Class.forName(drv);
		Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		
		//UPDATE文の準備
		String sql1 ="INSERT INTO my_wb (word, meaning, username) values (?, ?, ?)";
	    PreparedStatement pStmt = conn.prepareStatement(sql1);
	    
	    pStmt.setString(1, word.getWord());
	    pStmt.setString(2, word.getMeaning());
	    pStmt.setString(3, word.getUsername());
	    
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
