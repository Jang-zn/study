package com.employee.model.service;

import static com.common.SqlSessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.employee.model.dao.EmployeeDao;
import com.employee.model.vo.Employee;

public class EmployeeService {
	private EmployeeDao dao = new EmployeeDao();
	public EmployeeService() {
	
	}
	
	public List<Employee> selectEmpAll(int cPage, int numPerpage){
		SqlSession session = getSession();
		List<Employee> list = dao.selectEmpAll(session, cPage, numPerpage);
		session.close();
		return list;
	}
	
	public int selectEmpCount() {
		SqlSession session = getSession();
		int count = dao.selectEmpCount(session);
		session.close();
		return count;
	}
	
	public List<Employee> selectEmp(Map<String, String> data){
		SqlSession session = getSession();
		List<Employee> list = dao.selectEmp(session, data);
		session.close();
		return list;
	}
}
