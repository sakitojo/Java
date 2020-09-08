package model;
import java.io.Serializable;

public class Word implements Serializable{
	private String meaning;
	private String word;
	private int id;
	private String username;

	
	/*public Word(String meaning) {
		this.meaning = meaning;
	}*/
	
	public  Word(int id, String meaning) {
		this.id = id;
		this.meaning = meaning;
	}
	
	public Word(int id, String meaning, String word) {
		this.id = id;
		this.meaning = meaning;
		this.word = word;
	}
	
	public Word(String word, String meaning) {
		this.word = word;
		this.meaning = meaning;
	}
	
	public Word(String word) {
		this.word = word;
	}
	
	public Word(String meaning, String word, String username) {
		this.meaning = meaning;
		this.word = word;
		this.username = username;
	}
	
	public Word(int id, String meaning, String word, String username) {
		this.id = id;
		this.meaning = meaning;
		this.word = word;
		this.username = username;
	}

	
	@Override
	public String toString() {
		return "Word [meaning=" + meaning + ", word=" + word + ", id=" + id + "]";
	}


	public String getMeaning() {
		return meaning;
	}


	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}


	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	}


