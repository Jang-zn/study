<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.student.model.vo.*" %>
<%
		List<Student> list = (List<Student>)request.getAttribute("students");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table td, th{
		border:1px solid black;
		text-align:center;
	}
	table{
		border:1px solid black;
	}

</style>
</head>
<body>
	
	
	<h1>회원정보 조회결과</h1>
	<table>
		<tr>
		<th>MEMBER_ID</th>
		<th>MEMBER_PWD</th>
		<th>MEMBER_NAME</th>
		<th>GENDER</th>
		<th>AGE</th>
		<th>EMAIL</th>
		</tr>
		<%if(list.isEmpty()){ %>
			<tr><td colspan="6" style="color:red">조회된 회원이 없습니다</td></tr>
		<%}else{ 
			for(Student s : list){%>
			<tr>
			<td><%= s.getMemberId()%></td>
			<td><%= s.getMemberPwd()%></td>
			<td><%= s.getMemberName()%></td>
			<td><%= s.getGender()%></td>
			<td><%= s.getAge()%></td>
			<td><%= s.getEmail()%></td>
			</tr>
			<%}
		}%>
	</table>
</body>
</html>