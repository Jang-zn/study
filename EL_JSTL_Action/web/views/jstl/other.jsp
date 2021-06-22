<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="java.util.List" %>
<%@ page import="com.action.model.vo.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>c:import</h3>
	<p>
		현재페이지에서 다른 페이지를 불러오는것 -> c:out으로 출력해줘야 출력됨
	</p>
	<c:import var="h" url="http://google.com"/>
	<hr>
	<c:out value="${h }" escapeXml="false"/>
	<hr>
	<h3>c:url</h3>
	<p>주소값을 저장하는 태그 (c:set하고 비슷함)-> parameter를 자식태그로 해서 전송 가능</p>
	<c:set var="naver" value="https://search.naver.com/search.naver?query=woou_c"/>
	<a href="${naver}">c:set값 검색</a><br>
	<c:url var="na" value="https://search.naver.com/search.naver">
		<c:param name="query" value="가슴"/>
		<c:param name="test" value="다리"/>
	</c:url>
	<a href="${na}">c:url값 검색</a>
	<hr>
	<h3>c:redirect</h3>
	<p>response.redirect하고 똑같은 기능.. c:forward는 dispatcher.forward 하고 같음 </p>
	<p>얘도 url처럼 parameter 보내기 가능</p>
	<%-- <c:redirect url="http://google.com">
		<c:param name="test" value="test"/>
	</c:redirect> --%>
	
	<hr>
	<h3>c:catch </h3>
	<p>에러 발생시 try-catch문의 catch 역할을 해주는 태그</p>
	<%
		String test = null;
	%>
	<c:catch var="e">
		<%=test.charAt(0)%>
	</c:catch>
	${e }
</body>
</html>