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
 * Servlet implementation class NoticeWriteEndServlet
 */
@WebServlet("/notice/noticeWriteEnd")
public class NoticeWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//File f = new File(request.getParameter("file"));
		//파일 업로드 로직 : cos.jar에서 제공하는 MultipartRequest class이용하면 됨 (binary file의 처리)
		//enctype이 multipart/form-data 가 아니면 저걸로 처리하면 안됨
		//ServletFileUpload 클래스의 isMultipartContent()로 예외처리 해줘야됨
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "작성오류 : form:enctype");
			request.setAttribute("loc", "/notice/List");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		//MultipartRequest 생성자로 생성하면 자동으로 업로드됨
		//생성자에 매개변수 주면 된다. (1. HttpServletRequest / 2. Filepath / 3. File 최대크기
							//  (4. File encoding값 / 5. 업로드 파일명 리네임 로직 (객체?))
		// 리네임은 파일명 중복 방지를 위해서 필요함 : 중복되면 덮어씌우잖아
		//리네임 로직은 기본 제공되며 커스터마이징도 가능
		
		// filePath : ServletContext 객체의 getRealPath() 메소드로 HDD의 직접경로를 가져올 수 있음
		// -> hdd 직접경로를 가져와야 저장 가능
		// getContextPath() 는 web부터 쓰는거고 getRealPath()는 HDD 경로 전체를 가져옴
		String path =getServletContext().getRealPath("/upload/notice/");
		
		// File 최대 size 설정
		int maxSize = 1024*1024*10; //기본단위 : byte / 1024byte(1kb)*1024(1mb)*10 = 10mb
		
		// Encoding값
		String encode = "UTF-8";
		
		// renameLogic -> rename Class = DefaultFileRenamePolicy / FileRenamePolicy interface를 구현하면 로직 커스텀 가능
		FileRenamePolicy renamePolicy = new DefaultFileRenamePolicy();
		
		//upload
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encode, renamePolicy);
		
		//생성된 MultipartRequest 객체를 통해서 vo에 data setting
		Notice n = new Notice();
		n.setNoticeTitle(mr.getParameter("title"));
		n.setNoticeWriter(mr.getParameter("writer"));
		n.setNoticeContent(mr.getParameter("content"));
		//filepath에는 rename된 file명을 넣어주면 됨 (경로는 이미 지정되어있다.)
		//getFilesystemName() 매개변수에는 input tag의 name을 적어줌
		//getOriginalFileName() 매개변수에는 input tag의 name을 적어줌 : rename 전의 file명을 가져옴
		n.setFilepath(mr.getFilesystemName("file"));
		int result = new NoticeService().noticeWrite(n);
		String msg = "";
		String location="";
		if(result>0) {
			msg="등록되었습니다.";
			location="/notice/List";
		}else {
			msg="등록에 실패했습니다.";
			location="/notice/write";
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
