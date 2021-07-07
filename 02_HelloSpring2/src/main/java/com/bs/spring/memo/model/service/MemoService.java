package com.bs.spring.memo.model.service;

import java.util.List;

import com.bs.spring.memo.model.vo.Memo;

public interface MemoService {
	public int memoInsert(Memo memo);
	
	public int memoDelete(int no);
	
	public List<Memo> memoSelect();
}
