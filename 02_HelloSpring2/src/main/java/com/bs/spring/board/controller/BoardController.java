package com.bs.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bs.spring.board.model.service.BoardService;
import com.bs.spring.board.model.vo.Board;
import com.bs.spring.common.PageFactory;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@RequestMapping("/board/boardList.do")
	public String boardList(Model m, 
			@RequestParam(value="cPage", defaultValue="1") int cPage,
			@RequestParam(value="numPerpage", defaultValue="5")int numPerpage) {
		int totalData = bs.countBoard();
		List<Board> list = bs.boardList(cPage, numPerpage);
		m.addAttribute("list", list);
		m.addAttribute("totalContents",totalData);
		m.addAttribute("pageBar", PageFactory.getPageBar(totalData, cPage, numPerpage, "boardList.do"));
		return "board/boardList";
	}
}
