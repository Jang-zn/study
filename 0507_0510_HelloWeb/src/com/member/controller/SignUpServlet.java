package com.member.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.member.model.service.*;
import com.member.model.vo.*;
/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	MemberService ms = new MemberService();
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m = new Member();
//		request.setCharacterEncoding("utf-8");
		m.setUserId(request.getParameter("userId"));
		m.setPassword(request.getParameter("password"));
		m.setUserName(request.getParameter("userName"));
		m.setAge(Integer.parseInt(request.getParameter("age")));
		m.setEmail(request.getParameter("email"));
		m.setPhone(request.getParameter("phone"));
		m.setAddress(request.getParameter("address"));
		m.setGender(request.getParameter("gender"));
		m.setHobby(String.join(",",request.getParameterValues("hobby"))); //hobby는 String[] getParmeterValues()로 받아야됨
		
		int result = ms.memberSignup(m);
		String msg="";
		String location = "/";
		if(result!=0) {
			msg = "가입에 성공했습니다.";
		}else {
			msg = "가입에 실패했습니다.";
			location="/views/signup.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", location);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
//		Member acceptM = ms.memberSignup(m);
//		if(acceptM!=null) {
//			request.setAttribute("userId", acceptM.getUserId());
//			request.setAttribute("password", acceptM.getPassword());
//			request.getRequestDispatcher("/login").forward(request, response);
//		}else {
//			String msg = "가입에 실패했습니다.";
//			String location = "/";
//			request.setAttribute("msg", msg);
//			request.setAttribute("loc", location);
//			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
