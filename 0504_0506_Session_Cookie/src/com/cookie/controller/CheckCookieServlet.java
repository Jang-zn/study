package com.cookie.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class CheckCookieServlet
 */
@WebServlet("/checkcookie.do")
public class CheckCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//저장된 쿠키 가져오기
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html>"
				+ "<body>"
				+ "<ul>");
		//getName / getValue로 가져올 수 있음
		for(Cookie c : cookies) {
			System.out.println("key : "+c.getName()+"   value : "+c.getValue());
			out.write("<li>"+"key : "+c.getName()+"   value : "+c.getValue()+"</li>");
		}
		out.write("</ul>"
				+ "<h3><a href='deleteCookie.do'>쿠키지우기</a></h3>"
					+ "</body>"
					+ "</html>");
		//cookie는 주로 최근에 조회상품 이런걸 db의 pk값으로 저장해서 불러오는데 씀
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
