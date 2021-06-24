package com.employee.model.service;

import static com.common.SqlSessionTemplate.getSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.employee.model.dao.EmployeeDao;
import com.employee.model.vo.Employee;

public class EmployeeService {
	private EmployeeDao dao = new EmployeeDao();
	public EmployeeService() {
	
	}
	
	public List<Employee> selectEmpAll(){
		SqlSession session = getSession();
		List<Employee> list = dao.selectEmpAll(session);
		return list;
	}
}
