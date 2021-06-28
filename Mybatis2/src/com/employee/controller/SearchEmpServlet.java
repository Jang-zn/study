package com.employee.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.model.service.EmployeeService;
import com.employee.model.vo.Employee;

/**
 * Servlet implementation class SearchEmpServlet
 */
@WebServlet("/searchEmp")
public class SearchEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> data = new HashMap();
		request.setCharacterEncoding("utf-8");
		data.put("type",request.getParameter("searchType"));
		data.put("key", request.getParameter("searchKeyword"));
		data.put("gender", request.getParameter("gender"));
		data.put("salary", request.getParameter("salary"));
		String lege = request.getParameter("le_ge");
		switch(lege) {
			case "le":	data.put("lege", "<="); break;
			case "ge":	data.put("lege", ">="); break;
		}
		List<Employee> list = new EmployeeService().selectEmp(data);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/empList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
