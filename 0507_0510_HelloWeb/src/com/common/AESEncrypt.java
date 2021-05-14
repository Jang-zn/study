package com.common;

import java.io.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;

import javax.crypto.*;

public class AESEncrypt {
	//양방향 암호화 기능을 제공하는 클래스
	//1. key생성 : 유일한 값으로 파일 관리 필요
	//	 SecretKey 클래스로 객체를 만들어서 사용
	
	
	private static SecretKey key; //키 관리 객체
	
	private String path; // 키 저장 경로
	
	public AESEncrypt() {
		//1.key file 확인 필요 -> file 있으면 SecretKey 객체 호출 / 없으면 SecretKey 객체 생성후 file저장
		this.path = AESEncrypt.class.getResource("/").getPath();
		//-> ...WEB-INF/classes (compile 위치)
		this.path = this.path.substring(0,this.path.indexOf("classes"));
		//-> 이러면 WEB-INF에 저장된다
		
		File f = new File(this.path+"/Key.ls");
		if(f.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
				key = (SecretKey)ois.readObject();
			}catch(IOException|ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}else {
			generateKey();
		}
		
		
	}
	//키생성 메소드
	private void generateKey() {
		//key 생성은 중복되면 안되니까 랜덤값을 줘야됨
		SecureRandom sr = new SecureRandom(); //sort값을 이용함..대충 알고리즘에 의한 중복값 생성방지 로직이라고 생각하면 됨
		//key 생성 / 설정
		KeyGenerator keyGen=null;
		try {
			keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(128,sr); //sr이 그 중복값 방지해서 뽑아낸값
			AESEncrypt.key = keyGen.generateKey();
		}catch(Exception e) {
			e.printStackTrace();
		}
		File f = new File(this.path+"/Key.ls");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
			oos.writeObject(AESEncrypt.key);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//암호화처리 메소드
	public static String encrypt(String value) throws NoSuchAlgorithmException, 
	NoSuchPaddingException,InvalidKeyException, BadPaddingException, IllegalBlockSizeException{
		//암/복호화 둘다 처리해주는 클래스
		Cipher cipher = Cipher.getInstance("AES");
		
		//암호화 모드로 설정
		cipher.init(Cipher.ENCRYPT_MODE, AESEncrypt.key);
		//byte화
		byte[] nativeVal = value.getBytes(Charset.forName("utf-8"));
		byte[] encResult = cipher.doFinal(nativeVal);
		//String으로 인코딩
		return Base64.getEncoder().encodeToString(encResult);
		
	}
	
	public static String decrypt(String value) throws NoSuchAlgorithmException, 
	NoSuchPaddingException,InvalidKeyException, BadPaddingException, IllegalBlockSizeException{
		//암/복호화 둘다 처리해주는 클래스
		Cipher cipher = Cipher.getInstance("AES");
		
		//복호화 모드로 설정
		cipher.init(Cipher.DECRYPT_MODE, AESEncrypt.key);
		
		//복호화
		byte[] decodeStr = Base64.getDecoder().decode(value.getBytes(Charset.forName("utf-8")));
		byte[] decodeResult = cipher.doFinal(decodeStr);
		
		//String으로 인코딩
		return new String(decodeResult);
		
		
		
		
		
		
	}
}
