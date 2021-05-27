package com.board.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.servlet.*;

import com.board.model.service.*;
import com.board.model.vo.*;
import com.common.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

/**
 * Servlet implementation class BoardWriteEnd
 */
@WebServlet("/board/writeEnd")
public class BoardWriteEndServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteEndServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Board b = new Board();
		b.setBoardTitle(request.getParameter("title"));
		b.setBoardWriter(request.getParameter("writer"));
		b.setBoardContent(request.getParameter("content"));
		int result = new BoardService().boardWrite(b);
		String msg = "";
		String location="";
		if(result>0) {
			request.getRequestDispatcher("/blist").forward(request, response);
		}else {
			msg="게시글 등록 실패!";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
