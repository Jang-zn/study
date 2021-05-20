package com.board.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.board.model.service.*;
import com.board.model.vo.*;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/List")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		int numPerpage;
		try {
			numPerpage = Integer.parseInt(request.getParameter("numPerpage"));
		}catch(NumberFormatException e) {
			numPerpage=5;
		}
		int totalData = new BoardService().getBoardCount();
		int totalPage = (int) Math.ceil((double)totalData/numPerpage);
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		System.out.println(cPage+" "+pageNo+" "+pageEnd);
		String pageBar = "";
		
		if(pageNo==1) {
			pageBar+="<span>&nbsp[이전]&nbsp</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/board/List?cPage="+(pageNo-1)+"&numPerpage="+numPerpage+"'>[이전]</a>";
		}
		while(!(pageNo>pageEnd||pageNo>totalPage)){
			if(cPage==pageNo) {
				pageBar+="<span>&nbsp"+pageNo+"&nbsp</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()+"/board/List?cPage="+pageNo+"'>&nbsp"+pageNo+"&nbsp</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<span>&nbsp[다음]&nbsp</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/board/List?cPage="+pageNo+"'>&nbsp[다음]&nbsp</a>";
		}
		
		List<Board> list =new BoardService().getBoardList(cPage, numPerpage); 
		
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("boardList", list);
		request.getRequestDispatcher("/views/board/boardList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
