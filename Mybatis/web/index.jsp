<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>마이바티스 이용</h3>
	<h4>학생정보 등록하기</h4>
	<a href="${path}/insertStudent">학생입력</a>
	<h4>학생이름 변경해서 등록</h4>
	<form action="${path}/insertStudentName">
		<input type="text" name="name"><br>
		<input type="submit" value="저장">
	</form>
	<h4>학생정보 입력받아 등록</h4>
	<form action="${path}/insertStudentInfo">
		이름 : <input type="text" name="name"><br>
		전화번호 : <input type="text" name="tel"><br>
		이메일 : <input type="text" name="email"><br>
		주소 : <input type="text" name="addr"><br>
		<input type="submit" value="저장">
	</form>
</body>
</html>