package com.admin.controller;

import static com.common.AESEncrypt.*;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.admin.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/admin/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> list = new AdminService().getMemberList();
		for(Member m : list) {
			try {
				m.setEmail(decrypt(m.getEmail()));
			}catch(Exception e) {
				
			}
			try {
				m.setPhone(decrypt(m.getPhone()));
			}catch(Exception e) {
				
			}
			
		}
		request.setAttribute("memberList", list);
		request.getRequestDispatcher("/views/admin/memberList.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
