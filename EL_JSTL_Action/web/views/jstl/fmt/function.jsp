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
	<h2>fn: prefix는 { } 안에서 사용함 </h2>
	<c:set var="str" value="how are you"/>
	<p>str : <c:out value="${str}"/></p>
	<p>upperCase : <c:out value="${fn:toUpperCase(str)}"/></p>
	<p>replace : <c:out value="${fn:replace(str,'how','what')}"/></p>
	<p>contains : <c:out value="${fn:contains(str,'you')?'yes':'no'}"/></p>
</body>
</html>