package com.bs.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

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
	
	
	@Around("execution(* com.bs.spring..*(..))")
	public Object aroundTest(ProceedingJoinPoint join) throws Throwable{
		//전처리 / 후처리 로직을 동시에 구현함 - 구분기준은 ProceedingJoinPoint에서 proceed()로 구분
		//실행시점 전 / 후로 로직을 나눔
		//before보다 전 / after보다 후?임<얘는 확인필요
		
		
		//before
		Signature sig = join.getSignature();
		log.debug("===== around before=====");
		log.debug(sig.getName()+ "   "+sig.getDeclaringTypeName());
		log.debug("========================");
		log.debug("");
		log.debug("");
		Object obj = join.proceed();
		//after
		log.debug("===== around after=====");
		log.debug(sig.getName()+ "   "+sig.getDeclaringTypeName());
		log.debug("=======================");
		
		return obj;
	}
	
	@Around("execution(* com.bs.spring..dao.*.*(..))")
	// * com.bs.spring..*Dao.*(..)
	public Object daoCheckRuntime(ProceedingJoinPoint join) throws Throwable{
		log.debug("===== Dao 성능=====");
		StopWatch sw = new StopWatch();
		sw.start();
		Object obj = join.proceed();
		sw.stop();
		Signature sig = join.getSignature();
		log.debug(sig.getName() + " : " + sw.getTotalTimeMillis()+"ms");
		log.debug("===== 측정완료 =====");
		
		return obj;
		
	}
}
