package com.member.model.service;

import static com.common.JdbcTemplate.*;

import java.sql.*;
import java.util.*;

import com.member.model.dao.*;
import com.member.model.vo.*;

public class MemberService {
	private MemberDao dao=new MemberDao();
	
	public MemberService() {
	
	}
	
	public Member loginCheck(String id, String pw) {
		Connection conn = getConnection();
		Member m = dao.loginCheck(conn, id, pw);
		close(conn);
		return m;
	}
	
	
	public int memberSignup(Member m) {
		Connection conn = getConnection();
		int result = dao.memberSignup(m, conn);
		if(result>0) {  // 사실 insert한개라서 transaction처리 할필요는 없음 근데 이렇게 한단것만 알아둔다.
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;	
	}
	
	public int deleteMember(String id) {
		Connection conn = getConnection();
		int result = dao.deleteMember(id, conn);
		if(result>0) {  // 사실 insert한개라서 transaction처리 할필요는 없음 근데 이렇게 한단것만 알아둔다.
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;	
	}
	
	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result = dao.updateMember(m, conn);
		if(result>0) {  // 사실 insert한개라서 transaction처리 할필요는 없음 근데 이렇게 한단것만 알아둔다.
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;	
	}
	
	public int updatePassword(String id, String pw_new) {
		Connection conn = getConnection();
		int result = dao.updatePassword(id, pw_new, conn);
		if(result>0) { 
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;	
	}
	
	
	
	
	public boolean duplicateCheck(String id) {
		Connection conn = getConnection();
		boolean yn = dao.duplicateCheck(id, conn);
		close(conn);
		return yn;
	}
	
	public Member selectMemberId(String id) {
		Connection conn = getConnection();
		Member m = dao.selectMemberId(id, conn);
		close(conn);
		return m;
	}
	
	
	
}
