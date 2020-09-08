package model;

import dao.QuestionHistoryDAO;

public class QuestionHistoryLogic {
	public void execute(QuestionHistory questionhistory) {
		
		QuestionHistoryDAO dao = new QuestionHistoryDAO();
		dao.create(questionhistory);
		
	}

	
	
	
	
}
