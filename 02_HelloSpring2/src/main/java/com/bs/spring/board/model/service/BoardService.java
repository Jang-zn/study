package com.bs.spring.board.model.service;

import java.util.List;

import com.bs.spring.board.model.vo.Board;

public interface BoardService {
	List<Board> boardList(int cPage, int numPerpage);
	int countBoard();
	int insertBoard(Board b);
	Board selectBoard(int no);
}
