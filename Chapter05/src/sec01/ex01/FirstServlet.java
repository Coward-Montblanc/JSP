package sec01.ex01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 메소드 호출");
		//시작할때 한번만
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet 메소드 호출");
		//새로고침시 얘가 나옴
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 메소드 호출");
	}
	
	
}
