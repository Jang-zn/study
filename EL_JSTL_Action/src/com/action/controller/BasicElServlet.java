package com.action.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.action.model.vo.Person;

/**
 * Servlet implementation class BasicElServlet
 */
@WebServlet("/basicEl")
public class BasicElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasicElServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("p", new Person("장우영3", "가마산로", 33));
		request.setAttribute("list", List.of(1,2,3,4,5,6,7,8,9));
		HttpSession session = request.getSession();
		session.setAttribute("list","리스트");
		session.setAttribute("today", new Date() );
		
		getServletContext().setAttribute("userId","admin");
		getServletContext().setAttribute("p","P");
		
		request.getRequestDispatcher("/views/el/result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
