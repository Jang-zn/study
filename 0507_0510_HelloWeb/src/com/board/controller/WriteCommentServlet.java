package com.board.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.board.model.service.*;
import com.board.model.vo.*;

/**
 * Servlet implementation class WriteCommentServlet
 */
@WebServlet("/board/writeComment")
public class WriteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comment c = new Comment();
		c.setBoardCommentLevel(Integer.parseInt(request.getParameter("level")));
		c.setBoardCommentWriter(request.getParameter("commentWriter"));
		c.setBoardCommentContent(request.getParameter("content"));
		c.setBoardRef(Integer.parseInt(request.getParameter("boardRef")));
		c.setBoardCommentRef(Integer.parseInt(request.getParameter("commentRef")));
		int result = new BoardService().writeComment(c);
		String msg="";
		String loc="/board/content?boardNo="+request.getParameter("boardRef");
		if(result>0) {
			msg="등록 성공";
		}else {
			msg="등록 실패";
		}
		List<Comment> list = new BoardService().getComment(Integer.parseInt(request.getParameter("boardRef")));
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.setAttribute("commentList",list);
		System.out.println("servlet : "+list.size());
		System.out.println(((List<Comment>)request.getAttribute("commentList")).size());
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
