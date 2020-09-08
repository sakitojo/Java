package model;

import java.sql.Timestamp;

public class QuestionHistory {
	private String username;
	private String meaning;
	private Timestamp date;
	private String answer;

	
	@Override
	public String toString() {
		return "QuestionHistory [username=" + username + ", meaning=" + meaning + ", date=" + date + ", answer="
				+ answer + "]";
	}


	public QuestionHistory(String username, String meaning, Timestamp date) {
		super();
		this.username = username;
		this.meaning = meaning;
		this.date = date;
	}
	
	public QuestionHistory(String username, String meaning, Timestamp date, String answer) {
		super();
		this.username = username;
		this.meaning = meaning;
		this.date = date;
		this.answer = answer;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getMeaning() {
		return meaning;
	}


	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}


	public Timestamp getDate() {
		return date;
	}


	public void setDate(Timestamp date) {
		this.date = date;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
	
	
	
	
	

}
