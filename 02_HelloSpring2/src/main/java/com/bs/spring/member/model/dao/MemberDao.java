package com.bs.spring.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.bs.spring.member.model.vo.Member;

public interface MemberDao {

	public Member loginMember(SqlSessionTemplate session, Map param);
	
	public int insertMember(SqlSessionTemplate session, Member member);
}
