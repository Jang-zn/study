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
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div id="search-container">
	<form action="${path}/searchEmp" method="post">
		<table>
			<tr>
				<td>
					<select name="searchType">
						<option disabled selected>검색 타입</option>
						<option value="EMP_ID">사번</option>
						<option value="EMP_NAME">사원명</option>
						<option value="PHONE">전화번호</option>
						<option value="EMAIL">이메일</option>
					</select>
					<input type="search" name="searchKeyword"/>
				</td>
				<td>
					<label><input type="radio" value="M" name="gender">남</label>
					<label><input type="radio" value="F" name="gender">여</label>
				</td>
			</tr>
			<tr>
				<td>급여 : <input type="number" name="salary" step="100000" min="1000000"></td>
				<td><label><input type="radio" name="le_ge" value="le">이하</label>
				<label><input type="radio" name="le_ge" value="ge">이상</label></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="조회">
				</td>
			</tr>
		</table>
	</form>
</div>



<div>
	<table border="1">
		<tr>
			<th>EMP_ID</th>
			<th>EMP_NAME</th>
			<th>EMP_NO</th>
			<th>GENDER</th>
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
				<td><c:out value="${e.gender eq 'M'?'남':'여'}"/></td>
				<td><c:out value="${e.email}"/></td>
				<td><c:out value="${e.phone}"/></td>
				<td><c:out value="${e.deptCode}"/></td>
				<td><c:out value="${e.jobCode}"/></td>
				<td><c:out value="${e.salLevel}"/></td>
				<td><fmt:formatNumber type="currency" value="${e.salary}"/></td>
				<td><c:out value="${e.bonus}"/></td>
				<td><c:out value="${e.managerId}"/></td>
				<td><fmt:formatDate type="date" value="${e.hireDate}"/></td>
				<td><fmt:formatDate type="date" value="${e.entDate}"/></td>
				<td><c:out value="${e.entYn}"/></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>