package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Word;
import dao.DeletewbDAO;
import model.CreatewbLogic;
import model.DeletewbLogic;


@WebServlet("/DeletewbServlet")
public class DeletewbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher =
				 request.getRequestDispatcher("Deletewb.jsp");
		 dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String word = request.getParameter("word");
		String username = request.getParameter("username");
	
	//	Word newword = new Word(word, username);
		 
		 DeletewbLogic deletewbLogic = new DeletewbLogic();
		 deletewbLogic.execute(username, word);
		 
		 System.out.println(username + "さんの" + word + "を削除しました");
		 
		
		 RequestDispatcher dispatcher =
				 request.getRequestDispatcher("ChoiceWordBook.jsp");
		 dispatcher.forward(request, response);
		
		
		
	}

}








