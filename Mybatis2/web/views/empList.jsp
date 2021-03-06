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
<<<<<<< HEAD
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
=======
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div id="search-container">
	<form action="${path}/searchEmp" method="post">
		<table>
			<tr>
				<td>
					<select name="searchType">
						<option disabled selected>?????? ??????</option>
						<option value="EMP_ID">??????</option>
						<option value="EMP_NAME">?????????</option>
						<option value="PHONE">????????????</option>
						<option value="EMAIL">?????????</option>
					</select>
					<input type="search" name="searchKeyword"/>
				</td>
				<td>
					<label><input type="radio" value="M" name="gender">???</label>
					<label><input type="radio" value="F" name="gender">???</label>
				</td>
			</tr>
			<tr>
				<td>?????? : <input type="number" name="salary" step="100000" min="1000000"></td>
				<td><label><input type="radio" name="le_ge" value="le">??????</label>
				<label><input type="radio" name="le_ge" value="ge">??????</label></td>
			</tr>
			<tr>
				<td>????????? : <input type="date" name="hireDate"></td>
				<td><label><input type="radio" name="d_le_ge" value="le">??????</label>
				<label><input type="radio" name="d_le_ge" value="ge">??????</label></td>
			</tr>
			<tr>
				<td>????????????</td>
				<td><label><input type="checkbox" name="jobCode" value="J1">??????</label></td>
				<td><label><input type="checkbox" name="jobCode" value="J2">?????????</label></td>
				<td><label><input type="checkbox" name="jobCode" value="J3">??????</label></td>
				<td><label><input type="checkbox" name="jobCode" value="J4">??????</label></td>
				<td><label><input type="checkbox" name="jobCode" value="J5">??????</label></td>
				<td><label><input type="checkbox" name="jobCode" value="J6">??????</label></td>
				<td><label><input type="checkbox" name="jobCode" value="J7">??????</label></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="??????">
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
				<td><c:out value="${e.gender eq 'M'?'???':'???'}"/></td>
				<td><c:out value="${e.email}"/></td>
				<td><c:out value="${e.phone}"/></td>
				<td><c:out value="${e.deptCode}"/></td>
				<td><c:out value="${e.jobCode}"/></td>
				<td><c:out value="${e.salLevel}"/></td>
				<td><fmt:formatNumber type="currency" value="${e.salary}"/></td>
				<td><fmt:formatNumber type="percent" value="${e.bonus}"/></td>
				<td><c:out value="${e.managerId}"/></td>
				<td><fmt:formatDate type="date" value="${e.hireDate}"/></td>
				<td><fmt:formatDate type="date" value="${e.entDate}"/></td>
				<td><c:out value="${e.entYn}"/></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div>
		${pageBar}
	</div>
>>>>>>> branch 'master' of https://github.com/Jang-zn/study.git
</body>
</html>