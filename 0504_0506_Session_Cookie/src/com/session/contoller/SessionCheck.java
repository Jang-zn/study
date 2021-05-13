package com.session.contoller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class SessionCheck
 */
@WebServlet("/sessionCheck.do")
public class SessionCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		//request로부터 getSession 실행시 true : 세션 없으면 객체 만들어줌 / false : 세션 없으면 null 반환
		// false 줬으면 분기처리 해줘야됨 (NullPointException)
		if(session!=null) {
		out.write("<html>"
				+ "<body>"
				+ "<p> session ID : "+session.getId()+"</p>"
				+"<p> creation Time : "+session.getCreationTime()+"</p>"
				+"<p>session data : "+session.getAttribute("check")+"</p>"
				+ "</body>"
				+ "</html>");
		}else {
			out.write("<html>"
					+ "<body>"
					+ "<h1 style='color:red'> 세션이 없습니다 </h1>"
					+ "</body>"
					+ "</html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
