<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hellospring</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="${path }/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id="container">
		<header>
			<div id="header-container">
				<h2>${param.title }</h2>
			</div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">
					<img src="${path }/resources/images/logo-spring.png"
					alt="스프링로고" width="50px"/>
				</a>
				<button class="navbar-toggler" type="button"
				data-toggle="collapse" data-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active">
							<a class="nav-link" href="${path }">Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${path}/board/boardList.do">게시판</a>
						</li>
						
						<%-- <li class="nav-item">
							<a class="nav-link" href="${path }/demo/demo.do">Demo</a>
						</li> --%>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" 
							id="navbarDropdown" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">demo</a>
							<div class="dropdown-menu" aria-lebelledby="navbarDropdown">
								<a class="dropdown-item" href="${path }/demo/demo.do">Demo등록</a>
								<a class="dropdown-item" href="${path }/demo/demoList.do">Demo목록</a>
							</div>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${path}/memo/memo.do">메모</a>
						</li>
					</ul>
					<c:choose>
						<c:when test="${empty login}">
							<button class="btn btn-outline-success my-2 my-sm-0"
							type="button" data-toggle="modal" data-target="#loginModal">
							로그인</button>
							&nbsp;&nbsp;
							<button class="btn btn-outline-success my2 my-sm-0" type="button" onclick="fn_submit();">
							회원가입
							</button>
						</c:when>
						<c:otherwise>
							<span>
							<a href="${path}/member/mypage.do"><c:out value="${login.userName}"/></a>님 환영합니다.
							</span>
							&nbsp;&nbsp;
							<button class="btn btn-outline-success my2 my-sm-0" type="button" onclick="fn_logout();">
							로그아웃
							</button>
						</c:otherwise>
					</c:choose>
						
				</div>
			</nav>
		</header>
		
		<div class="modal face" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">로그인</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="${path}/member/memberLogin.do" method="post">
						<div class="modal-body">
							<input type="text" name="userId" placeholder="ID" required class="form-control"/>
							<input type="password" name="password" placeholder="Password" required class="form-control"/>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-outline-success">로그인</button>
							<button type="button" class="btn btn-outline-success" data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<script>
			const fn_submit=()=>{
				location.assign("${path}/member/submit.do")
			}
			const fn_logout=()=>{
				location.assign("${path}/member/logout.do")
			}
		</script>