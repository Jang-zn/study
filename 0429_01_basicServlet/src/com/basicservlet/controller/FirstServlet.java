package com.basicservlet.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

//서블릿 규약 준수하여 작성
// 1. javax.servlet.http.HttpServlet 클래스 상속 -> serial 만들어줌
// 2. client 요청을 받아서 처리하는 메소드를 재정의 해준다(override)
//  - doGet(){}
//  - doPost(){}
// get / post 전송방식에 따른 처리 로직 구현하면 서블릿 컨테이너가 맞춰서 실행한다.
// * 2개의 Exception 처리 -> ServletException / IOException
// 


public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = -7886240222416180979L;

	public FirstServlet() {
	
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		//매개변수에 들어가는 두 객체만 알면 끝. 어려울거 없음
		System.out.println("firstServlet");
		// 응답페이지 작성
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<h1>응답함</h1>");
		out.write("</body>");
		out.write("</html>");
	}
	
}
