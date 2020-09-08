package model;

public class Account {
	private String name;
	private String username;
	private String pass;
	private String gender;
	private String tel;
	private String zip;
	private String address1;
	private String address2;
	private String email;
	private String age;
	
	@Override
	public String toString() {
		return "Account [name=" + name + ", username=" + username + ", pass=" + pass + ", gender=" + gender + ", tel="
				+ tel + ", zip=" + zip + ", address1=" + address1 + ", address2=" + address2 + ", email=" + email
				+ ", age=" + age + "]";
	}

	public Account() {}
	
	public Account(String name, String username, String pass) {
		this.name = name;
		this.username = username;
		this.pass = pass;
	}
	
	public Account(String name, String pass, String gender,
			String tel,String zip, String address1, String address2, String email, String age) {
		this.name = name;
		this.pass = pass;
		this.gender = gender;
		this.tel = tel;
		this.zip = zip;
		this.address1 = address1;
		this.address2 = address2;
		this.email = email;
		this.age = age;
	}
	
	public Account(String name, String username, String pass, String gender, String tel,
			 String zip, String address1, String address2, String email, String age) {
		this.name = name;
		this.username = username;
		this.pass = pass;
		this.gender = gender;
		this.tel = tel;
		this.zip = zip;
		this.address1 = address1;
		this.address2 = address2;
		this.email = email;
		this.age = age;
	}
	
	/*@Override
	public String toString() {
		return "Account [name=" + name + ", username=" + username + ", pass=" + pass + ", gender=" + gender + ", tel="
				+ tel + ", address=" + address + ", email=" + email + ", age=" + age + "]";
	}*/

	public Account(String username) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getName() { return name; }
	public String getUserName() { return username; }
	public String getPass() { return pass; }
	public String getGender() { return gender; }
	public String getTel() { return tel; }
	public String getZip() { return zip; }
	public String getAddress1() { return address1; }
	public String getAddress2() { return address2; }
	public String getEmail() { return email; }
	public String getAge() { return age; }

	public void setUserName(String string) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public String Account(String username) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	
}
