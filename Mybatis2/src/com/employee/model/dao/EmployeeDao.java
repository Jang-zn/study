package com.employee.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.employee.model.vo.Employee;

public class EmployeeDao {
	public EmployeeDao() {
	
	}
	
	public List<Employee> selectEmpAll(SqlSession session){
		return session.selectList("employee.selectEmpAll");
	}
	public List<Employee> selectEmp(SqlSession session, Map<String, String> data){
		return session.selectList("employee.selectEmp", data);
	}
	
}
