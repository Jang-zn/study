package com.basicservlet.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
//@Annotation으로 servlet 등록
//@WebServlet("/주소값") 으로 표기해준다.
//Servlet-name 등록도 가능 (name="", urlPatterns={"/주소"})
//한개 서블릿에 여러 주소 연결 가능
@WebServlet(name="anno",urlPatterns= {"/anno"})



public class AnnoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 4734249908953990659L;

	public AnnoServlet() {
	
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("anno");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html><body> <h2>어노테이션 연결</h2>   </body></html>");
		
	}

}
