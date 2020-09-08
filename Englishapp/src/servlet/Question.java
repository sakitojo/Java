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
import model.GetSecondQLogic;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import java.sql.Timestamp;


@WebServlet("/wordcontroller") 
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	//Logicで問題をランダムに取得
	GetQuestionLogic getQuestionLogic = new GetQuestionLogic();
	Word word = getQuestionLogic.execute();
	
		request.setAttribute("word", word); //リクエストスコープに単語を保存
	
		String wordcheck = word.getWord(); //Word(id,meaning,word)からwordを取得して、
		                                   //wordcheckに格納
		
		HttpSession session = request.getSession();  //セッションスコープの取得
		session.setAttribute("wordcheck",wordcheck); //"wordcheck"という名前でwordcheckを保存
		

		//追加部分！！！！！！！！！
	//HttpSession key = request.getSession();
	String words = (String)session.getAttribute("wordcheck");
	GetSecondQLogic getsecondQLogic = new GetSecondQLogic();
	List<Word> second = getsecondQLogic.execute(words);
	request.setAttribute("second", second);		

		
		//問題画面を表示
		RequestDispatcher dispatcher = 
	    		request.getRequestDispatcher("/begginer.jsp");
		dispatcher.forward(request, response);
		
	}
	
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	  
		//セッションスコープからwordcheck(答えの単語)を取得
		HttpSession session = request.getSession();
		String word = (String)session.getAttribute("wordcheck");
		
		//リクエストパラメータの取得
		//答案と問題を取得している
		request.setCharacterEncoding("UTF-8");
		String answer = request.getParameter("answer"); 
		String meaning = request.getParameter("meaning");
		String username = request.getParameter("username");
		String hints = request.getParameter("hint");
		
		Timestamp date = null;
		QuestionHistory questionhistory = new QuestionHistory(username, meaning, date, answer);
		
		//会員の場合は回答履歴をDBに保存、未会員は保存しない
		if(username != "") {
			
			//テーブルanswer_hsに登録するロジック
			QuestionHistoryLogic questionhistorylogic = new QuestionHistoryLogic();
			 questionhistorylogic.execute(questionhistory);
			 
			 System.out.println("回答をDBに登録しました");
		}
	    
		
		//正解、不正解での分岐
		if(answer.equals(word)) {
		
		System.out.println("正解");
		
		//リクエストスコープに正解メッセージを保存
		request.setAttribute("Cong", "おめでとう、正解です！");
		
		
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("begginer.jsp");
		dispatcher.forward(request, response);
			
			}else {
				
			//リクエストスコープに間違いメッセージを保存	
				request.setAttribute("Mistake", "残念、不正解です。");
				request.setAttribute("Meaning", meaning);
				
				request.setAttribute("Hint",hints);
				request.setAttribute("Kaitou", word);
				
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("begginer.jsp");
			dispatcher.forward(request, response);	
			}
		}
		
  }
  

 
