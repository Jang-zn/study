package com.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.model.service.StudentService;
import com.student.model.vo.Student;

/**
 * Servlet implementation class InsertStudentServlet
 */
@WebServlet("/insertStudentInfo")
public class InsertStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertStudentInfoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		String addr=request.getParameter("addr");
		Student s = new Student();
		s.setStudentName(name); s.setStudentEmail(email); s.setStudentTel(tel); s.setStudentAddr(addr);
		int result = new StudentService().insertStudentInfo(s);
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(result>0?"성공":"실패");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
