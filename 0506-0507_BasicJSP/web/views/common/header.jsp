<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String checkTest = "asdfghjkl";
%>
<style>
	ul>li{
		display : inline-block;
		margin-right:30px;
		font-size:30px;
		font-weight:bolder;
	}
	li>a{
		color:magenta;
		text-decoration: none;
	}
	table td{
		border : 3px blue dotted;
	}
	table{
		width : 500px;
		height : 200px;
		border : 1px lime solid;
	}
</style>
</head>
<body>
<header>
		<ul>
			<li><a href="main.jsp">메인화면</a></li>
			<li><a href="">갤러리</a></li>
			<li><a href="board.jsp">게시판</a></li>
			<li><a href="">자료실 </a></li>
		</ul>
	</header>
