package com.bs.spring.member.model.service;

import java.util.Map;

import com.bs.spring.member.model.vo.Member;

public interface MemberService {

	public Member loginMember(Map param);
	
	public int insertMember(Member member);
	
	public int updateMember(Member member);
	
	public int deleteMember(Member member);
}
