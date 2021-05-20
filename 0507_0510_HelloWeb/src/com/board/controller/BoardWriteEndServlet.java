package com.board.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.servlet.*;

import com.board.model.service.*;
import com.board.model.vo.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

/**
 * Servlet implementation class BoardWriteEnd
 */
@WebServlet("/board/writeEnd")
public class BoardWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "작성오류 : form:enctype");
			request.setAttribute("loc", "/board/List");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		String path = getServletContext().getRealPath("/upload/board");
		int maxSize = 1024*1024*10;
		String encode = "UTF-8";
		FileRenamePolicy renamePolicy = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encode, renamePolicy);
		Board b = new Board();
		b.setBoardTitle(mr.getParameter("title"));
		b.setBoardWriter(mr.getParameter("writer"));
		b.setBoardContent(mr.getParameter("content"));
		b.setBoardOriginalFileName(mr.getOriginalFileName("file"));
		b.setBoardRenamedFileName(mr.getFilesystemName("file"));
		int result = new BoardService().boardWrite(b);
		String msg = "";
		String location="";
		if(result>0) {
			msg="등록되었습니다.";
			location="/board/List";
		}else {
			msg="등록에 실패했습니다.";
			location="/board/write";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", location);
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
