package com.employee.model.vo;

import lombok.Data;

@Data
public class Employee2 {
	private String empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private Department dept;
	private int salary;
	private double bonus;
	
}
