package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Word;
import java.util.ArrayList;
import java.util.List;

public class SelectWordBookDAO {
	private final String JDBC_URL=
			"jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	private final String drv = "com.mysql.cj.jdbc.Driver";
	
	
	public List<Word> findBy(String user){
	List<Word> wordlist = new ArrayList<>();
		
		try{
			Class.forName(drv);
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			//SELECT文の準備
			String sql = "SELECT * FROM my_wb where username= ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, user);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
			String word = rs.getString("word");
			String meaning = rs.getString("meaning");
			
			Word myword = new Word(word, meaning);
			wordlist.add(myword);
			
			}


		}catch(SQLException e) {
			e.printStackTrace();
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return wordlist;
	  }

	

}
