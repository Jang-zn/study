package com.employee.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.employee.model.vo.Employee;

public class EmployeeDao {
	public EmployeeDao() {
	
	}
	
	public List<Employee> selectEmpAll(SqlSession session){
		return session.selectList("employee.selectEmpAll");
	}
	
}
