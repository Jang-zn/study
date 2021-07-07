package com.bs.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;



//Annotation으로 aop 등록

@Component
@Aspect
@Slf4j
public class LoggerAspectAnn {
	@Pointcut("execution(* com.bs.spring..service.*.*(..))")
	public void service() {};
	
	@Pointcut("execution(* com.bs.spring.demo..*(..))")
	public void demo() {};
	
	
	@Before("service()")
	public void loggerTestAnn(JoinPoint jp) {
		log.debug("===========Annotation Aspect=============");
		Signature sig = jp.getSignature();
		log.debug(sig.getName()+ "   "+sig.getDeclaringTypeName());
		log.debug("=========================================");
	}
	
	@After("demo()")
	public void loggerDemoTestAnn(JoinPoint jp) {
		log.debug("===========Annotation Aspect Demo=============");
		Signature sig = jp.getSignature();
		Object[] p = jp.getArgs();
		for(Object k : p) {
			log.debug("getArgs : {}",k);
		}
		log.debug(sig.getName()+ "   "+sig.getDeclaringTypeName());
		log.debug("=========================================");
	}
	
}
