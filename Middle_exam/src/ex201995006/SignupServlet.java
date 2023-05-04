package ex201995006;

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
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//getParameter메소드로 전송된 회원정보 가져오기
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String user_name = request.getParameter("user_name");
		HttpSession session = request.getSession();
		
		
		
		if (session.isNew()) {
			if(user_id!=null) {
				session.setAttribute("user_id", user_id);
				session.setAttribute("user_name", user_name);
				String data = "<html><body><h1>중간고사 2번 강석현 - 결과</h1>";
				data += "User ID: " + user_id + "<br>";
				data += "Password: " + user_pwd + "<br>";
				data += "Name: " + user_name + "<br>";
				data += "</body></html>";
				out.print(data);
				out.println("<a href='Signup'>로그인 상태 확인</a>");
			} else {
				out.println("<a href='signup.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		} else {
			user_id = (String) session.getAttribute("user_id");
			user_name = (String) session.getAttribute("user_name");
			if(user_id != null && user_id.length() !=0) {
				out.print("<h1>안녕하세요 " + user_name + "님!!!</h1>");
				response.addHeader("Refresh", "3; url = result");
			} else {
				out.println("<a href='signup.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}
		
	}

}
