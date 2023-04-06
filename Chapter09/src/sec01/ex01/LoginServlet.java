package sec01.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//getParameter메소드로 전송된 회원정보 가져오기
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		//hidden 태그로 전송된 값 가져오기
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		String data = "안녕하세요!<br> " + user_id + "님 환영합니다.<br><br>";
		data += "<html><body>";
		data += "아이디" + user_id + "<br>";
		data += "비밀번호" + user_pw + "<br>";
		data += "주소" + user_address + "<br>";
		data += "이메일" + user_email + "<br>";
		data += "휴대전화" + user_hp + "<br>";
		data += "</body></html>";
		out.print(data);
	}

}
