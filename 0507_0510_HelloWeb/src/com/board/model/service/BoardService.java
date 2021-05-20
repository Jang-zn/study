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
}
