package test;

import model.Login;
import model.Loginlogic;

public class LoginLogicTest {
	public static void main(String[]args) {
		test1();
		test2();
	}
	public static void test1() {
		Login login = new Login("minato", "1234");
		Loginlogic bo = new Loginlogic();
		boolean result = bo.execute(login);
		if(result) {
			System.out.println("test1成功");
		}else {
			System.out.println("test1失敗");
		}
	}
	public static void test2() {
		Login login = new Login("minato", "12345");
		Loginlogic bo = new Loginlogic();
		boolean result = bo.execute(login);
		if(!result) {
			System.out.println("test2成功");
		}else {
			System.out.println("test2失敗");
		}
	}


}
