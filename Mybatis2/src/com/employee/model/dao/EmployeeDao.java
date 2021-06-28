package com.employee.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.employee.model.vo.Employee;
import com.employee.model.vo.Employee2;

public class EmployeeDao {
	public EmployeeDao() {
	
	}
	
	public List<Employee> selectEmpAll(SqlSession session, int cPage, int numPerpage){
		// RowBounds class로 paging처리함
		// 생성시 매개변수로 Data의 구역을 구분할 수 있는 숫자로 대입 ex) A부터 B까지
		// 1. offset : 시작값, (cPage-1)*numPerpage
		// 2. limit : 제한(몇개뽑아올건지의 범위값) : numPerpage
		RowBounds row = new RowBounds((cPage-1)*numPerpage, numPerpage);
		return session.selectList("employee.selectEmpAll",null,row);
	}
	public List<Employee> selectEmp(SqlSession session, Map<String, String> data){
		return session.selectList("employee.selectEmp", data);
	}
	
	public int selectEmpCount(SqlSession session){
		return session.selectOne("employee.selectEmpCount");
	}
	
	public Employee2 selectOneEmp(SqlSession session, int no){
		return session.selectOne("employee.selectOneEmp",no);
	}
	
}
