package com.kh.spring.demo.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.model.dao.DemoDao;
import com.kh.spring.demo.model.vo.Dev;


@Service
public class DemoServiceimpl implements DemoService {
	
	@Autowired
	private DemoDao dao;
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertDemo(Dev dev) {
		int result = dao.insertDemo(session, dev);
		//transaction처리는 spring이 해줌
		//여러개면 수동으로 묶어주고 처리하면 됨
		return result;
	}

}
