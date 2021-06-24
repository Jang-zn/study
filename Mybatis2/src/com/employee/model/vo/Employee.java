package com.employee.model.vo;

import java.util.Date;

import lombok.Data;
	//lombok - vo의 getter / setter / tostring / hashcode / equals를 overriding해주는 library
	//클래스 선언부에 annotation 작성해줌
@Data
public class Employee {
	private int empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private String deptCode;
	private String jobCode;
	private String salLevel;
	private int salary;
	private double bonus;
	private int managerId;
	private Date hireDate;
	private Date entDate;
	private String entYn;
		
}
