package com.bs.spring.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bs.spring.member.model.service.MemberService;
import com.bs.spring.member.model.vo.Member;

@Controller
@SessionAttributes("login")
public class MemberController {
	@Autowired
	MemberService ms;
	
	@RequestMapping("/member/memberLogin.do")
	public String loginMember(@RequestParam Map param, Model m, HttpSession session) {
		Member member = ms.loginMember(param);
		//session.setAttribute("login", member);
		//model의 attribute를 session scope로 이동 가능 (annotation 이용 @SessionAttributes)
		// 클래스 선언부에 선언해주면 된다.. @SessionAttributes("model의 key값")
		m.addAttribute("login",member);
		return "index";
	}
	@RequestMapping("/member/submit.do")
	public String forwardSubmit() {
		return "member/submit";
	}
	
	@RequestMapping("/member/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("/member/insertMember.do")
	public String insertMember(Member member, Model m) {
		int result = ms.insertMember(member);
		m.addAttribute("loc","/");
		m.addAttribute("msg",result>0?"가입성공":"가입실패");
		return "common/msg";
	}
	
}
