package model;
import dao.SelectWordBookDAO;
import model.Word;
import java.util.List;

public class SelectwbLogic {

	public List<Word> execute(String user) {
		SelectWordBookDAO dao = new SelectWordBookDAO();
		
		List<Word> mylist = dao.findBy(user);
		return mylist;
	}

}
