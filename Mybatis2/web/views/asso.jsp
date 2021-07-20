<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사원조회결과</h2>
	<ul>
		<li>사번  :  <c:out value="${e.empId}"/></li>
		<li>사원명  :  <c:out value="${e.empName}"/></li>
		<li>주민번호  :  <c:out value="${e.empNo}"/></li>
		<li>이메일  :  <c:out value="${e.email}"/></li>
		<li>전화번호  :  <c:out value="${e.phone}"/></li>
		<li>월급  :  <fmt:formatNumber type="currency" value="${e.salary}"/></li>
		<li>보너스  :  <fmt:formatNumber type="percent" value="${e.bonus}"/></li>
		<ul>부서
			<li><c:out value="${e.dept.deptId}"/></li>
			<li><c:out value="${e.dept.deptTitle}"/></li>
			<li><c:out value="${e.dept.locationId}"/></li>
		</ul>
	</ul>
</body>
</html>