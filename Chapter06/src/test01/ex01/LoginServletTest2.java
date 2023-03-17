package test01.ex01;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet4
 */
@WebServlet("/LoginTest2")
public class LoginServletTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 메소드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 메소드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doHandle 메소드 호출");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); //mimetype지정
		
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("아이디	: "+user_id);
		System.out.println("비밀번호	: "+user_pw);
		
		if(user_id!=null &&(user_id.length()!=0)) {
			if(user_id.equals("admin")) {
				String data = "<html>";
				data += "<body>";
				data += "<font size='12'>관리자로 로그인 하셧습니다!! </font>";
				data += "<br>";
				data += "<br>";
				data += "<input type=button value='회원정보 수정하기'   />";
				data += "<input type=button value='회원정보 삭제하기'   />";
				data += "</html>";
				
				out.print(data);
			}else {
				String data = "<html>";
				data += "<body>";
				data += user_id +" 님!! 로그인 하셨습니다.";
				data += "</body>";
				data += "</html>";
				
				out.print(data);
			}
		} else {
			String data = "<html>";
			data += "<body>";
			data += "아이디를 입력하세요!!!";
			data += "<br>";
			data += "<a href='http://localhost:8090/Chapter06/test01/login.html'> 로그인 창으로 이동 </a>";
			data += "</body>";
			data += "</html>";
			
			out.print(data);
		}
	}
}
