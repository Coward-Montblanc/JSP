package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SetAttribute
 */
@WebServlet("/Set")
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String ctxMsg = "context에 바인딩됩니다.";
		String sesMsg = "session에 바인딩됩니다.";
		String reqMsg = "request에 바인딩됩니다.";
		
		//getServletContext 객체, getSession객체, HttpServletRequest객체로 속성 바인딩
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		ctx.setAttribute("context", ctxMsg);
		session.setAttribute("session", sesMsg);
		request.setAttribute("request", reqMsg);
		
		out.print("바인딩을 수행합니다.");
	}

}
