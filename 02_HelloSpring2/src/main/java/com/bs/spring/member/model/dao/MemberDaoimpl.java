package com.bs.spring.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bs.spring.member.model.vo.Member;

@Repository
public class MemberDaoimpl implements MemberDao{

	@Override
	public Member loginMember(SqlSessionTemplate session, Map param) {
		return session.selectOne("member.selectOneMember",param);
	}

	@Override
	public int insertMember(SqlSessionTemplate session, Member member) {
		return session.insert("member.insertMember", member);
	}

	
	
}
