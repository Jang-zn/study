package com.bs.spring.memo.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.spring.memo.model.dao.MemoDao;
import com.bs.spring.memo.model.vo.Memo;

@Service
public class MemoServiceimpl implements MemoService{
	
	@Autowired
	SqlSessionTemplate session;
	
	
	@Autowired
	MemoDao dao;
	
	
	public int memoInsert(Memo memo) {
		return dao.memoInsert(session, memo);
	}
	
	public int memoDelete(int no) {
		return dao.memoDelete(session, no);
	}
	
	public List<Memo> memoSelect() {
		return dao.memoSelect(session);
	}
}
