<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>사람</h3>
	<ul>
		<li>이름 : ${p.name }</li>
		<li>나이 : ${p.age }</li>
		<li>주소 : ${p.addr }</li>
	</ul>
	<br>
	<h3>리스트 출력</h3>
	<h${list.get(0) }>h${list.get(0) }</h${list.get(0) }>
	<h${list.get(1) }>h${list.get(1) }</h${list.get(1) }>
	<h${list.get(2) }>h${list.get(2) }</h${list.get(2) }>
	<h${list.get(3) }>h${list.get(3) }</h${list.get(3) }>
	<h${list.get(4) }>h${list.get(4) }</h${list.get(4) }>
	<h${list.get(5) }>h${list.get(5) }</h${list.get(5) }>
	<h${list.get(6) }>h${list.get(6) }</h${list.get(6) }>
	
	<%-- <c:forEach var="i" items="${list}">
		<h${i}>h${i}</h${i}>
	</c:forEach> --%>
	<p> session : ${today}</p>
	<p> session list : ${sessionScope.list}</p>
	<p>context : ${userId}</p>
	<p>context p: ${applicationScope.p}</p>
	<br><br>
	<h3>파라미터 값 출력</h3>
	<p> name : ${param.name }</p>
	<p> age : ${param.age }</p>
	<p> name : ${paramValues.hobby[0] }</p>
</body>
</html>