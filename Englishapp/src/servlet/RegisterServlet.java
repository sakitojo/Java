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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher =
				 request.getRequestDispatcher("http://localhost:8080/Englishapp/regiii.jsp");
		 dispatcher.forward(request, response);
	}

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
		String address2= request.getParameter("address2");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		
		 if(gender.equals("男性")){
			 gender = "男性";
		 } else{
	         gender = "女性";
	        }
	
		 
		Account account = 
				new Account(name, username, pass, gender,
				            tel, zip, address1, address2, email, age);  
		
	
		 HttpSession session1 = request.getSession();
		 session1.setAttribute("account", account);
		 
		 System.out.println("セッションスコープに新規アカウントを保存");
		 
		 
		 RequestDispatcher dispatcher =
				 request.getRequestDispatcher("http://localhost:8080/Englishapp/RegisterActionServlet");
		 dispatcher.forward(request, response);
   	}
       		
       	
	 }
		


