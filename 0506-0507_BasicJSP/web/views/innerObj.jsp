<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("request","request data");
		request.setAttribute("hobby",new String[]{"게임","잠","섹스","포커","코딩"});
		session.setAttribute("session","session data");
		application.setAttribute("application","application data");
		out.println(session.getAttribute("userId")+"<br>");
		out.println(application.getAttribute("email"));
		
		//페이지 전환
		request.getRequestDispatcher("/").forward(request, response);
		//response.sendRedirect(request.getContextPath());
	%>
</body>
</html>