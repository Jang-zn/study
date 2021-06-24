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
	<h4>학생정보 입력받아 수정</h4>
	<form action="${path}/updateStudentInfo">
		학생 번호 : <input type="number" name="no"><br>
		전화번호 : <input type="text" name="tel"><br>
		이메일 : <input type="text" name="email"><br>
		주소 : <input type="text" name="addr"><br>
		<input type="submit" value="수정">
	</form>
	<h4>학생번호로 삭제</h4>
	<form action="${path}/deleteStudentInfo">
		학생 번호 : <input type="number" name="no"><br>
		<input type="submit" value="삭제">
	</form>
	<h2>DB data 조회 (SELECT)</h2>
	<ul>
		<li> 1개 row 가져오기<br>
			<a href="${path}/studentCount">학생수 조회</a><br>
			<form action="${path}/selectStudentOne">
				<input type="number" name="no">
				<input type="submit" value="조회">
			</form>
		</li>
		<li> 여러 row 가져오기<br>
		<a href="${path}/selectStudentAll">전체 학생 조회</a><br>
		
		</li>
		<li> 여러 row중 부분을 가져오기(ex: paging)<br>
		
		</li>
	</ul>
</body>
</html>