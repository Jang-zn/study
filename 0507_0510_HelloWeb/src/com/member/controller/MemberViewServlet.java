package com.member.controller;

import java.io.*;
import static com.common.AESEncrypt.*;

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
		
		
		try {
			m.setEmail(decrypt(m.getEmail()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			m.setPhone(decrypt(m.getPhone()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		//각각 예외처리 하는 이유는 에러발생했을때 어디서 난건지 확인하기 위함
		
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
