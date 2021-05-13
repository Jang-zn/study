package com.common.filter;

import javax.servlet.http.*;

//Wrapper class 상속
public class MyWrapper extends HttpServletRequestWrapper{
	//매개변수로 super class를 갖는 생성자가 필요함
	public MyWrapper (HttpServletRequest request) {
		super(request);
	}
	// HttpServletRequest가 갖는 메소드의 재정의(Override) 하는 용도 -> 동적 바인딩
	
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name); //기본 설정된 getParameter() 실행
		return value + " override";
	}
	
	

}
