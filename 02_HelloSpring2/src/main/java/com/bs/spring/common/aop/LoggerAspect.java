package com.bs.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerAspect {
	
	
	public void logTest(JoinPoint jp) {
		//point에 대한 정보를 가지고 있는 signature 객체 이용
		Signature sig = jp.getSignature();
		log.debug("==========AOP==========");
		log.debug("method : " + sig.getName()+" class : " + sig.getDeclaringTypeName());
		log.debug("=======================");
	}
}
