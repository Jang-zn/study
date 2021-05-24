package com.admin.model.dao;

import static com.common.JdbcTemplate.*;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.member.model.vo.*;

public class AdminDao {
	
	public List<Member> getMemberList(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		Properties p = new Properties();
		List<Member> list = new ArrayList();
			try {
				String path = AdminDao.class.getResource("/SQL/admin_sql.properties").getPath();
				p.load(new FileReader(path));
				pstmt = conn.prepareStatement(p.getProperty("selectMemberList"));
				//공식 외우든가 이해를 하든가 해서 바로 튀어나오게 할 것
				int pageNo=(cPage-1)*numPerpage+1;
				int pageEnd=cPage*numPerpage;
				pstmt.setInt(1, pageNo);
				pstmt.setInt(2, pageEnd);
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
			}finally {
				close(rs);
				close(pstmt);
				return list;
			}
	}
	
	public List<Member> searchMemberList(Connection conn, String column, String value ,int cPage, int numPerpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		Properties p = new Properties();
		List<Member> list = new ArrayList();
			try {
				String path = AdminDao.class.getResource("/SQL/admin_sql.properties").getPath();
				p.load(new FileReader(path));
				String sql = p.getProperty("searchMemberList");
				sql=sql.replace("<C>", column);
				//sql 속성에서는 ? set 안된다 (''붙어서 나옴) replace로 처리해줘야됨
				// 거꾸로 value에서 replace하니까 안되지!!!!
				//replace는 원본값 수정 아니니까 대입도 해줘야됨 아 개빡친다
				pstmt = conn.prepareStatement(sql);
				value = "%"+value+"%";
				pstmt.setString(1, value);
				//공식 외우든가 이해를 하든가 해서 바로 튀어나오게 할 것
				int pageNo=(cPage-1)*numPerpage+1;
				int pageEnd=cPage*numPerpage;
				pstmt.setInt(2, pageNo);
				pstmt.setInt(3, pageEnd);
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
			}finally {
				close(rs);
				close(pstmt);
				return list;
			}
	}
	
	
	public int getMemberCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		Properties p = new Properties();
		int result=0;
		List<Member> list = new ArrayList();
			try {
				String path = AdminDao.class.getResource("/SQL/admin_sql.properties").getPath();
				p.load(new FileReader(path));
				pstmt = conn.prepareStatement(p.getProperty("getMemberCount"));
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
				return result;
			}
	}
	
	public int getMemberCount(Connection conn, String column, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		Properties p = new Properties();
		int result=0;
			try {
				String path = AdminDao.class.getResource("/SQL/admin_sql.properties").getPath();
				p.load(new FileReader(path));
				String sql = p.getProperty("getMemberCount2");
				sql=sql.replace("<C>", column);
				System.out.println(sql);
				pstmt = conn.prepareStatement(sql);
				value = "%"+value+"%";
				pstmt.setString(1, value);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
			close(rs);
			close(pstmt);
			System.out.println("result : "+result);
			return result;
			}
	}
}
