package com.kh.spring.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String basicDemo(Dev dev, Model m) {
		m.addAttribute("dev",dev);
		return "demo/result";
	}
	
	
	@RequestMapping("/demo/reqParamDemo.do")
	public String reqPramDemo(
			@RequestParam(value="devName") String devName,
			//required default값이 true라서 안넣어주면 에러남 / + false 처리 후에는 defaultValue 해주는게 좋다
			@RequestParam(value="devAge", required=false, defaultValue="0") int devAge,
			
			@RequestParam(value="devEmail") String devEmail,
			@RequestParam(value="devGender") String devGender,
			@RequestParam(value="devLang") String[] devLang,
			Model m
			//String으로 받아도 배열 알아서 String 처리해줌
			//Model로 Data를 Front로 넘겨줄 수 있다.
			
			//Annotation 없이 매개변수에 그냥 변수 선언해줘도 됨(String devName....)
			//-> 1. front에서 보내준 key값하고 변수명이 같아야됨
			//   2. 빠진거 없이 다 보내져야됨
		) {
		System.out.println(devName+" "+devAge+" "+devEmail+" "+devGender+" "+devLang);
		Dev dev = Dev.builder().devName(devName).devEmail(devEmail).devAge(devAge).devGender(devGender).devLang(devLang).build();
		m.addAttribute("dev",dev);
		//model의 생명주기는 request와 같음
		return "demo/result";
	}
	
	//Command 방식 입력
	// -> 1. front에서 보내준 key값하고 멤버변수명이 같아야됨
	//    2. VO객체 멤버변수에 다른 객체가 존재하면 안됨 (Date같은..) -> String으로 받아서 Date 처리해주는게 더 나을수도 있다
	//	     VO에 멤버변수에 설정된 Date가 util.Date면 못받고 sql.Date면 들어가짐
	//    3. required 안해줘도 알아서 있는거만 받음 (int는 parsing때문에 에러나서 default value 줘야됨)
	@RequestMapping("/demo/commandDemo.do")
	public String commandDemo(Dev dev, Model m) {
		m.addAttribute("dev",dev);
		return "demo/result";
	}
	
	//Map으로 전달받으면 ㄹㅇ 기본자료형만 처리 가능 (배열이면 맨 앞에거만 들어감)
	//배열만 따로 받아서 Map에 덮어씌워주면 사용 쌉가능
	@RequestMapping("/demo/mapDemo.do")
	public String mapDemo(@RequestParam Map dev, String[] devLang, Model m) {
		System.out.println(dev);
		dev.put("devLang", devLang);
		m.addAttribute("dev",dev);
		return "demo/result";
	}
	
	@RequestMapping("/demo/extraDemo.do")
	public String extraDemo(
			@CookieValue(value="time") String time,
			@RequestParam Map dev, String[] devLang, Model m,
			@RequestHeader(value="Referer") String prev,
			@RequestHeader(value="user-agent") String userAgent
			) {
		System.out.println(time);
		System.out.println(prev);
		System.out.println(userAgent);
		return "demo/result";
	}
}
