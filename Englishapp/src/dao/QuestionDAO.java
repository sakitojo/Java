package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Word;

public class QuestionDAO {
	//DBに接続する情報
	private final String JDBC_URL=
			"jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	String drv = "com.mysql.cj.jdbc.Driver";
	
	public Word findById(int randId){
    //宣言＆初期化
	Word word1 = null;		
	
	try{
		Class.forName(drv);
		Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		
		
		//SELECT文の準備
		String sql = "SELECT * FROM word where id = ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		
		//INSERT文の？に使用する値を設定し、SQL文を完成
		pStmt.setInt(1, randId);
		
		//SELECT文を実行し、ResultSetを取得
		ResultSet rs = pStmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String meaning = rs.getString("meaning");
			String word = rs.getString("word");
			
			//コンストラクタWordに入れている
			word1 = new Word(id, meaning, word);
			
			
		}
	
	}catch(SQLException e) {
		e.printStackTrace();
	
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	return word1;
  }
	
	
	public List<Word> SecondQ(String words) {
		List<Word> secondQ = new ArrayList<>();
	//	int randId = 0;
	
	try{
		Class.forName(drv);
		Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		
		//SELECT文の準備
		String sql = "SELECT * FROM word where word not in (?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		
		//INSERT文の？に使用する値を設定し、SQL文を完成
		pStmt.setString(1, words);
	//	pStmt.setInt(2, randId);
		
		System.out.println(words);
	//	System.out.println(randId);
		
		//SELECT文を実行し、ResultSetを取得
		ResultSet rs = pStmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String meaning = rs.getString("meaning");
			String word = rs.getString("word");
			
			Word second = new Word(id, meaning, word);
			secondQ.add(second);
			
		}
	
	}catch(SQLException e) {
		e.printStackTrace();
	
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	return secondQ;
  }
}

