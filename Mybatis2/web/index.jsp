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
	<h2>동적 쿼리</h2>
	<ul>
		<li><h3>전체조회</h3>
			<a href="${path}/selectEmpAll">조회</a>
		</li>
		<li><h3>사원 조회</h3>
			<a href="${path}/selectOneEmp?no=200">조회</a>
		</li>
		<li><h3>사원 조회</h3>
			<a href="${path}/selectBoard?no=39">조회</a>
		</li>
	</ul>
</body>
</html>