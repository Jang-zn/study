package com.bs.spring.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bs.spring.board.model.vo.Board;


@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Board> boardList(SqlSessionTemplate session, int cPage, int numPerpage) {
		RowBounds row = new RowBounds((cPage-1)*numPerpage, numPerpage);
		return session.selectList("board.selectListBoard",null,row);
	}

	@Override
	public int countBoard(SqlSessionTemplate session) {
		return session.selectOne("board.countBoard");
	}

}
