package com.session.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/sessionTest.do")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session은 request의 getSession()으로 생성되는 객체 -> 데이터는 서버에 저장
		// 생성시 클라이언트에게 식별 JSession ID값을 전송
		// 클라이언트는 접속시 전송받은 JSession ID를 자동으로 갖다 씀
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(10); //객체 유지시간 단위 : 초
		session.setAttribute("check", "check Data");
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
