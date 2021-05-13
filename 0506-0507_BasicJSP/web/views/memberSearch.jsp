<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="java.util.*, com.member.model.vo.*"
    
%>
    
<%

    List<Member> list = new ArrayList();
	list.add(new Member("admin","admin","관리자",100));
	list.add(new Member("user1","user1","user1",200));
	list.add(new Member("user2","user2","user2",300));
	list.add(new Member("user3","user3","user3",400));
	
	request.setAttribute("members",list);
	request.getRequestDispatcher("resultMember.jsp").forward(request,response);

%>  