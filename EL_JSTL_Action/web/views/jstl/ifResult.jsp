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
	<c:if test="${param.su+param.su2>100 }">
		<h3>100></h3>
	</c:if>
	<c:if test="${param.color eq 'red' }">
		<h3 style="color:${param.color}">${param.color}</h3>
	</c:if>
	<c:if test="${param.color eq 'blue' }">
		<h3 style="color:${param.color}">${param.color}</h3>
	</c:if>
	<c:if test="${param.color eq 'green' }">
		<h3 style="color:${param.color}">${param.color}</h3>
	</c:if>
	<c:if test="${param.color eq 'yellow' }">
		<h3 style="color:${param.color}">${param.color}</h3>
	</c:if>
</body>
</html>