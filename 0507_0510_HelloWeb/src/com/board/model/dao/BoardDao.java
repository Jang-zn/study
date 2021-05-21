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
	
	public Board getBoardContent(Connection conn, int boardNo, boolean readCheck){
		Properties p = new Properties();
		List<Board> list = new ArrayList();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt_readCount = null;
		ResultSet rs = null;
		Board b = new Board();
		try {
			String path = BoardDao.class.getResource("/SQL/board_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt=conn.prepareStatement(p.getProperty("selectBoardContent"));
			pstmt_readCount=conn.prepareStatement(p.getProperty("readCountUpdate"));
			pstmt.setInt(1,boardNo);
			pstmt_readCount.setInt(2, boardNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				b.setBoardNo(rs.getInt(1));
				b.setBoardTitle(rs.getString(2));
				b.setBoardWriter(rs.getString(3));
				b.setBoardContent(rs.getString(4));
				b.setBoardOriginalFileName(rs.getString(5));
				b.setBoardRenamedFileName(rs.getString(6));
				b.setBoardDate(rs.getDate(7));
				int readCount = rs.getInt(8);
				if(!readCheck) {
					readCount = rs.getInt(8)+1;
				}
				pstmt_readCount.setInt(1, readCount);
				b.setBoardReadCount(readCount);
			}
			pstmt_readCount.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(pstmt_readCount);
			return b;
		}
	}
	public int boardWrite(Connection conn, Board b) {
		int result=0;
		PreparedStatement pstmt=null;
		Properties p = new Properties();
		try {
			String path = BoardDao.class.getResource("/SQL/board_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt = conn.prepareStatement(p.getProperty("boardWrite"));
			pstmt.setString(1,b.getBoardTitle());
			pstmt.setString(2,b.getBoardWriter());
			pstmt.setString(3,b.getBoardContent());
			pstmt.setString(4,b.getBoardOriginalFileName());
			pstmt.setString(5,b.getBoardRenamedFileName());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			return result;
		}
		
	}
	
	public int writeComment(Connection conn, Comment c) {
		int result=0;
		PreparedStatement pstmt=null;
		Properties p = new Properties();
		try {
			String path = BoardDao.class.getResource("/SQL/board_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt = conn.prepareStatement(p.getProperty("commentWrite"));
			pstmt.setInt(1,c.getBoardCommentLevel());
			pstmt.setString(2,c.getBoardCommentWriter());
			pstmt.setString(3, c.getBoardCommentContent());
			pstmt.setInt(4, c.getBoardRef());
			pstmt.setString(5, c.getBoardCommentRef()==0?null:""+c.getBoardCommentRef());
			//0일때는 null로 세팅
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			return result;
		}
	}
	
	public List<Comment> getComment(Connection conn, int boardNo){
		Properties p = new Properties();
		List<Comment> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Comment c = null;
		try {
			String path = BoardDao.class.getResource("/SQL/board_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt=conn.prepareStatement(p.getProperty("selectComment"));
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				c=new Comment();
				c.setBoardCommentNo(rs.getInt(1));
				c.setBoardCommentLevel(rs.getInt(2));
				c.setBoardCommentWriter(rs.getString(3));
				c.setBoardCommentContent(rs.getString(4));
				c.setBoardRef(rs.getInt(5));
				c.setBoardCommentRef(rs.getInt(6));
				c.setBoardCommentDate(rs.getDate(7));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println(list.size());
			close(rs);
			close(pstmt);
			return list;
		}
	}
}
