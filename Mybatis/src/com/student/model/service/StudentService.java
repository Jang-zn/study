package com.student.model.service;

import static com.student.common.SqlSessionTemplate.getSession;

import org.apache.ibatis.session.SqlSession;

import com.student.model.dao.StudentDao;
import com.student.model.vo.Student;

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
	
	public int insertStudentName(String name) {
		SqlSession session = getSession();
		int result = dao.insertStudentName(session, name);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	public int insertStudentInfo(Student s) {
		SqlSession session = getSession();
		int result = dao.insertStudentInfo(session, s);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	public int updateStudentInfo(Student s) {
		SqlSession session = getSession();
		int result = dao.updateStudentInfo(session, s);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	public int deleteStudentInfo(int no) {
		SqlSession session = getSession();
		int result = dao.deleteStudentInfo(session, no);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
}
