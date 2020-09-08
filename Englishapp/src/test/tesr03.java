package test;

import java.util.Random;
import dao.QuestionDAO;
import model.Word;
import dao.COUNTDAO;
	
public class tesr03{
	public static void main(String[] args) {
	
		COUNTDAO daoct = new COUNTDAO();
		
	Random rand = new Random();
	int number = rand.nextInt(daoct.countrecord()-1)+1;
		
	QuestionDAO dao = new QuestionDAO(); 
		
	System.out.println(dao.findById(number));
		
	}
      }
		
	
