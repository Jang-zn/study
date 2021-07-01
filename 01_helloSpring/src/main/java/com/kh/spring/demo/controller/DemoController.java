package com.kh.spring.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.spring.demo.model.vo.Dev;

@Controller
public class DemoController {
	@RequestMapping(value = "/demo/demo.do", method = RequestMethod.GET)
	public String demo() {
		System.out.println("실행");
		return "demo/demo";
	}
	
	//스프링에서는 프론트에서 보내준 데이터를 Mapping 메소드의 매개변수로 받을 수 있음
	//매개변수들은 주요 정보를 가지고 있는 객체, 파라미터값으로 선언이 가능함 ->받아올 필요 없이 선언만 해주면 된다
	// ====== Mapping 메소드의 매개변수로 선언할 수 있는 변수 ->자동으로 대입됨 ======
	// 1. HttpServletRequest - Model / VO가 역할 대체해서 거의 쓸일 없는듯
	// 2. HttpServletResponse
	// 3. HttpSession
	// 4. java.util.Locale --지역정보
	// 5. InputStream / InputStreamReader
	// 6. OutputStream / OutputStreamWriter
	//==================================================================
	//=== Data 관리용 객체 ====
	// 1. VO - Parameter key값과 vo 멤버변수명이 동일해야 됨
	//		 - 기본자료형과 String / 배열만 자동으로 넣어줌
	// 2. Model 객체 - request의 데이터를 보관하는 기능을 함 
	// 3. ModelAndView - Data보관하는 Model + 화면정보 보관 View : return값으로도 사용 가능함
	//==================================================================
	
	//@Annotation으로 옵션을 설정해주는 매개변수
	// 1. @RequestParam(value="key값", 옵션..) 값 받을 변수선언
	// 2. @RequestHeader(value="headerKey값", 옵션..) 값 받을 변수선언
	// 3. @CookieValue(value="cookieKey값", 옵션..) 값 받을 변수선언
	
	//=================================================================
	//Mapping 메소드에 선언하는 Annotation
	// 1. @PathVariable("값") - Restful 방식의 url 요청 왔을 때 데이터를 받음
	// 2. @ResponseBody - 리턴해주는 값이 Page가 아니라 Data일 때 Json으로 처리해서 보냄 - 페이지 갱신 / AJAX 이런거에 쓰겠네
	
	
	//*******Mapping 메소드를 doGet처럼 쓰기 (비추)... request, response 메소드 매개변수로 넣고 걍 쓰면 됨**************************
	
	// VO에 Parameter 받기 -> 그냥 받아줄 VO를 매개변수에 넣어준다
	@RequestMapping("/demo/basicDemo.do")
	public String basicDemo(Dev dev, HttpServletRequest request) {
		request.setAttribute("dev", dev);
		System.out.println(dev);
		return "demo/result";
	}
	
}
