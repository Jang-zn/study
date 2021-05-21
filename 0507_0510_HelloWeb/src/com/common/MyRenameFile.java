package com.common;

import java.io.*;
import java.text.*;
import java.util.*;

import com.oreilly.servlet.multipart.*;

public class MyRenameFile implements FileRenamePolicy{

	public MyRenameFile() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public File rename(File oldFile) {
		File newFile = null;
		//file명 중복되면 다시할라고 do-while문 사용
		do {
			long currentTime = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rnd =(int)(Math.random()*1320);
			String oriName = oldFile.getName();
			//확장자 필요하니까 원래이름에서 가져와야됨
			int dot = oriName.lastIndexOf(".");
			String ext = ""; //확장자 저장할 String 변수
			if(dot!=-1) {
				ext=oriName.substring(dot);
			}
			//새 이름 지정
			String newName = sdf.format(new Date(currentTime))+"_"+rnd+ext;
			newFile=new File(oldFile.getParent(),newName); 
			//파일의 상위경로까지 가져와서 거기에 newName으로 저장 (MultipartRequest 호출시 지정한 경로)
			
		}while(createNewFile(newFile));
		
		return newFile;
	}
	private boolean createNewFile(File newFile) {
		try {
			return newFile.createNewFile();
		}catch(Exception e) {
			return false;
		}
		
	}
	

}
