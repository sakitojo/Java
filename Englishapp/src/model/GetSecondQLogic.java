package model;
import java.util.List;
import java.util.Random;
import dao.QuestionDAO;
import model.Word;
import dao.COUNTDAO;
import dao.QuestionDAO;

public class GetSecondQLogic {
	public List<Word> execute(String words) {
		
		COUNTDAO daoct = new COUNTDAO();
		Random rand = new Random();  //乱数を生成
		//int number = 0;
		
		QuestionDAO dao = new QuestionDAO();
		List<Word> changeInfo = dao.SecondQ(words);
		return changeInfo;
	}

}

