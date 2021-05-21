<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.board.model.vo.*"%> 
<%
	String location = (String)request.getAttribute("loc");
	String msg = (String)request.getAttribute("msg");
	System.out.println("msg : "+((List<Comment>)request.getAttribute("commentList")).size());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		alert('<%=msg%>');
		<%= request.getAttribute("script")!=null? request.getAttribute("script") : "" %>
		location.replace('<%=request.getContextPath()%><%=location%>');	
	</script>
</body>
</html>