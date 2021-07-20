package com.bs.spring.memo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.bs.spring.memo.model.vo.Memo;

public interface MemoDao {
	public int memoInsert(SqlSessionTemplate session, Memo memo);
	
	public int memoDelete(SqlSessionTemplate session, int no);
	
	public List<Memo> memoSelect(SqlSessionTemplate session);
}
