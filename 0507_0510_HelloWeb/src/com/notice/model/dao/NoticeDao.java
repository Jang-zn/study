package com.notice.model.dao;

import static com.common.JdbcTemplate.*;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.notice.model.vo.*;

public class NoticeDao {

	public List<Notice> getNoticeList(Connection conn, int cPage, int numPerpage){
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		Properties p = new Properties();
		List<Notice> list = new ArrayList();
		try {
			String path = NoticeDao.class.getResource("/SQL/notice_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt=conn.prepareStatement(p.getProperty("selectAll"));
			int pageNo =(cPage-1)*numPerpage+1; 
			int pageEnd = cPage*numPerpage;
			pstmt.setInt(1,pageNo);
			pstmt.setInt(2,pageEnd);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rs.getInt("NOTICE_NO"));
				n.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				n.setNoticeWriter(rs.getString("NOTICE_WRITER"));
				n.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				n.setNoticeDate(rs.getString("NOTICE_DATE"));
				n.setFilepath(rs.getString("FILEPATH"));
				list.add(n);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			return list;
		}
	}
	
	
	public int getNoticeCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		Properties p = new Properties();
		int result = 0;
		try {
			String path = NoticeDao.class.getResource("/SQL/notice_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt=conn.prepareStatement(p.getProperty("selectNoticeCount"));
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
	
	public Notice getNoticeContent(Connection conn, int noticeNo, String column) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Properties p = new Properties();
		Notice n = null;
		try {
			String path = NoticeDao.class.getResource("/SQL/notice_sql.properties").getPath();
			p.load(new FileReader(path));
			String sql = p.getProperty("selectOne");
			sql=sql.replace("<C>",column);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				n=new Notice();
				n.setNoticeNo(rs.getInt("NOTICE_NO"));
				n.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				n.setNoticeWriter(rs.getString("NOTICE_WRITER"));
				n.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				n.setNoticeDate(rs.getString("NOTICE_DATE"));
				n.setFilepath(rs.getString("FILEPATH"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			return n;
		}
	}
	public int noticeWrite(Connection conn, Notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		Properties p = new Properties();
		try {
			String path = NoticeDao.class.getResource("/SQL/notice_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt = conn.prepareStatement(p.getProperty("noticeWrite"));
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeWriter());
			pstmt.setString(3, n.getNoticeContent());
			/////////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////
			pstmt.setString(4, n.getFilepath());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			return result;
		}
	}
	public int deleteNotice(Connection conn, int n) {
		int result = 0;
		PreparedStatement pstmt = null;
		Properties p = new Properties();
		try {
			String path = NoticeDao.class.getResource("/SQL/notice_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt = conn.prepareStatement(p.getProperty("noticeDelete"));
			pstmt.setInt(1, n);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			return result;
		}
	}
	public int updateNotice(Connection conn, Notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		Properties p = new Properties();
		try {
			String path = NoticeDao.class.getResource("/SQL/notice_sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt = conn.prepareStatement(p.getProperty("noticeUpdate"));
			pstmt.setString(1,n.getNoticeTitle() );
			pstmt.setString(2,n.getNoticeContent() );
			pstmt.setString(3,n.getFilepath() );
			pstmt.setInt(4,n.getNoticeNo() );
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			return result;
		}
	}
	
}
