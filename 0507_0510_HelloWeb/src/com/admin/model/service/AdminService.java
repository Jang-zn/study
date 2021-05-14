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
	
	public List<Member> getMemberList() {
		Connection conn = getConnection();
		List<Member> list = dao.getMemberList(conn);
		close(conn);
		return list;
	}
	
	
	
}
