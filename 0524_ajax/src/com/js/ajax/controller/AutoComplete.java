package com.js.ajax.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.admin.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class AutoComplete
 */
@WebServlet("/ajax/autoComplete.do")
public class AutoComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("keyword");
		List<Member> list = new AdminService().searchMemberList("USERNAME", keyword, 1, 50);
		String csv = "";
		for(int i=0;i<list.size();i++) {
			if(i!=0) csv+=",";
			csv+=list.get(i).getUserName();
		}
		response.setContentType("text/csv;charset=utf-8");
		response.getWriter().print(csv);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
