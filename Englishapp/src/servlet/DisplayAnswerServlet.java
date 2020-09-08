package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DisplayAnswer;
import model.DisplayAnswerLogic;

@WebServlet("/DisplayAnswerServlet")
public class DisplayAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayAnswerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションを作って、
		//セッションの中にユーザー情報のusernameをもってきて、
		//Stringのuserを使ってLogicでQueryする
		//Query結果をリストに格納
		HttpSession key = request.getSession();
		String user = (String) key.getAttribute("username");
		DisplayAnswerLogic displayanswerlogic = new DisplayAnswerLogic();
		List<DisplayAnswer> disp = displayanswerlogic.execute(user);
		request.setAttribute("disp", disp);

		RequestDispatcher dp = request.getRequestDispatcher("/Loginok.jsp");
		dp.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
