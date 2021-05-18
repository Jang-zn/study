package com.notice.controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class NoticeFileDownloadServlet
 */
@WebServlet("/fileDownload")
public class NoticeFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//File download
		String fileName = request.getParameter("fileName");
		//입출력 Stream을 local hdd - 서버 - client간 사용한다고 생각하면 됨
		// client에 보낼때 mime 정해서 보내주면 브라우저가 알아서 처리해줌
		
		//InputStream 열어서 file 불러오기
		String path = getServletContext().getRealPath("/upload/notice/");
		File f = new File(path+fileName);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
		
		//파일명이 한글이면 깨질수 있음 -> 안깨지게 file명 인코딩 처리해줘야됨
		String fileNameAfterEnc = "";
		String header = request.getHeader("user-agent"); // client가 사용하는 브라우저 정보를 가져오는것,
		
		//브라우저마다 인코딩 방식이 달라서 깨지는거니까 이거 맞춰줘야됨
		boolean isMS=header.contains("Trident")||header.contains("MSIE"); //true면 익스플로러라는 얘기임.. 또 너야?
		if(isMS) {
			//익스플로러일때.. 어휴 이새꺄
			fileNameAfterEnc = URLEncoder.encode(fileName,"utf-8").replaceAll("\\+","%20");
		}else {
			fileNameAfterEnc = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		}
		
		
		//응답메세지
		response.setContentType("application/octet-stream"); 
		//octet-stream은 잘 알려지지 않은 확장자를 가진 파일에 대해 적용하는데 이거 쓰면 엥간한거 다 보내진다.

		response.setHeader("Content-disposition", "attachment;filename="+fileNameAfterEnc); 
		// attachment 쓰면 무조건 다운 / attachment 말고 inline 쓰면 브라우저 내에서 열수 있는 파일은 그냥 열어버림 -> IE에서만 지원
		
		
		//file 출력스트림
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		int read = -1;
		//inputStream에서 읽어와서 1이 아니면 계속 진행
		while((read=bis.read())!=-1) {
			bos.write(read);
		}
		bis.close(); bos.close();
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
