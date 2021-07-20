package com.bs.spring.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bs.spring.board.model.service.BoardService;
import com.bs.spring.board.model.vo.Attachment;
import com.bs.spring.board.model.vo.Board;
import com.bs.spring.common.PageFactory;

import lombok.extern.slf4j.Slf4j;
@Slf4j
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

	@RequestMapping("/board/boardForm.do")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	//file 받는 객체인 MultipartFile을 attribute 이름과 같게 하면 알아서 들어감
	//여러개면 배열로 선언해주면 됨	
	@RequestMapping("/board/boardFormEnd.do")
	public ModelAndView boardWriteEnd(Board b, MultipartFile[] upFile, ModelAndView mv, HttpServletRequest request) {
		String path = request.getRealPath("/reousrces/upload/board");
		
		//폴더만들기 
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		for(MultipartFile f : upFile) {
			if(!f.isEmpty()) {
				String ori = f.getOriginalFilename();
				String ext = ori.substring(ori.lastIndexOf("."));
				//리네임 규칙
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
				int rnd = (int)(Math.random()*1000);
				String rename = sdf.format(System.currentTimeMillis())+"_"+rnd+ext;
				//transferTo() 로 파일 저장
				try {
					f.transferTo(new File(path+rename));
					b.getAttachments().add(Attachment.builder().originalFilename(ori).renamedFilename(rename).build());
				}catch(Exception e) {
					
				}
			}	
			
		}
		int result = bs.insertBoard(b);
		mv.addObject("msg",result>0?"등록성공":"등록실패");
		mv.addObject("loc","/board/boardList.do");
		mv.setViewName("common/msg");
		return mv;
	}
	
	@RequestMapping("/board/boardView.do")
	public ModelAndView boardView(int no, ModelAndView mv) {
		mv.addObject("board", bs.selectBoard(no));
		mv.setViewName("/board/boardContent");
		return mv;
	}
}
