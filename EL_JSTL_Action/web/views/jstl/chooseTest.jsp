<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>추첨결과</h3>
	<c:choose>
		<c:when test="${param.choice%5==0}">   
			<h3>집</h3>
		</c:when>
		<c:when test="${param.choice%5==2}">
			<h3>쭉빵미녀</h3>
		</c:when>
		<c:when test="${param.choice%5==4}">   
			<h3>100억</h3>
		</c:when>
		<c:otherwise>   
			<h3>꽝</h3>
		</c:otherwise>
	</c:choose>




</body>
</html>