package model;
import java.io.Serializable;

public class Login implements Serializable{
	private String username;
	private String pass;
	
	public Login() {}
	public Login(String username, String pass) {
		this.username = username;
		this.pass = pass;
	}
	public String getUserName() { return username; }
	public String getPass() { return pass; }
	
	}

