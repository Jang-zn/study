<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.member.model.vo.*" %>
<%@ page import = "java.util.*" %>
<% Member loginMember = (Member)request.getSession().getAttribute("login");
   Cookie [] cookies = request.getCookies();
   String saveId = null;
   if(cookies!=null){
	   for(Cookie c : cookies){
		   if(c.getName().equals("saveId")){
			   saveId = c.getValue();
			   break;
		   }
	   }		   
   }
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloMVC</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/src/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/src/css/header.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/src/css/memberList.css">

<script src = "<%=request.getContextPath() %>/src/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id="container">
		<header>
		<h1> Hello MVC</h1>
		<div class ="login-container">
		<%if(loginMember ==null){ %>
		<form id="loginFrm" action="<%=request.getContextPath()%>/login" method="post" onsubmit="return fn_invalidate();">
			<table>
				<tr>
					<td>
						<input type="text" name="userId" id="userId" placeholder="아이디" value="<%=saveId==null?"":saveId%>">
					</td>
					<td></td>
				</tr>
				<tr>
					<td>
						<input type="password" name="password" id="password" placeholder="비밀번호">
					</td>
					<td>
						<input type="submit" value="로그인" onclick="return fn_invalidate();">
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="checkbox" name="saveId" id="saveId" <%=saveId==null?"":"checked" %>>	
						<label for="saveId">아이디 저장</label>
						<input type="button" value="회원가입" onclick="fn_signUp();">
					</td>
				</tr>
			</table>
		</form>
		<% }else{%>
			<table>
				<tr>
					<td colspan="2">
						<%=loginMember.getUserName() %>님, 환영합니다 
					</td>
				</tr>
				<tr>
					<td>
						<input type = "button" value="내 정보 보기" onclick="fn_memberView();">
					</td>
					<td>
						<input type = "button" value="로그아웃" onclick="fn_logout();">
					</td>
				</tr>
			</table>
		<%} %>
		</div>
		<nav>
			<ul class="main-nav">
				<li class="home"><a href="<%=request.getContextPath()%>">Home</a></li>
				<li id="notice"><a href="<%=request.getContextPath()%>/notice/List">공지사항</a></li>
				<li id="board"><a href="<%=request.getContextPath()%>/board/List">게시판</a></li>
				<%if(loginMember!=null&&loginMember.getUserId().equals("admin")){ %>
					<li id="memberManage"><a href="<%=request.getContextPath()%>/admin/memberList">회원관리</a></li>
				<%} %>
			</ul>
		</nav>
		</header>
		<script>
			const fn_invalidate=()=>{
				const userId=$("#userId").val();
				const pw = $("#password").val();
				if(userId.trim().length<4){
					alert("아이디를 4글자 이상 입력하세요");
					return false;
				}
				if(pw.trim().length==0){
					alert("패스워드를 입력하세요");
					return false;
				}
				return true;
				
			}
			
			const fn_logout=()=>{
				location.replace("<%=request.getContextPath()%>/logout");
			}
			
			const fn_signUp=()=>{
				location.assign("<%=request.getContextPath()%>/views/signup.jsp")
			}
			/* jquery에서는 location 객체 못씀 + scriptlet이랑 script랑 별개(scriptlet 먼저 로딩)라서 이벤트 주고 sendRedirect 이런거 안됨 */
			
			const fn_memberView = ()=>{
				location.assign("<%=request.getContextPath()%>/memberView.do?userId=<%=loginMember!=null?loginMember.getUserId():""%>");
				
			}
			
		</script>