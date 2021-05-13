package com.dataservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetLogin
 */
@WebServlet("/getlogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 클라이언트가 전송한 데이터는 parameter 라고 함
		// parameter는 HttpServletRequest객체에 저장 (Servlet container가 알아서 함)
		// getParameter()로 가져올 수 있다.
		// request.getParameter("key값") -> key값은 input tag name값 : '무조건' String으로 반환해줌
		// -> 전송받은 Data의 Parsing 필요
		//★ 컨텍스트 다시 로드했다고 하면 서버 리스타트 안해줘도 됨 / 서블릿 추가는 껐다켜야됨
		String id = request.getParameter("userId");
		String pw = request.getParameter("pw");
		System.out.println("id : "+id+" "+"pw : "+pw);
		
		//응답페이지 구성 -> 문자열(코드, 데이터)을 스트림으로 전송해줌 (writer - write)
		//setContentType()으로 MIME type(text/html, text/css, application/javascript media, image..)+인코딩 설정
		request.setCharacterEncoding("utf-8");
		//setCharacterEncoding은 기본적으로 모든 요청에 대해서 세팅해놓는다.
		response.setContentType("text/html; charset=utf-8");
		//응답하기 위한 스트림 - getWriter() : 문자열 / getOutputStream() : file => '서버' 기준으로 생각 (서버에서 내보냄)
		//getWriter()는 PrintWriter 객체를 반환
		PrintWriter out = response.getWriter();
		out.write("<html><body><h1>입력한 아이디는 "+id+" 비밀번호는 "+pw+"</h1></body></html>");
		//근데 jsp 쓰면 크게 쓸일 없을거야
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write("Post방식 전송 - doPost 호출");
		//post방식은 setCharacterEncoding으로 잡아줘야 한글 표시 가능 (byte단위 전송이라서 불러올때 인코딩 안잡아주면 깨짐)
		
		String id = request.getParameter("userId");
		String pw = request.getParameter("pw");
		System.out.println("id : "+id+" "+"pw : "+pw);
		//post로 불러오건 get으로 불러오건 중요한건 전송시점이지 서버에 도착하고부터는 중요하지 않음
		//전송된 이후에는 같은 로직이라서 서버 내에서는 걍 doGet으로 보내버림 (단순화(default가 get이니까)-> 개발시 로직은 get에만 작성하면 됨) 
		doGet(request, response);
		
	}

}
