<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>include</h2>
	<p>외부의 다른 페이지를 현재 페이지로 불러옴</p>
	<p>jsp:include 로 작성, 속성값으로 불러올 페이지 설정함 (page="주소")</p>
	<p> %@include 하고 비슷한 기능인데 얘랑 달리 불러온 페이지 내부에 선언한 변수는 못가져옴(컴파일이 별도로 일어남)</p>
	<a href="stdtag/include.jsp">include</a>
	<br>
	<br>
	<h2>useBean</h2>
	<p>자바 객체를 페이지에서 이용할 때 사용 (vo)</p>
	<a href="<%=request.getContextPath() %>/useBeanTest">useBean</a>
	<form action="<%=request.getContextPath() %>/useBeanTest">
		<input type="text" name="name">
		<input type="number" name="age">
		<input type="text" name="addr">
		<input type="submit" value="test">
	</form>
</body>
</html>