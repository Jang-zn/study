package com.bs.spring.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bs.spring.member.model.service.MemberService;
import com.bs.spring.member.model.vo.Member;

@Controller
@SessionAttributes({"login"})
public class MemberController {
	@Autowired
	private MemberService ms;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	
	@RequestMapping("/member/memberLogin.do")
	public String loginMember(@RequestParam Map param, Model m, HttpSession session) {
		Member member = ms.loginMember(param);
		//입력받은 pw랑 암호화된 pw랑 비교해주는 matches 메소드 사용
		//매개변수는 입력받은값, 암호화된값
		String location="";
		if(member!=null) {
			boolean check = pwEncoder.matches((String)param.get("password"), member.getPassword());
			if(check) {
				m.addAttribute("login",member);
				location="index";
			}else {
				m.addAttribute("msg","로그인 실패");
				m.addAttribute("loc","/");
				location="common/msg";
			}
		}
		//session.setAttribute("login", member);
		//model의 attribute를 session scope로 이동 가능 (annotation 이용 @SessionAttributes)
		// 클래스 선언부에 선언해주면 된다.. @SessionAttributes("model의 key값")
		//@SessionAttributes({"model의 key값","key","key",...}) 배열로도 넣을수 있음
		//Session에 Attribute가 넘어가는 순간은 viewResolver 도달시점이라서 여기서 syso 찍어도 안나옴
		
			
		return location;
	}
	@RequestMapping("/member/submit.do")
	public String forwardSubmit() {
		return "member/submit";
	}
	
	@RequestMapping("/member/mypage.do")
	public String forwardMypage() {
		return "member/mypage";
	}
	
	@RequestMapping("/member/logout.do")
	public String logout(HttpSession session, SessionStatus ss) {
		//@SessionAttributes로 넘겨준 Attribute는 invalidate로 못없앰
		//SessionStatus 객체를 완료시켜줘서 없애줘야됨 (setComplete())
		if(!ss.isComplete()) {
			ss.setComplete();
		}
		//index 보내면 주소가 남아있으니까 redirect 해준다
		return "redirect:/";//servlet 주소를 줘야됨 지금은 logout이니까 그냥 /
	}
	
	@RequestMapping("/member/insertMember.do")
	public String insertMember(Member member, Model m) {
		member.setPassword(pwEncoder.encode(member.getPassword()));
		int result = ms.insertMember(member);
		m.addAttribute("loc","/");
		m.addAttribute("msg",result>0?"가입성공":"가입실패");
		return "common/msg";
		//권한인증 / 암호화 해야되는데 이거를 SpringSecurity로 구현 가능
	}
	
	@RequestMapping("/member/updateMember.do")
	public String updateMember(Member member, Model m) {
		int result = ms.updateMember(member);
		m.addAttribute("loc","/member/mypage.do");
		m.addAttribute("msg",result>0?"수정성공":"수정실패");
		return "common/msg";
		//권한인증 / 암호화 해야되는데 이거를 SpringSecurity로 구현 가능
	}
	
}
