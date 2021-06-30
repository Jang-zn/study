package com.kh.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// BeanConfiguration 기능 클래스
@Configuration
public class ContextTest {
	
	
	//bean 설정이 가능한 객체임
	// @Bean Annotation으로 메소드 선언 / 메소드는 등록할 Bean 클래스를 반환함
	
	@Bean
	public Employee getEmp() {
		return new Employee();
	}
	
	@Bean
	public Department getDepartment() {
		return new Department();
	}
	
	
	// 중복되는 클래스는 메소드명이 id값이 된다.
	// 아니면 Qualifier로 이름 줄수도 있음
	@Bean
	@Qualifier("p1")
	public Person getPerson() {
		return new Person();
	}
	
	@Bean
	@Qualifier("p2")
	public Person getPerson2() {
		Person p = new Person("장우영", 30, "서울");
		return p;
	}
}
