package com.notice.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.notice.model.service.*;
import com.notice.model.vo.*;

/**
 * Servlet implementation class NoticeContent
 */
@WebServlet("/notice/content")
public class NoticeContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo=Integer.parseInt(request.getParameter("noticeSrl"));
		String column = "NOTICE_NO";
		Notice n = new NoticeService().getNoticeContent(noticeNo, column);
		
		if(n!=null) {
			request.setAttribute("notice", n);
			request.getRequestDispatcher("/views/notice/noticeContent.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "조회된 페이지가 없습니다");
			request.setAttribute("loc", "/notice/notice/List");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
