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
	<h3> 반복문 사용 <c:out value="<c:forEach>"/> 사용</h3>
	<p>기본 for문 이용</p>
	<p>forEach 이용</p>
	<ul>c:forEach
		<li>begin : 초기값</li>
		<li>end : 마지막값</li>
		<li>step : 증감</li>
		<li>--------------</li>
		<li>var : 순회할 array/collection 요소를 저장할 변수 / begin~end 순회하는 loofCounter값도 들어감</li>
		<li>items : 순회할 배열/collection</li>
		<li>varStatus : 반복문에 대한 정보를 저장하는 속성(몇회째인지 뭐 그런거)</li>
	</ul>
	<br><br>
	<h3>기본 반복문 활용하기</h3>
	<h4>1~10 출력</h4>
	<c:forEach begin="1" end="10" step="1" var="i">
		<c:out value="${i}"/><br>
	</c:forEach>
	<c:forEach begin="1" end="10" step="1" var="i">
		<h${i}>${i}</h${i}>
	</c:forEach>
	<br><br>
	<h3>array / collection 순회 (ForEach)</h3>
	<%
		List<Person> list = List.of(new Person("장우영", "서울", 30), 
				new Person("장우영29","울산",29), 
				new Person("장우영26", "이천", 26));
	%>
</body>
</html>