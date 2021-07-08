package com.bs.spring.board.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.spring.board.model.dao.BoardDao;
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
	
	
}
