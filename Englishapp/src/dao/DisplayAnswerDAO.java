package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.DisplayAnswer;
import model.QuestionHistory;
import model.Word;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DisplayAnswerDAO {
	private final String JDBC_URL=
			"jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	private final String drv = "com.mysql.cj.jdbc.Driver";

	
	public List<DisplayAnswer> findBy(String user){
	List<DisplayAnswer> displist = new ArrayList<>();
		
		try{
			Class.forName(drv);
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			
			//SELECT文の準備
			String sql = "SELECT * FROM answer_hs join word using (meaning) where USERNAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, user);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String username = rs.getString("username");
				String meaning = rs.getString("meaning");
				Timestamp date = rs.getTimestamp("date");
				String answer = rs.getString("answer");
				String word = rs.getString("word");
				
				//コンストラクタDisplayAnswerに入れている
			DisplayAnswer dispanswer = new DisplayAnswer(username, meaning, date, answer, word);
				displist.add(dispanswer);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return displist;
	  }

	}
