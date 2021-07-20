package com.bs.spring.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.bs.spring.board.model.vo.Attachment;
import com.bs.spring.board.model.vo.Board;

public interface BoardDao {
	List<Board> boardList(SqlSessionTemplate session, int cPage, int numPerpage);
	int countBoard(SqlSessionTemplate session);
	int insertBoard(SqlSessionTemplate session, Board b);
	int insertBoardAttachment(SqlSessionTemplate session, Attachment a);
	Board selectBoard(SqlSessionTemplate session, int no);
}
