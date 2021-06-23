package com.student.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.student.model.vo.Student;

public class StudentDao {
	public StudentDao() {
	
	}
	public int insertStudent(SqlSession session) {
		//쿼리문 실행을 위한 구문만 작성
		//selectOne, selectList, insert, update, delete
		//매개변수에 sql구문(mapper에 있는거, String), Object(placeholder ? 에 들어갈 값이나 추가로 필요한 Data들 넘겨줌)
		int result=session.insert("student.insertStudent"); //query문은 namespace명.queryTagId 로 선택해줌
		return result;
	}
	
	public int insertStudentName(SqlSession session, String name) {
		int result=session.insert("student.insertStudentName", name); //query문은 namespace명.queryTagId 로 선택해줌
		return result;
	}
	public int insertStudentInfo(SqlSession session, Student s) {
		int result=session.insert("student.insertStudentInfo", s); //query문은 namespace명.queryTagId 로 선택해줌
		return result;
	}
}
