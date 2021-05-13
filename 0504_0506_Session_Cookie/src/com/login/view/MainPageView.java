package com.login.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/mainPage.do")
public class MainPageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String html ="<html>"
				+ "<head>"
				+ "<style>"
				+ "ul>li{display:inline-block;margin-right:20px;font-size:25px;font-weight:bolder;}"
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+ "<h1> 홈페이지에 오신것을 환영함</h1>";
		HttpSession session=request.getSession();
		if(session!=null&&session.getAttribute("login")!=null) {
			html+="<ul>"
					+ "<li>메인화면</li>"
					+ "<li>갤러리</li>"
					+ "<li>게시판</li>"
					+ "</ul>"
					+ "<button onclick='location.replace(\""+request.getContextPath()+"/logout.do\")'>로그아웃</button>";
		}else {
			html+="<form action='login.do' method='post'>"
					+ "<input type='text' name='userId'><br>"
					+ "<input type='password' name='userPw'><br>"
					+ "<input type='submit' value='로그인'></form>";
		}
		html+="</body></html>";
		
		response.getWriter().write(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
