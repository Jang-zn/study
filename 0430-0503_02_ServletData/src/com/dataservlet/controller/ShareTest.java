package com.dataservlet.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class ShareTest
 */
@WebServlet("/share.do")
public class ShareTest extends HttpServlet {
	private static final long serialVersionUID = -2704325203134593050L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ShareTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//WAS Data 공유 객체
		//1. ServletConstext : 서버 닫을때까지 계속 있음
		//2. HttpSession : 생성후 Timeout 도달까지 있음 (서버에서 없애야 사라짐)
		//3. ServletRequest : 요청 - 응답까지 있음
		
		//1. Context객체 생성
		ServletContext context = request.getServletContext();
		//2. Session객체 생성
		HttpSession session = request.getSession();
		
		//setAttribute(키(string),밸류(object)) 형태로 데이터 저장 / getAttribute(키)로 불러옴 / removeAttribute(키)로 지움
		context.setAttribute("context", "ContextData");
		session.setAttribute("session", "SessionData");
		request.setAttribute("request", "RequestData");
		//object->string으로 down casting할때는 강제형변환 필요 
		String cv = (String)context.getAttribute("context");
		System.out.println(cv);
		String sv = (String)session.getAttribute("session");
		System.out.println(sv);
		String rv = (String)request.getAttribute("request");
		System.out.println(rv);
		//data 변경 / 삭제 : 변경은 같은 키값으로 재저장 / 삭제는 removeAttribute(키) 이용
//		request.setAttribute("request", "2RequestData2");
//		rv = (String)request.getAttribute("request");
//		System.out.println(rv);
//		request.removeAttribute("request");
//		System.out.println(request.getAttribute("request"));
		//없는 키값을 넣으면 null 나옴
		
		//페이지 이동시의 객체활용 - servlet
		//1. requestDispatcher 이용
//		RequestDispatcher rd = request.getRequestDispatcher("useData.do");
//		rd.forward(request, response);
		
		
		//2. sendRedirect 이용
		response.sendRedirect("useData.do");
		//request에 저장된 값이 사라지고 null 출력 (응답한번 하고 새로 생긴 request 객체라서(주소가 바뀜))
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
