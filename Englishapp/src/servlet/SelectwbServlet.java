package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DisplayAnswer;
import model.DisplayAnswerLogic;
import model.Word;
import model.SelectwbLogic;


@WebServlet("/SelectwbServlet")
public class SelectwbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession key = request.getSession();
		String user = (String)key.getAttribute("username");
	
	System.out.println(user);
		
		SelectwbLogic selectwblogic = new SelectwbLogic();
		List<Word> myword = selectwblogic.execute(user);
		request.setAttribute("myword", myword);
		
		
		RequestDispatcher dp =
				request.getRequestDispatcher("/Showwb.jsp");
		dp.forward(request, response);
		
		
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
