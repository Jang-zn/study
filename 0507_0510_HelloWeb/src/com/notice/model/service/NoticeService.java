package com.notice.model.service;

import java.sql.*;
import java.util.*;

import com.notice.model.dao.*;
import com.notice.model.vo.*;
import static com.common.JdbcTemplate.*;

public class NoticeService {
	private NoticeDao dao = new NoticeDao();
	
	public List<Notice> getNoticeList(int cPage, int numPerpage){
		Connection conn = getConnection();
		List<Notice> list = dao.getNoticeList(conn, cPage, numPerpage);
		close(conn);
		return list;
	}
	public int getNoticeCount() {
		Connection conn = getConnection();
		int result = dao.getNoticeCount(conn);
		close(conn);
		return result;
	}
	
	public Notice getNoticeContent(int noticeNo, String column) {
		Connection conn = getConnection();
		Notice n = dao.getNoticeContent(conn, noticeNo,column);
		close(conn);
		return n;
	}
}
