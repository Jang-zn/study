package com.member.model.dao;

import static com.common.JdbcTemplate.*;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.member.model.vo.*;

public class MemberDao {
	
	public Member loginCheck(Connection conn, String id, String pw) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		Properties p = new Properties();
			try {
				String path = MemberDao.class.getResource("/SQL/sql.properties").getPath();
				
				p.load(new FileReader(path));
				pstmt = conn.prepareStatement(p.getProperty("selectLoginMember"));
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				rs = pstmt.executeQuery();
				if(rs.next()) {
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
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			close(rs);
			close(pstmt);
			
			return m;
	}
	
	
	public int memberSignup(Member m, Connection conn) {
		PreparedStatement pstmt = null;
		Properties p = new Properties();
		int result=0;
		try {
			String path = MemberDao.class.getResource("/SQL/sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt = conn.prepareStatement(p.getProperty("signup"));
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			result=pstmt.executeUpdate();
			//excuteUpdate에서 멈춰버리면 DB접근이 차단된거니까 db commit / developer 종료 / 서버 restart 후 다시 해볼것
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);	
		}
		return result;
		
	}
	
	public int updateMember(Member m, Connection conn) {
		PreparedStatement pstmt = null;
		Properties p = new Properties();
		int result=0;
		try {
			String path = MemberDao.class.getResource("/SQL/sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt = conn.prepareStatement(p.getProperty("updateMember"));
			pstmt.setString(1, m.getUserId());
//			pstmt.setString(2, m.getPassword());
			pstmt.setString(2, m.getUserName());
			pstmt.setString(3, m.getGender());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getAddress());
			pstmt.setString(8, m.getHobby());
			pstmt.setString(9, m.getUserId());
			result=pstmt.executeUpdate();
			//excuteUpdate에서 멈춰버리면 DB접근이 차단된거니까 db commit / developer 종료 / 서버 restart 후 다시 해볼것
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);	
		}
		return result;
		
	}
	
	public int updatePassword(String id, String pw_new, Connection conn) {
		PreparedStatement pstmt = null;
		Properties p = new Properties();
		int result=0;
		try {
			String path = MemberDao.class.getResource("/SQL/sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt = conn.prepareStatement(p.getProperty("updatePassword"));
			pstmt.setString(1, pw_new);
			pstmt.setString(2, id);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);	
		}
		return result;
		
	}
	
	public int deleteMember(String id, Connection conn) {
		PreparedStatement pstmt = null;
		Properties p = new Properties();
		int result=0;
		try {
			String path = MemberDao.class.getResource("/SQL/sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt = conn.prepareStatement(p.getProperty("deleteMember"));
			pstmt.setString(1, id);
			result=pstmt.executeUpdate();
			//excuteUpdate에서 멈춰버리면 DB접근이 차단된거니까 db commit / developer 종료 / 서버 restart 후 다시 해볼것
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);	
		}
		return result;
		
	}
	
	
	public boolean duplicateCheck(String id,Connection conn) {
		boolean yn=false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Properties p = new Properties();
		try {
			String path = MemberDao.class.getResource("/SQL/sql.properties").getPath();
			p.load(new FileReader(path));
			pstmt=conn.prepareStatement(p.getProperty("duplicate"));
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				yn=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return yn;
	}
	
	
	public Member selectMemberId(String id, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		Properties p = new Properties();
			try {
				String path = MemberDao.class.getResource("/SQL/sql.properties").getPath();
				p.load(new FileReader(path));
				pstmt = conn.prepareStatement(p.getProperty("duplicate"));
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
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
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			close(rs);
			close(pstmt);
			
			return m;
	}
	
}
