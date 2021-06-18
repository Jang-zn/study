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
	<h3><c:out value="<c:if> 문"/></h3>
	<p>자바의 if문을 태그로 변경한 것</p><br>
	
	<p> <c:out value="<c:if test='비교연산 / 조건문  (EL)' var='test 결과 저장용 변수'>"/></p>
	<p> 로직</p>
	<p> <c:out value="</c:if>"/></p>
	<br>
	<br>
	<c:set var="s" value="20"/>
	<c:set var="s1" value="10"/>
	<c:if test="${s==s1}" var="result">
		<h3> ${s }는 ${s1 }과 같음</h3>
	</c:if>
	<c:out value="${result }"/>
	<br>
	<br>
	<form action="ifResult.jsp">
		<input type="number" name="su">
		<input type="number" name="su2">
		<select name="color">
			<option value="red">red</option>
			<option value="blue">blue</option>
			<option value="green">green</option>
			<option value="yellow">yellow</option>
		</select>
		<input type="submit" value="전송">
	</form>
	<br><br>
	<h3>c:choose</h3>
	<p>switch랑 비슷함.. sql하고 생긴건 비슷하다</p>
	<p><c:out value="<c:choose>"/></p>
	<p><c:out value="	<c:when test=''> 로직 </c:when>"/></p>
	<p><c:out value="	<c:when test=''> 로직 </c:when>"/></p>
	<p><c:out value="	<c:when test=''> 로직 </c:when>"/></p>
	<p><c:out value="	<c:otherwise> 로직 </c:otherwise>"/></p>
	<p><c:out value="</c:choose>"/></p>
	<form action="chooseTest.jsp">
		<input type="number" name="choice"><br>
		<input type="submit">
	</form>
	<br><br>
	
	<a href="${pageContext.request.contextPath}/views/jstl/foreach.jsp">다음</a>
</body>
</html>