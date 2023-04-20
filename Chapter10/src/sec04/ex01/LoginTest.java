package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login2")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//getParameter메소드로 전송된 회원정보 가져오기
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pwd);
		if(session.isNew()) {
			//세션에 바인딩시 미리 HttpSessionBindingListener를 구현한 valueBound(); 메서드 호출
			session.setAttribute("loginUser", loginUser);
		}
		
		String data = "<html><head>";
		data += "<script type='text/javascript'>";
		data += "setTimeout('history.go(0);', 5000)";
		data += "</script></head>";
		data += "<body>";
		data += "아이디 :" + loginUser.user_id + "<br>";
		data += "총 접속자수 :" + LoginImpl.total_user + "<br>";
		data += "</body></html>";
		out.print(data);
	}

}
