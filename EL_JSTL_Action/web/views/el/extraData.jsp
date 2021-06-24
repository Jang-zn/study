<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> cookie 가져오기</h3>
	<h4>cookie : ${cookie }</h4>
	<h4>cookie.c : ${cookie.c }</h4>
	<h4>cookie.c.name : ${cookie.c.name }</h4>
	<h4>cookie.c.value : ${cookie.c.value }</h4>
	<h4>이전 페이지(Referer) : ${header["Referer"]}</h4>
</body>
</html>