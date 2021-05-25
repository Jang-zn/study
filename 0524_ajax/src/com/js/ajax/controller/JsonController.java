package com.js.ajax.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;

import com.js.ajax.model.vo.*;

/**
 * Servlet implementation class JsonController
 */
@WebServlet("/ajax/jsonTest.do")
public class JsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person p = new Person("우유씨","01069696969","woou.jpg");
		//json 처리해줄 객체 필요 (json simple library) ->자바 객체를 {키:밸류,키:밸류,...}형태의 문자열(js객체)로 처리해주는것
		//JSONObject 이용
		JSONObject json = new JSONObject();
		//옮겨줄 객체의 멤버변수값 세팅
		json.put("name", p.getName());
		json.put("phone", p.getPhone());
		json.put("profile", p.getProfile());
		json.put("age", 20);
		response.setContentType("applictation/json;charset=utf-8");
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
