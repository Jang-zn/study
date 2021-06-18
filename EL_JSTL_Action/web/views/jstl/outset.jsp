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
	<h3>set / out </h3>
	<ul>c:set = 변수 선언 태그
		<li>var : 변수명</li>
		<li>value : 변수에 저장할 값</li>
		<li>scope : 변수가 선언될 위치 (default : page /  request, session, context) </li>
	</ul>
	<br><br>
	<ul>c:out = 변수 출력 태그 ()
		<li>value : 출력할 값(literal / EL 식)</li>
		<li>default : 변수가 없으면 출력할 값 </li>
		<li>escapeXml : 태그형식으로 출력할지 문자로 출력할지 결정 (false면 tag / true면 문자)</li>
	</ul>	
	<br><br>
	<h3>페이지 내 변수 선언</h3>
	<c:set var="name" value="장우영"/>
	<c:set var="path" value="${pageContext.request.contextPath }"/>
	<%
		String test = "테스트";
	%>
	<h3>출력</h3>
	<c:out value="${name}"/><br>
	<c:out value="${path}"/><br>
	<c:out value="<%= test%>"/>
	
	
	<br><br>
	<h3>범위지정</h3>
	<c:set var="name" value="re장우영" scope="request"/>
	<c:out value="${name}"/><br>	<!-- 중복이면 작은범위부터 시작 -->
	<c:out value="${requestScope.name }"/>
	
	
	<br><br>
	<h3>null시 default 출력</h3>
	<c:out value="${age}" default="20"/>
	<br><br>
	
	<h3>c:out에 tag 포함될 경우의 처리 (escapeXml)</h3>
	<c:out value="<h3>되냐? escapeXml:true(default)</h3>"/>
	<c:out value="<h3>되냐? escapeXml:false</h3>" escapeXml="false"/>
	<br><br>
	
	<!-- 걍 써도 되는데 c:out의 존재 이유가 뭐임? -->
	
	
</body>
</html>