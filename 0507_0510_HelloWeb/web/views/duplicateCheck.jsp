<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 boolean result = (boolean)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "<%=request.getContextPath() %>/src/js/jquery-3.6.0.min.js"></script>
<style>
	div#checkId-container{text-align:center;paddin-top:50px;}
	span#duplicated{color:red;font-weight:bold;}
	
</style>
</head>
<body>
<div id="checkId-container">
		<% if(!result){ %>
			[<span><%=request.getParameter("userId") %></span>]는 사용가능합니다.	
			<br><br>
			<button type="button" onclick="pageclose();">닫기</button>
			
		<%}else{ %>
			[<span id="duplicated"><%=request.getParameter("userId") %></span>]는 사용중입니다.
			<br><br>
			<!-- 아이디 재입력창 구성 -->
			<form action="<%= request.getContextPath()%>/checkDuplicate" method="post" onsubmit="return fn_nullcheck();">
				<input type="text" name="userId" id="userId">
				<input type="submit" value="중복검사">
			</form>
		<%} %>
	</div>
	<script>
		const pageclose=()=>{
			/*window.opener.name="parentPage";*/
			/*useOK.submit();*/
			opener.document.getElementById("userId_").value = "<%=request.getParameter("userId")%>";
			/* submit 없이 opener에서 접근해서 바꿔줘도 된다.  */
			self.close();
		}
		const fn_nullcheck=()=>{
			if($("#userId").val()==""){
				alert("아이디를 입력하세요");
				return false;
			}else if($("#userId").val().length<4){
				alert("4글자 이상 입력하세요");
				return false;
			}
			return true;	
		}
		
	</script>
</body>
</html>