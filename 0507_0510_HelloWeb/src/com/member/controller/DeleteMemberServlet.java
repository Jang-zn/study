package com.member.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.member.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class DeleteMemberServlet
 */
@WebServlet("/delete.do")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = ((Member)session.getAttribute("login")).getUserId();
		int result = new MemberService().deleteMember(userId);
		String msg = "";
		String location = "";
		if(result>0) {
			msg = "정상적으로 탈퇴되었습니다.";
			location = "/logout";
			
		}else {
			msg = "탈퇴에 실패했습니다 다시 시도해주세요";
			location = "/views/memberView.do?userId="+userId;

		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", location);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
