package com.employee.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
	//lombok - vo의 getter / setter / tostring / hashcode / equals를 overriding해주는 library
	//클래스 선언부에 annotation 작성해줌
@Data // getter / setter /기본생성자/ toString / hashcode, equals

@AllArgsConstructor //매개변수 있는 생성자 -> 쓰면 기본생성자 없어짐
@NoArgsConstructor //기본생성자

@Getter
@Setter
@Builder //BuilderPattern
//Employee e = Emploee.builder().멤버변수("값").멤버변수("값").멤버변수("값")...build(); 로 생성해서 가독성이 좋게 만들수 있음


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
