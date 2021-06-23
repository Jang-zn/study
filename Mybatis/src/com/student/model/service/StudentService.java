package com.student.model.service;

import org.apache.ibatis.session.SqlSession;

import com.student.model.dao.StudentDao;
import com.student.common.SQLSessionTemplate.*;

public class StudentService {
	private StudentDao dao = new StudentDao();
	public StudentService() {
	
	}
	
	public int insertStudent () {
		//Connection 갖다가 써야됨
		
		int result = dao.insertStudent();
		SqlSession session = getSession();
		return result;
	}
}
