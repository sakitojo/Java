package model;
import java.util.Random;
import dao.QuestionDAO;
import model.Word;
import dao.COUNTDAO;
	
public class GetQuestionLogic {
	
	public Word execute() {
		COUNTDAO daoct = new COUNTDAO();

	Random rand = new Random();  //乱数を生成
	int number = rand.nextInt(daoct.countrecord()-1)+1;
		
	QuestionDAO dao = new QuestionDAO(); 
		
	return dao.findById(number);
	}
	

}

