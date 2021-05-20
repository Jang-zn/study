package com.board.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.board.model.vo.*;
import com.notice.model.dao.*;

import static com.common.JdbcTemplate.*;

public class BoardDao {

	public BoardDao() {
		
	}
	
	public List<Board> getBoardList(Connection conn, int cPage, int numPerpage){
		Properties p = new Properties();
		List<Board> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String path = BoardDao.class.getResource("/SQL/board_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt=conn.prepareStatement(p.getProperty("selectBoardList"));
			int pageNo =(cPage-1)*numPerpage+1; 
			int pageEnd = cPage*numPerpage;
			pstmt.setInt(1,pageNo);
			pstmt.setInt(2,pageEnd);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setBoardNo(rs.getInt(2));
				b.setBoardTitle(rs.getString(3));
				b.setBoardWriter(rs.getString(4));
				b.setBoardContent(rs.getString(5));
				b.setBoardOriginalFileName(rs.getString(6));
				b.setBoardRenamedFileName(rs.getString(7));
				b.setBoardDate(rs.getDate(8));
				b.setBoardReadCount(rs.getInt(9));
				list.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			return list;
		}
	}
	
	public int getBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		Properties p = new Properties();
		int result = 0;
		try {
			String path = NoticeDao.class.getResource("/SQL/board_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt=conn.prepareStatement(p.getProperty("selectBoardCount"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			
		}finally {
			close(rs);
			close(pstmt);
			return result;
		}
	}
	
	public Board getBoardContent(Connection conn, int boardNo){
		Properties p = new Properties();
		List<Board> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board b = new Board();
		try {
			String path = BoardDao.class.getResource("/SQL/board_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt=conn.prepareStatement(p.getProperty("selectBoardContent"));
			pstmt.setInt(1,boardNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				b.setBoardNo(rs.getInt(1));
				b.setBoardTitle(rs.getString(2));
				b.setBoardWriter(rs.getString(3));
				b.setBoardContent(rs.getString(4));
				b.setBoardOriginalFileName(rs.getString(5));
				b.setBoardRenamedFileName(rs.getString(6));
				b.setBoardDate(rs.getDate(7));
				int readCount = rs.getInt(8)+1;
				b.setBoardReadCount(readCount);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			return b;
		}
	}
	
	
}
