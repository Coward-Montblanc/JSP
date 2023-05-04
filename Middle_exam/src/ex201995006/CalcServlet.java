package ex201995006;

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
@WebServlet("/Calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//getParameter메소드로 전송된 회원정보 가져오기
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String op = request.getParameter("op");
		int result = 0;
		if (op.equals("+")) {
			result = Integer.parseInt(num1) + Integer.parseInt(num2);
		} else if (op.equals("-")) {
			result = Integer.parseInt(num1) - Integer.parseInt(num2);
		} else if (op.equals("*")) {
			result = Integer.parseInt(num1) * Integer.parseInt(num2);
		} else if (op.equals("/")) {
			result = Integer.parseInt(num1) / Integer.parseInt(num2);
		}
		String data = "<html><body><h1>중간고사 1번 강석현 - 결과</h1>";
		data += num1 + op + num2 + "=";
		data += result;
		out.print(data);
		response.addHeader("Refresh", "3; url = result");
	}

}
