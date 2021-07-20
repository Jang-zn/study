<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>
			제목 : <c:out value="${board.boardTitle}"/>
			</td>
			<td>
			글쓴이 : <c:out value="${board.boardWriter}"/>
			</td>
			<td>
			등록일 : <fmt:formatDate type="date" value="${board.boardDate}"/>
			</td>
		</tr>
		<tr>
			<td colspan="3">
			 내용 :<c:out value="${board.boardContent}"/> 
			</td>
		</tr>
		<c:forEach var="r" items="${board.comments}">
		<tr>
			<td>작성자 : <c:out value="${r.commentWriter}"/></td>
			<td>등록일 : <fmt:formatDate type="date" value="${r.commentDate}"/></td>
			<td>댓글 : <c:out value="${r.commentContent}"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>