package com.js.ajax.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.admin.model.service.*;
import com.google.gson.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class SearchIdServlet
 */
@WebServlet("/ajax/searchId")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("keyword");
		List<Member> list = new AdminService().searchMemberList("userId", userId, 1, 20);
		
//		if(list.size()>0) {
//			Member m = list.get(0);
//			json.put("userId",m.getUserId());
//			json.put("userName",m.getUserName());
//			json.put("gender",m.getGender());
//			json.put("age",m.getAge());
//			json.put("email",m.getEmail());
//		}
		
		
		
		
		//JSONArray 클래스를 통해서 JSONObject를 List 형태로 저장
//		JSONArray jlist = new JSONArray();
//		for(Member m : list) {
//			JSONObject json = new JSONObject();
//			json.put("userId",m.getUserId());
//			json.put("userName",m.getUserName());
//			json.put("gender",m.getGender());
//			json.put("age",m.getAge());
//			json.put("email",m.getEmail());
//			//json.put("enrollDate", m.getEnrollDate()); //Date는 Object라서 String처리 해줘야됨
//			jlist.add(json);
//		}
		
		
		
		//Gson 쓰는거
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson(list,response.getWriter());
		//끝
		//이렇게 넣으면 멤버변수 명으로 파싱돼서 알아서 들어감
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
