package model;
import java.util.List;

import dao.AccountDAO;


public class GetInfoLogic {
	public List<Account> execute(String changeId) {
		AccountDAO dao = new AccountDAO();
		List<Account> changeInfo = dao.change(changeId);
		return changeInfo;
	}

}
