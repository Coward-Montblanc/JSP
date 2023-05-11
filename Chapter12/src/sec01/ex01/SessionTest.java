package sec01.ex01;

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
@WebServlet("/session1")
public class SessionTest extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("name", "강석현");
		
		String data = "<html><body>";
		data += "<h1>세션에 이름을 바인딩합니다.</h1>";
		data += "<a href='/Chapter12/session/session1.jsp'>첫번째 페이지로 이동</a>";
		//     /Chapter12/ < 이거는 WebContent를 의미한다.
		data += "</body></html>";
		out.print(data);
	}

}
