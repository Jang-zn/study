package com.admin.model.dao;

import static com.common.JdbcTemplate.*;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.member.model.vo.*;

public class AdminDao {
	
	public List<Member> getMemberList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		Properties p = new Properties();
		List<Member> list = new ArrayList();
			try {
				String path = AdminDao.class.getResource("/SQL/admin_sql.properties").getPath();
				p.load(new FileReader(path));
				pstmt = conn.prepareStatement(p.getProperty("selectAll"));
				rs = pstmt.executeQuery();
				while(rs.next()) {
					m=new Member();
					m.setUserId(rs.getString("USERID"));
					m.setPassword(rs.getString("PASSWORD"));
					m.setUserName(rs.getString("USERNAME"));
					m.setAge(rs.getInt("AGE"));
					m.setGender(rs.getString("GENDER"));
					m.setEmail(rs.getString("EMAIL"));
					m.setPhone(rs.getString("PHONE"));
					m.setAddress(rs.getString("ADDRESS"));
					m.setHobby(rs.getString("HOBBY"));
					m.setEnrollDate(rs.getDate("ENROLLDATE"));
					list.add(m);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			close(rs);
			close(pstmt);
			
			return list;
	}
}
