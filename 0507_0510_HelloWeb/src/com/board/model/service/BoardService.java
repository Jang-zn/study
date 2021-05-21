package com.board.model.service;
import static com.common.JdbcTemplate.*;

import java.sql.*;
import java.util.*;

import com.board.model.dao.*;
import com.board.model.vo.*;


public class BoardService {
	private BoardDao dao = new BoardDao();
	
	
	public BoardService() {
	
	}
	
	public List<Board> getBoardList(int cPage, int numPerpage){
		Connection conn = getConnection();
		List<Board> list = dao.getBoardList(conn, cPage, numPerpage);
		close(conn);
		return list;
	}
	
	public int getBoardCount() {
		Connection conn = getConnection();
		int result = dao.getBoardCount(conn);
		close(conn);
		return result;
	}
	
	public Board getBoardContent(int boardNo, boolean readCheck) {
		Connection conn = getConnection();
		Board b = dao.getBoardContent(conn, boardNo, readCheck);
		commit(conn);
		close(conn);
		return b;
	}
	
	public int boardWrite(Board b) {
		Connection conn = getConnection();
		int result = dao.boardWrite(conn, b);
		if(result>0) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
		}
		return result;
	}
	
	public int writeComment(Comment c) {
		Connection conn = getConnection();
		int result = dao.writeComment(conn, c);
		if(result>0) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
		}
		return result;
	}
	
	public List<Comment> getComment(int boardNo){
		Connection conn = getConnection();
		List<Comment> list = dao.getComment(conn, boardNo);
		close(conn);
		System.out.println("service : "+list.size());
		return list;
	}
}
