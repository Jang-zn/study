<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, com.member.model.vo.*"
    %>
<% List<Member> members = (List<Member>)request.getAttribute("members"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 회원조회결과 </h3>
	<table>
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>포인트</th>
		</tr>
		<% if(members!=null){%>
			<%for(Member m : members){%>
			<tr>
			<td><%= m.getUserId() %></td>
			<td><%= m.getPassword() %></td>
			<td><%= m.getName() %></td>
			<td><%= m.getPoint() %></td>
			</tr>
		<%	}
		}else{%>
			<tr>조회 결과가 없습니다.</tr>
		<%}%>
	</table>
	
</body>
</html>