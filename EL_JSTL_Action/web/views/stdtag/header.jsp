<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
%>
<style>
	ul{
	}
	ul>li{
		display:inline-block;
		marin-right:20px;
		font-size:20px;
		font-weight:bold;
		list-style:none;
		cursor:pointer
	}
	ul>li:hover{
		color:green;
	}
</style>
<body>
	---------------------------------<%=request.getParameter("title") %>---------------------------
	<ul>
		<li>메인</li>
		<li>게시판</li>
		<li>갤러리</li>
		<li>자료실</li>
	</ul>