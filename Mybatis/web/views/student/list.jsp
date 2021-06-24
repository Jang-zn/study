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
	<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>주소</th>
		<th>가입일</th>
	</tr>
	<c:forEach var="i" items="${list}">
		<tr>
			<td><c:out value="${i.studentNo}"/></td>
			<td><c:out value="${i.studentName}"/></td>
			<td><c:out value="${i.studentEmail}"/></td>
			<td><c:out value="${i.studentTel}"/></td>
			<td><c:out value="${i.studentAddr}"/></td>
			<td><fmt:formatDate value="${i.regDate}" type="date"/></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>