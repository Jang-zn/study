package com.notice.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.servlet.*;

import com.notice.model.service.*;
import com.notice.model.vo.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

/**
 * Servlet implementation class NoticeUpdateEndServet
 */
@WebServlet("/notice/updateNoticeEnd")
public class NoticeUpdateEndServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateEndServet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "공지사항 수정실패 [form:enctype] X(");
			request.setAttribute("loc", "/notice/noticeList");
			request.getRequestDispatcher("/views/common/msg.jsp")
			.forward(request, response);
			return;
		}
		
		String path=getServletContext().getRealPath("/upload/notice/");
		MultipartRequest mr=new MultipartRequest(request,path,1024*1024*10,
					"utf-8",new DefaultFileRenamePolicy());
		
		Notice n=new Notice();
		n.setNoticeTitle(mr.getParameter("noticeTitle"));
		n.setNoticeWriter(mr.getParameter("noticeWriter"));
		n.setNoticeContent(mr.getParameter("content"));
		
		String fileName=mr.getFilesystemName("up_file");
		
		
		//파일처리하기
		File f=mr.getFile("up_file");
		
		if(f!=null&&f.length()>0) {
			//새로운파일이 전달됨.
			//이전파일을 삭제
			File del=new File(path+mr.getParameter("oldFile"));
			del.delete();
		}else {
			//새로운 파일이없음
			fileName=mr.getParameter("oldFile");
		}
		n.setFilepath(fileName);
		//DB수정
		int result = new NoticeService().updateNotice(n);
		//화면선택
		String msg = "";
		if(result>0) {
			msg="공지사항이 수정되었습니다.";
			
		}else {
			msg="공지사항을 수정하지 못했습니다.";
		}
		request.setAttribute("msg",msg);
		request.setAttribute("loc", "/notice/List");
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
