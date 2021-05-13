package com.student.model.dao;

import java.sql.*;
import java.util.*;

import com.student.model.vo.*;

public class StudentDAO {

	public List<Student> studentList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement("SELECT * FROM MEMBER");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Student std = new Student();
				std.setMemberId(rs.getString(1));
				std.setMemberPwd(rs.getString(2));
				std.setMemberName(rs.getString(3));
				std.setGender(rs.getString(4));
				std.setAge(rs.getInt(5));
				std.setEmail(rs.getString(6));
				list.add(std);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			rs.close();
			pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}return list;
	}
	
}
