package model;
import dao.MakeWordBookDAO;
import dao.RegisterDAO;
import model.Word;

public class CreatewbLogic {

		public void execute(Word word) {
			MakeWordBookDAO dao = new MakeWordBookDAO();
			dao.create(word);
		}

}
