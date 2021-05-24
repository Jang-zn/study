package com.admin.model.service;

import static com.common.JdbcTemplate.*;

import java.sql.*;
import java.util.*;

import com.admin.model.dao.*;
import com.member.model.vo.*;

public class AdminService {
	private AdminDao dao=new AdminDao();
	
	public AdminService() {
	
	}
	
	public List<Member> getMemberList(int cPage, int numPerpage) {
		Connection conn = getConnection();
		List<Member> list = dao.getMemberList(conn, cPage, numPerpage);
		close(conn);
		return list;
	}
	
	public int getMemberCount() {
		Connection conn = getConnection();
		int result = dao.getMemberCount(conn);
		close(conn);
		return result;
	}
	
	public int getMemberCount(String column, String value) {
		Connection conn = getConnection();
		int result = dao.getMemberCount(conn, column, value);
		close(conn);
		return result;
	}
	
	public List<Member> searchMemberList(String column, String value, int cPage, int numPerpage) {
		Connection conn = getConnection();
		List<Member> list = dao.searchMemberList(conn, column, value, cPage, numPerpage);
		close(conn);
		return list;
	}
	
	
}
