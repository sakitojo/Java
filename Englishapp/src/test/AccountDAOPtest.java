package test;

import model.Account;
import model.Login;
import dao.AccountDAO;

public class AccountDAOPtest {
	public static void main(String[] args) {
		testFindByLogin1();
		testFindByLogin2();
	}
	public static void testFindByLogin1() {
		Login login = new Login("minato", "1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
	
		if(result != null && 
				result.getUserName().equals("minato") &&
				result.getPass().equals("1234") &&
				result.getEmail().equals("minato@sukkiri.com") &&
				result.getName().equals("湊　雄輔")) {
			System.out.println("testfindbylogin1成功しました");
		}else {
			System.out.println("1 失敗しました");
		}
	}
	public static void testFindByLogin2() {
		Login login = new Login("minato","12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if(result == null) {
			System.out.println("2 成功しました");
		}else {
			System.out.println("2 失敗しました");
		}
	}

	
}
