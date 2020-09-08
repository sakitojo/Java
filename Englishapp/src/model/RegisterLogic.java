package model;
import dao.RegisterDAO;

public class RegisterLogic {
	public void execute(Account account) {
		RegisterDAO dao = new RegisterDAO();
		dao.create(account);
	}


}
