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
}
