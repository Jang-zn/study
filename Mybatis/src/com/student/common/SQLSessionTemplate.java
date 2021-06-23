package com.student.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SQLSessionTemplate {
	//Mybatis가 제공하는 sql session을 만들고 사용하게 만들어주는 클래스
	
	//1. SqlSessionFactoryBuilder 생성
	//2. SqlSessionFactoryBuilder로부터 build(mybatis-config 내용) 메소드로 SqlSessionFactory를 생성
	//3. SqlSessionFactory로부터 openSession() 메소드로 SqlSession을 얻음
	//4. SqlSession 객체를 갖다 쓴다.
	public static SqlSession getSession() {
		SqlSession session =null;
		String resource="/mybatis-config.xml";
		try {
			//config xml로 연결되는 스트림 열어줌
			InputStream is=Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession(false); //boolean값을 줘서 true면 auto commit / false면 self
			
		}catch(IOException e){
			e.printStackTrace();
		}
		return session;
	}
	
	
}
