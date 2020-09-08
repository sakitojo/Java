package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.RegisterLogic;
import dao.RegisterDAO;


@WebServlet("/RegisterActionServlet")
public class RegisterActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegisterActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		String zip = request.getParameter("zip");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		
		 Account account = new Account(name, username, pass, gender, tel, zip,  address1, address2, email, age);
		 
		 
		 RegisterLogic registerLogic = new RegisterLogic();
		 registerLogic.execute(account);
		
		 
		 RequestDispatcher dispatcher =
				 request.getRequestDispatcher("Registerok.jsp");
		 dispatcher.forward(request, response);
		 
}
}
