package com.bs.spring.memo.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bs.spring.memo.model.vo.Memo;

@Repository
public class MemoDaoimpl implements MemoDao{
	
	public int memoInsert(SqlSessionTemplate session, Memo memo) {
		return session.insert("memo.memoInsert",memo);
	}
	
	public int memoDelete(SqlSessionTemplate session, int no) {
		return session.delete("memo.memoDelete",no);
	}
	
	public List<Memo> memoSelect(SqlSessionTemplate session) {
		return session.selectList("memo.memoSelect");
	}
}
