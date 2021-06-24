<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>EMP_ID</th>
			<th>EMP_NAME</th>
			<th>EMP_NO</th>
			<th>EMAIL</th>
			<th>PHONE</th>
			<th>DEPT_CODE</th>
			<th>JOB_CODE</th>
			<th>SAL_LEVEL</th>
			<th>SALARY</th>
			<th>BONUS</th>
			<th>MANAGER_ID</th>
			<th>HIRE_DATE</th>
			<th>ENT_DATE</th>
			<th>ENT_YN</th>
		</tr>
		<c:forEach	var="e" items="${list}">
			<tr>
				<td><c:out value="${e.empId}"/></td>
				<td><c:out value="${e.empName}"/></td>
				<td><c:out value="${e.empNo}"/></td>
				<td><c:out value="${e.email}"/></td>
				<td><c:out value="${e.phone}"/></td>
				<td><c:out value="${e.deptCode}"/></td>
				<td><c:out value="${e.jobCode}"/></td>
				<td><c:out value="${e.salLevel}"/></td>
				<td><c:out value="${e.salary}"/></td>
				<td><c:out value="${e.bonus}"/></td>
				<td><c:out value="${e.managerId}"/></td>
				<td><fmt:formatDate type="date" value="${e.hireDate}"/></td>
				<td><fmt:formatDate type="date" value="${e.entDate}"/></td>
				<td><c:out value="${e.entYn}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>