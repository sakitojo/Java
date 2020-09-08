package servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Word;
import model.QuestionHistory;
import model.GetQuestionLogic;
import model.Account;
import model.AnswerCheckLogic;
import model.GetInfoLogic;
import model.QuestionHistoryLogic;
import model.RegisterLogic;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import java.sql.Timestamp;



@WebServlet("/NXTQuestionServlet")
public class NXTQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession key = request.getSession();
		String f_question = (String)key.getAttribute("meaning");
		GetInfoLogic getInfoLogic = new GetInfoLogic();
		List<Account> question = getInfoLogic.execute(f_question);
		request.setAttribute("question", question);
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
