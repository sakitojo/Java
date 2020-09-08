package dao;

import java.sql.*;
import model.Word;


public class AnswerCheckDAO {
	//DBに接続する情報
	private final String JDBC_URL=
			"jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	String drv = "com.mysql.cj.jdbc.Driver";
	
	public Word AnswerCheck(int randId){
    //宣言＆初期化
	Word wordcheck = null;	
	
	try{
		Class.forName(drv);
		Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		
		System.out.println("DB接続完了");
		
		//SELECT文の準備
		String sql = "SELECT word FROM word where id = ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		
		//INSERT文の？に使用する値を設定し、SQL文を完成
		pStmt.setInt(1, randId);
		
		//SELECT文を実行し、ResultSetを取得
		ResultSet rs = pStmt.executeQuery();
		
		while(rs.next()) {
			String word = rs.getString("word");
			
			//コンストラクタWordに入れている
			wordcheck = new Word(word);
		}
	
	}catch(SQLException e) {
		e.printStackTrace();
	
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	return wordcheck;
  }

}
	

