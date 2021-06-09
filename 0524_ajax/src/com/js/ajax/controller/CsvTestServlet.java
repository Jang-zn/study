package com.js.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.ajax.model.vo.Person;

/**
 * Servlet implementation class CsvTestServlet
 */
@WebServlet("/ajax/csvTest.do")
public class CsvTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsvTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> list = new ArrayList();
		list.add(new Person("박보검","0103131331","parkBogum.jpg"));
		list.add(new Person("맷데이먼","0102121212","mattDamon.jpg"));
		list.add(new Person("줄리아로버츠","010696969","juliaRoberts.jpg"));
		String csv="";
		for(int i=0;i<list.size();i++) {
			if(i!=0) csv+="\n";
			csv+=list.get(i);
		}
		response.setContentType("text/csv;charset=utf-8");
		response.getWriter().write(csv);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
