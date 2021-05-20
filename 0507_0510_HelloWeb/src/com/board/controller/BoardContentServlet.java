package com.board.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.board.model.service.*;
import com.board.model.vo.*;

/**
 * Servlet implementation class BoardContentServlet
 */
@WebServlet("/board/content")
public class BoardContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//조회 체크  - coockie에 읽은 게시물 번호를 저장하고 있으면 조회수 안올라가게 함
		boolean readCheck = false;
		//글번호 저장 변수 선언
		String boardReadNo="";
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Cookie[] coo =request.getCookies();
		if(coo!=null) {
			for(Cookie c : coo) {
				String name = c.getName();
				String value = c.getValue();
				if(name.equals("boardReadNo")) {
					if(value.contains("["+boardNo+"]")) {
						readCheck=true;
						break;
					}
					boardReadNo=value;
				}
				
			}
		}
		if(!readCheck) {
			Cookie c = new Cookie("boardReadNo",boardReadNo+"["+boardNo+"]");
			c.setMaxAge(60*60*24); //로그아웃시에 지워지도록 설정할수도 있음 (매개변수를... 뭐로 줘야되냐)
								   //아니면 Listener에서 session 끝나면 지워지게 해도 됨
			response.addCookie(c);
		}
		
		
		
		Board b = new BoardService().getBoardContent(boardNo, readCheck);
		
		String view ="";
		if(b==null) {
			
		}
		
		request.setAttribute("board", b);
		request.getRequestDispatcher("/views/board/boardContent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
