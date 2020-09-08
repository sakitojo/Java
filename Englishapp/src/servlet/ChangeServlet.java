package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.ChangeLogic;
import model.GetInfoLogic;



@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//セッションを作って、
		//セッションの中にログイン情報のusernameをもってきて、
		//StringのchangedIdを使ってLogicでQueryする
		//Query結果をリストに格納
		HttpSession key = request.getSession();
		String changedId = (String)key.getAttribute("username");
		GetInfoLogic getInfoLogic = new GetInfoLogic();
		List<Account> Info = getInfoLogic.execute(changedId);
		request.setAttribute("Info", Info);
		
		
		RequestDispatcher dp =
				request.getRequestDispatcher("/change.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		String zip = request.getParameter("zip");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		
		 if(gender.equals("男性")){
			 gender = "男性";
		 } else{
	         gender = "女性";
	        }
		
		 Account account = new Account(username, name, pass, gender, tel, zip, address1, address2, email, age);
				 
				 ChangeLogic changeLogic = new ChangeLogic();
				 changeLogic.execute(account);
				 
				 RequestDispatcher dispatcher =
						 request.getRequestDispatcher("/changeok.jsp");
				 dispatcher.forward(request, response);
		
	}

}
