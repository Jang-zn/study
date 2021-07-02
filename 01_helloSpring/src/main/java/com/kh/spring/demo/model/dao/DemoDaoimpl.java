package com.kh.spring.demo.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Dev;

@Repository
public class DemoDaoimpl implements DemoDao {

	@Override
	public int insertDemo(SqlSessionTemplate session, Dev dev) {
		return session.insert("dev.insertDemo",dev);
	}

}
