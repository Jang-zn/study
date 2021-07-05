package com.bs.spring.member.model.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.spring.member.model.dao.MemberDao;
import com.bs.spring.member.model.vo.Member;

@Service
public class MemberServiceimpl implements MemberService {
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate session;

	
	@Override
	public Member loginMember(Map param) {
		
		return dao.loginMember(session, param);
	}


	@Override
	public int insertMember(Member member) {
		return dao.insertMember(session, member);
	}
	
	
	
	
}
