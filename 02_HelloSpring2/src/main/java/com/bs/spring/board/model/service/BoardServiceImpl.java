package com.bs.spring.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.spring.board.model.dao.BoardDao;
import com.bs.spring.board.model.vo.Attachment;
import com.bs.spring.board.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	SqlSessionTemplate session;
	
	@Autowired
	BoardDao dao;
	
	@Override
	public List<Board> boardList(int cPage, int numPerpage){
		return dao.boardList(session, cPage, numPerpage);
	}

	@Override
	public int countBoard() {
		return dao.countBoard(session);
	}

	
	//@Transactional
	@Override
	public int insertBoard(Board b) {
	
		int result = dao.insertBoard(session, b);
		if(result>0) {
			if(b.getAttachments().size()>0) {
				for(Attachment a: b.getAttachments()) {
					a.setBoardNo(b.getBoardNo());
					dao.insertBoardAttachment(session, a);
				}
			}else if(result>0) {
				return 1;
			}else{
				return 0;
			}
		}else {
			return 0;
		}
	
	return result;
	}
	
	@Override
	public Board selectBoard(int no) {
		return dao.selectBoard(session, no);
	}

	
	
}
