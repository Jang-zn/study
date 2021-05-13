package com.member.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.member.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
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
		//id/pw받아서 db에 있는지 확인 / 맞으면 로그인 틀리면 다시
		String id = request.getParameter("userId");
		String pw = request.getParameter("password");
		String saveId = request.getParameter("saveId");
		Member m = new MemberService().loginCheck(id, pw);
		System.out.println(saveId);
		//saveId 값에 따라 체크유무 확인 가능 : on/null
		if(saveId!=null) {
			//on이면 쿠키에 아이디값 저장
			Cookie cookie = new Cookie("saveId", id);
			cookie.setMaxAge(7*24*60*60); //단위 : 초
			response.addCookie(cookie);
		}else {
			Cookie[] cookies = request.getCookies();
			if(cookies!=null) {
				for(Cookie c : cookies ) {
					if(c.getName().equals("saveId")) {
						c.setMaxAge(0);
						response.addCookie(c);
					}
				}
			}
			//위처럼 안하고 그냥 새로 만들고 키값만 같게 해준다음 setMaxAge(0) 하고 추가해줘도 됨
			//Cookie c = new Cookie("saveId", "");
			// c.setMaxAge(0);
			//response.addCookie(c);
			
			
		}
		if(m!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", m);
			response.sendRedirect(request.getContextPath());
			
		}else {
			String msg = "아이디 또는 비밀번호가 일치하지 않습니다";
			String location = "/";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", location);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
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
