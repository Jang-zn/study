<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script sre="${path}/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<header id="container">
		<div id="header-container">
			<h2><c:out value="${param.title}"/></h2>
		</div>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">
				<img src="${path}/resources/imgs/logo-spring.png" alt="spring logo" width="50px"/>
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
			aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="${path}">Home</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="">게시판</a>
					</li>
					<%-- <li class="nav-item">
						<a class="nav-link" href="${path}/demo/demo.do">Demo</a>
					</li> --%>
					<li class="nav-item dropdown">
					<a class="nave-link dropdown-toggle" href="#"
					   id="navbarDropdown" role="button" data-toggle="dropdown"
					   aria-haspopup="true" aria-expanded="false">demo</a>
					<div class="dropdown-menu" aria-lebelledby="navbarDropdown">
						<a class="dropdown-item" href="${path}/demo/demo.do">Demo 등록</a>
						<a class="dropdown-item" href="${path}/demo/demoList.do">Demo 목록</a>
					</div>   
					</li>
				</ul>
			</div>
		</nav>
	</header>
