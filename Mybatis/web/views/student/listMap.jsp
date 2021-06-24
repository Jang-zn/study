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
	<!-- Map으로 받으면 key값이 column명으로 들어감 -->
	<!-- ${i.['STUDENT_NO']} 같이 ['']으로 써줘도 됨 -->
	<c:forEach var="i" items="${list}">
		<tr>
			<td><c:out value="${i.STUDENT_NO}"/></td>
			<td><c:out value="${i.STUDENT_NAME}"/></td>
			<td><c:out value="${i.STUDENT_EMAIL}"/></td>
			<td><c:out value="${i.STUDENT_TEL}"/></td>
			<td><c:out value="${i.STUDENT_ADDR}"/></td>
			<td><fmt:formatDate value="${i.REG_DATE}" type="date"/></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>