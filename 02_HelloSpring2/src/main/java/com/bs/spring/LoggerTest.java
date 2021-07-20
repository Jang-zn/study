package com.bs.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bs.spring.member.model.vo.Member;

public class LoggerTest {
	
	
	private Logger logger=LoggerFactory.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		new LoggerTest().testLogger();
	}
	
	
	public void testLogger() {
		Member m= new Member();
		logger.debug("debug 출력");
		//객체 출력하는법
		logger.debug("{}",m); //이렇게 써도 되고 (이렇게 쓰는게 낫다 toString 없을수도 있으니)
		//logger.debug(m.toString); 이렇게 써도 됨
		
		
		logger.info("info 출력");
		logger.warn("warn 출력");
		logger.error("error 출력");
	}
}
