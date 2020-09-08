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
import model.CreatewbLogic;
import dao.MakeWordBookDAO;


@WebServlet("/WordBookServlet")
public class WordBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher =
				 request.getRequestDispatcher("MakeWordbook.jsp");
		 dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String word = request.getParameter("word");
		String meaning = request.getParameter("meaning");
		String username = request.getParameter("username");
	
		Word newword = new Word(word, meaning, username);
		
		HttpSession session1 = request.getSession();
		 session1.setAttribute("words", newword);
		 
		 if(username != "") {
		 
		 CreatewbLogic createwbLogic = new CreatewbLogic();
		 createwbLogic.execute(newword);
		 
		 System.out.println("新しい単語を追加しました");
		 }
		 
		 System.out.println("会員ではないので登録できません");
		 
		 RequestDispatcher dispatcher =
				 request.getRequestDispatcher("ChoiceWordBook.jsp");
		 dispatcher.forward(request, response);
		 
	}
	
	
	

}
