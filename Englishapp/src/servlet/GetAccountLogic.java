package servlet;
import dao.AccountDAO;
import model.Account;
import model.Login;


public class GetAccountLogic {

	public Account execute(Login login) {
		AccountDAO dao = new AccountDAO();
		
		return dao.findByLogin(login);
	}
	

}
