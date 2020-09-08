package model;

import dao.ChangeDAO;

public class ChangeLogic {

	public void execute(Account account) {
		ChangeDAO dao = new ChangeDAO();
		dao.update(account);
	}


}
