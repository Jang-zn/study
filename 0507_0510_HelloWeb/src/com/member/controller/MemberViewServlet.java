package com.member.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.member.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class MemberView
 */
@WebServlet("/memberView.do")
public class MemberViewServlet extends HttpServlet {
	MemberService ms = new MemberService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//Member m = (Member)session.getAttribute("login");
		//세션에서 가져와도 되는데 프론트에서 쿼리스트링으로 가져오는걸로 연습해라..
		String userId = request.getParameter("userId");
		Member m = ms.selectMemberId(userId);
		request.setAttribute("Member", m);
		request.getRequestDispatcher("/views/memberView.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
