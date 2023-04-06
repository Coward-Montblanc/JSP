package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadAppConfig
 */
@WebServlet(name = "LoadConfig", urlPatterns = { "/LoadConfig" }, loadOnStartup=1)
public class LoadAppConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	private ServletContext context;
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("LoadAppConfig의 init메소드 호출");
		
		//init() 메소드에서srvletContext 객체 얻음
		context = config.getServletContext();
		
		//getInitParameter()메소드로 web.xml의 메뉴 정보를 읽어옴
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		//메뉴정보를 servletContext객체에 바인딩함.
		context.setAttribute("menu_member", menu_member);
		context.setAttribute("menu_order", menu_order);
		context.setAttribute("menu_goods", menu_goods);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String menu_member = (String)context.getAttribute("menu_member");
		String menu_order = (String)context.getAttribute("menu_order");
		String menu_goods = (String)context.getAttribute("menu_goods");
		
		out.print("<html><body>");
		out.print("<table border=1 cellspacing=0><tr>메뉴이름</tr>");
		out.print("<tr><td>" + menu_member +"</td></tr>");
		out.print("<tr><td>" + menu_order +"</td></tr>");
		out.print("<tr><td>" + menu_goods +"</td></tr>");
		out.print("</table></body></html>");
		out.close();
	}

}
