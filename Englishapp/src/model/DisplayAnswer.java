package model;

import java.sql.Timestamp;

public class DisplayAnswer {
	private String username;
	private String meaning;
	private Timestamp date;
	private String answer;
	private String word;
	
	@Override
	public String toString() {
		return "DisplayAnswer [username=" + username + ", meaning=" + meaning + ", date=" + date + ", answer=" + answer
				+ ", word=" + word + "]";
	}

	public DisplayAnswer(String username, String meaning, Timestamp date, String answer, String word) {
		super();
		this.username = username;
		this.meaning = meaning;
		this.date = date;
		this.answer = answer;
		this.word = word;
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

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	

}
