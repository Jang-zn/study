package com.dataservlet.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class UseDataServlet
 */
@WebServlet("/useData.do")
public class UseDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UseDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//저장된 객체를 불러옴
		ServletContext context = request.getServletContext();
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html>"
				+ "<body>"
				+ "<ul>"
				+ "<li><h1> context : "+context.getAttribute("context")+"</h1></li>"
				+ "<li><h1> session : "+session.getAttribute("session")+"</h1></li>"
				+ "<li><h1> request : "+request.getAttribute("request")+"</h1></li>"
				+"</ul>"
				+"<button onclick='location.assign(\"sessionout.do\")'>sessionOut</button>"
				+"</body>"
				+"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
