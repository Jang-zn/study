package com.admin.controller;

import static com.common.AESEncrypt.*;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.admin.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/admin/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리를 위한 전처리
		int cPage;//현재페이지, 페이지 바뀔때마다 요청하니까 request마다 계속 값 바껴야됨
		try {  // 1page갈때는 주소로 접근할수도 있으니까 예외처리 
		cPage= Integer.parseInt(request.getParameter("cPage")); 
		}catch(Exception e) {
			cPage=1;
		}
		
		int numPerpage; // 페이지당 출력수, 게시판에서 출력수를 조정할수도 있으니까 request에서 가져옴
		try { //1page갈때는 주소로 접근할수도 있으니까 예외처리 
		numPerpage= Integer.parseInt(request.getParameter("numPerpage")); 
		}catch(Exception e) {
			numPerpage=5;
		}
		
		//페이지바 변수 설정
		int totalData = new AdminService().getMemberCount();
		int totalPage = (int)Math.ceil((double)totalData/numPerpage); //ceil 올림 round 반올림 floor 버림
		int pageBarSize = 5; //이건 알아서 지정하면 됨
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		
		//페이지바 만들기
		String pageBar="";  // [이전] 1 2 3 4 5 [다음]
		if(pageNo==1) {
			pageBar += "<span>&nbsp[이전]&nbsp</span>";
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/admin/memberList?cPage="+(pageNo-1)+"&numPerpage="+numPerpage+"'>[이전]</a>";
		}
		
		//cPage는 사용자가 누르는 pageNo 값으로 지정되는 유동값
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span style='color:blue'>&nbsp&nbsp"+pageNo+"&nbsp&nbsp</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()+"/admin/memberList?cPage="+pageNo+"'>&nbsp&nbsp"+pageNo+"&nbsp&nbsp</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage){
			pageBar+="<span>&nbsp[다음]&nbsp</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/admin/memberList?cPage="+pageNo+"'>[다음]</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		
		List<Member> list = new AdminService().getMemberList(cPage, numPerpage);
		for(Member m : list) {
			try {
				m.setEmail(decrypt(m.getEmail()));
			}catch(Exception e) {
				
			}
			try {
				m.setPhone(decrypt(m.getPhone()));
			}catch(Exception e) {
				
			}
			
		}
		request.setAttribute("memberList", list);
		request.getRequestDispatcher("/views/admin/memberList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
