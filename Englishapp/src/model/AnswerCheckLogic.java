package model;

import java.util.Random;
import dao.AnswerCheckDAO;
import model.Word;
import dao.COUNTDAO;
	

public class AnswerCheckLogic {
	public Word execute() {
		COUNTDAO daoct = new COUNTDAO();
		
	Random rand = new Random();  //乱数を生成
	int number = rand.nextInt(daoct.countrecord()-1)+1;
		
	AnswerCheckDAO dao = new AnswerCheckDAO(); 
		
	return dao.AnswerCheck(number);
		
		
      }
		
	}

