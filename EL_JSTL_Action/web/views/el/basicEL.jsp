<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.action.model.vo.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = "게으름";
		int age = 7;
		request.setAttribute("name",name);
		request.setAttribute("age",age);
		Person p = new Person("장우영","서울",30);
		application.setAttribute("p",p);
	%>
	<h3> EL 기본출력</h3>
	<p>EL 출력시 data는 내장객체에 포함되어있어야 한다</p>
	<p>그냥 페이지에 선언된건 출력 안됨</p>
	<h3>${name}, ${age}</h3>
	<h3>${p}</h3>
</body>
</html>