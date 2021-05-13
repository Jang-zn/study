package com.student.model.service;

import java.sql.*;
import java.util.*;

import com.student.model.dao.*;
import com.student.model.vo.*;

public class StudentService {
	private StudentDAO dao = new StudentDAO();
	public List<Student> studentList(){
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			conn.setAutoCommit(false);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		List<Student> list = dao.studentList(conn);
		
		
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
