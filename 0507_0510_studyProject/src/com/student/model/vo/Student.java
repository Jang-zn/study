package com.student.model.vo;

public class Student {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String gender;
	private int age;
	private String email;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String memberId, String memeberPwd, String memberName, String gender, int age, String email) {
		super();
		this.memberId = memberId;
		this.memberPwd = memeberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.age = age;
		this.email = email;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memeberPwd) {
		this.memberPwd = memeberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
