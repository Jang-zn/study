package com.bs.spring.memo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.spring.memo.model.service.MemoServiceimpl;
import com.bs.spring.memo.model.vo.Memo;

@Controller
public class MemoController {

	@Autowired
	MemoServiceimpl ms;
	
	
	@RequestMapping("memo/memo.do")
	public String memo(HttpServletRequest request) {
		List<Memo> list = ms.memoSelect();
		request.setAttribute("list", list);
		return "memo/memo";
	}
	
	@RequestMapping("memo/memoInsert.do")
	public String memoInsert(Memo memo) {
		int result = ms.memoInsert(memo);
		return "redirect:memo.do";
	}
	
	@RequestMapping("memo/memoDelete.do")
	public String memoDelete(HttpServletRequest request) {
		int no = Integer.parseInt(request.getParameter("no"));
		int result = ms.memoDelete(no);
		return "redirect:memo.do";
	}
	
}
