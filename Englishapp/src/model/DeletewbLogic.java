package model;
import dao.DeletewbDAO;
import dao.MakeWordBookDAO;
import model.Word;

public class DeletewbLogic {

	public void execute(String user, String word) {
		DeletewbDAO dao = new DeletewbDAO();
		dao.delete(user, word);
	}
	
	
}
