package com.dataservlet.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class DispatcherTestServlet
 */
@WebServlet("/dispatcherTest.do")
public class DispatcherTestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5879691063724614449L;
	
    public DispatcherTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		
		
		String name = request.getParameter("name");
		System.out.println(name);
		System.out.println("dispatcherTest.do");
		
		//request의 RequestDispatcher객체로 다른 서블릿 호출
		//request.getRequestDispatcher("호출할 서블릿 / jsp주소, 경로")
		response.setContentType("text/html; charset=EUC-KR");
		request.setCharacterEncoding("EUC-KR"); 
		RequestDispatcher rd = request.getRequestDispatcher("testPerson.do");
		rd.forward(request, response);
		//아 시발 왜깨지냐고 ㅋㅋㅋㅋㅋ
		//이거 새로고침할때마다 계속 request 객체 갖다가 쓰니까 재전송할때 안쓸려면 redirect로 줘야됨 (ex 글 등록 뭐 그런거)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
