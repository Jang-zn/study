package com.member.controller;

import java.io.*;
import static com.common.AESEncrypt.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.member.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	Member m = new Member();
			m.setUserId(request.getParameter("userId"));
			/* m.setPassword(request.getParameter("password")); */
			m.setUserName(request.getParameter("userName"));
			m.setAge(Integer.parseInt(request.getParameter("age")));
			try {
				m.setEmail(encrypt(request.getParameter("email")));
			}catch(Exception e){
				e.printStackTrace();
			}
			
			try {
				m.setPhone(encrypt(request.getParameter("phone")));
			}catch(Exception e){
				e.printStackTrace();
			}
			m.setAddress(request.getParameter("address"));
			m.setGender(request.getParameter("gender"));
			m.setHobby(String.join(",",request.getParameterValues("hobby")));
		int result = new MemberService().updateMember(m);
		String msg = "";
		String location = "/memberView.do?userId="+m.getUserId();
		if(result>0) {
			msg = "정상적으로 수정되었습니다.";
			HttpSession session = request.getSession();
			session.setAttribute("login", m);
			// ★★★★★★★★★★★★★★★★★★★★★멤버정보가 수정되었으니까 현재 로그인되어있는 세션의 객체도 수정해줘야됨★★★★★★★★★★★★★★★★★★★★★★★
		}else {
			msg = "수정에 실패했습니다 다시 시도해주세요";
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
