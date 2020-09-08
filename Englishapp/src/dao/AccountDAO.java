package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Login;

public class AccountDAO {
	private final String JDBC_URL=
			"jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	private final String drv = "com.mysql.cj.jdbc.Driver";
	  
	//ログインコンストラクタの新しいloginというものを生成して使う
	public Account findByLogin(Login login) {
		Account account = null;
	 
	try{
		Class.forName(drv);
		Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		
		//SELECT文の準備
		String sql1 ="SELECT NAME, USERNAME, PASS, GENDER, TEL, ZIP, ADDRESS1, ADDRESS2, MAIL, AGE FROM user_tb WHERE USERNAME = ? AND PASS = ?";
	    PreparedStatement pStmt = conn.prepareStatement(sql1);
	    pStmt.setString(1, login.getUserName());
	    pStmt.setString(2, login.getPass());
	    
		
		//SELECT文を実行し、ResultSetを取得
		ResultSet rs = pStmt.executeQuery();
		
		//一致したユーザーがいた場合、
		//そユーザーを表すインスタンスを生成する
		while(rs.next()) {
		    String name = rs.getString("NAME");
		    String username = rs.getString("USERNAME");
		    String pass = rs.getString("PASS");
		    String gender = rs.getString("GENDER");
		    String tel = rs.getString("TEL");
		    String zip = rs.getString("ZIP");
		    String address1 = rs.getString("ADDRESS1");
		    String address2 = rs.getString("ADDRESS2");
		    String email = rs.getString("MAIL");
		    String age = rs.getString("AGE");
		    
		    account = new Account(name, username, pass, gender, tel, zip,
		    		address1, address2, email, age); //インスタンス生成
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	//見つかったユーザーまたはnullをかえす
	return account;
  }


public List<Account> change(String changeId) {
	List<Account> changeInfo = new ArrayList<>();
	
try {
	Class.forName(drv);
	Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	
	//SELECT文の準備
	String sql1 ="SELECT NAME, USERNAME, PASS, GENDER, TEL, ZIP, ADDRESS1, ADDRESS2, MAIL, AGE fROM user_tb WHERE USERNAME = ?";
	PreparedStatement pStmt = conn.prepareStatement(sql1);
	pStmt.setString(1, changeId);
	
	//SELECT文を実行し、ResultSetを取得
	ResultSet rs = pStmt.executeQuery();
	
	//一致したユーザーがいた場合、
	//そのユーザーを表すインスタンスを生成する
	while(rs.next()) {
		 String name = rs.getString("NAME");
		 String username = rs.getString("USERNAME");
		 String pass = rs.getString("PASS");
         String gender = rs.getString("GENDER");
   	     String tel = rs.getString("TEL");
   	     String zip = rs.getString("ZIP");
	     String address1 = rs.getString("ADDRESS1");
	     String address2 = rs.getString("ADDRESS2");
		 String email = rs.getString("MAIL");
		 String age = rs.getString("AGE");
		
		
		Account ac = new Account(name, username, pass, gender, tel, zip, address1, address2, email, age);
		changeInfo.add(ac);
	}
		
	}catch(SQLException e) {
		e.printStackTrace();
	
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	//見つかったユーザーまたはnullをかえす
	return changeInfo;
  }

}
