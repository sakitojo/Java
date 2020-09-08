package model;

import java.util.List;

import dao.DisplayAnswerDAO;

public class DisplayAnswerLogic {
	
	public List<DisplayAnswer> execute(String user) {
		DisplayAnswerDAO dao = new DisplayAnswerDAO();
		
		List<DisplayAnswer> dispanswer = dao.findBy(user);
		return dispanswer;
	}
	


}
