package com.common.filter;

import java.nio.charset.*;
import java.security.*;
import java.util.*;

import javax.servlet.http.*;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getParameter(String name) {
		String value;
		if(name.equals("password")) {
			//암호화
			System.out.println(super.getParameter(name));
			value = getSHA512(super.getParameter(name));
			System.out.println(value);
		}else if(name.equals("password_new")) {
			System.out.println(""+super.getParameter(name));
			value = getSHA512(super.getParameter(name));
			System.out.println(value);
		}else {
			value = super.getParameter(name);
		}
		
		return value;
	}
	
	private String getSHA512(String value) {
		String encVal;
		//SHA512방식의 해쉬 암호화 이용
		MessageDigest md=null;
		try {
			md=MessageDigest.getInstance("SHA-512"); 
			//매개변수로 알고리즘명을 넣는다. 근데 자바에서 지원 안할수 있으니 NoSuchAlgorithmException 처리하는것
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//암호화는 bit단위로 실행하는데 data최소단위는 byte임 -> String인 value를 Byte로 나눠줘야된다.(Byte[]형태)
		byte[] bytes = value.getBytes(Charset.forName("utf-8")); //그냥 utf-8쓰면 예외처리 해줘야되는데 이렇게 하면 안해도됨
		
		//MessageDigest 객체에 쪼개놓은 byte배열을 등록해줌
		md.update(bytes);
		
		//문자열로 반환하기 위해 Encoder 사용해야됨 : Base64Encoder
		encVal = Base64.getEncoder().encodeToString(md.digest());
		return encVal;
	}
}
