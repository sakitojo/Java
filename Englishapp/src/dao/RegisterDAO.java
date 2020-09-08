package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;


public class RegisterDAO {
	
		private final String JDBC_URL=
				"jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
		private final String DB_USER = "root";
		private final String DB_PASS = "root";
		private final String drv = "com.mysql.cj.jdbc.Driver";
		String empNo1 = "0";
			
		public boolean create(Account account){	
			
		try{
			Class.forName(drv);
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			String sql ="SELECT * FROM user_tb WHERE USERNAME = ?";
			
			PreparedStatement pSt = conn.prepareStatement(sql);
			
			pSt.setString(1, account.getUserName());
			
			ResultSet rs1 = pSt.executeQuery();
			
			while(rs1.next()){
                empNo1 = rs1.getString(1);
              }  
			
			if (empNo1 == "0") {   

			//INSERT文の準備
			String sql1 ="INSERT INTO user_tb (NAME, USERNAME, PASS,"
					+ "GENDER, TEL, ZIP, ADDRESS1, ADDRESS2, MAIL, AGE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    PreparedStatement pStmt = conn.prepareStatement(sql1);
		    
		    pStmt.setString(1, account.getName()); 
		    pStmt.setString(2, account.getUserName());
		    pStmt.setString(3, account.getPass());
		    pStmt.setString(4, account.getGender());
		    pStmt.setString(5, account.getTel());
		    pStmt.setString(6, account.getZip());
		    pStmt.setString(7, account.getAddress1());
		    pStmt.setString(8, account.getAddress2());
		    pStmt.setString(9, account.getEmail());
		    pStmt.setString(10, account.getAge());
		   
		    
			//SELECT文を実行し、ResultSetを取得
			int rs = pStmt.executeUpdate();
			
			if(rs != 1) {
				return false;
			}
			
		 } else {
             	System.out.println("そのユーザー名は既に登録されています。");
             	
             }  
			
		}catch(SQLException e) {
			e.printStackTrace();
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
		
	  }
}
