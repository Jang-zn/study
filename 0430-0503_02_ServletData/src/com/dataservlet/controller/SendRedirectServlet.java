package com.dataservlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendRedirectServlet
 */
@WebServlet("/redirectTest.do")
public class SendRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("sendRedirect");
		
		
		//sendRedirect("주소(url)");
		response.sendRedirect("testPerson.do");
		//redirect로 호출시 request 객체가 새로 생성돼서 기존 객체의 parameter가 사라지게 된다.
		//request 객체에는 setAttribute(키,밸류)해서 값을 집어넣을수 있다.
		//getAttribute(키)로 가져올 수 있음
		//요런 객체가 ServletContext / ServletRequest / HttpSession 세개 있음 (생명주기에 따라 사용처가 다름)
		// request : 용답이 있을때까지 / Context : 서버 닫기 전까지  
		// HttpSession : Session 설정시간(TimeOut) 다될때까지(서버가 없애기 전까지) ID값을 가진 객체를 부여함.
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
