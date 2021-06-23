package com.student.model.service;

import org.apache.ibatis.session.SqlSession;

import com.student.model.dao.StudentDao;
import static com.student.common.SqlSessionTemplate.*;

public class StudentService {
	private StudentDao dao = new StudentDao();
	public StudentService() {
	
	}
	
	public int insertStudent () {
		//Connection 갖다가 써야됨
		SqlSession session = getSession();
		int result = dao.insertStudent(session);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
}
