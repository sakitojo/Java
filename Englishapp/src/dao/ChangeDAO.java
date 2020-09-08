package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Account;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeDAO {
	
	private final String JDBC_URL=
			"jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	private final String drv = "com.mysql.cj.jdbc.Driver";
	  
	
	public boolean update(Account account){
	
	try{
		Class.forName(drv);
		Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		
		//UPDATE文の準備
		String sql1 ="UPDATE ACCOUNT SET NAME = ?, PASS = ?, GENDER = ?, TEL = ?, ZIP = ?"
				+ "ADDRESS1 = ?, ADDRESS2 = ?, MAIL = ?, AGE = ? WHERE USERNAME = ?";
	    PreparedStatement pStmt = conn.prepareStatement(sql1);
	    
	    pStmt.setString(1, account.getName());
	    pStmt.setString(2, account.getPass());
	    pStmt.setString(3, account.getGender());
	    pStmt.setString(4, account.getTel()); 
	    pStmt.setString(5, account.getZip());
	    pStmt.setString(6, account.getAddress1());
	    pStmt.setString(7, account.getAddress2());
	    pStmt.setString(8, account.getEmail());
	    pStmt.setString(9, account.getAge());
	    pStmt.setString(10, account.getUserName());
		
		//SELECT文を実行し、ResultSetを取得
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
