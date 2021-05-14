package com.member.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.member.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class UpdatePasswordEndServlet
 */
@WebServlet("/updatePasswordEnd")
public class UpdatePasswordEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pw = request.getParameter("password");
		String pw_new=request.getParameter("password_new");
		MemberService ms = new MemberService();
		Member check = ms.loginCheck(userId, pw);
		String msg = "";
		String location="";
		if(check==null) {
			msg = "현재 비밀번호를 확인해주세요";
			System.out.println(userId+","+pw+","+pw_new);
			location = "/member/updatePassword?userId="+userId; // userId 안보내주면 재확인을 못한다
			
		}else {
			int result = ms.updatePassword(userId, pw_new);
			if(result>0) {
				msg = "비밀번호 변경 성공";
				location = "/memberView.do";
			}else {
				msg = "비밀번호 변경 실패, 다시 시도해주세요";
				location = "/member/updatePassword?userId="+userId;
			}
		}
		request.setAttribute("msg",msg);
		request.setAttribute("loc",location);
		request.setAttribute("script","window.close();");
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
